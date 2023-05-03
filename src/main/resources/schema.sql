-- Adminer 4.8.1 PostgreSQL 15.2 (Debian 15.2-1.pgdg110+1) dump

DROP TABLE IF EXISTS "Beneficiary";
DROP SEQUENCE IF EXISTS "Beneficiary_Beneficiary_id_seq";

CREATE TABLE "public"."Beneficiary" (
                                        "Beneficiary_id" character(10) DEFAULT 'nextval(''"Beneficiary_Beneficiary_id_seq"'')' NOT NULL,
                                        "Creation_date" timestamp NOT NULL,
                                        "Update_date" timestamp,
                                        CONSTRAINT "Beneficiary_pkey" PRIMARY KEY ("Beneficiary_id")
) WITH (oids = false);


DROP TABLE IF EXISTS "Payment";
CREATE TABLE "public"."Payment" (
                                    "Payment_id" bigint NOT NULL,
                                    "Customer_id" character(10) NOT NULL,
                                    "Beneficiary_id" character(10) NOT NULL,
                                    "Payment_type" character(10) NOT NULL,
                                    "Amount" numeric NOT NULL,
                                    "Creation_date" timestamp NOT NULL,
                                    "Update_date" timestamp
) WITH (oids = false);


DROP TABLE IF EXISTS "User";
DROP SEQUENCE IF EXISTS "User_customer_id_seq";

CREATE TABLE "public"."User" (
                                 "customer_id" character(10) DEFAULT 'nextval(''"User_customer_id_seq"'')' NOT NULL,
                                 "Document_type" character(8) NOT NULL,
                                 "Document_number" character(50) NOT NULL,
                                 "Name" character(100) NOT NULL,
                                 "SurName" character(100) NOT NULL,
                                 "LastName" character(100) NOT NULL,
                                 "Country" character(3) NOT NULL,
                                 "Telephone" integer NOT NULL,
                                 "Creation_date" timestamp NOT NULL,
                                 "Update_date" timestamp NOT NULL,
                                 CONSTRAINT "User_pkey" PRIMARY KEY ("customer_id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Beneficiary_id_fkey" FOREIGN KEY ("Beneficiary_id") REFERENCES "Beneficiary"("Beneficiary_id") NOT DEFERRABLE;
ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Customer_id_fkey" FOREIGN KEY ("Customer_id") REFERENCES "User"(customer_id) NOT DEFERRABLE;

-- 2023-05-03 08:06:54.117389+00