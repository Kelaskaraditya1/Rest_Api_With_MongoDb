    package com.StarkIndustries.RestApiWithMongoDb.api.model;

    import com.fasterxml.jackson.annotation.JsonBackReference;
    import jakarta.persistence.OneToOne;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;

    @Document
    public class Address {

        @Id
        private Long addressId;

        private String areaName;

        private String city;

        private String pinCode;

        private String country;

        private Person person;

        public Address(Long addressId, String areaName, String city, String pinCode, String country) {
            this.addressId = addressId;
            this.areaName = areaName;
            this.city = city;
            this.pinCode = pinCode;
            this.country = country;
        }

        public Address(String areaName, String city, String pinCode, String country) {
            this.areaName = areaName;
            this.city = city;
            this.pinCode = pinCode;
            this.country = country;
        }

        public Address() {

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

        @Override
        public String toString() {
            return "Address{" +
                    "addressId=" + addressId +
                    ", areaName='" + areaName + '\'' +
                    ", city='" + city + '\'' +
                    ", pinCode='" + pinCode + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
