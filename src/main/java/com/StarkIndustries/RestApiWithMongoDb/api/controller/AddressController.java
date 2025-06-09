package com.StarkIndustries.RestApiWithMongoDb.api.controller;

import com.StarkIndustries.RestApiWithMongoDb.api.dto.AddressDto;
import com.StarkIndustries.RestApiWithMongoDb.api.model.Address;
import com.StarkIndustries.RestApiWithMongoDb.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    public AddressService addressService;

    @PostMapping("/add-address")
    public ResponseEntity<?> addAddress(@RequestBody AddressDto addressDto){
        Address address = this.addressService.addAddress(addressDto);
        if(address!=null)
            return ResponseEntity.status(HttpStatus.OK).body(address);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Address!!");
    }

    @GetMapping("/get-address/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable("id") Long addressId){

        Address address = this.addressService.getAddressById(addressId);
        if(address!=null)
            return ResponseEntity.status(HttpStatus.OK).body(address);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address doesn't exist!!");

    }

    @GetMapping("/get-addresses")
    public ResponseEntity<?> getAllAddresses(){
        List<Address> addressList = this.addressService.getAllAddresses();
        if(!addressList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(addressList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address doesn't exist!!");
    }
}
