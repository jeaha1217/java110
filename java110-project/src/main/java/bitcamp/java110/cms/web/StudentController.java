package bitcamp.java110.cms.web;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.mvc.RequestParam;
import bitcamp.java110.cms.service.StudentService;

@Component
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ServletContext sc;

    @RequestMapping("/student/list")
    public String list (
            @RequestParam(value="pageNo", defaultValue="1") int pageNo,
            @RequestParam(value="pageSize", defaultValue="5") int pageSize,
            Map<String, Object> map){

        if(pageNo < 1) {
            pageNo = 1;
        }
        if(pageSize <= 5 || pageSize >= 10) {
            pageSize = 5;
        }
        List<Student> list = studentService.list(pageNo, pageSize);
        map.put("list", list);
        return "/student/list.jsp";
    }



    @RequestMapping("/student/add")
    public String add (
            Student student,
            HttpServletRequest request) throws Exception {

        if(request.getMethod().equals("GET")) {
            return "/student/form.jsp";
        }
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("file1");
        if(part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(sc.getRealPath("/upload/" + filename));
            student.setPhoto(filename);
        }
        studentService.add(student);
        return "redirect:list";
    }



    @RequestMapping("/student/detail")
    public String detail (
            @RequestParam(value="no") int no,
            Map<String, Object> map) throws Exception {
        Student s = studentService.get(no);
        map.put("student", s);
        return "/student/detail.jsp";
    }



    @RequestMapping("/student/delete")
    public String delete (@RequestParam("no") int no) throws Exception {
        studentService.delete(no);
        return "redirect:list";
    }
}