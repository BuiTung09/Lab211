package dto;

/**
 * DTO chứa thông tin sinh viên dùng để hiển thị.
 */
public class StudentResponseDto {

    private int registrationId;
    private String id;
    private String studentName;
    private int age;
    private String semester;
    private String courseName;

    public StudentResponseDto() {
    }

    public StudentResponseDto(int registrationId, String id,
            String studentName, int age, String semester,
            String courseName) {
        this.registrationId = registrationId;
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}