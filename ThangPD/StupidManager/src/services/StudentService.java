package services;

import dto.StudentRequestDTO;
import dto.StudentResponseDTO;
import model.Report;
import model.Student;
import repository.StudentRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentService {

    private StudentRepository repo = new StudentRepository();

    public boolean isEmpty() {
        return repo.isEmpty();
    }

    public int getSize() {
        return repo.getSize();
    }

    // 1. NGHIỆP VỤ TẠO SINH VIÊN (Dùng lại các helper cũ)
    // Kiểm tra sai lệch ID và Tên
    public boolean checkIDExist(String id, String name) {
        for (Student student : repo.getAll()) {
            if (student.getId().equalsIgnoreCase(id) && !student.getStudentName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    // Kiểm tra trùng môn học
    public boolean checkStudentExist(String id, String semester, String courseName) {
        for (Student student : repo.getAll()) {
            if (student.getId().equalsIgnoreCase(id)
                    && student.getSemester().equalsIgnoreCase(semester)
                    && student.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    // Xử lý tạo mới
    public boolean createStudent(StudentRequestDTO request) {
        repo.addStudent(new Student(request.getId(), request.getStudentName(), request.getSemester(), request.getCourseName()));
        return true;
    }

    // 2. NGHIỆP VỤ CẬP NHẬT
    public boolean updateStudent(StudentResponseDTO oldRecord, StudentRequestDTO newRecord) {
        String finalId = oldRecord.getId();
        String finalName = newRecord.getStudentName().isEmpty() ? oldRecord.getStudentName() : newRecord.getStudentName();
        String finalSemester = newRecord.getSemester().isEmpty() ? oldRecord.getSemester() : newRecord.getSemester();
        String finalCourse = newRecord.getCourseName().isEmpty() ? oldRecord.getCourseName() : newRecord.getCourseName();

        // Kiểm tra trùng lịch học bằng helper isSameRecord
        for (Student s : repo.getAll()) {
            if (!isSameRecord(s, oldRecord)) {
                if (s.getId().equalsIgnoreCase(finalId)
                        && s.getSemester().equalsIgnoreCase(finalSemester)
                        && s.getCourseName().equalsIgnoreCase(finalCourse)) {
                    return false;
                }
            }
        }

        // Tiến hành cập nhật và đồng bộ tên
        for (Student s : repo.getAll()) {
            if (s.getId().equalsIgnoreCase(finalId)) {
                s.setStudentName(finalName);
            }
            if (isSameRecord(s, oldRecord)) {
                s.setSemester(finalSemester);
                s.setCourseName(finalCourse);
            }
        }
        return true;
    }

    // 3. TÌM KIẾM VÀ SẮP XẾP
    public ArrayList<StudentResponseDTO> findAndSortByName(String nameSearch) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : repo.getAll()) {
            if (student.getStudentName().toLowerCase().contains(nameSearch.toLowerCase())) {
                result.add(student);
            }
        }
        if (!result.isEmpty()) {
            Collections.sort(result, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getStudentName().compareTo(s2.getStudentName());
                }
            });
        }
        return convertToResponseDTOList(result);
    }

    public ArrayList<StudentResponseDTO> getListStudentById(String id) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : repo.getAll()) {
            if (student.getId().equalsIgnoreCase(id)) {
                list.add(student);
            }
        }
        return convertToResponseDTOList(list);
    }

    // 4. NGHIỆP VỤ XÓA
    public boolean deleteStudent(StudentResponseDTO recordToDelete) {
        return repo.getAll().removeIf(student -> isSameRecord(student, recordToDelete));
    }

    // 5. NGHIỆP VỤ BÁO CÁO (Dùng lại helper checkReportExist)
    public ArrayList<Report> generateReport() {
        ArrayList<Report> lr = new ArrayList<>();
        for (Student student : repo.getAll()) {
            int total = 0;
            for (Student countStudent : repo.getAll()) {
                if (student.getStudentName().equalsIgnoreCase(countStudent.getStudentName())
                        && student.getCourseName().equalsIgnoreCase(countStudent.getCourseName())) {
                    total++;
                }
            }
            if (!checkReportExist(lr, student.getStudentName(), student.getCourseName(), total)) {
                lr.add(new Report(student.getStudentName(), student.getCourseName(), total));
            }
        }
        return lr;
    }

    // =========================================================================
    // KHU VỰC CÁC HÀM HELPER CŨ CỦA BẠN - GIỮ NGUYÊN LOGIC, CHỈ ĐỔI MẢNG THÀNH repo.getAll()
    // =========================================================================
    private boolean checkReportExist(ArrayList<Report> lr, String name, String course, int total) {
        for (Report report : lr) {
            if (report.getStudentName().equalsIgnoreCase(name)
                    && report.getCourseName().equalsIgnoreCase(course)
                    && report.getTotalCourse() == total) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameRecord(Student s, StudentResponseDTO dto) {
        return s.getId().equalsIgnoreCase(dto.getId())
                && s.getSemester().equalsIgnoreCase(dto.getSemester())
                && s.getCourseName().equalsIgnoreCase(dto.getCourseName());
    }

    private ArrayList<StudentResponseDTO> convertToResponseDTOList(ArrayList<Student> list) {
        ArrayList<StudentResponseDTO> dtoList = new ArrayList<>();
        for (Student s : list) {
            dtoList.add(new StudentResponseDTO(s.getId(), s.getStudentName(), s.getSemester(), s.getCourseName()));
        }
        return dtoList;
    }
}
