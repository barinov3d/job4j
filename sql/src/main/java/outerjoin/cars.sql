DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS body;
DROP TABLE IF EXISTS engine;
DROP TABLE IF EXISTS transmission;

CREATE TABLE body (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE engine (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE transmission (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE car (
  id              SERIAL PRIMARY KEY,
  name            VARCHAR(100),
  body_id         INT REFERENCES body (id),
  engine_id       INT REFERENCES engine (id),
  transmission_id INT REFERENCES transmission (id)
);

INSERT INTO body (name) VALUES ('sedan'), ('cope'), ('cabriolet');
INSERT INTO engine (name) VALUES ('200'), ('150'), ('110');
INSERT INTO transmission (name) VALUES ('auto 4 steps'), ('manual'), ('auto 6 steps');

INSERT INTO car (name, body_id, engine_id, transmission_id)
VALUES ('car1', 1, 3, 2), ('car2', 2, 1, 3);

SELECT
  c.name,
  b.name,
  e.name,
  t.name
FROM car AS c LEFT OUTER JOIN body AS b ON c.body_id = b.id
  LEFT OUTER JOIN engine AS e ON c.engine_id = e.id
  LEFT OUTER JOIN transmission AS t ON c.transmission_id = t.id;

SELECT b.name
FROM body AS b LEFT OUTER JOIN car AS c ON c.body_id = b.id
WHERE c.id IS NULL;
SELECT e.name
FROM engine AS e LEFT OUTER JOIN car AS c ON c.engine_id = e.id
WHERE c.id IS NULL;
SELECT t.name
FROM transmission AS t LEFT OUTER JOIN car AS c ON c.transmission_id = t.id
WHERE c.id IS NULL;