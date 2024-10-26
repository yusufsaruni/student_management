package harmo.projects.student_management.repository;

import harmo.projects.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
