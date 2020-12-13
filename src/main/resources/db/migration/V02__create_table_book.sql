CREATE TABLE book (
	id SERIAL NOT NULL,
	title VARCHAR(100) NOT NULL,
	idauthor INT NOT NULL,
	available BOOL DEFAULT true,
	CONSTRAINT PK_book PRIMARY KEY(id),
	CONSTRAINT FK_author FOREIGN KEY(idauthor) REFERENCES author
);

INSERT INTO book(title, idauthor) VALUES ('Código Limpo: Habilidades Práticas do Agile Software', 1);
INSERT INTO book(title, idauthor) VALUES ('Refactoring: Improving the Design of Existing Code', 2);
INSERT INTO book(title, idauthor) VALUES ('Scrum: a arte de fazer o dobro do trabalho na metade do tempo', 3);
INSERT INTO book(title, idauthor) VALUES ('Introduction To Algorithms', 4);
INSERT INTO book(title, idauthor) VALUES ('Inferno', 5);
INSERT INTO book(title, idauthor) VALUES ('O Poder do Hábito', 6);
INSERT INTO book(title, idauthor) VALUES ('Sistemas Operacionais Modernos', 7);
INSERT INTO book(title, idauthor) VALUES ('Projeto de Banco de Dados', 8);
INSERT INTO book(title, idauthor) VALUES ('Sistemas Digitais - Princípios e Aplicações', 9);
INSERT INTO book(title, idauthor) VALUES ('Engenharia de Software', 10);
