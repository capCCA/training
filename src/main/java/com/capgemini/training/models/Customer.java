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
@ToString
@Entity
@Table
public class Customer {

  @Id
  @Column(name = "customer_id" )
  private String customerId;
  @Column(name = "document_type", length = 8)
  private String DocumentType;
  @Column(name = "document_number", length = 50, nullable = false)
  private String DocumentNumber;
  @Column( length = 100, nullable = false)
  private String name;
  @Column( length = 100, nullable = false)
  private String surname;
  @Column( length = 10)
  private String lastname;
  @Column( length = 3, nullable = false)
  private String country;
  @Column( length = 9)
  private int telephone;
  //Giving pattern for the date
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
  @Column(name = "creation_date", nullable = false)
  private Date creationDate;
  //Giving pattern for the date
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
  @Column(name = "update_date")
  private Date updateDate;
}
