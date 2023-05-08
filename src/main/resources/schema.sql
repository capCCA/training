DROP TABLE IF EXISTS "Beneficiary";
CREATE TABLE "public"."Beneficiary" (
                                        "Beneficiary_id" VARCHAR(10) NOT NULL,
                                        "Creation_date" timestamp NOT NULL,
                                        "Update_date" timestamp,
                                        CONSTRAINT "Beneficiary_pkey" PRIMARY KEY ("Beneficiary_id")
) WITH (oids = false);


DROP TABLE IF EXISTS "Payment";
CREATE TABLE "public"."Payment" (
                                    "Payment_id" bigint NOT NULL,
                                    "Customer_id" VARCHAR(10) NOT NULL,
                                    "Beneficiary_id" VARCHAR(10) NOT NULL,
                                    "Payment_type" VARCHAR(10) NOT NULL,
                                    "Amount" numeric NOT NULL,
                                    "Creation_date" timestamp NOT NULL,
                                    "Update_date" timestamp
) WITH (oids = false);


DROP TABLE IF EXISTS "customer";
CREATE TABLE "public"."customer" (
                                     "customer_id" VARCHAR(10) NOT NULL,
                                     "document_type" VARCHAR(8) NOT NULL,
                                     "document_number" VARCHAR(50) NOT NULL,
                                     "name" VARCHAR(100) NOT NULL,
                                     "surname" VARCHAR(100) NOT NULL,
                                     "lastname" VARCHAR(100) NOT NULL,
                                     "country" VARCHAR(3) NOT NULL,
                                     "telephone" integer NOT NULL,
                                     "creation_date" timestamp NOT NULL,
                                     "update_date" timestamp NOT NULL,
                                     CONSTRAINT "User_pkey" PRIMARY KEY ("customer_id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Beneficiary_id_fkey" FOREIGN KEY ("Beneficiary_id") REFERENCES "Beneficiary"("Beneficiary_id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE;
ALTER TABLE ONLY "public"."Payment" ADD CONSTRAINT "Payment_Customer_id_fkey" FOREIGN KEY ("Customer_id") REFERENCES customer(customer_id) ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE;

-- 2023-05-07 20:35:54.62171+00