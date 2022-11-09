package se.bjoremo.cvservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity //en entitet i en tabel
@Table(name = "process")
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;

    @ManyToMany(mappedBy = "processes")
    private Set<Person> persons = new HashSet<>();

    @Column(name = "process_type")
    private String processType;

}
