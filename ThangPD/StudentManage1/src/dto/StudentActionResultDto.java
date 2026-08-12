package dto;

/**
 * DTO chứa kết quả của một thao tác thêm, sửa hoặc xóa.
 */
public class StudentActionResultDto {

    private boolean success;
    private String message;

    public StudentActionResultDto() {
    }

    public StudentActionResultDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static StudentActionResultDto success(String message) {
        return new StudentActionResultDto(true, message);
    }

    public static StudentActionResultDto failure(String message) {
        return new StudentActionResultDto(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}