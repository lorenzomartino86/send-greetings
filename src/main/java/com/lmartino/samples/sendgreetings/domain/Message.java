package com.lmartino.samples.sendgreetings.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Message {

    public Message(String firstName, String lastName) {

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
