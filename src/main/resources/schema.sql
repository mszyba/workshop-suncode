--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 2083 (class 1259 OID 392707)
-- Dependencies: 5
-- Name: tabela_testowa; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE tabela_testowa (
                                id bigint NOT NULL,
                                kolumna1 character varying(256),
                                kolumna2 character varying(256),
                                kolumna3 character varying(256),
                                kolumna4 bigint
);


ALTER TABLE public.tabela_testowa OWNER TO postgres;

--
-- TOC entry 2407 (class 0 OID 392707)
-- Dependencies: 2083
-- Data for Name: tabela_testowa; Type: TABLE DATA; Schema: public; Owner: postgres
--


ALTER TABLE ONLY tabela_testowa
    ADD CONSTRAINT i1_constr PRIMARY KEY (id);
