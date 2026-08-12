package entity;

public class Student implements Comparable<Student> {

    private int registrationId;
    private String id;
    private String studentName;
    private int age;
    private String semester;
    private Course course;

    public Student() {
    }

    public Student(int registrationId, String id,
            String studentName, int age,
            String semester, Course course) {
        setRegistrationId(registrationId);
        setId(id);
        setStudentName(studentName);
        setAge(age);
        setSemester(semester);
        setCourse(course);
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        if (registrationId <= 0) {
            throw new IllegalArgumentException(
                    "Registration ID must be greater than 0."
            );
        }

        this.registrationId = registrationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || !id.matches("^[Ss]\\d+$")) {
            throw new IllegalArgumentException(
                    "ID must start with S followed by digits."
            );
        }

        this.id = id.toUpperCase();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName == null
                || !studentName.matches("[A-Za-z\\s]+")) {
            throw new IllegalArgumentException(
                    "Student name must contain letters and spaces only."
            );
        }

        this.studentName = normalizeName(studentName);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 100) {
            throw new IllegalArgumentException(
                    "Age must be from 1 to 100."
            );
        }

        this.age = age;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        if (semester == null
                || !semester.matches(
                        "^(Spring|Summer|Fall)\\d{4}$"
                )) {
            throw new IllegalArgumentException(
                    "Semester must have format Spring2024, "
                    + "Summer2024 or Fall2024."
            );
        }

        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException(
                    "Course cannot be null."
            );
        }

        this.course = course;
    }

    private String normalizeName(String name) {
        String[] parts = name.trim()
                .toLowerCase()
                .split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            result.append(
                    Character.toUpperCase(part.charAt(0))
            );

            if (part.length() > 1) {
                result.append(part.substring(1));
            }

            result.append(" ");
        }

        return result.toString().trim();
    }

    /**
     * Sắp xếp sinh viên theo tuổi tăng dần.
     */
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Student{"
                + "registrationId=" + registrationId
                + ", id=" + id
                + ", studentName=" + studentName
                + ", age=" + age
                + ", semester=" + semester
                + ", course=" + course.valueLanguage()
                + '}';
    }
}