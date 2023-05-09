-- Step 1:
INSERT INTO customer("customer_id", "document_type", "document_number", "name", "surname", "country", "telephone") VALUES
    (0123456789, 'passport', 'J12393496', 'Tony', 'Stark', 'US', '600000001'),
    (1234567890, 'passport', 'ABA9875413', 'Peter', 'Parker', 'US', '600000002'),
    (2345678901, 'passport', 'KF0192332C', 'Brian Jeremy', 'Braddock', 'UK', '600000003'),
    (3456789012, 'dni', '12345678A', 'Paquito', 'Chocolatero', 'ES', '600000004'),
    (4567890123, 'passport', 'RU146757245', 'Natalia Alianovna', 'Romanova', 'RU', '600000005');

INSERT INTO beneficiary("beneficiary_id") VALUES
    (1111111111),
    (2222222222),
    (3333333333),
    (4444444444),
    (5555555555),
    (6666666666),
    (7777777777),
    (8888888888);


 -- Step 2:
 INSERT INTO payment("payment_type", "amount", "customer_id", "beneficiary_id") VALUES
     ('bizum', 1000, 0123456789, 1111111111),
     ('bizum', 4069400, 0123456789, 1111111111),
     ('transfer', 9999000, 0123456789, 2222222222),
     ('bizum', 599, 1234567890, 2222222222),
     ('bizum', 60000, 2345678901, 4444444444),
     ('transfer', 703000000, 3456789012, 4444444444),
     ('transfer', 300000, 3456789012, 5555555555),
     ('transfer', 0.99, 4567890123, 5555555555),
     ('transfer', 351, 4567890123, 5555555555);