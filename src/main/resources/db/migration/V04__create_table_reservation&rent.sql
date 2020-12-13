CREATE TABLE reservation (
	id SERIAL NOT NULL,
	iduser INT NOT NULL,
	idbook INT NOT NULL,
	rentDate DATE NOT NULL,
	CONSTRAINT PK_reservation PRIMARY KEY(id),
	CONSTRAINT FK_user_reserva FOREIGN KEY(iduser) REFERENCES users,
	CONSTRAINT FK_book_reserva FOREIGN KEY(idbook) REFERENCES book
);


CREATE TABLE rent (
	id SERIAL NOT NULL,
	iduser INT NOT NULL,
	idbook INT NOT NULL,
	rentDate DATE NOT NULL,
	devolutionDate DATE NOT NULL,
	paymentValue DECIMAL(10,2),
	CONSTRAINT PK_rent PRIMARY KEY(id),
	CONSTRAINT FK_user_rent FOREIGN KEY(iduser) REFERENCES users,
	CONSTRAINT FK_book_rent FOREIGN KEY(idbook) REFERENCES book
);
