package bitcamp.java110.cms.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.mvc.RequestParam;
import bitcamp.java110.cms.service.ManagerService;

@Component
public class ManagerController {

    @Autowired
    ManagerService managerService;
    
    @Autowired
    ServletContext sc;
    
    @RequestMapping("/manager/list")
    public String list (
            @RequestParam(value="pageNo", defaultValue="1") int pageNo,
            @RequestParam(value="pageSize", defaultValue="5") int pageSize,
            HttpServletRequest request) {
        
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
        List<Manager> list = managerService.list(pageNo, pageSize);
        request.setAttribute("list", list);
        
        return "/manager/list.jsp";
    }
    
    
    
    @RequestMapping("/manager/add")
    public String add(
            Manager manager, 
            HttpServletRequest request) throws Exception {

        if(request.getMethod().equals("GET")) {
            return "/manager/form.jsp";
        }
        
        request.setCharacterEncoding("UTF-8");
        
        //  인서트를 하기전에 사진 데이터 처리.
        Part part = request.getPart("file1");
        if(part.getSize() > 0) {    //  파일이 정상적으로 선택 됬을때
            String filename = UUID.randomUUID().toString();
            part.write(sc.getRealPath("/upload/" + filename));
            //  파일을 정상적으로 저장하면 DB에 파일명 저장.
            manager.setPhoto(filename);
        }
        managerService.add(manager);

        // 오류 없이 등록에 성공했으면, 
        // 목록 페이지를 다시 요청하라고 redirect
        return "redirect:list";
    }
    
    
    
    @RequestMapping("/manager/detail")
    public String detail (
            @RequestParam(value="no") int no,
            HttpServletRequest request) {
        Manager m = managerService.get(no);
        // JSP 페이지에서 사용할 수 있도록 ServletRequest 보관소에 저장한다.
        request.setAttribute("manager", m);
        return "/manager/detail.jsp";
    }
    
    
    
    @RequestMapping("/manager/delete")
    public String delete(
            @RequestParam("no") int no,
            HttpServletRequest request) throws Exception {
        managerService.delete(no);
        return "redirect:list";
    }
}