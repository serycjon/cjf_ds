CREATE SEQUENCE seq_zavod;
CREATE TABLE "zavod" (
	"zavod_id" int NOT NULL UNIQUE DEFAULT nextval('seq_zavod'),
	"nazev" varchar(50) NOT NULL,
	"datum" date NOT NULL default CURRENT_DATE,
	"misto_konani" varchar(50) NOT NULL,
	PRIMARY KEY("zavod_id")
);

CREATE SEQUENCE seq_kategorie;
CREATE TABLE "kategorie" (
	"kategorie_id" int NOT NULL UNIQUE DEFAULT nextval('seq_kategorie'),
	"nazev" varchar(20) NOT NULL UNIQUE,
	"pocet_koni" int4 DEFAULT 1 CHECK (pocet_koni > 0),
	"pocet_prisedicich" int4 DEFAULT 1 CHECK (pocet_prisedicich >= 0),
	PRIMARY KEY("kategorie_id")
);

CREATE SEQUENCE seq_tymy;
CREATE TABLE "tymy" (
	"tym_id" int NOT NULL UNIQUE DEFAULT nextval('seq_tymy'),
	"nazev" varchar(50) NOT NULL,
	"startovni_cislo" int DEFAULT NULL, --nextval('seq_startovni_cislo'), 
	"cas_prvniho_kola" INTEGER,
	"cas_druheho_kola" INTEGER, -- puvodne interval(0) NOT NULL DEFAULT '0',
	"penalizace_prvni_kolo" int4 NOT NULL DEFAULT 0 CHECK (penalizace_prvni_kolo >= 0),
	"penalizace_druhe_kolo" int4 NOT NULL DEFAULT 0 CHECK (penalizace_druhe_kolo >= 0),
	"dojel" bool NOT NULL DEFAULT False,
	"zavod_id" int4 DEFAULT NULL,
	"kategorie_id" int4 NOT NULL,
	PRIMARY KEY("tym_id"),
	FOREIGN KEY ("zavod_id") REFERENCES "zavod"("zavod_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("kategorie_id") REFERENCES "kategorie"("kategorie_id") ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE SEQUENCE seq_osoby;
CREATE TABLE "osoby" (
	"osoba_id" int NOT NULL UNIQUE DEFAULT nextval('seq_osoby'),
	"jmeno" varchar(20) NOT NULL,
	"prijmeni" varchar(20) NOT NULL,
	"datum_narozeni" date NOT NULL,
	-- rodne cislo pro nase demo nepotrebujeme
	PRIMARY KEY("osoba_id")
);

CREATE SEQUENCE seq_kone;
CREATE TABLE "kone" (
	"kun_id" int NOT NULL UNIQUE DEFAULT nextval('seq_kone'),
	"jmeno" varchar(20) NOT NULL,
	"plemeno" varchar(50) NOT NULL,
	"majitel" varchar(35) NOT NULL,
	-- konske cislo
	PRIMARY KEY("kun_id")
);


CREATE SEQUENCE seq_staje;
CREATE TABLE "staje" (
	"staj_id" int NOT NULL UNIQUE DEFAULT nextval('seq_staje'),
	"jmeno" varchar(50) NOT NULL UNIQUE,
	"mesto" varchar(20) NOT NULL,
	PRIMARY KEY("staj_id")
);

CREATE TABLE "zavod_has_kategorie" (
	"zavod_zavod_id" int4 NOT NULL,
	"kategorie_kategorie_id" int4 NOT NULL,
	PRIMARY KEY("zavod_zavod_id","kategorie_kategorie_id"),
	FOREIGN KEY ("kategorie_kategorie_id") REFERENCES "kategorie"("kategorie_id") ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY ("zavod_zavod_id") REFERENCES "zavod"("zavod_id") ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE "tymy_has_osoby" (
	"tymy_tym_id" int4 NOT NULL,
	"osoby_osoba_id" int4 NOT NULL,
	"je_jezdec" bool NOT NULL,
	PRIMARY KEY("tymy_tym_id","osoby_osoba_id"),
	FOREIGN KEY ("tymy_tym_id") REFERENCES "tymy"("tym_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("osoby_osoba_id") REFERENCES "osoby"("osoba_id") ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE "tymy_has_kone" (
	"tymy_tym_id" int4 NOT NULL,
	"kone_kun_id" int4 NOT NULL,
	PRIMARY KEY("tymy_tym_id","kone_kun_id"),
	FOREIGN KEY ("tymy_tym_id") REFERENCES "tymy"("tym_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("kone_kun_id") REFERENCES "kone"("kun_id") ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE "osoby_has_staje" (
	"osoby_osoba_id" int4 NOT NULL,
	"staje_staj_id" int4 NOT NULL,
	"platne_od" date NOT NULL, 
	"platne_do" date NOT NULL, 
	PRIMARY KEY("osoby_osoba_id","staje_staj_id","platne_od","platne_do"),
	FOREIGN KEY ("staje_staj_id") REFERENCES "staje"("staj_id") ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY ("osoby_osoba_id") REFERENCES "osoby"("osoba_id") ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE OR REPLACE FUNCTION check_pocty() RETURNS TRIGGER AS '
	DECLARE
		pocet_koni_povoleny INTEGER;
		pocet_lidi_povoleny INTEGER;
		pocet_koni_realny INTEGER;
		pocet_jezdcu INTEGER;
		pocet_lidi_realny INTEGER;
		check_tym_id INTEGER;
	BEGIN
	
	IF (TG_OP = ''INSERT'') AND NEW.zavod_id IS NOT NULL THEN
		RAISE EXCEPTION ''Tym lze priradit k zavodu az po jeho naplneni!'';
	END IF;
	IF NEW.zavod_id IS NULL THEN
		RETURN NEW;
	END IF;
	check_tym_id := NEW.tym_id;
	SELECT pocet_koni, pocet_prisedicich INTO pocet_koni_povoleny, pocet_lidi_povoleny FROM kategorie
		INNER JOIN tymy ON kategorie.kategorie_id = tymy.kategorie_id
		WHERE tymy.tym_id = check_tym_id;
	SELECT COUNT(kone_kun_id) INTO pocet_koni_realny FROM tymy_has_kone GROUP BY tymy_tym_id
		HAVING tymy_tym_id = check_tym_id;

	SELECT COUNT(osoby_osoba_id) INTO pocet_lidi_realny FROM tymy_has_osoby WHERE NOT je_jezdec GROUP BY tymy_tym_id
		HAVING tymy_tym_id = check_tym_id;
	SELECT COUNT(osoby_osoba_id) INTO pocet_jezdcu FROM tymy_has_osoby WHERE je_jezdec GROUP BY tymy_tym_id 
		HAVING tymy_tym_id = check_tym_id; 

	IF NOT pocet_koni_povoleny=pocet_koni_realny OR pocet_koni_realny IS NULL THEN
		RAISE EXCEPTION ''Spatny pocet koni!'';
	ELSEIF NOT pocet_lidi_povoleny=pocet_lidi_realny OR pocet_lidi_realny IS NULL THEN
		RAISE EXCEPTION ''Spatny pocet prisedicich!'';
	ELSEIF NOT pocet_jezdcu = 1 OR pocet_jezdcu IS NULL THEN
		RAISE EXCEPTION ''Spatny pocet jezdcu!'';
	END IF;

	--RAISE DEBUG ''pocet koni realny %'', pocet_koni_realny;
	--SET client_min_messages TO WARNING;
	RETURN NEW;
	END
	'
	LANGUAGE plpgsql;

CREATE TRIGGER trig_pocty
   BEFORE UPDATE OR INSERT ON tymy
   FOR EACH ROW
   EXECUTE PROCEDURE check_pocty();

CREATE OR REPLACE FUNCTION check_after_reg() RETURNS TRIGGER AS '
	DECLARE
		nalezeny INTEGER;
		id_to_find INTEGER;
	BEGIN
	--RETURN NEW;
	IF (TG_OP = ''DELETE'') THEN
		id_to_find := OLD.tymy_tym_id;
	ELSE
		id_to_find := NEW.tymy_tym_id;
	END IF;

	SELECT zavod_id INTO nalezeny FROM tymy WHERE tym_id = id_to_find;
	IF nalezeny IS NOT NULL THEN
		RAISE EXCEPTION ''Po registraci nelze slozeni tymu menit!'';
	END IF;
	RETURN NEW;
	END
	'
	LANGUAGE plpgsql;

CREATE TRIGGER trig_kone_after_reg
   BEFORE INSERT OR DELETE OR UPDATE ON tymy_has_kone
   FOR EACH ROW
   EXECUTE PROCEDURE check_after_reg();

CREATE TRIGGER trig_osoby_after_reg
   BEFORE INSERT OR DELETE OR UPDATE ON tymy_has_osoby
   FOR EACH ROW
   EXECUTE PROCEDURE check_after_reg();

CREATE OR REPLACE FUNCTION prirad_startovni_cisla(zavod INTEGER) RETURNS boolean AS '
	DECLARE
		i RECORD;
		update_count INTEGER;
		cislo INTEGER;
	BEGIN
		cislo := 1;
		FOR i IN SELECT tym_id FROM tymy WHERE zavod_id = zavod ORDER BY random() LOOP
			RAISE DEBUG ''updating id %'', i.tym_id;
			UPDATE tymy SET startovni_cislo = cislo WHERE tym_id = i.tym_id;
			GET DIAGNOSTICS update_count = ROW_COUNT;
			cislo := cislo+1;
			IF update_count < 1 THEN
				RETURN FALSE;
			END IF;
		END LOOP;
		RETURN TRUE;
	END
	'
	LANGUAGE plpgsql;
