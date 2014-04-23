INSERT INTO staje(jmeno, mesto) VALUES ('Dukla', 'Pardubice');
INSERT INTO staje(jmeno, mesto) VALUES ('Spolana', 'Neratovice');
INSERT INTO staje(jmeno, mesto) VALUES ('KK Brno', 'Brno');
INSERT INTO staje(jmeno, mesto) VALUES ('JK Sobotka', 'Jičín');
INSERT INTO staje(jmeno, mesto) VALUES ('JK Robousy', 'New York');

INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Tomas', 'Vomacka', '1990-01-30');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Karel', 'Zubrohlav', '2001-11-06');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Rudolf', 'Nejedlý', '1930-04-11');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Jenovéfa', 'Salámová', '1994-05-21');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Michal', 'Kořínek', '1991-07-28');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Milan', 'Kořínek', '1964-05-07');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Jan', 'Exnar', '1973-01-09');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Lada', 'Ondráčková', '1993-12-28');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Daniel', 'Zigler', '1975-07-06');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Jan', 'Bareš', '1979-08-27');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Hans', 'Jánošík', '1990-09-11');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Vilam', 'Lupak', '1986-08-30');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Jiří', 'Klatík', '1991-01-01');

INSERT INTO kategorie(nazev, pocet_koni, pocet_prisedicich) VALUES ('jednospřeží', 1, 1);
INSERT INTO kategorie(nazev, pocet_koni, pocet_prisedicich) VALUES ('dvojspřeží', 2, 1);
INSERT INTO kategorie(nazev, pocet_koni, pocet_prisedicich) VALUES ('čtyřspřeží', 4, 2);
INSERT INTO kategorie(nazev, pocet_koni, pocet_prisedicich) VALUES ('dvanáctispřeží', 12, 6);

INSERT INTO zavod(nazev, datum, misto_konani) VALUES ('První jarní vyjížďka', '2014-01-01', 'pole');
INSERT INTO zavod(nazev, datum, misto_konani) VALUES ('Druhá jarní vyjížďka', '2014-02-01', 'louka');
INSERT INTO zavod(nazev, datum, misto_konani) VALUES ('Třetí jarní vyjížďka', '2014-03-01', 'bazén');

INSERT INTO zavod_has_kategorie(zavod_zavod_id, kategorie_kategorie_id)
	SELECT zavod_id, kategorie_id FROM zavod, kategorie WHERE misto_konani = 'pole' AND kategorie.nazev = 'dvojspřeží' LIMIT 1;

INSERT INTO zavod_has_kategorie(zavod_zavod_id, kategorie_kategorie_id)
	SELECT zavod_id, kategorie_id FROM zavod, kategorie WHERE misto_konani = 'pole' AND kategorie.nazev = 'jednospřeží' LIMIT 1;

INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Betty', 'pravá', 'Mr. Nobody');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Fantom', 'Brumby', 'Mr. Everybody');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Gaston', 'Gidran', 'Mr. Body');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Hannibal', 'Hucul', 'Mr. Anybody');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Fido', 'Strýček', 'Jan Firbacher');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Galina', 'Strýček', 'Jan Firbacher');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Up', 'Hafling', 'Milan Kořínek');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Stargate', 'Hafling', 'Milan Kořínek');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Apollo', 'Hafling', 'Michal Kořínek');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Nuget', 'Hafling', 'Michal Kořínek');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Gary', 'Ponny', 'Jana Hladíková');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Gina', 'Ponny', 'Jana Hladíková');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Salammi', 'Hucul', 'Mr. Everybody');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Kent', 'Gidran', 'Káťa Ta Naše');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Anna', 'Fallabella', 'Václav Nývlt');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Sacramosso', 'Kladrubský osel', 'František Ryv');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Desperado', 'Kladrubský osel', 'František Ryv');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Zefír', 'Kladrubský osel', 'František Ryv');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Hektor', 'Kladrubský osel', 'František Ryv');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Wendy', 'Frýzák', 'Robert Olbrich');
INSERT INTO kone(jmeno, plemeno, majitel) VALUES ('Centaur', 'Frýzák', 'Robert Olbrich');
