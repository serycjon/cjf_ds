BEGIN;
INSERT INTO tymy (nazev, kategorie_id)
	SELECT 'chybny', kategorie_id FROM kategorie
	WHERE kategorie.nazev = 'dvojspřeží';

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, true FROM tymy, osoby
	WHERE tymy.nazev = 'chybny' AND osoby.jmeno = 'Hans' LIMIT 1;

INSERT INTO tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec)
	SELECT tym_id, osoba_id, false FROM tymy, osoby
	WHERE tymy.nazev = 'chybny' AND osoby.jmeno = 'Vilam' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'chybny' AND kone.jmeno = 'Kent' LIMIT 1;

INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'chybny' AND kone.jmeno = 'Fido' LIMIT 1;
	
INSERT INTO tymy_has_kone (tymy_tym_id, kone_kun_id)
	SELECT tym_id, kun_id FROM tymy, kone
	WHERE tymy.nazev = 'chybny' AND kone.jmeno = 'Anna' LIMIT 1;
UPDATE tymy SET zavod_id = 2 WHERE nazev = 'chybny';
COMMIT;
