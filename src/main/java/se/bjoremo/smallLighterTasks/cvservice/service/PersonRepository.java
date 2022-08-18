package se.bjoremo.christine.cvservice.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import se.bjoremo.christine.cvservice.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByUsername(String username);
    
}
