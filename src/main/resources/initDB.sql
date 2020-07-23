drop table post;
drop sequence if exists global_seq;
CREATE SEQUENCE global_seq START WITH 10;
CREATE TABLE post
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    title             VARCHAR                 NOT NULL,
    anons            VARCHAR                 NOT NULL,
    full_text         VARCHAR                 NOT NULL

);
