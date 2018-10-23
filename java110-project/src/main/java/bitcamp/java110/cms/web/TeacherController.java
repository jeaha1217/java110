package bitcamp.java110.cms.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.mvc.RequestParam;
import bitcamp.java110.cms.service.TeacherService;

@Component
public class TeacherController {
    
    @Autowired
    TeacherService teacherService;
    
    @Autowired
    ServletContext sc;
    
    
    @RequestMapping("/teacher/list")
    public String list (
            @RequestParam(value="pageNo", defaultValue="1") int pageNo,
            @RequestParam(value="pageSize", defaultValue="5") int pageSize,
            HttpServletRequest request) throws Exception {
        
        if(request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if(pageNo < 1) {
                pageNo = 1;
            }
        }
        
        if(request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if(pageSize <= 5 || pageSize >= 10) {
                pageSize = 5;
            }
        }
        List<Teacher> list = teacherService.list(pageNo, pageSize);
        request.setAttribute("list", list);
        
        return "/teacher/list.jsp";
    }
    
    
    
    @RequestMapping("/teacher/add")
    public String add (
            Teacher teacher,
            HttpServletRequest request) throws Exception {
        if(request.getMethod().equals("GET")) {
            return "/teacher/form.jsp";
        }
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("file1");
        if(part.getSize() > 0) {
            String filename = UUID.randomUUID().toString();
            part.write(sc.getRealPath("/upload/" + filename));
            teacher.setPhoto(filename);
        }
        teacherService.add(teacher);
        return "redirect:list";
    }
    
    
    
    @RequestMapping("/teacher/detail")
    public String detail (
            @RequestParam(value="no") int no,
            HttpServletRequest request) throws Exception {
        Teacher t = teacherService.get(no);
        request.setAttribute("teacher", t);
        return "/teacher/detail.jsp";
    }
    
    
    
    @RequestMapping("/teacher/delete")
    public String delete (
            @RequestParam("no") int no,
            HttpServletRequest request) throws Exception {
        teacherService.delete(no);
        return "redirect:list";
    }
}
