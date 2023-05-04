package com.capgemini.training.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Customer {

    private String customer_id;
    private String Document_type;
    private String Document_number;
    private String Name;
    private String SurName;
    private String LastName;
    private String Country;
    private int Telephone;
    private Date Creation_date;
    private Date Update_date;

}
