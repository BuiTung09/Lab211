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
public class Fresher extends Candidate {
    //Fresher "is a kind of" Employee.

    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(String candidateID, String firstName, String lastName, int birtDate, String address,
            String Phone, String email, CandidateType type,
            int graduationDate, String graduationRank, String education) {
        super(candidateID, firstName, lastName, birtDate, address, Phone, email, type);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" + super.toString() + ", " + graduationDate + ", " + graduationRank + ", " + education + '}';
    }

}
