package kr.co.chunjae.service;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService{
  private final StudentRepository studentRepository;


  public int save(StudentDTO studentDTO) {
    return studentRepository.save(studentDTO);
  }


  public List<StudentDTO> findAll() {
    return studentRepository.findAll();
  }

  public Boolean findByMemId(StudentDTO studentDTO) {
    Boolean result = studentRepository.findByMemId(studentDTO);
    if (result) {
      return true;
    } else {
      return false;
    }
  }

  public boolean update(StudentDTO studentDTO) {
    int result = studentRepository.update(studentDTO);
    if (result > 0){
      return true;
    } else {
      return false;
    }
  }

  public StudentDTO findByStudentId(String studentId) {
    return studentRepository.findByStudentId(studentId);
  }

  public void delete(String studentId) {
    studentRepository.delete(studentId);

  }
}
