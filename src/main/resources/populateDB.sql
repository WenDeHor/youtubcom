delete from post;
drop sequence if exists global_seq;
CREATE SEQUENCE if not exists global_seq START WITH 10;
INSERT INTO post (id, title, anons, full_text)
VALUES (10, 'Володимир Сергійович', 'Брав мед та прополіс', 'Дякую за оперативність та якість'),
       (11, 'Юлія Олегівна', '10 л весняного меду', 'Приємний аромат меду та висока якість. Дякую');

