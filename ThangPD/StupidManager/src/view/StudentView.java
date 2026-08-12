package view;

import dto.StudentResponseDTO;
import java.util.ArrayList;
import model.Report;

public class StudentView {

    public void showMessage(String msg, boolean isError) {
        if (isError) {
            System.err.println(msg);
        } else {
            System.out.println(msg);
        }
    }

    public void displayFindAndSortHeader() {
        System.out.printf("%-15s | %-10s | %-10s\n", 
                "Student Name", 
                "Semester", 
                "Course Name");
    }

    public void displayStudent(StudentResponseDTO student) {
        System.out.printf("%-15s | %-10s | %-10s\n", 
                student.getStudentName(), 
                student.getSemester(), 
                student.getCourseName());
    }
    
    public void displayStudentWithID(StudentResponseDTO student) {
        System.out.printf("ID: %-5s | Name: %-15s | Semester: %-10s | Course: %-10s\n", 
                student.getId(),
                student.getStudentName(), 
                student.getSemester(), 
                student.getCourseName());
    }

    public void displayReport(ArrayList<Report> reportList) {
        for (Report report : reportList) {
            System.out.printf("%s | %s | %d\n", 
                    report.getStudentName(), 
                    report.getCourseName(), 
                    report.getTotalCourse());
        }
    }
}
