package com.StarkIndustries.RestApiWithMongoDb.api.controller;

import com.StarkIndustries.RestApiWithMongoDb.api.model.Person;
import com.StarkIndustries.RestApiWithMongoDb.api.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PersonController {

    @Autowired
    public PersonService personService;

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

/*
 There are 2 approaches for logging.
 1) Using Logger Class, creating an object of Logger class : Logger logger = LoggerFactory.getLogger(Class_Name.class)
 public static final Logger logger = LoggerFactory.getLogger(Controller.class);

 2) Using @Slf4j annotation , it provides a 'log' object using which we can log.
 compulsory use 'log' object for logging.

 3) use logger.error("...") or log.error("....")

 4) By default only error is available and "info", "stack" are not available we have to enable it manually.

 5) we can customize the log's in such a manner that only logs of a certain priority and higher priority are only available.
* */

    @GetMapping("/greetings")
    public ResponseEntity<?> greetings(){
        log.info("I am Optimus Prime");
        return ResponseEntity.status(HttpStatus.OK).body("Greetings, I am Optimus Prime!!");
    }

//    @GetMapping("/logger-test/{id}")
//    public ResponseEntity<?> loggerTest(@PathVariable("id") int id){
//
//        if(id>0){
//            logger.error("id greater than 0");
//            return ResponseEntity.status(HttpStatus.OK).body("Id greater than 0");
//        }else{
//            logger.error("id less than 0");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Id less than 0");
//        }
//
//    }

//    @GetMapping("/logger-test2/{age}")
//    public ResponseEntity<?> loggerTest2(@PathVariable("age") int age){
//        if(age<18 && age>0){
//            log.error("Child");
//            return ResponseEntity.status(HttpStatus.OK).body("Child");
//        }else if(age>18 && age<60){
//            log.error("Man");
//            return ResponseEntity.status(HttpStatus.OK).body("Man");
//        }else if(age>60 && age<75){
//            log.error("Senior citizen");
//            return ResponseEntity.status(HttpStatus.OK).body("Senior Citizen");
//        }else if(age>75){
//            log.error("Super Senior Citizen");
//            return ResponseEntity.status(HttpStatus.OK).body("Super Senior Citizen");
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Enter Proper age!!");
//    }

    @PostMapping("/add-person")
    public ResponseEntity<?> addPerson(@RequestBody Person person){

        Person person1 = this.personService.addPerson(person);
        if(person1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(person1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Person!!");
    }

    @GetMapping("/get-person/{personId}")
    public ResponseEntity<?> getPersonById(@PathVariable("personId") Long personID){

        if(this.personService.getPersonById(personID)!=null)
            return ResponseEntity.status(HttpStatus.OK).body(this.personService.getPersonById(personID));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person doesn't exist");
    }

    @GetMapping("/get-persons")
    public ResponseEntity<?> getAllPersons(){

        List<Person> personList = this.personService.getAllPersons()    ;
        if(!personList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(personList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter Persons first!!");
    }

    @DeleteMapping("/delete-person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long personId){
        if(this.personService.deletePerson(personId))
            return ResponseEntity.status(HttpStatus.OK).body("Person deleted successfully!!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person doesn't exist!!");
    }

//    @GetMapping("/get-sentiment-analysis")
//    public ResponseEntity<?> getPersonForSentimentAnalysis(){
//        List<Person> personList = this.personService.getPersonsForSentimentAnalysis();
//        if(!personList.isEmpty())
//            return ResponseEntity.status(HttpStatus.OK).body(personList);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter proper Person's first!!");
//    }
//
//    @GetMapping("/get-person-by-age/{lowerLimit}/{upperLimit}")
//    public ResponseEntity<?> getPersonByAge(@PathVariable("lowerLimit") int lowerLimit,@PathVariable("upperLimit") int upperLimit){
//        List<Person> personList = this.personService.getPersonByAge(lowerLimit,upperLimit);
//        if(!personList.isEmpty())
//            return ResponseEntity.status(HttpStatus.OK).body(personList);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter proper Person's first!!");
//    }

    @GetMapping("/get-persons-by-role")
    public ResponseEntity<?> getPersonsByCodingAndRole(){
        List<Person> personList = this.personService.getPersonByRoleAndCoding();
        if(!personList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(personList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No valid entries!!");
    }

}
