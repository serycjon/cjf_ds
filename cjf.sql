﻿CREATE SEQUENCE seq_zavod;
CREATE TABLE "zavod" (
	"zavod_id" int NOT NULL UNIQUE DEFAULT nextval('seq_zavod'),
	"nazev" varchar(50) NOT NULL,
	"datum" date NOT NULL,
	"misto_konani" varchar(50) NOT NULL,
	PRIMARY KEY("zavod_id")
);

CREATE SEQUENCE seq_kategorie;
CREATE TABLE "kategorie" (
	"kategorie_id" int NOT NULL UNIQUE DEFAULT nextval('seq_kategorie'),
	"nazev" varchar(20) NOT NULL,
	"pocet_koni" int4 DEFAULT 1,
	"pocet_prisedicich" int4 DEFAULT 1,
	PRIMARY KEY("kategorie_id")
);

CREATE SEQUENCE seq_tymy;
CREATE SEQUENCE seq_startovni_cislo;
CREATE TABLE "tymy" (
	"tym_id" int NOT NULL UNIQUE DEFAULT nextval('seq_tymy'),
	"nazev" varchar(50) NOT NULL,
	"startovni_cislo" int NOT NULL UNIQUE DEFAULT nextval('seq_startovni_cislo'),
	"cas_prvniho_kola" interval(0),
	"cas_druheho_kola" interval(0),
	"penalizace_prvni_kolo" int4 NOT NULL DEFAULT 0,
	"penalizace_druhe_kolo" int4 NOT NULL DEFAULT 0,
	"dojel" bool NOT NULL DEFAULT False,
	"zavod_id" int4 NOT NULL,
	"kategorie_id" int4 NOT NULL,
	PRIMARY KEY("tym_id"),
	FOREIGN KEY ("zavod_id") REFERENCES "zavod"("zavod_id"),
	FOREIGN KEY ("kategorie_id") REFERENCES "kategorie"("kategorie_id")
);


CREATE SEQUENCE seq_osoby;
CREATE TABLE "osoby" (
	"osoba_id" int NOT NULL UNIQUE DEFAULT nextval('seq_osoby'),
	"jmeno" varchar(20) NOT NULL,
	"prijmeni" varchar(20) NOT NULL,
	"datum_narozeni" date NOT NULL,
	"staj_id" int4 NOT NULL,
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
	"jmeno" varchar(50) NOT NULL,
	"mesto" varchar(20) NOT NULL,
	PRIMARY KEY("staj_id")
);

CREATE TABLE "zavod_has_kategorie" (
	"zavod_zavod_id" int4 NOT NULL,
	"kategorie_kategorie_id" int4 NOT NULL,
	PRIMARY KEY("zavod_zavod_id","kategorie_kategorie_id"),
	FOREIGN KEY ("kategorie_kategorie_id") REFERENCES "kategorie"("kategorie_id"),
	FOREIGN KEY ("zavod_zavod_id") REFERENCES "zavod"("zavod_id")
);

CREATE TABLE "tymy_has_osoby" (
	"tymy_tym_id" int4 NOT NULL,
	"osoby_osoba_id" int4 NOT NULL,
	"je_jezdec" bool NOT NULL,
	PRIMARY KEY("tymy_tym_id","osoby_osoba_id"),
	FOREIGN KEY ("tymy_tym_id") REFERENCES "tymy"("tym_id"),
	FOREIGN KEY ("osoby_osoba_id") REFERENCES "osoby"("osoba_id")
);

CREATE TABLE "tymy_has_kone" (
	"tymy_tym_id" int4 NOT NULL,
	"kone_kun_id" int4 NOT NULL,
	PRIMARY KEY("tymy_tym_id","kone_kun_id"),
	FOREIGN KEY ("tymy_tym_id") REFERENCES "tymy"("tym_id"),
	FOREIGN KEY ("kone_kun_id") REFERENCES "kone"("kun_id")
);

CREATE TABLE "osoby_has_staje" (
	"osoby_osoba_id" int4 NOT NULL,
	"staje_staj_id" int4 NOT NULL,
	"platne_od" date NOT NULL,
	"platne_do" date NOT NULL,
	PRIMARY KEY("osoby_osoba_id","staje_staj_id","platne_od","platne_do"),
	FOREIGN KEY ("staje_staj_id") REFERENCES "staje"("staj_id"),
	FOREIGN KEY ("osoby_osoba_id") REFERENCES "osoby"("osoba_id")
);
