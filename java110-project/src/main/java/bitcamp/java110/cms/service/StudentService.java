package bitcamp.java110.cms.service;

import java.util.List;

import bitcamp.java110.cms.domain.Student;

public interface StudentService {
    //  서비스 인터페이스는 업무 로직을 규칙으로 정의함.
    //  따라서 메소드 이름은 업무에 가깝게 명명해야 함.
    /* public abstract */ void add(Student student);
    List<Student> list(int pageNo, int pageSize);
    Student get(int no);
    void delete(int no);
}
