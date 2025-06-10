package com.StarkIndustries.RestApiWithMongoDb.api.service;

import com.StarkIndustries.RestApiWithMongoDb.api.dto.AddressDto;
import com.StarkIndustries.RestApiWithMongoDb.api.model.Address;
import com.StarkIndustries.RestApiWithMongoDb.api.model.Person;
import com.StarkIndustries.RestApiWithMongoDb.api.repository.AddressRepository;
import com.StarkIndustries.RestApiWithMongoDb.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public PersonRepository personRepository;

    public Address addAddress(AddressDto addressDto){

        if(this.personRepository.existsById(addressDto.getPersonId())){
            Person person = this.personRepository.findById(addressDto.getPersonId()).get();
            Address address = new Address();
            address.setAddressId(addressDto.getAddressId());
            address.setCity(addressDto.getCity());
            address.setAreaName(addressDto.getAreaName());
            address.setCountry(addressDto.getCountry());
            address.setPinCode(addressDto.getPinCode());
            address.setLocalDateTime(LocalDateTime.now());
            person.setAddress(address);
            this.personRepository.save(person);
            this.addressRepository.save(address);
            return address;
        }
        return null;
    }

    public Address getAddressById(Long addressId){
        if(this.addressRepository.existsById(addressId))
            return this.addressRepository.findById(addressId).get();
        return null;
    }

    public List<Address> getAllAddresses(){
        return this.addressRepository.findAll();
    }

    public boolean deleteAddress(Long addressId){
        if(this.addressRepository.existsById(addressId)){
            this.addressRepository.deleteById(addressId);
            return true;
        }
        return false;
    }
}
