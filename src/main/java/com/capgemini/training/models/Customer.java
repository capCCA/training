package com.capgemini.training.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "User")
@Table( name = "User")
public class User {

  @Id
  @Column(name = "customer_id", nullable = false)
  private String customer_id;
  @Column(name = "document_type", length = 8, nullable = false)
  private String DocumentType;
  @Column(name = "document_number", length = 50, nullable = false)
  private String DocumentNumber;
  @Column(name = "Name", length = 100, nullable = false)
  private String name;
  @Column(name = "SurName", length = 100, nullable = false)
  private String surname;
  @Column(name = "LastName", length = 10)
  private String lastname;
  @Column(name = "country", length = 3, nullable = false)
  private String country;
  @Column(name = "Telephone", length = 9)
  private int telephone;
  //Giving pattern for the date
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
  @Column(name = "Creation_Date", nullable = false)
  private Date creationDate;
  //Giving pattern for the date
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
  @Column(name = "Update_Date")
  private Date updateDate;
}
