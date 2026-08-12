package service;

import dto.StudentActionResultDto;
import dto.StudentReportDto;
import dto.StudentRequestDto;
import dto.StudentResponseDto;
import java.util.List;

/**
 * Interface định nghĩa các chức năng nghiệp vụ quản lý sinh viên.
 */
public interface StudentService {

    StudentActionResultDto createStudent(
            StudentRequestDto requestDto);

    List<StudentResponseDto> findAndSortByName(
            String searchName);

    List<StudentResponseDto> findByStudentId(
            String studentId);

    StudentActionResultDto updateStudent(
            int registrationId,
            StudentRequestDto requestDto);

    StudentActionResultDto deleteStudent(
            int registrationId);

    List<StudentReportDto> getStudentReport();

    int getTotalRegistrations();
}