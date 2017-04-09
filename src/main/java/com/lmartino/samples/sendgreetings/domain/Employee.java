package com.lmartino.samples.sendgreetings.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;

import static java.time.LocalDate.*;

public class Employee {

    private final LocalDate birthday;

    public Employee(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }

    public LocalDate getBirthday() {
        return birthday;
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
