package harmo.projects.student_management.service;

import harmo.projects.student_management.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    Student getStudentById(Long id);
    void deleteById(Long id);
}
