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
CREATE SEQUENCE seq_startovni_cislo;
CREATE TABLE "tymy" (
	"tym_id" int NOT NULL UNIQUE DEFAULT nextval('seq_tymy'),
	"nazev" varchar(50) NOT NULL,
	"startovni_cislo" int NOT NULL UNIQUE DEFAULT nextval('seq_startovni_cislo'), -- chceme udelat jakoby novou sekvenci pro kazdy zavod
										      -- jeste jsme nevymysleli, jak na to
	"cas_prvniho_kola" interval(0) NOT NULL DEFAULT '0',
	"cas_druheho_kola" interval(0) NOT NULL DEFAULT '0',
	"penalizace_prvni_kolo" int4 NOT NULL DEFAULT 0 CHECK (penalizace_prvni_kolo >= 0),
	"penalizace_druhe_kolo" int4 NOT NULL DEFAULT 0 CHECK (penalizace_druhe_kolo >= 0),
	"dojel" bool NOT NULL DEFAULT False,
	"zavod_id" int4 NOT NULL,
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
	PRIMARY KEY("osoba_id")
);

CREATE SEQUENCE seq_kone;
CREATE TABLE "kone" (
	"kun_id" int NOT NULL UNIQUE DEFAULT nextval('seq_kone'),
	"jmeno" varchar(20) NOT NULL,
	"plemeno" varchar(50) NOT NULL,
	"majitel" varchar(35) NOT NULL,
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
	"platne_od" date NOT NULL, -- zacatek tohoto roku, zatim jsme neprisli na to, jak ho tam dat defaultne
	"platne_do" date NOT NULL, -- konec tohoto roku, zatim jsme neprisli na to, jak ho tam dat defaultne
	PRIMARY KEY("osoby_osoba_id","staje_staj_id","platne_od","platne_do"),
	FOREIGN KEY ("staje_staj_id") REFERENCES "staje"("staj_id") ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY ("osoby_osoba_id") REFERENCES "osoby"("osoba_id") ON DELETE CASCADE ON UPDATE CASCADE
);


-- gets random number in range...
-- from http://www.if-not-true-then-false.com/2010/postgresql-select-a-random-number-in-a-range-between-two-numbers/
--
CREATE OR REPLACE FUNCTION get_random_number(INTEGER, INTEGER) RETURNS INTEGER AS $$
DECLARE
    start_int ALIAS FOR $1;
    end_int ALIAS FOR $2;
BEGIN
    RETURN trunc(random() * (end_int-start_int) + start_int);
END;
$$ LANGUAGE 'plpgsql' STRICT;

CREATE OR REPLACE FUNCTION check_pocet_koni() RETURNS TRIGGER AS '
	DECLARE
		pocet_povoleny INTEGER;
		pocet_realny INTEGER;
		check_tym_id INTEGER;
	BEGIN
	check_tym_id := TG_ARGV[0];
	SELECT pocet_koni INTO pocet_povoleny FROM kategorie INNER JOIN tymy ON kategorie.kategorie_id = tymy.kategorie_id
		WHERE tymy.tym_id = check_tym_id;
	SELECT COUNT(DISTINCT kone_kun_id) INTO pocet_realny FROM tymy_has_kone GROUP BY tymy_tym_id
		HAVING tymy_tym_id = check_tym_id;

	IF NOT pocet_povoleny=pocet_realny THEN
		RAISE EXCEPTION ''Spatny pocet koni !!!'';
	END IF;
	RETURN NULL;
	END
	'
	LANGUAGE plpgsql;
