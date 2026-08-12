package entity;

/**
 * Danh sách các môn học được phép sử dụng trong chương trình.
 */
public enum CourseName {
    JAVA("Java"),
    DOT_NET(".Net"),
    C_CPP("C/C++");

    private final String displayName;

    CourseName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Lấy tên môn học dùng để hiển thị.
     *
     * @return tên môn học
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Chuyển lựa chọn từ menu thành CourseName.
     *
     * @param choice lựa chọn từ 1 đến 3
     * @return môn học tương ứng
     */
    public static CourseName fromChoice(int choice) {
        switch (choice) {
            case 1:
                return JAVA;
            case 2:
                return DOT_NET;
            case 3:
                return C_CPP;
            default:
                throw new IllegalArgumentException(
                        "Course choice must be from 1 to 3."
                );
        }
    }
}