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
}
