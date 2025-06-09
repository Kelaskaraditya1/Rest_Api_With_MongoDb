package com.StarkIndustries.RestApiWithMongoDb.api.service;

import com.StarkIndustries.RestApiWithMongoDb.api.model.Person;
import com.StarkIndustries.RestApiWithMongoDb.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    public PersonRepository personRepository;

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

}
