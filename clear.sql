drop sequence seq_zavod CASCADE;
drop sequence seq_kategorie CASCADE;
drop sequence seq_tymy CASCADE;
drop sequence seq_osoby CASCADE;
drop sequence seq_kone CASCADE;
drop sequence seq_staje CASCADE;

drop table if exists "kategorie" cascade;
drop table if exists "zavod_has_kategorie" cascade;
drop table if exists "zavod" cascade;
drop table if exists "kone" cascade;
drop table if exists "staje" cascade;
drop table if exists "osoby_has_staje" cascade;
drop table if exists "osoby" cascade;
drop table if exists "tymy" cascade;
drop table if exists "tymy_has_kone" cascade;
drop table if exists "tymy_has_osoby" cascade;
