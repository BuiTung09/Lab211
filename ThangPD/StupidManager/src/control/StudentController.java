package control;

import dto.StudentRequestDTO;
import dto.StudentResponseDTO;
import java.util.ArrayList;
import services.StudentService;
import view.StudentView;

public class StudentController {
    private StudentService service = new StudentService();
    private StudentView view = new StudentView(); 

    // Mở cổng cho Main hỏi Service
    public boolean checkIdExist(String id, String name) {
        return service.checkIDExist(id, name);
    }

    public boolean checkStudentExist(String id, String semester, String courseName) {
        return service.checkStudentExist(id, semester, courseName);
    }

    public int getStudentCount() {
        return service.getSize();
    }

    // Nhận DTO hoàn chỉnh từ Main để thêm vào hệ thống
    public void addStudent(StudentRequestDTO dto) {
        if (service.createStudent(dto)) {
            view.showMessage("Add successfully!", false);
        } else {
            view.showMessage("Add failed due to system logic conflict.", false);
        }
    }
    
    public void getListByID(String id){
        ArrayList<StudentResponseDTO> listByID = service.getListStudentById(id);
        
    }
    
    // ... (Giữ nguyên các hàm gọi Find, Update, Report như bước trước) ...
}