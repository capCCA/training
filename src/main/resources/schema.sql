
CREATE TABLE Beneficiary (
                             beneficiary_id VARCHAR(10) NOT NULL,
                             creation_date timestamp NOT NULL,
                             update_date timestamp,
                             PRIMARY KEY (beneficiary_id)
);



CREATE TABLE Customer (
                          customer_id VARCHAR(10) NOT NULL,
                          document_type VARCHAR(8) NOT NULL,
                          document_number VARCHAR(50) NOT NULL,
                          name VARCHAR(100) NOT NULL,
                          surname VARCHAR(100) NOT NULL,
                          lastname VARCHAR(100) NOT NULL,
                          country VARCHAR(3) NOT NULL,
                          telephone integer NOT NULL,
                          creation_date timestamp NOT NULL,
                          update_date timestamp NOT NULL,
                          PRIMARY KEY (customer_id)
);


CREATE TABLE Payment (
                         payment_id bigint NOT NULL,
                         customer_id VARCHAR(10) NOT NULL,
                         beneficiary_id VARCHAR(10) NOT NULL,
                         payment_type VARCHAR(10) NOT NULL,
                         amount numeric NOT NULL,
                         creation_date timestamp NOT NULL,
                         update_date timestamp,
                         PRIMARY KEY (payment_id),
                         FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE ,
                         FOREIGN KEY (beneficiary_id) REFERENCES Beneficiary(beneficiary_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO "customer" ("customer_id", "document_type", "document_number", "name", "surname", "lastname", "country", "telephone", "creation_date", "update_date") VALUES
    ('13','DNI','25725563v','Juan','Gonu','Perez Lopez','FR',952382688,'2023-03-05 01:00:00','2023-05-20 02:00:00');

INSERT INTO Beneficiary (beneficiary_id, creation_date, update_date)
VALUES ('ben1', '2023-05-08 00:00:00', NULL);

INSERT INTO Payment (payment_id, customer_id, beneficiary_id, payment_type, amount, creation_date, update_date)
VALUES (1, '13', 'ben1', 'bizum', 100.00, '2023-05-08 00:00:00', NULL);


