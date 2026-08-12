/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.ManageStudent;
import entity.Course;
import entity.Student;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Validator;

/**
 *
 * @author win
 */
public class Controller {

    private ManageStudent studentManager;

    public Controller() {
        studentManager = new ManageStudent();
    }

    public void addStudent() throws Exception {
        do {
            String ID = Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+");
            ArrayList<Student> list = studentManager.getListStudentById(ID);
            String name;
            if (list.isEmpty()) {
                name = Validator.getString("Enter name student: ", 
                        "Invalid!", "[A-Za-z\\s]+").toUpperCase();
            } else {
                name = list.get(0).getStudentName();
                System.out.println("Name Student: " + name);
            }
            String semester = Validator.getString("Enter Semester: ", 
                    "Invalid!", "^(Spring|Summer|Fall)\\d{4}$");
            Course course = Course.
                    getLanguage(Validator.getInt("Only three courses:\n"
                            + "\t1-Java\n"
                            + "\t2-.Net\n"
                            + "\t3-C/C++\n"
                            + "Enter your choice:",
                            "Please enter number 1->3", 
                            "Invalid", 1, 3));
            Student student = new Student(ID, name, semester, course);
            if (studentManager.add(student)) {
                System.out.println("Add success: " + student);
            } else {
                System.out.println("Add Fail: " + student);
            }
            if (studentManager.getList().size() > 1) {
                String choice = Validator.getString("Do you want to continue (Y/N)?",
                        "Just (Y or N) ", "^[YNyn]$");
                if (choice.equalsIgnoreCase("N")) {
                    return;
                }
            }
        } while (true);
    }

    public void findAndSort() throws Exception {
        //Tai sao o day ko dung validator? Do co Nang yeu cau la enter luon o chuc nang 2 ma khong nhap gi
        System.out.print("Enter name student: ");
        String name = new Scanner(System.in).nextLine();
        ArrayList<Student> list = studentManager.getListStudentByName(name);
        if (list.isEmpty()) {
            throw new Exception("Can not found!!!");
        } else {
            ManageStudent result = new ManageStudent(list);
            System.out.println(result.toString());
        }
    }

    public void updateOrDelete() throws Exception {
        String id = Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+");
        ArrayList<Student> list = studentManager.getListStudentById(id);
        if (list.isEmpty()) {
            throw new Exception("Can not found!!!");
        } else {
            ManageStudent result = new ManageStudent(list);
            System.out.println(result);
            int choice = Validator.getInt("Enter choice record you want to delete or update:",
                    "Enter 1->" + (list.size()),
                    "Invalid!", 1, list.size());
            Student student = list.get(choice - 1);
            System.out.println(student);
            String choose = Validator.getString("(Do you want to update (U) or delete (D):", 
                    "Just(U or D)", "^[UuDd]$");
            if (choose.equalsIgnoreCase("u")) {
                String semester = Validator.getString("Enter Semester: ", 
                        "Invalid!", "^(Spring|Summer|Fall)\\d{4}$");
                Course course = Course.
                        getLanguage(Validator.getInt("Only three courses:\n"
                                + "\t1-Java\n"
                                + "\t2-.Net\n"
                                + "\t3-C/C++\n"
                                + "Enter your choice:",
                                "Please enter number 1->3", "Invalid", 1, 3));
                studentManager.update(student, semester, course);
            } else {
                studentManager.delete(student);
            }
        }
    }

    public void report() throws Exception {
        String result = studentManager.report();
        if (result == null) {
            throw new Exception("List is empty!!!");
        }
        System.out.println(result);
    }

    public void generateStudent() throws Exception {
        studentManager.add(new Student("S1", "Tran Quoc Tuan", 
                "Fall2022", Course.JAVA));
        studentManager.add(new Student("S1", "Tran Quoc Tuan",
                "Summer2022", Course.DOT_NET));
        studentManager.add(new Student("S1", "Tran Quoc Tuan",
                "Fall2022", Course.C_CPP));
        studentManager.add(new Student("S2", "Doan Duy Huy", 
                "Fall2021", Course.JAVA));
        studentManager.add(new Student("S2", "Doan Duy Huy", 
                "Spring2022", Course.JAVA));
        studentManager.add(new Student("S3", "Le Thi Hoa", 
                "Fall2022", Course.DOT_NET));
        studentManager.add(new Student("S4", "Le Thi Quynh", "Fall2022", Course.JAVA));
        studentManager.add(new Student("S5", "Le Trong Nhat", 
                "Fall2022", Course.DOT_NET));
        studentManager.add(new Student("S5", "Le Trong Nhat", "Summer2022", Course.JAVA));
        studentManager.add(new Student("S6", "Le Van Quyen", "Fall2022", Course.JAVA));
    }

}
