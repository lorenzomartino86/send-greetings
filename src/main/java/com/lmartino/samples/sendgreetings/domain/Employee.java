package com.lmartino.samples.sendgreetings.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;

public class Employee {

    private final LocalDate dateOfBirth;
    private final String firstName;
    private final String lastName;
    private final String email;

    public Employee(LocalDate dateOfBirth, String firstName, String lastName, String email) {
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o){
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
