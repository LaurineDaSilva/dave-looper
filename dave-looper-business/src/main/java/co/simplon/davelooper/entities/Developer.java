package co.simplon.davelooper.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_developers")
public class Developer extends BaseEntity {

    @Column(name = "registration_number")
    private String registrationNumber;

    @Embedded
    private Person identity;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "developer")
    @JsonManagedReference
    private List<Skill> skills;

    public Developer() {
	// Default no-arg constructor
    }

    public String getRegistrationNumber() {
	return registrationNumber;
    }

    public void setRegistrationNumber(String number) {
	this.registrationNumber = number;
    }

    public Person getIdentity() {
	return identity;
    }

    public void setIdentity(Person identity) {
	this.identity = identity;
    }

    public Account getAccount() {
	return account;
    }

    public void setAccount(Account account) {
	this.account = account;
    }

    public List<Skill> getSkills() {
	return skills;
    }

    public void setSkills(List<Skill> skills) {
	this.skills = skills;
    }

    @Override
    public String toString() {
	return "{registrationNumber=" + registrationNumber + ", identity="
		+ identity + ", account=" + account + ", skills=" + skills
		+ "}";
    }
}
