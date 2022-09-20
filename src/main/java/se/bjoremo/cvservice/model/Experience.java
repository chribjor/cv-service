package se.bjoremo.christine.cvservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Date;
import java.util.UUID; //UniverseUniqueIdentifier - isch GOOGLA

@Getter //alla instansvariabler får en getter.
@Setter
@Entity
@Table(name = "experience")
public class Experience {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "person_id", nullable = true)
  private Person person;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "employer")
  private String employer;

  @Column(name = "city")
  private String city;

  @Column(name = "start_date")
  private Date startDate;

  @Column(name = "end_date")
  private Date endDate;

  @Column(name = "techniquesAndMethods")
  private String techniquesAndMethods;

}
