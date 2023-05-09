package com.capgemini.training.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;*/

/**
 * @author ccsw
 * 
 */

@Table(name = "User")

@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private String customer_id;

    @Column(name = "Document_type", nullable = false)
    private String Document_type;

    @Column(name = "Document_number", nullable = false)
    private String Document_number;

    @Column(name = "Name", nullable = false)
    private String Name;

    @Column(name = "SurName", nullable = false)
    private String SurName;

    @Column(name = "LastName", nullable = true)
    private String LastName;

    @Column(name = "Country", nullable = false)
    private String Country;

    @Column(name = "Telephone", nullable = true)
    private Integer Telephone;

    @Column(name = "Creation_date", nullable = false)
    private Integer Creation_date;

    @Column(name = "Update_date", nullable = true)
    private Integer Update_date;

}
