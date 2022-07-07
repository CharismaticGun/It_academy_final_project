CREATE DATABASE event_final
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA IF NOT EXISTS final_project
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS final_project.events_films
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    status character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    country uuid,
    description character varying(255) COLLATE pg_catalog."default",
    dt_end_of_sale bigint,
    dt_event bigint,
    duration integer,
    release_date date,
    release_year integer,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT events_films_pkey PRIMARY KEY (uuid)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project.events_films
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS final_project.events_concerts
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    status character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    category uuid,
    description character varying(255) COLLATE pg_catalog."default",
    dt_end_of_sale integer,
    dt_event integer,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT events_concerts_pkey PRIMARY KEY (uuid)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project.events_concerts
    OWNER to postgres;