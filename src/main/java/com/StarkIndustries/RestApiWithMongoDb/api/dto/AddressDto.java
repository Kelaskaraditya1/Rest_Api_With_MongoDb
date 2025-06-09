package com.StarkIndustries.RestApiWithMongoDb.api.dto;

public class AddressDto {

    private Long addressId;

    private String areaName;

    private String city;

    private String pinCode;

    private String country;

    private Long personId;

    public AddressDto(Long addressId, String areaName, String city, String pinCode, String country, Long personId) {
        this.addressId = addressId;
        this.areaName = areaName;
        this.city = city;
        this.pinCode = pinCode;
        this.country = country;
        this.personId = personId;
    }

    public AddressDto(String areaName, String city, String pinCode, String country, Long personId) {
        this.areaName = areaName;
        this.city = city;
        this.pinCode = pinCode;
        this.country = country;
        this.personId = personId;
    }

    public AddressDto(String areaName, String city, String pinCode, String country) {
        this.areaName = areaName;
        this.city = city;
        this.pinCode = pinCode;
        this.country = country;
    }

    public AddressDto() {

    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "areaName='" + areaName + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", country='" + country + '\'' +
                ", personId=" + personId +
                '}';
    }
}
