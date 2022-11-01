package se.bjoremo.cvservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "education_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;

    @Column(name = "school")
    private String school;

    @Column(name = "focus")
    private String focus;

    @Column(name = "city")
    private String city;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "degree")
    private String degree;

}
