package com.StarkIndustries.RestApiWithMongoDb.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.OneToOne;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.List;

@Document
public class Person {

    @Id
    private Long personId;

    private String name;

    private String sex;

    private int age;

    private String education;

    private List<String> hobbies;

    private Address address;

    private String email;

    private boolean sentimentAnalysis;

    public Person(Long personId, String name, String sex, int age, String education, List<String> hobbies, Address address, String email, boolean sentimentAnalysis) {
        this.personId = personId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.hobbies = hobbies;
        this.address = address;
        this.email = email;
        this.sentimentAnalysis = sentimentAnalysis;
    }

    public Person(Long personId, String name, String sex, int age, String education, List<String> hobbies, Address address) {
        this.personId = personId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.hobbies = hobbies;
        this.address = address;
    }

    public Person(String name, String sex, int age, String education, List<String> hobbies, Address address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.hobbies = hobbies;
        this.address = address;
    }

    public Person() {

    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSentimentAnalysis() {
        return sentimentAnalysis;
    }

    public void setSentimentAnalysis(boolean sentimentAnalysis) {
        this.sentimentAnalysis = sentimentAnalysis;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", hobbies=" + hobbies +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", sentimentAnalysis=" + sentimentAnalysis +
                '}';
    }
}
