package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherDao {
    
    private List<Teacher> list = new ArrayList<>();
    
    public int insert(Teacher teacher) {
        for(Teacher item : list) {
            if(item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }   //  중복검사.
        list.add(teacher);
        return 1;
    }
    
    public List<Teacher> findAll() {
        return list;
    }
    
    public Teacher findByEmail(String email) {
        for(Teacher item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Teacher item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;  //   이거 중요함 없으면 exception. 
            }
        }
        return 0;
    }   // 삭제하면 1 못하면 0
}