CREATE TABLE IF NOT EXISTS customer (
	Customer_id varchar(10) NOT NULL,
	Document_type varchar(8) NOT NULL,
	Document_number varchar(50) NOT NULL,
	Name varchar(100) NOT NULL,
	Surname varchar(100) NOT NULL,
	Lastname varchar(100),
	Country varchar(3) NOT NULL,
	Telephone integer,
	Creation_Date timestamp NOT NULL DEFAULT (now() at time zone 'utc'),
	Updated_Date timestamp DEFAULT (now() at time zone 'utc'),
	CONSTRAINT customer_id_pkey PRIMARY KEY (Customer_id)
);

CREATE TABLE IF NOT EXISTS payment (
	Payment_id bigserial NOT NULL,
	Payment_type varchar(10) NOT NULL,
	Amount decimal NOT NULL,
	Creation_Date timestamp NOT NULL DEFAULT (now() at time zone 'utc'),
	Updated_Date timestamp DEFAULT (now() at time zone 'utc'),
	Customer_id varchar(10) NOT NULL,
  Beneficiary_id varchar(10) NOT NULL,
	CONSTRAINT payment_id_pkey PRIMARY KEY (Payment_id)
);

CREATE TABLE IF NOT EXISTS beneficiary (
	Beneficiary_id varchar(10) NOT NULL,
	Creation_Date timestamp NOT NULL DEFAULT (now() at time zone 'utc'),
	Updated_Date timestamp DEFAULT (now() at time zone 'utc'),
	CONSTRAINT beneficiary_id_pkey PRIMARY KEY (Beneficiary_id)
);

ALTER TABLE payment ADD CONSTRAINT payment_customer_id_fkey FOREIGN KEY (Customer_id) REFERENCES customer (Customer_id);
ALTER TABLE payment ADD CONSTRAINT beneficiary_id_fkey FOREIGN KEY (Beneficiary_id) REFERENCES beneficiary (Beneficiary_id);