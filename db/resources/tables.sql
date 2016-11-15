CREATE TABLE public.accounts
(
    id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(32) NOT NULL,
    pass VARCHAR(128) NOT NULL,
    roles VARCHAR(16)
);