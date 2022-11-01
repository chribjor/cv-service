package se.bjoremo.cvservice.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import se.bjoremo.cvservice.model.Trustee;

public interface TrusteeRepository extends JpaRepository<Trustee, UUID> {
    
    
}
