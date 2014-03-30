--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: rimnacm
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO rimnacm;

SET search_path = public, pg_catalog;

--
-- Name: seq_kategorie; Type: SEQUENCE; Schema: public; Owner: student_db13_30
--

CREATE SEQUENCE seq_kategorie
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_kategorie OWNER TO student_db13_30;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: kategorie; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE kategorie (
    kategorie_id integer DEFAULT nextval('seq_kategorie'::regclass) NOT NULL,
    nazev character varying(20) NOT NULL,
    pocet_koni integer DEFAULT 1,
    pocet_prisedicich integer DEFAULT 1
);


ALTER TABLE public.kategorie OWNER TO student_db13_30;

--
-- Name: seq_kone; Type: SEQUENCE; Schema: public; Owner: student_db13_30
--

CREATE SEQUENCE seq_kone
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_kone OWNER TO student_db13_30;

--
-- Name: kone; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE kone (
    kun_id integer DEFAULT nextval('seq_kone'::regclass) NOT NULL,
    jmeno character varying(20) NOT NULL,
    plemeno character varying(50) NOT NULL,
    majitel character varying(35) NOT NULL
);


ALTER TABLE public.kone OWNER TO student_db13_30;

--
-- Name: seq_osoby; Type: SEQUENCE; Schema: public; Owner: student_db13_30
--

CREATE SEQUENCE seq_osoby
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_osoby OWNER TO student_db13_30;

--
-- Name: osoby; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE osoby (
    osoba_id integer DEFAULT nextval('seq_osoby'::regclass) NOT NULL,
    jmeno character varying(20) NOT NULL,
    prijmeni character varying(20) NOT NULL,
    datum_narozeni date NOT NULL,
    staj_id integer NOT NULL
);


ALTER TABLE public.osoby OWNER TO student_db13_30;

--
-- Name: osoby_has_staje; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE osoby_has_staje (
    osoby_osoba_id integer NOT NULL,
    staje_staj_id integer NOT NULL,
    platne_od date NOT NULL,
    platne_do date NOT NULL
);


ALTER TABLE public.osoby_has_staje OWNER TO student_db13_30;

--
-- Name: seq_staje; Type: SEQUENCE; Schema: public; Owner: student_db13_30
--

CREATE SEQUENCE seq_staje
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_staje OWNER TO student_db13_30;

--
-- Name: seq_startovni_cislo; Type: SEQUENCE; Schema: public; Owner: student_db13_30
--

CREATE SEQUENCE seq_startovni_cislo
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_startovni_cislo OWNER TO student_db13_30;

--
-- Name: seq_tymy; Type: SEQUENCE; Schema: public; Owner: student_db13_30
--

CREATE SEQUENCE seq_tymy
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_tymy OWNER TO student_db13_30;

--
-- Name: seq_zavod; Type: SEQUENCE; Schema: public; Owner: student_db13_30
--

CREATE SEQUENCE seq_zavod
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_zavod OWNER TO student_db13_30;

--
-- Name: staje; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE staje (
    staj_id integer DEFAULT nextval('seq_staje'::regclass) NOT NULL,
    jmeno character varying(50) NOT NULL,
    mesto character varying(20) NOT NULL
);


ALTER TABLE public.staje OWNER TO student_db13_30;

--
-- Name: tymy; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE tymy (
    tym_id integer DEFAULT nextval('seq_tymy'::regclass) NOT NULL,
    nazev character varying(50) NOT NULL,
    startovni_cislo integer DEFAULT nextval('seq_startovni_cislo'::regclass) NOT NULL,
    cas_prvniho_kola interval(0),
    cas_druheho_kola interval(0),
    penalizace_prvni_kolo integer DEFAULT 0 NOT NULL,
    penalizace_druhe_kolo integer DEFAULT 0 NOT NULL,
    dojel boolean DEFAULT false NOT NULL,
    zavod_id integer NOT NULL,
    kategorie_id integer NOT NULL
);


ALTER TABLE public.tymy OWNER TO student_db13_30;

--
-- Name: tymy_has_kone; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE tymy_has_kone (
    tymy_tym_id integer NOT NULL,
    kone_kun_id integer NOT NULL
);


ALTER TABLE public.tymy_has_kone OWNER TO student_db13_30;

--
-- Name: tymy_has_osoby; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE tymy_has_osoby (
    tymy_tym_id integer NOT NULL,
    osoby_osoba_id integer NOT NULL,
    je_jezdec boolean NOT NULL
);


ALTER TABLE public.tymy_has_osoby OWNER TO student_db13_30;

--
-- Name: zavod; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE zavod (
    zavod_id integer DEFAULT nextval('seq_zavod'::regclass) NOT NULL,
    nazev character varying(50) NOT NULL,
    datum date NOT NULL,
    misto_konani character varying(50) NOT NULL
);


ALTER TABLE public.zavod OWNER TO student_db13_30;

--
-- Name: zavod_has_kategorie; Type: TABLE; Schema: public; Owner: student_db13_30; Tablespace: 
--

CREATE TABLE zavod_has_kategorie (
    zavod_zavod_id integer NOT NULL,
    kategorie_kategorie_id integer NOT NULL
);


ALTER TABLE public.zavod_has_kategorie OWNER TO student_db13_30;

--
-- Data for Name: kategorie; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY kategorie (kategorie_id, nazev, pocet_koni, pocet_prisedicich) FROM stdin;
\.


--
-- Data for Name: kone; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY kone (kun_id, jmeno, plemeno, majitel) FROM stdin;
\.


--
-- Data for Name: osoby; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY osoby (osoba_id, jmeno, prijmeni, datum_narozeni, staj_id) FROM stdin;
\.


--
-- Data for Name: osoby_has_staje; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY osoby_has_staje (osoby_osoba_id, staje_staj_id, platne_od, platne_do) FROM stdin;
\.


--
-- Name: seq_kategorie; Type: SEQUENCE SET; Schema: public; Owner: student_db13_30
--

SELECT pg_catalog.setval('seq_kategorie', 1, false);


--
-- Name: seq_kone; Type: SEQUENCE SET; Schema: public; Owner: student_db13_30
--

SELECT pg_catalog.setval('seq_kone', 1, false);


--
-- Name: seq_osoby; Type: SEQUENCE SET; Schema: public; Owner: student_db13_30
--

SELECT pg_catalog.setval('seq_osoby', 1, false);


--
-- Name: seq_staje; Type: SEQUENCE SET; Schema: public; Owner: student_db13_30
--

SELECT pg_catalog.setval('seq_staje', 1, false);


--
-- Name: seq_startovni_cislo; Type: SEQUENCE SET; Schema: public; Owner: student_db13_30
--

SELECT pg_catalog.setval('seq_startovni_cislo', 1, false);


--
-- Name: seq_tymy; Type: SEQUENCE SET; Schema: public; Owner: student_db13_30
--

SELECT pg_catalog.setval('seq_tymy', 1, false);


--
-- Name: seq_zavod; Type: SEQUENCE SET; Schema: public; Owner: student_db13_30
--

SELECT pg_catalog.setval('seq_zavod', 1, false);


--
-- Data for Name: staje; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY staje (staj_id, jmeno, mesto) FROM stdin;
\.


--
-- Data for Name: tymy; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY tymy (tym_id, nazev, startovni_cislo, cas_prvniho_kola, cas_druheho_kola, penalizace_prvni_kolo, penalizace_druhe_kolo, dojel, zavod_id, kategorie_id) FROM stdin;
\.


--
-- Data for Name: tymy_has_kone; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY tymy_has_kone (tymy_tym_id, kone_kun_id) FROM stdin;
\.


--
-- Data for Name: tymy_has_osoby; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY tymy_has_osoby (tymy_tym_id, osoby_osoba_id, je_jezdec) FROM stdin;
\.


--
-- Data for Name: zavod; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY zavod (zavod_id, nazev, datum, misto_konani) FROM stdin;
\.


--
-- Data for Name: zavod_has_kategorie; Type: TABLE DATA; Schema: public; Owner: student_db13_30
--

COPY zavod_has_kategorie (zavod_zavod_id, kategorie_kategorie_id) FROM stdin;
\.


--
-- Name: kategorie_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY kategorie
    ADD CONSTRAINT kategorie_pkey PRIMARY KEY (kategorie_id);


--
-- Name: kone_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY kone
    ADD CONSTRAINT kone_pkey PRIMARY KEY (kun_id);


--
-- Name: osoby_has_staje_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY osoby_has_staje
    ADD CONSTRAINT osoby_has_staje_pkey PRIMARY KEY (osoby_osoba_id, staje_staj_id, platne_od, platne_do);


--
-- Name: osoby_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY osoby
    ADD CONSTRAINT osoby_pkey PRIMARY KEY (osoba_id);


--
-- Name: staje_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY staje
    ADD CONSTRAINT staje_pkey PRIMARY KEY (staj_id);


--
-- Name: tymy_has_kone_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY tymy_has_kone
    ADD CONSTRAINT tymy_has_kone_pkey PRIMARY KEY (tymy_tym_id, kone_kun_id);


--
-- Name: tymy_has_osoby_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY tymy_has_osoby
    ADD CONSTRAINT tymy_has_osoby_pkey PRIMARY KEY (tymy_tym_id, osoby_osoba_id);


--
-- Name: tymy_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY tymy
    ADD CONSTRAINT tymy_pkey PRIMARY KEY (tym_id);


--
-- Name: tymy_startovni_cislo_key; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY tymy
    ADD CONSTRAINT tymy_startovni_cislo_key UNIQUE (startovni_cislo);


--
-- Name: zavod_has_kategorie_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY zavod_has_kategorie
    ADD CONSTRAINT zavod_has_kategorie_pkey PRIMARY KEY (zavod_zavod_id, kategorie_kategorie_id);


--
-- Name: zavod_pkey; Type: CONSTRAINT; Schema: public; Owner: student_db13_30; Tablespace: 
--

ALTER TABLE ONLY zavod
    ADD CONSTRAINT zavod_pkey PRIMARY KEY (zavod_id);


--
-- Name: osoby_has_staje_osoby_osoba_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY osoby_has_staje
    ADD CONSTRAINT osoby_has_staje_osoby_osoba_id_fkey FOREIGN KEY (osoby_osoba_id) REFERENCES osoby(osoba_id);


--
-- Name: osoby_has_staje_staje_staj_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY osoby_has_staje
    ADD CONSTRAINT osoby_has_staje_staje_staj_id_fkey FOREIGN KEY (staje_staj_id) REFERENCES staje(staj_id);


--
-- Name: tymy_has_kone_kone_kun_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY tymy_has_kone
    ADD CONSTRAINT tymy_has_kone_kone_kun_id_fkey FOREIGN KEY (kone_kun_id) REFERENCES kone(kun_id);


--
-- Name: tymy_has_kone_tymy_tym_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY tymy_has_kone
    ADD CONSTRAINT tymy_has_kone_tymy_tym_id_fkey FOREIGN KEY (tymy_tym_id) REFERENCES tymy(tym_id);


--
-- Name: tymy_has_osoby_osoby_osoba_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY tymy_has_osoby
    ADD CONSTRAINT tymy_has_osoby_osoby_osoba_id_fkey FOREIGN KEY (osoby_osoba_id) REFERENCES osoby(osoba_id);


--
-- Name: tymy_has_osoby_tymy_tym_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY tymy_has_osoby
    ADD CONSTRAINT tymy_has_osoby_tymy_tym_id_fkey FOREIGN KEY (tymy_tym_id) REFERENCES tymy(tym_id);


--
-- Name: tymy_kategorie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY tymy
    ADD CONSTRAINT tymy_kategorie_id_fkey FOREIGN KEY (kategorie_id) REFERENCES kategorie(kategorie_id);


--
-- Name: tymy_zavod_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY tymy
    ADD CONSTRAINT tymy_zavod_id_fkey FOREIGN KEY (zavod_id) REFERENCES zavod(zavod_id);


--
-- Name: zavod_has_kategorie_kategorie_kategorie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY zavod_has_kategorie
    ADD CONSTRAINT zavod_has_kategorie_kategorie_kategorie_id_fkey FOREIGN KEY (kategorie_kategorie_id) REFERENCES kategorie(kategorie_id);


--
-- Name: zavod_has_kategorie_zavod_zavod_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: student_db13_30
--

ALTER TABLE ONLY zavod_has_kategorie
    ADD CONSTRAINT zavod_has_kategorie_zavod_zavod_id_fkey FOREIGN KEY (zavod_zavod_id) REFERENCES zavod(zavod_id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

