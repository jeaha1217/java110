package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        Teacher teacher = teacherDao.findByNo(no);
        
        if(teacher == null) {
            System.out.println("해당 번호의 강사 정보가 없습니다!");
            return;
        }
        
        System.out.printf("번   호 : %s\n", teacher.getNo());
        System.out.printf("이   름 : %s\n", teacher.getName());
        System.out.printf("이 메 일 : %s\n", teacher.getEmail());
        System.out.printf("암   호 : %s\n", teacher.getPassword());
        System.out.printf("전   화 : %s\n", teacher.getTel());
        System.out.printf("시   급 : %d\n", teacher.getPay());
        System.out.printf("강의과목 : %s\n", teacher.getSubjects());
    }
}
