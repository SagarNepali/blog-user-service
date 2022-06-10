package edu.miu.blogpost.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class Address {
    private String state;
    private String city;
    private String zip;
    private String street;
}
