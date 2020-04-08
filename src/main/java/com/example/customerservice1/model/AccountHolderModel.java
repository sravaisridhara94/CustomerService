package com.example.customerservice1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Customer Service API
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */
@JsonSerialize
public class AccountHolderModel {

        @JsonProperty
        private long id;
        @JsonProperty
        private String name;
        @JsonProperty
        private String ssn;
        @JsonProperty
        private String dob;
        @JsonProperty
        private String phone;
        @JsonProperty
        private String address;
        @JsonProperty
        private String countryOfBirth;
        @JsonProperty
        private String zipCode;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCountryOfBirth() {
            return countryOfBirth;
        }

        public void setCountryOfBirth(String countryOfBirth) {
            this.countryOfBirth = countryOfBirth;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }


}
