-- Adminer 4.8.1 PostgreSQL 15.2 (Debian 15.2-1.pgdg110+1) dump

DROP TABLE IF EXISTS "Beneficiary";
CREATE TABLE "public"."Beneficiary" (
    "Beneficiary_id" character varying(10) NOT NULL,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp,
    CONSTRAINT "Beneficiary_Beneficiary_id" PRIMARY KEY ("Beneficiary_id")
) WITH (oids = false);


DROP TABLE IF EXISTS "Payment";
DROP SEQUENCE IF EXISTS "Payment_Payment_id_seq";
CREATE SEQUENCE "Payment_Payment_id_seq" INCREMENT  MINVALUE  MAXVALUE  CACHE ;

CREATE TABLE "public"."Payment" (
    "Payment_id" bigint DEFAULT nextval('"Payment_Payment_id_seq"') NOT NULL,
    "Customer_id" character varying(10) NOT NULL,
    "Beneficiary_id" character varying(10) NOT NULL,
    "Payment_type" character varying(10) DEFAULT 'bizum, transfer' NOT NULL,
    "Amount" double precision NOT NULL,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp,
    CONSTRAINT "Payment_pkey" PRIMARY KEY ("Payment_id")
) WITH (oids = false);


DROP TABLE IF EXISTS "User";
CREATE TABLE "public"."User" (
    "customer_id" character varying(10) NOT NULL,
    "Document_type" character varying(8) DEFAULT 'DNI, passport' NOT NULL,
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


ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Beneficiary_id_fkey" FOREIGN KEY ("Beneficiary_id") REFERENCES "Beneficiary"("Beneficiary_id") NOT DEFERRABLE;
ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Customer_id_fkey" FOREIGN KEY ("Customer_id") REFERENCES "User"(customer_id) NOT DEFERRABLE;

-- 2023-05-05 11:54:41.61827+00