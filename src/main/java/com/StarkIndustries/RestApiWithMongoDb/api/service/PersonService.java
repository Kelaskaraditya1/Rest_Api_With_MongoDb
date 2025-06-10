package com.StarkIndustries.RestApiWithMongoDb.api.service;

import com.StarkIndustries.RestApiWithMongoDb.api.model.Person;
import com.StarkIndustries.RestApiWithMongoDb.api.repository.CustomPersonRepository;
import com.StarkIndustries.RestApiWithMongoDb.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    public PersonRepository personRepository;

    @Autowired
    public CustomPersonRepository customPersonRepository;

    public Person addPerson(Person person){
        return this.personRepository.save(person);
    }

    public Person getPersonById(Long personId){
        if(this.personRepository.existsById(personId))
            return this.personRepository.findById(personId).get();
        return null;
    }

    public List<Person> getAllPersons(){
        return this.personRepository.findAll();
    }

    public boolean deletePerson(Long personId){
        if(this.personRepository.existsById(personId)){
            this.personRepository.deleteById(personId);
            return true;
        }
        return false;
    }

    public List<Person> getPersonsForSentimentAnalysis(){

        return this.customPersonRepository.findPersonsForSentimentAnalysis();
    }

    public List<Person> getPersonByAge(int lowerLimit,int upperLimit){
        return this.customPersonRepository.getPersonsOfAge(lowerLimit,upperLimit);
    }

}
