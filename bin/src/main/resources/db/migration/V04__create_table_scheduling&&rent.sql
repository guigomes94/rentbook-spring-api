CREATE TABLE scheduling (
	idscheduling SERIAL NOT NULL,
	idclient INT NOT NULL,
	idbook INT NOT NULL,
	rentDate DATE NOT NULL,
	CONSTRAINT PK_scheduling PRIMARY KEY(idscheduling),
	CONSTRAINT FK_client_scheduling FOREIGN KEY(idclient) REFERENCES client,
	CONSTRAINT FK_book_scheduling FOREIGN KEY(idbook) REFERENCES book
);


CREATE TABLE rent (
	idrent SERIAL NOT NULL,
	idclient INT NOT NULL,
	idbook INT NOT NULL,
	rentDate DATE NOT NULL,
	devolutionDate DATE NOT NULL,
	paymentValue DECIMAL(10,2),
	CONSTRAINT PK_rent PRIMARY KEY(idrent),
	CONSTRAINT FK_client_rent FOREIGN KEY(idclient) REFERENCES client,
	CONSTRAINT FK_book_rent FOREIGN KEY(idbook) REFERENCES book
);
