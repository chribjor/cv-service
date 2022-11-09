package se.bjoremo.cvservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import se.bjoremo.cvservice.model.Trustee;


//Trustee är mer som arbetslivserfarenhet, dvs två personer kan i teorin ha samma erfarenhet,
// men kommer aldrig hända i praktiken.

public interface TrusteeRepository extends JpaRepository<Trustee, UUID> {

    List<Trustee> findAllByPersonId(String personId);
    Optional<Trustee> findAllByPersonIdAndId(String personId, UUID id);
}
