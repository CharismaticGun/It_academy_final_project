

CREATE DATABASE  classifier_final
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA IF NOT EXISTS final_project_classifier
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS final_project_classifier.concert_categories
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT concert_categories_pkey PRIMARY KEY (uuid)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project_classifier.concert_categories
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS final_project_classifier.countries
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    description character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT countries_pkey PRIMARY KEY (uuid)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project_classifier.countries
    OWNER to postgres;

