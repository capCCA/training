select 1 from dual;

--Create tables from  http://localhost:9090/?pgsql=postgres&username=postgres
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


ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Customer_id_fkey" FOREIGN KEY ("Customer_id") REFERENCES "User"(customer_id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Beneficiary_id_fkey" FOREIGN KEY ("Beneficiary_id") REFERENCES "Beneficiary"("Beneficiary_id") NOT DEFERRABLE;

**/