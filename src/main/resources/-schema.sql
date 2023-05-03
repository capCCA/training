select 1 from dual;

--Create tables. 
/**

-- Adminer 4.8.1 PostgreSQL 15.2 (Debian 15.2-1.pgdg110+1) dump

DROP TABLE IF EXISTS "Beneficiary";
DROP SEQUENCE IF EXISTS "Beneficiary_Beneficiary:id_seq";
CREATE SEQUENCE "Beneficiary_Beneficiary:id_seq" INCREMENT  MINVALUE  MAXVALUE  CACHE ;

CREATE TABLE "public"."Beneficiary" (
    "Beneficiary_id" character varying(10) DEFAULT 'nextval(''"Beneficiary_Beneficiary:id_seq"'')' NOT NULL,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp,
    CONSTRAINT "Beneficiary_pkey" PRIMARY KEY ("Beneficiary_id")
) WITH (oids = false);

INSERT INTO "Beneficiary" ("Beneficiary_id", "Creation_date", "Update_date") VALUES
('1',	'2023-04-28 16:25:33.49504',	NULL),
('2',	'2023-04-28 16:31:24.013974',	NULL),
('3',	'2023-04-28 16:31:34.584126',	NULL);

DROP TABLE IF EXISTS "Payment";
CREATE TABLE "public"."Payment" (
    "Payment_id" bigint NOT NULL,
    "Customer_id" character varying(10) NOT NULL,
    "Beneficiary_id" character varying(10) NOT NULL,
    "Payment_type" character varying(10) NOT NULL,
    "amount" money NOT NULL,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp
) WITH (oids = false);

COMMENT ON COLUMN "public"."Payment"."Payment_id" IS 'Serial, is autoincrement';

COMMENT ON COLUMN "public"."Payment"."Payment_type" IS 'bizum,transfer';

INSERT INTO "Payment" ("Payment_id", "Customer_id", "Beneficiary_id", "Payment_type", "amount", "Creation_date", "Update_date") VALUES
(1,	'1',	'2',	'transfer',	'$101.00',	'2023-04-28 16:26:44.624301',	NULL),
(3,	'2',	'3',	'Bizum',	'$200.00',	'2023-04-28 16:32:42.125722',	NULL);

DROP TABLE IF EXISTS "User";
DROP SEQUENCE IF EXISTS "User_customer:id_seq";
CREATE SEQUENCE "User_customer_id_seq" INCREMENT  MINVALUE  MAXVALUE  CACHE ;

CREATE TABLE "public"."User" (
    "customer_id" character varying(10) DEFAULT 'nextval(''"User_customer:id_seq"'')' NOT NULL,
    "Document_type" character varying(8) NOT NULL,
    "Document_number" character varying(50) NOT NULL,
    "Name" character varying(100) NOT NULL,
    "SurName" character varying(100) NOT NULL,
    "LastName" character varying(100),
    "Country" character varying(3) NOT NULL,
    "Telephone" integer,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp,
    CONSTRAINT "User_pkey" PRIMARY KEY ("customer_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."User"."Document_type" IS 'Dni, passport';

INSERT INTO "User" ("customer_id", "Document_type", "Document_number", "Name", "SurName", "LastName", "Country", "Telephone", "Creation_date", "Update_date") VALUES
('1',	'Dni',	'123456',	'Aname',	'Asurname',	'ALastname',	'44',	123123,	'16:24:29.552419',	NULL),
('2',	'Dni',	'1234567',	'Anamea',	'Asurnameb',	'ALastnameb',	'045',	1231234,	'16:25:06.4578',	NULL),
('3',	'Dni',	'123456',	'Aname',	'Asurnameb',	NULL,	'',	34,	'16:34:48.815022',	NULL);

ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Customer_id_fkey" FOREIGN KEY ("Customer_id") REFERENCES "User"(customer_id) NOT DEFERRABLE;

**/