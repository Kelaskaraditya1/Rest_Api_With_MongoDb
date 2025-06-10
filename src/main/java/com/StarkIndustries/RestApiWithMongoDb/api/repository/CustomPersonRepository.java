package com.StarkIndustries.RestApiWithMongoDb.api.repository;

import com.StarkIndustries.RestApiWithMongoDb.api.model.Person;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomPersonRepository {

    /* Criteria Api:
     *  used to write custom query method's for performing complex query's
     *  uses MongoTemplate , autowire it.
     *  1) Create a Query object,Query query = new Query().
     *  2) use query.addFilter(Criteria.where("attribute").condn("...").....chaining)
     *  3) mongoTemplate.find(query,<Name of Class/Model on which operation has to be operated>.class)
     *  4) Some Standard methods:
     *          1) if 1 attribute equals value use:is("value")
     *          2) if 1 attribute exists that is wheather it is present in the request/payload use: exists(true)
     *          3) if 1 attribute has to compare with another value:
     *                          greater than equal: gte(value)
     *                          greater than: gt(value)
     *                          less than equal: lte(value)
     *                          less than: lt(value)
     *          4) for verifying wheather String is empty/null/blank : notnull(),notBlank(),notEmpty()
     *                                      for not equals: Criteria.where("...").regex("..regular expression..")
     *          5) by default when written side by side Criteria.where("...").condn1("...").condn2("...") there is and operator in between
     *          6) working with more than 1 Criteria:
     *                           Criteria criteria1 = Criteria.where("attribute").condn1().condn2();
     *                           Criteria criteria2 = Criteria.where("attribute").condn1().condn2();
     *                           Query query = new Query();
     *                           query.addCriteria(criteria1.andOperator(criteria2))
     *                           query.addCriteria(criteria2.orOperator(criteria1))
     *
     *          7) and("attribute2"): it is used to another attribute in the Criteria.
     *                           Criteria.where("attribute1").condn1("...").and("attribute2").condn2("....");
     *          8) in operator: to check wheather an object is present in a given list or not
     *                           Criteria.where("attribute1").in(list) or Criteria.where("attribute1").in(obj1,obj2,obj3,....)
    */

    @Autowired
    public MongoTemplate mongoTemplate;

//     public List<Person> findPersonsForSentimentAnalysis(){
//
//         Query query = new Query();
//         Criteria criteria1 = Criteria.where("email").exists(true);
//         Criteria criteria2 = Criteria.where("sentimentAnalysis").is(true);
//         query.addCriteria(criteria1.andOperator(Criteria.where("sentimentAnalysis").is(true)));
//
//
//         List<Person> personList = mongoTemplate.find(query,Person.class);
//         return personList;
//     }
//
//     public List<Person> getPersonsOfAge(int lowerLimit,int upperLimit){
//
//         Query query  = new Query();
//         query.addCriteria(Criteria.where("age").gte(lowerLimit).lte(upperLimit));
//         List<Person> personList = mongoTemplate.find(query,Person.class);
//         return personList;
//     }

    public List<Person> findByRoleAndCoding() {
        Query query = new Query();

        Criteria criteria = new Criteria().andOperator(
                Criteria.where("role").exists(true),       // Role must be present
                Criteria.where("hobbies").in("Coding")     // "Coding" must be in hobbies array
        );

        query.addCriteria(criteria);

        return mongoTemplate.find(query, Person.class);
    }




}
