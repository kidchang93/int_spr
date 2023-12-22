package kr.co.chunjae.service;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.repository.MemberRepository;
import kr.co.chunjae.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public int saveStudent(StudentDTO studentDTO) {
        return studentRepository.saveStudent(studentDTO);
    }


    public List<StudentDTO> findAllStudent() {
        return studentRepository.findAllStudent();
    }

    public StudentDTO findStudentById(String studentId) {
        return studentRepository.findStudentById(studentId);
    }

    public boolean updateStudent(StudentDTO studentDTO) {
        int result = studentRepository.updateStudent(studentDTO);
        if (result > 0 ){
            return true;
        } else {
            return false;
        }
    }

    public void deleteStudent(String studentId) {
        studentRepository.deleteStudent(studentId);
    }
}
