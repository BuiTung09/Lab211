package main;

import constants.Constants;
import control.StudentController;
import dto.StudentRequestDTO;
import utils.Validation;
import java.util.Scanner;

public class Main {

    // Scanner DUY NHẤT của toàn bộ chương trình
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentController controller = new StudentController();

        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            // ... (Menu options) ...

            int choice = inputInt("Please choose an option: ", 1, 5);

            switch (choice) {
                case 1:
                    handleCreate(controller);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private static void handleCreate(StudentController controller) {
        while (true) {
            StudentRequestDTO dto = new StudentRequestDTO();

            // CHỐT 1: Nhập và check ID, Name tại chỗ
            while (true) {
                System.out.print("Enter Student ID: ");
                dto.setId(inputString());

                System.out.print("Enter Student Name: ");
                dto.setStudentName(inputString());

                if (controller.checkIdExist(dto.getId(), dto.getStudentName())) {
                    break;
                }
                System.err.println("ID has already existed with a different name. Please re-enter.");
            }

            // CHỐT 2: Nhập và check Semester, Course tại chỗ
            while (true) {
                System.out.print("Enter Semester: ");
                dto.setSemester(inputString());

                while (true) {
                    System.out.print("Enter Course (Java, .Net, C/C++): ");
                    String course = inputString();
                    if (course.equalsIgnoreCase(Constants.COURSE_JAVA)
                            || course.equalsIgnoreCase(Constants.COURSE_DOTNET)
                            || course.equalsIgnoreCase(Constants.COURSE_C_CPP)) {
                        dto.setCourseName(course);
                        break;
                    }
                    System.err.println("There are only three courses: Java, .Net, C/C++.");
                }

                if (!controller.checkStudentExist(dto.getId(), dto.getSemester(), dto.getCourseName())) {
                    break;
                }
                System.err.println("This student has already enrolled in this course for this semester. Please re-enter.");
            }

            // Truyền DTO sạch cho Controller
            controller.addStudent(dto);

            if (controller.getStudentCount() >= 10) {
                if (!inputOption("Do you want to continue (Y/N)? ", "Y", "N")) {
                    break;
                }
            }
        }
    }

    // --- CÁC HÀM HELPER BẮT LỖI GỌN GÀNG TẠI MAIN ---
    private static String inputString() {
        while (true) {
            try {
                return Validation.getString(sc.nextLine());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }
    }

    private static int inputInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                return Validation.getInt(sc.nextLine(), min, max);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static boolean inputOption(String prompt, String trueOpt, String falseOpt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Validation.getOption(sc.nextLine(), trueOpt, falseOpt);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
