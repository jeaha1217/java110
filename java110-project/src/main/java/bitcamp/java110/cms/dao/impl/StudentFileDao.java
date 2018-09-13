package bitcamp.java110.cms.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

//@Component
public class StudentFileDao implements StudentDao{
    
    private List<Student> list = new ArrayList<>();
    
    public StudentFileDao() {
        /*
        BufferedReader in;
        try {
//            File dataFile = new File("data/student.dat");
//            FileReader fr = new FileReader(dataFile);
//            BufferedReader br = new BufferedReader(fr);
            in = new BufferedReader(new FileReader("data/student.dat"));
            //  106기에 만드는것 있음.
            
            
        }   catch(Exception e) {
            e.printStackTrace();
        }   finally {
            try { in.close(); } catch (Exception e) {    }
        }
*/        
        File dataFile = new File("data/student.dat");
        try (   //  autoClose
            BufferedReader in = new BufferedReader(new FileReader(dataFile))
        ){
            while(true) {
            String line = in.readLine();
            if(line == null)
                break;
            String[] values = line.split(",");
            
            Student s = new Student();
            s.setEmail(values[0]);
            s.setName(values[1]);
            s.setPassword(values[2]);
            s.setSchool(values[3]);
            s.setTel(values[4]);
            s.setWorking(Boolean.parseBoolean(values[5]));
            
            list.add(s);
            }
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void save() {
        File dataFile = new File("data/student.dat");
        try (   //  autoClose
            BufferedWriter out = new BufferedWriter(new FileWriter(dataFile))
        ){
            for (Student s : list) {
                out.write(
                   String.format("%s,%s,%s,%s,%s,%b\n",
                        s.getEmail(),
                        s.getName(),
                        s.getPassword(),
                        s.getSchool(),
                        s.getTel(),
                        s.isWorking()
                        ));
            }
            out.flush();    //  버퍼에서 출력 하라.
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Student student) {
        for(Student item : list) {
            if(item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }   //  중복검사.
        list.add(student);
        save();
        return 1;
    }
    
    public List<Student> findAll() {
        return list;
    }
    
    public Student findByEmail(String email) {
        for(Student item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Student item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;  //   이거 중요함 없으면 exception. 
            }
        }
        return 0;
    }   // 삭제하면 1 못하면 0
}
