package com.capgemini.training.repository.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Entity
@Table
@Component
public class Customer {

  @Id
  @Column(name = "customer_id" )
  private String customerId;
  @Column(name = "document_type", length = 8 )
  private String documentType;
  @Column(name = "document_number", length = 50, nullable = false )
  private String documentNumber;
  @Column( length = 100, nullable = false )
  private String name;
  @Column( length = 100, nullable = false )
  private String surname;
  @Column( length = 10 )
  private String lastname;
  @Column( length = 3, nullable = false )
  private String country;
  @Column( length = 9 )
  private int telephone;
  //Giving pattern for the date
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
  @Column(name = "creation_date", nullable = false)
  private LocalDate creationDate;
  //Giving pattern for the date
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
  @Column(name = "update_date")
  private LocalDate updateDate;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Payment> payment;

}
