package bitcamp.java110.cms.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;
    ServletContext sc;
    
    public StudentController(StudentService studentService, ServletContext sc) {
        this.studentService = studentService;
        this.sc = sc;
    }

    @GetMapping("list")
    public void list (
            @RequestParam(defaultValue="1") int pageNo,
            @RequestParam(defaultValue="5") int pageSize,
            Model model){

        if(pageNo < 1) {
            pageNo = 1;
        }
        if(pageSize <= 5 || pageSize >= 10) {
            pageSize = 5;
        }
        List<Student> list = studentService.list(pageNo, pageSize);
        model.addAttribute("list", list);
    }
    
    @GetMapping("form")
    public void form() {}

    @RequestMapping("add")
    public String add (
            Student student,
            MultipartFile file1) throws Exception {

        if(file1.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            student.setPhoto(filename);
        }
        studentService.add(student);
        return "redirect:list";
    }



    @RequestMapping("detail")
    public void detail (
            int no,
            Model model) throws Exception {
        Student s = studentService.get(no);
        model.addAttribute("student", s);
    }



    @RequestMapping("delete")
    public String delete (int no) throws Exception {
        studentService.delete(no);
        return "redirect:list";
    }
}
