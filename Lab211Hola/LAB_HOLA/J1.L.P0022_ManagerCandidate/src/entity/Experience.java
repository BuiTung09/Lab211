/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tuan
 */
public class Experience extends Candidate {
//Experience "is a kind of" Employee.

    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(String candidateID, String firstName,
            String lastName, int birtDate, String address,
            String Phone, String email, CandidateType type,
            int expInYear, String proSkill) throws Exception {
        super(candidateID, firstName, lastName, birtDate, address, Phone, email, type);
        validateAge(birtDate); // Kiểm tra tuổi hợp lệ
        setExpInYear(expInYear);
        setProSkill(proSkill);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" + super.toString() + ", " + expInYear + ", " + proSkill + '}';
    }

    // Hàm kiểm tra tuổi tối thiểu 23
    private void validateAge(int birthYear) throws Exception {
        int currentYear = Year.now().getValue(); // Lấy năm hiện tại
        int age = currentYear - birthYear;
        if (age < 23) {
            throw new Exception("Candidate must be at least 23 years old.");
        }
    }

}
