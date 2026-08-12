/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Candidate;
import entity.CandidateType;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.Validator;

/**
 *
 * @author win
 */
public class ManagerCandidate {
    
    private List<Candidate> list;
    private int number;
    
    public ManagerCandidate() {
        list = new ArrayList<>();
        number = 0;
    }
    
    public Candidate getCandidateByID(String id) {
        for (Candidate candidate : list) {
            if (candidate.getCandidateID().equalsIgnoreCase(id)) {
                return candidate;
            }
        }
        return null;
    }
    
    public Candidate add(int mode) {
        Candidate candidate = null;
        String firstName = Validator.getString("Enter first name: ", "Just be contain alphabetic and spaces", "[A-Za-z\\s]+");
        String lastName = Validator.getString("Enter last name: ", "Just be contain alphabetic and spaces", "[A-Za-z\\s]+");
        int currentYear = LocalDate.now().getYear();
        int birthDate = Validator.getInt("Enter birth year: ", "Must be 1900 -> " + currentYear, "Invalid!", 1900, currentYear);
        String address = Validator.getString("Enter addresss: ", "Can not empty!", "^(?!\\s*$).+");
        String phone = Validator.getString("Enter phone: ", "Must be number with minumum 10 characters", "\\d{10,}");
        String email = Validator.getString("Enter email:", "Must be with format <account name>@<domain>", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        CandidateType type = CandidateType.getCandidateType(mode);
        switch (type) {
            case EXPERIENCE:
                String ID = "E" + number;
                int expInYear = Validator.getInt("Enter year of experience: ", "Must be >=0 and <=100", "Invalid!", 0, 100);
                String proSkill = Validator.getString("Enter Professional Skill: ", "Can not empty!", "^(?!\\s*$).+");
                try {
                    candidate = new Experience(ID, firstName, lastName, birthDate,
                        address, phone, email, type, expInYear, proSkill);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case FRESHER:
                ID = "F" + number;
                int graduationDate = Validator.getInt("Enter graduation date: ",
                        "Must be 1900 -> " + currentYear, "Invalid!", 1900, currentYear);
                int choiceRank = Validator.getInt("Choose Rank:\n"
                        + "1. Excellence\n"
                        + "2. Good\n"
                        + "3. Fair\n"
                        + "4. Poor\n"
                        + "Enter your choice: ", "Must be 1->4", "Invalid!", 1, 4);
                String graduationRank = null;
                switch (choiceRank) {
                    case 1:
                        graduationRank = "Excellence";
                        break;
                    case 2:
                        graduationRank = "Good";
                        break;
                    case 3:
                        graduationRank = "Fair";
                        break;
                    case 4:
                        graduationRank = "Poor";
                        break;
                }
                
                String education = Validator.getString("Enter education: ", "Can not empty!", "^(?!\\s*$).+");
                candidate = new Fresher(ID, firstName, lastName,
                        birthDate, address, phone, email,
                        type, graduationDate, graduationRank, education);
                break;
            case INTERN:
                ID = "I" + number;
                String majors = Validator.getString("Enter majors: ", "Can not empty!", "^(?!\\s*$).+");
                String semester = Validator.getString("Enter semester: ", "Can not empty!", "^(?!\\s*$).+");
                String universityName = Validator.getString("Enter university: ", "Can not empty!", "^(?!\\s*$).+");
                candidate = new Intern(ID, firstName, lastName, birthDate, address,
                        phone, email, type, majors, semester, universityName);
        }
        if (list.add(candidate)) {
            number++;
            return candidate;
        } else {
            return null;
        }
    }
    
    public void displayAllNameCandidate(int mode) {
        if (list.isEmpty()) {
            System.out.println("List Candidate is empty!");
            return;
        }
        if (mode == 0 || mode == 1) {
            System.out.println("===========EXPERIENCE CANDIDATE============");
            for (Candidate candidate : list) {
                if (candidate instanceof Experience) {
                    System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                }
            }
        }
        if (mode == 0 || mode == 2) {
            System.out.println("==========FRESHER CANDIDATE==============");
            for (Candidate candidate : list) {
                if (candidate instanceof Fresher) {
                    System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                }
            }
        }
        if (mode == 0 || mode == 3) {
            System.out.println("===========INTERN CANDIDATE==============");
            for (Candidate candidate : list) {
                if (candidate instanceof Intern) {
                    System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                }
            }
        }
    }
    
    public List<Candidate> search(String key) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate candidate : list) {
            String fullName = candidate.getFirstName() + " " + candidate.getLastName();
            if (fullName.toLowerCase().contains(key.toLowerCase())
                    || candidate.getAddress().toLowerCase().contains(key.toLowerCase())
                    || (candidate.getBirthDate() + "").contains(key)
                    || candidate.getEmail().toLowerCase().contains(key.toLowerCase())
                    || candidate.getPhone().contains(key)
                    || candidate.getType().getValue().toLowerCase().contains(key.toLowerCase())) {
                result.add(candidate);
            }
        }
        return result;
    }
    
    public void displaySearchResult(List<Candidate> list) {
        if (list.isEmpty()) {
            System.out.println("Can not found!");
        } else {
            System.out.println("The Candidates found: ");
            System.out.println("+-----+----------------+------------+------------+------------+-----------------+-------+");
            System.out.printf("%5s | %-14s | %-10s | %-10s | %-10s | %-15s | %5s |\n", "No.", "Fullname", "Birthdate", "Address", "Phone", "Email", "Type");
            System.out.println("+-----+----------------+------------+------------+------------+-----------------+-------+");
            int count = 0;
            for (Candidate candidate : list) {
                count++;
                String fullName = candidate.getFirstName() + " " + candidate.getLastName();
                System.out.printf("%5d | %-14s | %-10s | %-10s | %-10s | %-15s | %5s |\n", count, fullName, candidate.getBirthDate(),
                        candidate.getAddress(), candidate.getPhone(),
                        candidate.getEmail(), candidate.getType().getValue());
            }
            System.out.println("+-----+----------------+------------+------------+------------+-----------------+-------+");
        }
    }
}
