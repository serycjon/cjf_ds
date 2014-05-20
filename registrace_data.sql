BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'AlfaSamci', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Karel' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Tomas' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Betty' LIMIT 1;
UPDATE tymy SET zavod_id = 1 WHERE nazev = 'AlfaSamci';
COMMIT;
--  INSERT INTO tymy (nazev, zavod_id, kategorie_id)
--  	SELECT 'AlfaSamci', zavod_id, kategorie_id FROM zavod, kategorie
--  	WHERE zavod.misto_konani = 'pole' AND kategorie.nazev = 'jednospřeží';
--  
--  INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
--  	SELECT * FROM (SELECT tym_id, osoba_id, true FROM tymy, osoby
--  	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Karel' LIMIT 1) as jezdec
--  	UNION
--  	SELECT * FROM (SELECT tym_id, osoba_id, false FROM tymy, osoby
--  	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Tomas' LIMIT 1) as prisedici1
--  	UNION
--  	SELECT * FROM (SELECT tym_id, osoba_id, true FROM tymy, osoby
--  	WHERE tymy.nazev = 'AlfaSamci' AND osoby.jmeno = 'Rudolf' LIMIT 1) as jezdec2
--  	UNION
--  	SELECT * FROM (SELECT tym_id, osoba_id, false FROM tymy, osoby
--  	WHERE tymy.nazev = 'AlfaSamci' AND osoby.datum_narozeni = '1994-05-21' LIMIT 1) as prisedici2;
--  
--  INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
--  	SELECT * FROM (SELECT tym_id, kun_id FROM tymy, kone
--  	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Betty' LIMIT 1) as kun1
--  	UNION
--  	SELECT * FROM (SELECT tym_id, kun_id FROM tymy, kone
--  	WHERE tymy.nazev = 'AlfaSamci' AND kone.jmeno = 'Fantom' LIMIT 1) as kun2;

-------------------------------------------------------------------------

BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'BetaSamci', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'dvojspřeží';

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
UPDATE tymy SET zavod_id = 1 WHERE nazev = 'BetaSamci';
COMMIT;
	
--------------------------------------------------------------------------

BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Borci', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Borci' AND osoby.jmeno = 'Daniel' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Borci' AND osoby.jmeno = 'Rudolf' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Borci' AND kone.jmeno = 'Fantom' LIMIT 1;
UPDATE tymy SET zavod_id = 1 WHERE nazev = 'Borci';
COMMIT;
	
--------------------------------------------------------------------------
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'DrsnoJezdci', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'DrsnoJezdci' AND osoby.jmeno = 'Jenovéfa' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'DrsnoJezdci' AND osoby.jmeno = 'Michal' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'DrsnoJezdci' AND kone.jmeno = 'Gaston' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Borci';
COMMIT;
	
	--
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Hnojaci', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Hnojaci' AND osoby.jmeno = 'Hans' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Hnojaci' AND osoby.jmeno = 'Vilam' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Hnojaci' AND kone.jmeno = 'Hannibal' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Hnojaci';
COMMIT;
	
	--
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Kravataci', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'jednospřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Kravataci' AND osoby.jmeno = 'Jiří' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Kravataci' AND osoby.jmeno = 'Jan' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Kravataci' AND kone.jmeno = 'Fido' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Kravataci';
COMMIT;
	
	--dvojsprezi
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Slunicka', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'dvojspřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Slunicka' AND osoby.jmeno = 'Tomas' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Slunicka' AND osoby.jmeno = 'Karel' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Slunicka' AND kone.jmeno = 'Betty' LIMIT 1;
	
INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Slunicka' AND kone.jmeno = 'Fantom' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Slunicka';
COMMIT;

--
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Draci', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'dvojspřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Draci' AND osoby.jmeno = 'Rudolf' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Draci' AND osoby.jmeno = 'Jenovéfa' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Draci' AND kone.jmeno = 'Gaston' LIMIT 1;
	
INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Draci' AND kone.jmeno = 'Hannibal' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Draci';
COMMIT;
	
	--
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Bondaci007', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'dvojspřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Bondaci007' AND osoby.jmeno = 'Michal' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Bondaci007' AND osoby.jmeno = 'Milan' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Bondaci007' AND kone.jmeno = 'Fido' LIMIT 1;
	
INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Bondaci007' AND kone.jmeno = 'Galina' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Bondaci007';
COMMIT;
	--
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Drsoni', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'dvojspřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Drsoni' AND osoby.jmeno = 'Jan' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Drsoni' AND osoby.jmeno = 'Lada' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Drsoni' AND kone.jmeno = 'Up' LIMIT 1;
	
INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Drsoni' AND kone.jmeno = 'Stargate' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Drsoni';
COMMIT;

	--
BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'Dlouhani', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'dvojspřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'Dlouhani' AND osoby.jmeno = 'Hans' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'Dlouhani' AND osoby.jmeno = 'Vilam' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Dlouhani' AND kone.jmeno = 'Kent' LIMIT 1;
	
INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'Dlouhani' AND kone.jmeno = 'Anna' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'Dlouhani';
COMMIT;
