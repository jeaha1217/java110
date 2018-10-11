package bitcamp.java110.cms.service.impl;

import java.util.List;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.PhotoDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;
import bitcamp.java110.cms.util.TransactionManager;

/*  객체 지향 어느 객체가 어느 객체와 일을 하는지 흐름을 알아야 한다.

    DAO가 DAO사용하는것은 바람직 하지 않다.
    ManagerService 회사마다 다르기때문에 만든다.
    하나의 table은 하나의 DAO에서만 insert 가능하게 하는게 좋다.
            select 나 join은 괜찮음.
    Service는 다수의 DAO를 사용해도 괜찬음.
    Servlet도 다수의 Service를 사용해도 괜찮음.
 */

public class ManagerServiceImpl implements ManagerService {

    MemberDao memberDao;
    ManagerDao managerDao;
    PhotoDao photoDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public void add(Manager manager) {
        // 매니저 등록관 관련된 업무는 Service 객체에서 처리한다.
        TransactionManager txManager = TransactionManager.getInstance();
        try {
            txManager.startTransaction();

            memberDao.insert(manager);
            managerDao.insert(manager);

            if (manager.getPhoto() != null) {
                photoDao.insert(manager.getNo(), manager.getPhoto());
            }

            txManager.commit();
            //  와 시발... 코드 다 뜯어고치지 않아도 Transaction 관리 가능?
        } catch (Exception e) {
            try { txManager.rollback(); } catch(Exception e2) {}
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Manager> list() {
        return managerDao.findAll();
    }

    @Override
    public Manager get(int no) {
        return managerDao.findByNo(no);
    }

    @Override
    public void delete(int no) {
        TransactionManager txManager = TransactionManager.getInstance();
        try {
            txManager.startTransaction();
            
            if(managerDao.delete(no) == 0) {
                throw new RuntimeException("해당 번호의 매니져가 없습니다.");
            }
            photoDao.delete(no);
            memberDao.delete(no);
            
            txManager.commit();
        } catch(Exception e) {
            try { txManager.rollback(); } catch(Exception e2) {}
            throw new RuntimeException(e);
        }
    }
}