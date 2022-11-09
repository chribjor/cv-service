package se.bjoremo.cvservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.bjoremo.cvservice.model.Education;
import se.bjoremo.cvservice.model.Experience;
import se.bjoremo.cvservice.model.Person;
import se.bjoremo.cvservice.model.Technic;
import se.bjoremo.cvservice.model.Trustee;
import se.bjoremo.cvservice.model.Process;
import se.bjoremo.cvservice.service.CvService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("cv")
public class CvController {

    @Autowired
    private CvService cvService;

    @GetMapping("/{username}")
    public Person getPerson(@PathVariable String username){
       
        Optional<Person> result = cvService.getPerson(username);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    @GetMapping("/")
    public List<Person> getAllPersons(){
        return cvService.findAllPersons();
    }

    @PostMapping("/")
    public Person createPerson(@RequestBody Person person){
        return cvService.createPerson(person);
    }

    @PostMapping("/{userId}/education")
    public Education createEducation(@PathVariable String userId, @RequestBody Education newEdu){
        return cvService.createEducation(userId, newEdu);
    }

    @GetMapping("/{userId}/education")
    public List<Education> getAllEducations(@PathVariable String userId){
        return cvService.findAllEducations(userId);
    }

    @GetMapping("/{userId}/education/{eduId}")
    public Education getEducationById(@PathVariable String userId, @PathVariable String eduId){
        UUID uuid = UUID.fromString(eduId);
        Optional<Education> result = cvService.findEducationById(userId, uuid);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    @PostMapping("/{userId}/experience")
    public Experience createExperience(@PathVariable String userId, @RequestBody Experience newExp){
        return cvService.createExperience(userId, newExp);
    }

    @GetMapping("/{userId}/experience")
    public List<Experience> getAllExperiences(@PathVariable String userId){
        return cvService.findAllExperiences(userId);
    }

    @GetMapping("/{userId}/experience/{expId}")
    public Experience getExperienceById(@PathVariable String userId, @PathVariable String expId){
        UUID uuid = UUID.fromString(expId);
        Optional<Experience> result = cvService.findExperienceById(userId, uuid);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    @PostMapping("/{userId}/trustee")
    public Trustee createTrustee(@PathVariable String userId, @RequestBody Trustee newTru){
        return cvService.createTrustee(userId, newTru);
    }

    @GetMapping("/{userId}/trustee")
    public List<Trustee> getAllTrustees(@PathVariable String userId){
        return cvService.findAllTrustees(userId);
    }

    @GetMapping("/{userId}/trustee/{truId}")
    public Trustee getTrusteeById(@PathVariable String userId, @PathVariable String truId){
        UUID uuid = UUID.fromString(truId);
        Optional<Trustee> result = cvService.findTrusteesById(userId, uuid);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    @PostMapping("/{userId}/technic")
    public Technic createTechnic(@PathVariable String userId, @RequestBody Technic newTec){
        return cvService.createTechnic(userId, newTec);
    }

    @GetMapping("/{userId}/technical")
    public List<Technic> getAllTechnicalSkills(@PathVariable String userId){
        return cvService.findAllTechnicSkills(userId);
    }

    @GetMapping("/{userId}/technic/{tecId}")
    public Technic getTechnicById(@PathVariable String userId, @PathVariable String tecId){
        UUID uuid = UUID.fromString(tecId);
        Optional<Technic> result = cvService.findTechnicSkillsById(userId, uuid);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    @PostMapping("/{userId}/process")
    public Process createProcess(@PathVariable String userId, @RequestBody Process newPro){
        return cvService.createProcess(userId, newPro);
    }

    @GetMapping("/{userId}/process")
    public List<Process> getAllProcessAndMethod(@PathVariable String userId){
        return cvService.findAllProcesses(userId);
    }

    @GetMapping("/{userId}/process/{proId}")
    public Process getProcessById(@PathVariable String userId, @PathVariable String proId){
        UUID uuid = UUID.fromString(proId);
        Optional<Process> result = cvService.findProcessesById(userId, uuid);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    // Doesn't need to create personals, because they are personals.
    @GetMapping("/{userId}/personal")
    public String personalInterests(){
        return "På fritiden tycker jag om att hitta på äventyr tillsammans med min sambo och våra två barn," +
                "inredning, svampplockning och enklare programmeringsprojekt.";
    }

}
