package se.bjoremo.christine.cvservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.bjoremo.christine.cvservice.model.Education;
import se.bjoremo.christine.cvservice.model.Experience;
import se.bjoremo.christine.cvservice.model.Person;
import se.bjoremo.christine.cvservice.model.Technic;
import se.bjoremo.christine.cvservice.model.Trustee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CvService {

    @Autowired
    private ExperienceRepository expRepo;

    @Autowired
    private EducationRepository eduRepo;

    @Autowired
    private PersonRepository perRepo;

    @Autowired
    private TrusteeRepository truRepo;

    @Autowired
    private TechnicSkillRepository tecRepo;

    public Optional<Experience> findExperience(String personId, UUID id){
        return expRepo.findByPersonIdAndId(personId, id);
    }

    public List<Experience> findAllExperiences(String personId) {
        return expRepo.findAllByPersonId(personId);
    }

    public Experience createExperience(String userId, Experience newExp) {
        return expRepo.save(newExp);
    }

    public Education findEducationById(int id){
  //      Education uni = new Education("Karlstads univeristet", "CB", "Systemdesign", "Karlstad", new Date(), new Date(), "Kandidatexamen", UUID.randomUUID());
        return null;
    }

    public Education findAllEducations(String personId){
        return eduRepo.findAllByPersonId(personId);
    }

    public Education createEducation(String personId, Education newEdu) {
        return eduRepo.save(newEdu);
    }

    public Optional<Person> getPerson(String username) {
        return perRepo.findByUsername(username);
    }

    public Person createPerson(Person person) {
        return perRepo.saveAndFlush(person);
    }

    public List<Person> findAllPersons() {
        return perRepo.findAll();
    }

    public List<Trustee> findAllTrustees() {
        return truRepo.findAll();
    }

    public List<Technic> findAllTechnicSkills() {
        return tecRepo.findAll();
    }

    public Technic createTechnic(Technic newTec) {
        return tecRepo.save(newTec);
    }

}
