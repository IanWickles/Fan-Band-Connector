BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	email_address varchar(200) NOT NULL UNIQUE,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS public.band
(
    band_id integer NOT NULL DEFAULT nextval('"Band_band_id_seq"'::regclass),
    band_name character varying(200) COLLATE pg_catalog."default" NOT NULL,
    band_description character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    band_member character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    manager_id integer NOT NULL,
    CONSTRAINT band_id PRIMARY KEY (band_id),
    CONSTRAINT manager_id FOREIGN KEY (manager_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.band
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.genre
(
    genre_id integer NOT NULL DEFAULT nextval('genre_genre_id_seq'::regclass),
    genre_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT genre_pkey PRIMARY KEY (genre_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.genre
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.band_genre
(
    band_id integer NOT NULL,
    genre_id integer NOT NULL,
    CONSTRAINT band_id FOREIGN KEY (band_id)
        REFERENCES public.band (band_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT genre_id FOREIGN KEY (genre_id)
        REFERENCES public.genre (genre_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.band_genre
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.messages
(
    message_id integer NOT NULL DEFAULT nextval('messages_message_id_seq'::regclass),
    message_body character varying(2000) COLLATE pg_catalog."default" NOT NULL,
    message_timestamp timestamp without time zone NOT NULL,
    band_id integer NOT NULL,
    CONSTRAINT messages_pkey PRIMARY KEY (message_id),
    CONSTRAINT band_id FOREIGN KEY (band_id)
        REFERENCES public.band (band_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.messages
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.user_band
(
    user_id integer NOT NULL,
    band_id integer NOT NULL,
    CONSTRAINT band_id FOREIGN KEY (band_id)
        REFERENCES public.band (band_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_band
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.show
(
    show_id integer NOT NULL DEFAULT nextval('show_show_id_seq'::regclass),
    show_time timestamp without time zone NOT NULL,
    show_location character varying(200) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT show_pkey PRIMARY KEY (show_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.show
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.show_band
(
    show_id integer NOT NULL,
    band_id integer NOT NULL,
    CONSTRAINT band_id FOREIGN KEY (band_id)
        REFERENCES public.band (band_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT show_id FOREIGN KEY (show_id)
        REFERENCES public.show (show_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.show_band
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.venue
(
    venue_id integer NOT NULL DEFAULT nextval('venue_venue_id_seq'::regclass),
    venue_name character varying(200) COLLATE pg_catalog."default" NOT NULL,
    venue_address character varying(200) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT venue_pkey PRIMARY KEY (venue_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.venue
    OWNER to postgres;

COMMIT TRANSACTION;
