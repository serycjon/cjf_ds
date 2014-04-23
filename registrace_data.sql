INSERT INTO tymy (nazev, zavod_id, kategorie_id)
	SELECT 'AlfaSamci', zavod_id, kategorie_id FROM zavod, kategorie
	WHERE zavod.misto_konani = 'pole' AND kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT * FROM (SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Karel' LIMIT 1) as jezdec
	UNION
	SELECT * FROM (SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Tomas' LIMIT 1) as prisedici1
	UNION
	SELECT * FROM (SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Rudolf' LIMIT 1) as jezdec2
	UNION
	SELECT * FROM (SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.datum_narozeni = '1994-05-21' LIMIT 1) as prisedici2;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT * FROM (SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Betty' LIMIT 1) as kun1
	UNION
	SELECT * FROM (SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Fantom' LIMIT 1) as kun2;

-------------------------------------------------------------------------

INSERT INTO tymy (nazev, zavod_id, kategorie_id)
	SELECT 'BetaSamci', zavod_id, kategorie_id FROM zavod, kategorie
	WHERE zavod.misto_konani = 'pole' AND kategorie.nazev = 'dvojspřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT * FROM (SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'BetaSamci' AND osoby.jmeno = 'Lada' LIMIT 1) as jezdec
	UNION 
	SELECT * FROM (SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'BetaSamci' AND osoby.jmeno = 'Jan' LIMIT 1) as prisedici;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT * FROM (SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'BetaSamci' AND kone.jmeno = 'Stargate' LIMIT 1) as kun1
	UNION
	SELECT * FROM (SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'BetaSamci' AND kone.jmeno = 'Apollo' LIMIT 1) as kun2;
