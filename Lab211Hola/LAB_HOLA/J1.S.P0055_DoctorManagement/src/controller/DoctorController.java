/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.DoctorManager;
import entity.Doctor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import utils.Validator;

/**
 *
 * @author win
 */
public class DoctorController {

    private DoctorManager doctorManager;
    private static final String FILE_PATH = "doctor.dat";

    public DoctorController() {
        doctorManager = new DoctorManager();
    }

    public void addDoctor() {
        String code = Validator.getString("Enter Code: ", "Must be DOC x ( x is digit)", "DOC\\s\\d+");
        String name = Validator.getString("Enter Name: ", "Can not empty", "^(?!\\s*$).+");
        String specialization = Validator.getString("Enter Specialization: ", "Can not empty", "^(?!\\s*$).+");
        int availability = Validator.getInt("Enter Availability: ", "Availability must be non-negative!", "Invalid input, please enter a number!", 0, Integer.MAX_VALUE);
        try {
            Doctor doctor = new Doctor(code, name, specialization, availability);
            if (doctorManager.addDoctor(doctor)) {
                System.out.println("Doctor added successfully:");
                System.out.println(doctor);
            } else {
                System.out.println("Add fail!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDoctor() {
        String code = Validator.getString("Enter Code: ", "Must be DOC x ( x is digit)", "DOC\\s\\d+");
        try {
            if (!doctorManager.getDoctorMap().containsKey(code)) {
                throw new Exception("Doctor code doesn’t exist. Update fail");
            }
            System.out.println("Before update: " + doctorManager.getDoctorMap().get(code));
            String name = Validator.getString("Enter NEW Name: ", "Can not empty", "^(?!\\s*$).+");
            String specialization = Validator.getString("Enter NEW Specialization: ", "Can not empty", "^(?!\\s*$).+");
            int availability = Validator.getInt("Enter NEW Availability: ", "Availability must be non-negative!",
                    "Invalid input, please enter a number!", 0, Integer.MAX_VALUE);
            Doctor doctor = new Doctor(code, name, specialization, availability);
            if (doctorManager.updateDoctor(doctor)) {
                System.out.println("Doctor updated successfully:");
                System.out.println("After update: " + doctorManager.getDoctorMap().get(code));
            } else {
                System.out.println("Update fail!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDoctor() {
        String code = Validator.getString("Enter Code to delete: ", "Must be DOC x ( x is digit)", "DOC\\s\\d+");
        try {
            if (doctorManager.deleteDoctor(code)) {
                System.out.println("Doctor deleted successfully!");
            } else {
                System.out.println("Delete false");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchDoctor() {
        String input = Validator.getString("Enter search term: ", "Can not empty", "^(?!\\s*$).+");
        Map<String, Doctor> result = doctorManager.searchDoctor(input);
        if (result == null) {
            System.out.println("No matching doctors found.");
        } else {
            DoctorManager manager = new DoctorManager();
            manager.setDoctorMap(result);
            System.out.println(manager.toString());
        }
    }

    public void displayAllDoctors() {
        String str = doctorManager.toString();
        if (str == null) {
            System.out.println("This list is empty!");
        } else {
            System.out.println(str);
        }
    }
    // Load dữ liệu từ file vào danh sách tài khoản

    public void loadFile() {
        File file = new File(FILE_PATH);
        Map<String, Doctor> result;
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                result = (Map<String, Doctor>) ois.readObject();
                doctorManager.setDoctorMap(result);
                System.out.println("Load file doctor.dat successful!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Lưu danh sách tài khoản vào file
    public void saveFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(doctorManager.getDoctorMap());
            System.out.println("Save file doctor.dat successful!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
