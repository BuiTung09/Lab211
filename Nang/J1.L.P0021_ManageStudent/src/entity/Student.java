package entity;

public class Student implements Comparable<Student> {

    private String id;
    private String studentName;
    private String semester;
    private Course course;

    public Student(String id, String studentName, String semester, Course courseName) {
        setId(id);
        setStudentName(studentName);
        setSemester(semester);
        setCourse(courseName);
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!id.matches("^[Ss]\\d+$")) {
            throw new IllegalArgumentException("ID must be Sx(x must be digit).");
        }
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (!studentName.matches("[A-Za-z\\s]+")) {
            throw new IllegalArgumentException("Student name must be alphabet and space.");
        }
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        // Điều kiện kiểm tra định dạng semester (ví dụ: "Spring2024")
        if (!semester.matches("^(Spring|Summer|Fall)\\d{4}$")) {
            throw new IllegalArgumentException("Semester format is invalid. Use 'Spring2024', 'Summer2024', etc.");
        }
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course name cannot be null.");
        }
        this.course = course;
    }

    private String normalizeName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "";
        }
        String[] parts = name.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public int compareTo(Student t) {
        // Lấy phần tên của sinh viên hiện tại
        String thisLastName = extractLastName(this.studentName);
        // Lấy phần tên của sinh viên được so sánh
        String otherLastName = extractLastName(t.studentName);

        // So sánh phần tên
        return thisLastName.compareTo(otherLastName);
    }

// Hàm hỗ trợ để lấy phần tên cuối cùng (last name)
    private String extractLastName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "";
        }
        // Cắt bỏ khoảng trắng đầu cuối và tách chuỗi theo dấu cách
        String[] parts = fullName.trim().split("\\s+");
        // Phần tử cuối cùng trong mảng là tên của sinh viên
        return parts[parts.length - 1];
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", studentName=" + studentName
                + ", semester=" + semester + ", courseName=" + course.valueLanguage() + '}';
    }
}
