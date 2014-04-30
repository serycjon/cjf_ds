INSERT INTO tymy (nazev, zavod_id, kategorie_id)
	SELECT 'AlfaSamci', zavod_id, kategorie_id FROM zavod, kategorie
	WHERE zavod.misto_konani = 'pole' AND kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Karel' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Tomas' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Betty' LIMIT 1;

-- druhej jezdec - melo by to rvat!
INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Rudolf' LIMIT 1;

-- moc prisedicich - melo by rvat!
INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.datum_narozeni = '1994-05-21' LIMIT 1;

-- moc koni - melo by rvat
INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Fantom' LIMIT 1;

--muj tym
INSERT INTO tymy (nazev, zavod_id, kategorie_id)
	SELECT 'AlfaSamci', zavod_id, kategorie_id FROM zavod, kategorie
	WHERE zavod.misto_konani = 'pole' AND kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Karel' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Tomas' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Betty' LIMIT 1;
