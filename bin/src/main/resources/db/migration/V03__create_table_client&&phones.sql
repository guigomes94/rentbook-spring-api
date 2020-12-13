CREATE TABLE client (
	idclient SERIAL NOT NULL,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	CONSTRAINT PK_client PRIMARY KEY(idclient)
);

CREATE TABLE phone (
	idphone SERIAL NOT NULL,
	number VARCHAR(15) NOT NULL,
	idclient INT NOT NULL,
	CONSTRAINT PK_phone PRIMARY KEY(idphone),
	CONSTRAINT FK_client FOREIGN KEY(idclient) REFERENCES client
);


insert into client (name, email) values ('Hendrick Carlsen', 'hcarlsen0@gizmodo.com');
insert into client (name, email) values ('Ade Ferfulle', 'aferfulle1@odnoklassniki.ru');
insert into client (name, email) values ('Rosalinda Waiting', 'rwaiting2@nyu.edu');
insert into client (name, email) values ('Sydel McCaghan', 'smccaghan3@about.com');
insert into client (name, email) values ('Keely Berisford', 'kberisford4@imgur.com');
insert into client (name, email) values ('Alberik Laphorn', 'alaphorn5@amazon.de');
insert into client (name, email) values ('Tiler Hodgon', 'thodgon6@sun.com');
insert into client (name, email) values ('Ami Stowgill', 'astowgill7@tmall.com');
insert into client (name, email) values ('Rodrick Perring', 'rperring8@economist.com');
insert into client (name, email) values ('Evyn Cuer', 'ecuer9@ehow.com');
insert into client (name, email) values ('Debora Guerin', 'dguerina@goo.gl');
insert into client (name, email) values ('Cortney Birkmyr', 'cbirkmyrb@narod.ru');
insert into client (name, email) values ('Germayne Netti', 'gnettic@nydailynews.com');
insert into client (name, email) values ('Bernadina Ladlow', 'bladlowd@google.it');
insert into client (name, email) values ('Calida McKmurrie', 'cmckmurriee@japanpost.jp');
insert into client (name, email) values ('Oswell Scates', 'oscatesf@dyndns.org');
insert into client (name, email) values ('Johnny Ghelardi', 'jghelardig@gizmodo.com');
insert into client (name, email) values ('Darrick McCuthais', 'dmccuthaish@toplist.cz');
insert into client (name, email) values ('Tamqrah Pepall', 'tpepalli@behance.net');
insert into client (name, email) values ('Terrell Trighton', 'ttrightonj@ucla.edu');
insert into client (name, email) values ('Joaquin Craise', 'jcraisek@free.fr');
insert into client (name, email) values ('Ki Laurence', 'klaurencel@tinypic.com');
insert into client (name, email) values ('Chrissy Shortell', 'cshortellm@posterous.com');
insert into client (name, email) values ('Holli Bonnick', 'hbonnickn@google.fr');
insert into client (name, email) values ('Ettore Masterton', 'emastertono@freewebs.com');
insert into client (name, email) values ('Joete Broker', 'jbrokerp@sciencedaily.com');
insert into client (name, email) values ('Britt Pawlyn', 'bpawlynq@arstechnica.com');
insert into client (name, email) values ('Hashim Grose', 'hgroser@cmu.edu');
insert into client (name, email) values ('Rosanne Rusling', 'rruslings@biblegateway.com');
insert into client (name, email) values ('Linda Megainey', 'lmegaineyt@apache.org');

insert into phone (number, idclient) values ('11999887755', 2);
insert into phone (number, idclient) values ('11988992233', 2);
insert into phone (number, idclient) values ('45912345678', 2);
insert into phone (number, idclient) values ('83988885555', 1);
insert into phone (number, idclient) values ('81955662233', 3);
insert into phone (number, idclient) values ('81944118989', 3);
