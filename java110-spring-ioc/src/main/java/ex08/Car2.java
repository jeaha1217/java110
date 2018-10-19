package ex08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

/*  Autowired 사용법.
    1) setter에 붙이기
    2) feild에 붙이기
    


*/
public class Car2 {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    
    
    @Autowired(required=false)
    private Engine engine;
//    private인데 이게 되네.;; 많이 쓴다고..
    
    
    public Car2() {
        System.out.println("Car() has Called..");
    }

    public Car2(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(Sting, int) has Called..");
    }

    public Car2(int cc, String maker) {
        this.maker = maker;
        this.cc = cc;
        System.out.println("Car(int, String) has Called..");
    }

    public Car2(String model, int cc, Engine engine) {
        this.model = model;
        this.cc = cc;
        this.engine = engine;
        System.out.println("Car(Sting, int, engine) has Called..");
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }
}
