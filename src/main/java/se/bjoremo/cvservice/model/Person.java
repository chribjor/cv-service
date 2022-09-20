package se.bjoremo.christine.cvservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter  //hämta värdena
@Setter  //Sätta värden
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy = "person")
    private Set<Education> educations;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Person_Technic",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "technic_id")}
    )
    private Set<Technic> technics = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Person_Process",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "process_id")}
    )
    private Set<Process> processes = new HashSet<>();

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Person_Trustee",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "trustee_id") }
    )
    private Set<Trustee> trustees = new HashSet<>();

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Person_Experience",
        joinColumns = { @JoinColumn(name = "person_id") },
        inverseJoinColumns = { @JoinColumn(name = "experience_id") }
    )
    private Set<Experience> experiences = new HashSet<>();

}
