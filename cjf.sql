-- =============================================================================
-- Diagram Name: cjf
-- Created on: 30.3.2014 15:39:44
-- Diagram Version: 
-- =============================================================================


CREATE TABLE "zavod" (
	"zavod_id" SERIAL NOT NULL,
	"nazev" varchar(50) NOT NULL,
	"datum" date NOT NULL,
	"misto_konani" varchar(50) NOT NULL,
	PRIMARY KEY("zavod_id")
);

CREATE TABLE "tymy" (
	"tym_id" SERIAL NOT NULL,
	"nazev" varchar(50) NOT NULL,
	"startovni_cislo" SERIAL NOT NULL,
	"cas_prvniho_kola" interval(0),
	"cas_druheho_kola" interval(0),
	"penalizace_prvni_kolo" int4 NOT NULL DEFAULT 0,
	"penalizace_druhe_kolo" int4 NOT NULL DEFAULT 0,
	"dojel" bool NOT NULL DEFAULT False,
	"zavod_id" int4 NOT NULL,
	"kategorie_id" int4 NOT NULL,
	PRIMARY KEY("tym_id"),
	FOREIGN KEY ("zavod_id") REFERENCES "zavod"("zavod_id")	MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE,
	FOREIGN KEY ("kategorie_id") REFERENCES "kategorie"("kategorie_id") MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE
);

---------------------------------------------------------------


CREATE TABLE "osoby" (
	"osoba_id" SERIAL NOT NULL,
	"jmeno" varchar(20) NOT NULL,
	"prijmeni" varchar(20) NOT NULL,
	"datum_narozeni" date NOT NULL,
	"staj_id" int4 NOT NULL,
	PRIMARY KEY("osoba_id")
);

CREATE TABLE "kone" (
	"kun_id" SERIAL NOT NULL,
	"jmeno" varchar(20) NOT NULL,
	"plemeno" varchar(50) NOT NULL,
	"majitel" varchar(35) NOT NULL,
	PRIMARY KEY("kun_id")
);

CREATE TABLE "kategorie" (
	"kategorie_id" SERIAL NOT NULL,
	"nazev" varchar(20) NOT NULL,
	"pocet_koni" int4 DEFAULT 1,
	"pocet_prisedicich" int4 DEFAULT 1,
	PRIMARY KEY("kategorie_id")
);

CREATE TABLE "staje" (
	"staj_id" SERIAL NOT NULL,
	"jmeno" varchar(50) NOT NULL,
	"mesto" varchar(20) NOT NULL,
	PRIMARY KEY("staj_id")
);

CREATE TABLE "zavod_has_kategorie" (
	"zavod_zavod_id" int4 NOT NULL,
	"kategorie_kategorie_id" int4 NOT NULL,
	PRIMARY KEY("zavod_zavod_id","kategorie_kategorie_id")
);
ALTER TABLE "zavod_has_kategorie" ADD CONSTRAINT "Ref_zavod_has_kategorie_to_kategorie" FOREIGN KEY ("kategorie_kategorie_id")
	REFERENCES "kategorie"("kategorie_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;
ALTER TABLE "zavod_has_kategorie" ADD CONSTRAINT "Ref_zavod_has_kategorie_to_zavod" FOREIGN KEY ("zavod_zavod_id")
	REFERENCES "zavod"("zavod_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

------------------------------------------------------------------


CREATE TABLE "tymy_has_osoby" (
	"tymy_tym_id" int4 NOT NULL,
	"osoby_osoba_id" int4 NOT NULL,
	"je_jezdec" bool NOT NULL,
	PRIMARY KEY("tymy_tym_id","osoby_osoba_id")
);
ALTER TABLE "tymy_has_osoby" ADD CONSTRAINT "Ref_tymy_has_osoby_to_tymy" FOREIGN KEY ("tymy_tym_id")
	REFERENCES "tymy"("tym_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "tymy_has_osoby" ADD CONSTRAINT "Ref_tymy_has_osoby_to_osoby" FOREIGN KEY ("osoby_osoba_id")
	REFERENCES "osoby"("osoba_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;


-------------------------------------------------------------
CREATE TABLE "tymy_has_kone" (
	"tymy_tym_id" int4 NOT NULL,
	"kone_kun_id" int4 NOT NULL,
	PRIMARY KEY("tymy_tym_id","kone_kun_id")
);
ALTER TABLE "tymy_has_kone" ADD CONSTRAINT "Ref_tymy_has_kone_to_tymy" FOREIGN KEY ("tymy_tym_id")
	REFERENCES "tymy"("tym_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

ALTER TABLE "tymy_has_kone" ADD CONSTRAINT "Ref_tymy_has_kone_to_kone" FOREIGN KEY ("kone_kun_id")
	REFERENCES "kone"("kun_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;

-----------------------------------------------------------

CREATE TABLE "osoby_has_staje" (
	"osoby_osoba_id" int4 NOT NULL,
	"staje_staj_id" int4 NOT NULL,
	"platne_od" date NOT NULL,
	"platne_do" date NOT NULL,
	PRIMARY KEY("osoby_osoba_id","staje_staj_id","platne_od","platne_do")
);
ALTER TABLE "osoby_has_staje" ADD CONSTRAINT "Ref_osoby_has_staje_to_staje" FOREIGN KEY ("staje_staj_id")
	REFERENCES "staje"("staj_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;
ALTER TABLE "osoby_has_staje" ADD CONSTRAINT "Ref_osoby_has_staje_to_osoby" FOREIGN KEY ("osoby_osoba_id")
	REFERENCES "osoby"("osoba_id")
	MATCH SIMPLE
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
	NOT DEFERRABLE;
