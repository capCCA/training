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

ALTER TABLE ONLY "public"."payment" ADD CONSTRAINT "Payment_Customer_id_fkey" FOREIGN KEY ("Customer_id") REFERENCES customer(customer_id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."payment" ADD CONSTRAINT "Payment_m_Beneficiary_id_fkey" FOREIGN KEY ("Beneficiary_id") REFERENCES beneficiary("Beneficiary_id") NOT DEFERRABLE;

-- 2023-05-04 17:42:08.646557+00