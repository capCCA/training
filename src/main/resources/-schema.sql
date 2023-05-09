
CREATE DATABASE training_db;

CREATE TABLE IF NOT EXISTS customer (
   customer_id VARCHAR(10) PRIMARY KEY,
   document_type VARCHAR(8) NOT NULL,
   document_number VARCHAR(50) NOT NULL ,
   name VARCHAR(100) NOT NULL,
   surname VARCHAR(100) NOT NULL,
   lastname VARCHAR(100),
   country VARCHAR(3) NOT NULL,
   telephone INTEGER,
   creation_date TIMESTAMP NOT NULL DEFAULT (now() at time zone 'utc'),
   update_date TIMESTAMP DEFAULT (now() at time zone 'utc'),
   CHECK( document_type in ('dni', 'passport') )
);

CREATE TABLE IF NOT EXISTS beneficiary (
   beneficiary_id VARCHAR(10) PRIMARY KEY,
   creation_date TIMESTAMP NOT NULL DEFAULT (now() at time zone 'utc'),
   update_date TIMESTAMP DEFAULT (now() at time zone 'utc')
);

CREATE TABLE IF NOT EXISTS payment (
   payment_id BIGSERIAL PRIMARY KEY,
   customer_id VARCHAR(10),
   beneficiary_id VARCHAR(10),
   payment_type VARCHAR(10) NOT NULL,
   amount DECIMAL NOT NULL,
   creation_date TIMESTAMP NOT NULL DEFAULT (now() at time zone 'utc'),
   update_date TIMESTAMP DEFAULT (now() at time zone 'utc'),
   CHECK( payment_type in ('bizum', 'transfer'))
);

ALTER TABLE  payment 
  ADD CONSTRAINT payment_customer_fk 
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id);
  
ALTER TABLE  payment 
  ADD CONSTRAINT payment_beneficiary_fk 
  FOREIGN KEY (beneficiary_id) REFERENCES beneficiary(beneficiary_id);
