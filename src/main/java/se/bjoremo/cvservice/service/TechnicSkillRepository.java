package se.bjoremo.cvservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import se.bjoremo.cvservice.model.Technic;
import se.bjoremo.cvservice.model.Trustee;

public interface TechnicSkillRepository extends JpaRepository<Technic, UUID> {
    Optional<Technic> findAllByPersonIdAndId(String personId, UUID id);
    List<Technic> findAllByPersonId(String personId);
}
