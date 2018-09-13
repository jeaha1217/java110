package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Manager;

//@Component
public class ManagerFile2Dao implements ManagerDao{
    static String defaultFileName = "data/manager2.dat";
    //  모든클래스가 동일한값.
    String fileName;
    //  인스턴스 변수.
    private List<Manager> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String fileName) {
        this.fileName = fileName;

        File dataFile = new File(fileName);
        try (
                ObjectInputStream in
                =new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(
                                        dataFile)));
                ){
            list = (List<Manager>) in.readObject();
            while(true) {
                try {
                    Manager m = (Manager)in.readObject();
                    list.add(m);
                }   catch (Exception e) {
                    break;
                }
            }
        }   catch(Exception e) {    }
    }

    public ManagerFile2Dao() {
        //  여기 주석 외에 다른거 끼면 안된다는것.
        this(defaultFileName);
    }

    private void save() {
        File dataFile = new File(fileName);
        try (
                ObjectOutputStream out
                = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        dataFile)));
                ){
            out.writeObject(list);
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Manager manager)
            throws MandatoryValueDaoException, DuplicationDaoException{
        //  필수 입력항목이 비었을 경우.
        if(manager.getName().length() == 0 ||
           manager.getEmail().length() == 0 ||
           manager.getPassword().length() == 0) {
            // 호출자에게 예외 정보를 만들어 던진다.
            throw new MandatoryValueDaoException();
        }
            
        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                //  같은 이메일의 매니져가 있을 경우,
                throw new DuplicationDaoException();
            }
        }
        list.add(manager);
        save();
        return 1;
    }

    public List<Manager> findAll() {
        return list;
    }

    public Manager findByEmail(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1; 
            }
        }
        return 0;
    }
}
/*  
    
    
 */