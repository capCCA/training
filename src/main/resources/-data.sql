select 1 from dual;

INSERT INTO customer (customer_id, document_type, document_number, name, Surname, Lastname, country, telephone) VALUES
('1',	'dni',	'123456',	'Aname',	'Asurname',	'ALastname',	'44',	123123),
('2',	'dni',	'1234567',	'Anamea',	'Asurnameb',	'ALastnameb',	'045',	1231234	),
('3',	'dni',	'123456',	'Aname',	'Asurnameb',	NULL,	'',	34),
('4',	'passport',	'1234568',	'Aname',	'Asurnamed',	NULL,	'',	345);
--testear el check: Error in query: ERROR: new row for relation "customer" violates check constraint "customer_document_type_check"
--INSERT INTO customer (customer_id, document_type, document_number, name, Surname, Lastname, country, telephone) VALUES
--('5',	'Nie',	'1234568',	'Aname',	'Asurnamed',	NULL,	'',	345);
--

INSERT INTO beneficiary ("beneficiary_id") VALUES
('01'),
('02'),
('03');

--INSERT INTO "payment" ("Payment_id", "Customer_id", "Beneficiary_id", "Payment_type", "amount") VALUES
INSERT INTO payment (customer_id, beneficiary_id, payment_type, amount) VALUES
('1',	'01',	'transfer',	'201.00'),
('2',	'02',	'bizum',	'20.00'),
('3',	'03',	'bizum',	'50.50'),
('1',	'02',	'transfer',	'990.00'),
('1',	'03',	'bizum',	'500.99');

