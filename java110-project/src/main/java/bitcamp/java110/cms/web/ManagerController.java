package bitcamp.java110.cms.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    ManagerService managerService;
    ServletContext sc;
    
    public ManagerController(
            ManagerService managerService,
            ServletContext sc) {
        this.managerService = managerService;
        this.sc = sc;
    }

    @GetMapping("list")
    public void list (
            @RequestParam(defaultValue="1") int pageNo,
            @RequestParam(defaultValue="5") int pageSize,
            Model model) {

        if(pageNo < 1) {
            pageNo = 1;
        }

        if(pageSize <= 5 || pageSize >= 10) {
            pageSize = 5;
        }
        
        List<Manager> list = managerService.list(pageNo, pageSize);
        model.addAttribute("list", list);
    }

    @GetMapping("form")
    public void form() {
        
    }

    @PostMapping("add")
    public String add(
            Manager manager, 
            MultipartFile file1) throws Exception {
        
        //  인서트를 하기전에 사진 데이터 처리.
        if(file1.getSize() > 0) {    //  파일이 정상적으로 선택 됬을때
            String filename = UUID.randomUUID().toString();
            file1.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            //  파일을 정상적으로 저장하면 DB에 파일명 저장.
            manager.setPhoto(filename);
        }
        managerService.add(manager);
        
        // 오류 없이 등록에 성공했으면, 
        // 목록 페이지를 다시 요청하라고 redirect
        return "redirect:list";
    }


    //  Original Spring WebMVC는 default값이 없는 @ReqeustParam은 태그가 없어도 인식한다.
    @RequestMapping("detail")
    public void detail (
            int no,
            Model model) {
        Manager m = managerService.get(no);
        // JSP 페이지에서 사용할 수 있도록 ServletRequest 보관소에 저장한다.
        model.addAttribute("manager", m);
    }



    @GetMapping("delete")
    public String delete(int no) throws Exception {
        managerService.delete(no);
        return "redirect:list";
    }
}
//  현업에선 Request는 잘 쓰지 않는다. Map에 담거나 Model에 담는다.