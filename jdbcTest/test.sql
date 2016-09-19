CREATE TABLE Person(
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

INSERT INTO Person(name, email) VALUES ('Dragos', 'dragos_s@hotmail.com');
INSERT INTO Person(name, email) VALUES ('Office', 'office@hotmail.com');

DELETE FROM Person WHERE id=1;

UPDATE Person SET name='modified', email='new_email@hotmail.com' WHERE name = 'Sales';

SELECT * FROM Person;