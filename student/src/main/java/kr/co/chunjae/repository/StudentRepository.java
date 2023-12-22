package kr.co.chunjae.repository;

import kr.co.chunjae.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final SqlSessionTemplate sql;

    public int saveStudent(StudentDTO studentDTO) {
        System.out.println("studentDTO = " + studentDTO);

        return sql.insert("Student.saveStudent", studentDTO);
    }

    public List<StudentDTO> findAllStudent() {
        return sql.selectList("Student.findAllStudent");
    }

    public StudentDTO findStudentById(String studentId) {
        return sql.selectOne("Student.findStudentById" , studentId);
    }

    public int updateStudent(StudentDTO studentDTO) {
        return sql.update("Student.updateStudent",studentDTO);
    }

    public void deleteStudent(String studentId) {
        sql.delete("Student.deleteStudent" , studentId);
    }
}

