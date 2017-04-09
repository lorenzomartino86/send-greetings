package com.lmartino.samples.sendgreetings.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Message {

    private final String firstName;
    private final String lastName;
    private final String body;
    private final String email;
    private final String subject;

    public Message(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.subject = "Happy Birthday!";
        this.body = "Happy Birthday, dear " + firstName + " " + lastName;
    }

    public String getBody() {
        return body;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
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
