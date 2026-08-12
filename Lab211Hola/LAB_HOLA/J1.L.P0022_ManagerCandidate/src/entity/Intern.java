/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author tuan
 */
public class Intern extends Candidate {

    //Intern "is a kind of" Employee.
    private String majors;
    private String semester;
    private String universityName;

    /**
     * Constructor Intern
     */
    public Intern() {
    }

    public Intern(String candidateID, String firstName, String lastName,
            int birtDate, String address, String Phone, String email, 
            CandidateType type, String majors, String semester, String universityName) {
        super(candidateID, firstName, lastName, birtDate, address, Phone, email, type);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Intern{" + super.toString()+", " + majors + ", " + semester + ", " + universityName + '}';
    }

  
}
