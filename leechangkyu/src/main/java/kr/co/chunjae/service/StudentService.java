package kr.co.chunjae.service;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentService {
  private final StudentRepository studentRepository;

  public void save(StudentDTO studentDTO) {
    studentRepository.save(studentDTO);
  }

  public List<StudentDTO> findAll(StudentDTO studentDTO) {
    return studentRepository.findAll(studentDTO);
  }


  public Boolean findByMemId(StudentDTO studentDTO) {
    StudentDTO dto = studentRepository.findByMemId(studentDTO);
    if (dto != null) {
      return true;
    } else {
      return false;
    }
  }

  public StudentDTO findByStudentId(String studentId) {
    return studentRepository.findByStudentId(studentId);
  }

  public boolean update(StudentDTO studentDTO) {
    int result = studentRepository.update(studentDTO);
    if (result > 0) {
      return true;
    } else {
      return false;
    }
  }

  public void delete(String studentId) {
    studentRepository.delete(studentId);
  }
}
