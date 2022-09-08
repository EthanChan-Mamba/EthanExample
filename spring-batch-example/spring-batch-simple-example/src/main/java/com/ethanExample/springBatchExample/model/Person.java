package com.ethanExample.springBatchExample.model;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2022-09-08 11:15
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person() {
        // default constructor
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
