package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;



/*  객체 지향 어느 객체가 어느 객체와 일을 하는지 흐름을 알아야 한다.

    DAO가 DAO사용하는것은 바람직 하지 않다.
    ManagerService 회사마다 다르기때문에 만든다.
    하나의 table은 하나의 DAO에서만 insert 가능하게 하는게 좋다.
            select 나 join은 괜찮음.
    Service는 다수의 DAO를 사용해도 괜찬음.
    Servlet도 다수의 Service를 사용해도 괜찮음.
 */

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    MemberDao memberDao;
    @Autowired
    ManagerDao managerDao;
    @Autowired
    PhotoDao photoDao;
    
    @Transactional(
                //  트랜젝션 관리자의 이름이 transactionManger이면
                //  다음속성은 생략해도 된다.
                //  transactionManager="transactionManager",

                //  이 method를 호출하는 쪽에 이미 트랜젝션이 있으면 그 트랜켁션에 소속되게 하고,
                //  없으면 새 트랜잭션응 만들어서 수행한다.
                //  기본값은 Propagation.REQUIRED임.
                propagation=Propagation.REQUIRED,
                
                //  method 실행 중에 Exception 예외가 발생하면 rollback을 수행한다.
                //  기본 값은 Exception.class
                rollbackFor=Exception.class)
    @Override
    public void add(Manager manager) {
        memberDao.insert(manager);
        managerDao.insert(manager);

        if (manager.getPhoto() != null) {

            HashMap<String, Object> params = new HashMap<>();
            params.put("no", manager.getNo());
            params.put("photo", manager.getPhoto());
            //  photo의 독립성을 위해 hashmap객체를 만들어서 보냄.
            //  성능등의 단점도 있지만 소스코드 재 사용성에서 장점임.
            //  성능원하면 C쓰덩가!
            photoDao.insert(params);
        }
    }

    @Override
    public List<Manager> list(int pageNo, int pageSize) {

        HashMap<String, Object> params = new HashMap<>();
        params.put("rowNo", (pageNo - 1) * pageSize);
        params.put("size", pageSize);

        return managerDao.findAll(params);
    }

    @Override
    public Manager get(int no) {
        return managerDao.findByNo(no);
    }
    
    @Transactional
    @Override
    public void delete(int no) {
        if(managerDao.delete(no) == 0) {
            throw new RuntimeException("해당 번호의 데이터가 없습니다.");
        }
        photoDao.delete(no);
        memberDao.delete(no);
    }
}