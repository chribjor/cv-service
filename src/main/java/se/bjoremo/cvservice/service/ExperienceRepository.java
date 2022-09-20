package se.bjoremo.christine.cvservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.bjoremo.christine.cvservice.model.Experience;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, UUID> {
    List<Experience> findAllByPersonId(String personId);
    Optional<Experience> findByPersonIdAndId(String personId, UUID id);

}
