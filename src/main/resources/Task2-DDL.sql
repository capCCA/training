-- Usando http://localhost:9090/?pgsql=postgres&username=postgres
- Adminer 4.8.1 PostgreSQL 15.2 (Debian 15.2-1.pgdg110+1) dump

DROP TABLE IF EXISTS "beneficiary";
DROP SEQUENCE IF EXISTS "Beneficiary_Beneficiary:id_seq";
CREATE SEQUENCE "Beneficiary_Beneficiary:id_seq" INCREMENT  MINVALUE  MAXVALUE  CACHE ;

CREATE TABLE "public"."beneficiary" (
    "Beneficiary_id" character varying(10) DEFAULT 'nextval(''"Beneficiary_Beneficiary:id_seq"'')' NOT NULL,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp,
    CONSTRAINT "Beneficiary_pkey" PRIMARY KEY ("Beneficiary_id")
) WITH (oids = false);

INSERT INTO "beneficiary" ("Beneficiary_id", "Creation_date", "Update_date") VALUES
('1',	'2023-04-28 16:25:33.49504',	NULL),
('2',	'2023-04-28 16:31:24.013974',	NULL),
('3',	'2023-04-28 16:31:34.584126',	NULL);

DROP TABLE IF EXISTS "customer";
DROP SEQUENCE IF EXISTS "User_customer_id_seq";
CREATE SEQUENCE "User_customer_id_seq" INCREMENT  MINVALUE  MAXVALUE  CACHE ;

CREATE TABLE "public"."customer" (
    "customer_id" character varying(10) DEFAULT 'nextval(''"User_customer_id_seq"'')' NOT NULL,
    "document_type" character varying(8) NOT NULL,
    "document_number" character varying(50) NOT NULL,
    "name" character varying(100) NOT NULL,
    "surname" character varying(100) NOT NULL,
    "lastname" character varying(100),
    "country" character varying(3) NOT NULL,
    "telephone" integer,
    "creation_date" time without time zone NOT NULL,
    "update_date" timestamp,
    CONSTRAINT "User_pkey" PRIMARY KEY ("customer_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."customer"."document_type" IS 'Dni, passport';

INSERT INTO "customer" ("customer_id", "document_type", "document_number", "name", "surname", "lastname", "country", "telephone", "creation_date", "update_date") VALUES
('004',	'Dni',	'2222222',	'c31',	'c32',	'c33',	'034',	99,	'13:23:39.723',	'2023-05-04 19:36:56.869');

DROP TABLE IF EXISTS "payment";
CREATE TABLE "public"."payment" (
    "Payment_id" bigint NOT NULL,
    "Customer_id" character varying(10) NOT NULL,
    "Beneficiary_id" character varying(10) NOT NULL,
    "Payment_type" character varying(10) NOT NULL,
    "amount" money NOT NULL,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp
) WITH (oids = false);

COMMENT ON COLUMN "public"."payment"."Payment_id" IS 'Serial, is autoincrememtn';
COMMENT ON COLUMN "public"."payment"."Payment_type" IS 'bizum,transfer';

INSERT INTO "payment" ("Payment_id", "Customer_id", "Beneficiary_id", "Payment_type", "amount", "Creation_date", "Update_date") VALUES
(1,	'1',	'2',	'transfer',	'$101.00',	'2023-04-28 16:26:44.624301',	NULL),
(3,	'2',	'3',	'Bizum',	'$200.00',	'2023-04-28 16:32:42.125722',	NULL);

ALTER TABLE ONLY "public"."payment" ADD CONSTRAINT "Payment_Customer_id_fkey" FOREIGN KEY ("Customer_id") REFERENCES customer(customer_id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."payment" ADD CONSTRAINT "Payment_m_Beneficiary_id_fkey" FOREIGN KEY ("Beneficiary_id") REFERENCES beneficiary("Beneficiary_id") NOT DEFERRABLE;

-- 2023-05-04 17:42:08.646557+00