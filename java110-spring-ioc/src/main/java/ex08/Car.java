package ex08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    private Engine engine;

    public Car() {
        System.out.println("Car() has Called..");
    }

    public Car(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(Sting, int) has Called..");
    }

    public Car(int cc, String maker) {
        this.maker = maker;
        this.cc = cc;
        System.out.println("Car(int, String) has Called..");
    }

    public Car(String model, int cc, Engine engine) {
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
    //  @Autowired 해당 의존 객체가 없으면 Spring IoC Container는 예외를 발생시킨다.
    @Autowired(required=false)  //  required=false 하면 예외 안뜸(없으면 이 메서드를 호출하지 않는다).
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }
}
