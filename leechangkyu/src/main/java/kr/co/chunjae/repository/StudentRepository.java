package kr.co.chunjae.repository;

import kr.co.chunjae.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class StudentRepository {
  private final SqlSessionTemplate sql;

  public void save(StudentDTO studentDTO) {
    sql.insert("Student.save" , studentDTO);
  }

  public List<StudentDTO> findAll(StudentDTO studentDTO) {
    return sql.selectList("Student.findAll", studentDTO);
  }

  public StudentDTO findByMemId(StudentDTO studentDTO) {
    return sql.selectOne("Student.findByMemId" , studentDTO);
  }


  public StudentDTO findByStudentId(String studentId) {
    return sql.selectOne("Student.findByStudentId" , studentId);

  }

  public int update(StudentDTO studentDTO) {
    return sql.update("Student.update" , studentDTO);
  }

  public void delete(String studentId) {
    sql.delete("Student.delete",studentId);
  }


}
