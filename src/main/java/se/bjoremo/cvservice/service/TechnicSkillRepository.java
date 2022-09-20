package se.bjoremo.christine.cvservice.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import se.bjoremo.christine.cvservice.model.Technic;

public interface TechnicSkillRepository extends JpaRepository<Technic, UUID> {
    
}
