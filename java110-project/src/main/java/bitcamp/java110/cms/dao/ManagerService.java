package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerService {
    List<Manager> findAll();
    int delete(int no);
}
