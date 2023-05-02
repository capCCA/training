select 1 from dual;

--Create tables
/**
DROP TABLE IF EXISTS "Beneficiary";
DROP SEQUENCE IF EXISTS "Beneficiary_Beneficiary_id_seq";
CREATE SEQUENCE "Beneficiary_Beneficiary_id_seq" INCREMENT  MINVALUE  MAXVALUE  CACHE ;

CREATE TABLE "public"."Beneficiary" (
    "Beneficiary_id" character varying(10) DEFAULT 'nextval(''"Beneficiary_Beneficiary_id_seq"'')' NOT NULL,
    "Creation_date" timestamp NOT NULL,
    "Update_date" timestamp,
    CONSTRAINT "Beneficiary_pkey" PRIMARY KEY ("Beneficiary_id")
) WITH (oids = false);
**/