package se.bjoremo.christine.cvservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "technic")
public class Technic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToMany(mappedBy = "technics")
    private Set<Person> persons = new HashSet<>();

    @Column(name = "technic_area")
    private String technicArea;

}
