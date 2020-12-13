CREATE TABLE author (
	id SERIAL NOT NULL,
	name VARCHAR(50) NOT NULL,
	CONSTRAINT PK_author PRIMARY KEY(id)
);

INSERT INTO author(name) VALUES ('Robert C. Martin');
INSERT INTO author(name) VALUES ('Martin Fowler');
INSERT INTO author(name) VALUES ('Jeff Sutherland');
INSERT INTO author(name) VALUES ('Thomas H. Cormen');
INSERT INTO author(name) VALUES ('Dan Brown');
INSERT INTO author(name) VALUES ('Charles Duhigg');
INSERT INTO author(name) VALUES ('Andrew S. Tanenbaum');
INSERT INTO author(name) VALUES ('Carlos Alberto Heuser');
INSERT INTO author(name) VALUES ('Ronald J. Tocci');
INSERT INTO author(name) VALUES ('Ian Sommerville');
