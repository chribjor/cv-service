package se.bjoremo.cvservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.bjoremo.cvservice.model.Education;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {
    List<Education> findAllByPersonId(String personId);
    Optional<Education> findAllByPersonIdAndId(String personId, UUID id);
}
