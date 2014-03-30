INSERT INTO staje(jmeno, mesto) VALUES ('Dukla', 'Pardubice');
INSERT INTO staje(jmeno, mesto) VALUES ('Spolana', 'Neratovice');
INSERT INTO staje(jmeno, mesto) VALUES ('KK Brno', 'Brno');

INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Tomas', 'Vomacka', '1990-01-30');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Karel', 'Zubrohlav', '2001-11-06');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Rudolf', 'Nejedlý', '1930-04-11');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Jenovéfa', 'Salámová', '1994-05-21');
INSERT INTO osoby(jmeno, prijmeni, datum_narozeni) VALUES ('Jenovéfa', 'Salámová', '1965-02-12');

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
