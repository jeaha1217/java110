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

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;
    ServletContext sc;

    public TeacherController(TeacherService teacherService, ServletContext sc) {
        super();
        this.teacherService = teacherService;
        this.sc = sc;
    }

    @GetMapping("list")
    public void list (
            @RequestParam(defaultValue="1") int pageNo,
            @RequestParam(defaultValue="5") int pageSize,
            Model model) throws Exception {

        if(pageNo < 1) {
            pageNo = 1;
        }

        if(pageSize <= 5 || pageSize >= 10) {
            pageSize = 5;
        }
        List<Teacher> list = teacherService.list(pageNo, pageSize);
        model.addAttribute("list", list);
    }
    
    @GetMapping("form")
    public void form()  {   }

    @RequestMapping("add")
    public String add (
            Teacher teacher,
            MultipartFile file1) throws Exception {

        if(file1.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            teacher.setPhoto(filename);
        }
        teacherService.add(teacher);
        return "redirect:list";
    }



    @RequestMapping("detail")
    public void detail (
            int no,
            Model model) throws Exception {
        Teacher t = teacherService.get(no);
        model.addAttribute("teacher", t);
    }



    @RequestMapping("delete")
    public String delete (int no) throws Exception {
        teacherService.delete(no);
        return "redirect:list";
    }
}
