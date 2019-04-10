CREATE USER webuser WITH PASSWORD 'webpassword';
CREATE DATABASE menagerie_db;
GRANT ALL PRIVILEGES ON DATABASE menagerie_db TO webuser;
\connect menagerie_db webuser;
CREATE TABLE menagerie
(
  id        BIGSERIAL PRIMARY KEY,
  name      VARCHAR(255),
  title     VARCHAR(255),
  position  VARCHAR(255),
  planet    VARCHAR(255),
  birthdate TIMESTAMP
);

INSERT INTO menagerie (name, title, position, planet, birthdate)
VALUES ('Абаддон', 'Командор', 'Советник Хоруса', 'Хтония', '1000.01.01');
INSERT INTO menagerie (name, title, position, planet, birthdate)
VALUES ('Калгар', 'Лорд', 'Магистр ордена Ультрамаринов', 'Ультрамар', '999.01.01');
INSERT INTO menagerie (name, title, position, planet, birthdate)
VALUES ('Шрайк', 'Командор', 'Магистр Гвардии Ворона', 'Киавар', '1001.01.01');