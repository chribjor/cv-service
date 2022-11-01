package se.bjoremo.cvservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.bjoremo.cvservice.model.Education;

import java.util.UUID;

@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {

    Education findAllByPersonId(String personId);
}
