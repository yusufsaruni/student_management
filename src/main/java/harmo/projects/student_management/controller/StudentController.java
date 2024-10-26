package harmo.projects.student_management.controller;

import harmo.projects.student_management.entity.Student;
import harmo.projects.student_management.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    //Adding a new student
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create student object to hold student data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }
    //Handler method to handle delete student request
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);

        return "redirect:/students";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,
                                Model model){
        //get student from database by id
        Student studentById = studentService.getStudentById(id);
        studentById.setId(id);
        studentById.setFirstName(student.getFirstName());
        studentById.setLastName(student.getLastName());
        studentById.setEmail(student.getEmail());
        studentService.updateStudent(studentById);
        return "redirect:/students";
    }
}
