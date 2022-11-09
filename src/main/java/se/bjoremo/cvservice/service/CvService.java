package se.bjoremo.cvservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.bjoremo.cvservice.model.Education;
import se.bjoremo.cvservice.model.Experience;
import se.bjoremo.cvservice.model.Person;
import se.bjoremo.cvservice.model.Technic;
import se.bjoremo.cvservice.model.Trustee;
import se.bjoremo.cvservice.model.Process;

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

    @Autowired
    private ProcessRepository proRepo;

    public Education createEducation(String personId, Education newEdu) {
        return eduRepo.save(newEdu);
    }

    public List<Education> findAllEducations(String personId){
        return eduRepo.findAllByPersonId(personId);
    }

    public Optional<Education> findEducationById(String personId, UUID id){
        return eduRepo.findAllByPersonIdAndId(personId, id);
    }

    public Experience createExperience(String userId, Experience newExp) {
        return expRepo.save(newExp);
    }

    public List<Experience> findAllExperiences(String personId) {
        return expRepo.findAllByPersonId(personId);
    }

    public Optional<Experience> findExperienceById(String personId, UUID id){
        return expRepo.findByPersonIdAndId(personId, id);
    }

    public Person createPerson(Person person) {
        return perRepo.saveAndFlush(person);
    }

    public List<Person> findAllPersons() {
        return perRepo.findAll();
    }

    public Optional<Person> getPerson(String username) {
        return perRepo.findByUsername(username);
    }

    public Optional<Trustee> findTrusteesById(String personId, UUID id){
        return truRepo.findAllByPersonIdAndId(personId, id);
    }

    public Optional<Technic> findTechnicSkillsById(String personId, UUID id){
        return tecRepo.findAllByPersonIdAndId(personId, id);
    }

    public Optional<Process> findProcessesById(String personId, UUID id){
        return proRepo.findAllByPersonIdAndId(personId, id);
    }

    public List<Trustee> findAllTrustees(String personId) {
        return truRepo.findAllByPersonId(personId);
    }

    public List<Technic> findAllTechnicSkills(String personId) {
        return tecRepo.findAllByPersonId(personId);
    }

    public List<Process> findAllProcesses(String personId) {
        return proRepo.findAllByPersonId(personId);
    }

    public Trustee createTrustee(String personId, Trustee newTru){
        return truRepo.save(newTru);
    }

    public Technic createTechnic(String userId, Technic newTec) {
        return tecRepo.save(newTec);
    }

    public Process createProcess(String userId, Process newPro) {
        return proRepo.save(newPro);
    }

}
