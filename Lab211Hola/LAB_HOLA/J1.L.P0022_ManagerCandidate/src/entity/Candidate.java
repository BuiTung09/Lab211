/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */
public class Candidate {
    //Candidate Id, First Name, Last Name, Birth Date, Address, Phone, Email and Candidate type
    private String candidateID;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private CandidateType type;

    public Candidate(String candidateID, String firstName, String lastName, 
            int birtDate, String address, String Phone, String email, CandidateType type) {
        this.candidateID = candidateID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birtDate;
        this.address = address;
        this.phone = Phone;
        this.email = email;
        this.type = type;
    }

    public Candidate() {
    }

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
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

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birtDate) {
        this.birthDate = birtDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CandidateType getType() {
        return type;
    }

    public void setType(CandidateType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Candidate{" + candidateID + ", " + firstName + ", " + lastName +
                ", " + birthDate + ", " + address + ", " + phone + ", " 
                + email + ", " + type + '}';
    }
    
}
