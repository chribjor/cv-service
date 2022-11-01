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

    @PostMapping("/{userId}/experience")
    public Experience createExperience(@PathVariable String userId, @RequestBody Experience newExp){
        return cvService.createExperience(userId, newExp);
    }

    @GetMapping("/{userId}/experience")
    public List<Experience> getExperiences(@PathVariable String userId){
        return cvService.findAllExperiences(userId);
    }

    @GetMapping("/{userId}/experience/{expId}")
    public Experience getExperience(@PathVariable String userId, @PathVariable String expId){
        UUID uuid = UUID.fromString(expId);
        Optional<Experience> result = cvService.findExperience(userId, uuid);
        if(result.isPresent()){
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

    @PostMapping("/{userId}/education")
    public Education getEducation(@PathVariable String userId, @RequestBody Education newEdu){
        return cvService.createEducation(userId, newEdu);
    }

    @GetMapping("/trustee")
    public List<Trustee> getTrustees(){
        return cvService.findAllTrustees();
    }

    @GetMapping("/technical")
    public List<Technic> getTechnicalSkills(){
        return cvService.findAllTechnicSkills();
    }

    @PostMapping("/technical")
    public Technic createTechnic(@RequestBody Technic newTec){
        return cvService.createTechnic(newTec);
    }

    @GetMapping("/process")
    public String processAndMethod(){
        return "SCRUM";
    }

    @GetMapping("/personal")
    public String personalInterests(){
        return "På fritiden tycker jag om att hitta på äventyr tillsammans med min sambo och våra två barn, inredning, svampplockning och enklare programmeringsprojekt.";
    }

}
