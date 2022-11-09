package se.bjoremo.cvservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.bjoremo.cvservice.model.Process;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProcessRepository extends JpaRepository<Process, UUID> {

    List<Process> findAllByPersonId(String personId);
    Optional<Process> findAllByPersonIdAndId(String personId, UUID id);
}
