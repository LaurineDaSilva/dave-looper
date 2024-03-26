package co.simplon.davelooper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Person {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    public Person() {
	// Default no-arg constructor
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    @Override
    public String toString() {
	return "{firstname=" + firstname + ", lastname=" + lastname + "}";
    }
}
