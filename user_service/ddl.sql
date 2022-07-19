CREATE DATABASE user_final
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA IF NOT EXISTS final_project_user
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS final_project_user.users
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    mail character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nick character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (uuid),
    CONSTRAINT uk_jhck7kjdogc7yia7qamc89ypv UNIQUE (mail)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project_user.users
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS final_project_user.user_roles
(
    uuid uuid NOT NULL,
    role character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT fkt4lx3rpw6gxkb49bvohe3sq5m FOREIGN KEY (uuid)
        REFERENCES final_project_user.users (uuid) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project_user.user_roles
    OWNER to postgres;


