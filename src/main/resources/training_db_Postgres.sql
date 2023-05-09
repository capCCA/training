--CREATE DATABASE training_db;
CREATE TABLE IF NOT EXISTS customer (											
   customer_id VARCHAR(10) PRIMARY KEY,                   
   document_type VARCHAR(8) NOT NULL,                     
   document_number VARCHAR(50) NOT NULL ,                 
   name VARCHAR(100) NOT NULL,                            
   sur_name VARCHAR(100) NOT NULL,                        
   last_name VARCHAR(100),                                
   country VARCHAR(3) NOT NULL,                           
   telephone INTEGER,                                     
   creation_date TIMESTAMP NOT NULL,                      
   update_date TIMESTAMP,                                 
   check(document_type in ('DNI', 'PASSPORT'))            
);                                                        
CREATE TABLE IF NOT EXISTS beneficiary (
   beneficiary_id VARCHAR(10) PRIMARY KEY,
   creation_date TIMESTAMP NOT NULL,
   update_date TIMESTAMP
);


CREATE TABLE IF NOT EXISTS payment (
   payment_id BIGSERIAL PRIMARY KEY,
   customer_id VARCHAR(10),
   beneficiary_id VARCHAR(10),
   payment_type VARCHAR(10) NOT NULL,
   account DECIMAL NOT NULL,
   creation_date TIMESTAMP NOT NULL,
   update_date TIMESTAMP,
   check(payment_type in ('BIZUM', 'TRANSFER')),
   CONSTRAINT fk_user FOREIGN KEY(customer_id)
      REFERENCES user(customer_id),
   CONSTRAINT fk_beneficiary FOREIGN KEY(beneficiary_id)
      REFERENCES beneficiary(beneficiary_id)
);



ALTER TABLE  payment 
		ADD CONSTRAINT Payment_Beneficiary_fkey 
		FOREIGN KEY (beneficiary_id) REFERENCES beneficiary(beneficiary_id) ;
ALTER TABLE  payment 
		ADD CONSTRAINT Payment_Customer_fkey 
		FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ;