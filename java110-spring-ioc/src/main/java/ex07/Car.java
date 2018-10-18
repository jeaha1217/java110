package ex07;

import java.sql.Date;

public class Car {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    private Engine engine;

    public Car() {
        System.out.println("Car() is Called!");
    }

    public Car(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(Sting, int) is Called!");
    }

    public Car(int cc, String maker) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(int, String) is Called!");
    }

    public Car(String model, int cc, Engine engine) {
        this.model = model;
        this.cc = cc;
        this.engine = engine;
        System.out.println("Car(Sting, int, engine) is Called!");
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        System.out.println("Car.setNo() is Called!");
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        System.out.println("Car.setModel() is Called!");
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        System.out.println("Car.setMaker() is Called!");
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        System.out.println("Car.setCc() is Called!");
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        System.out.println("Car.setCreateDate() is Called!");
        this.createdDate = createdDate;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        System.out.println("Car.setEngine() is Called!");
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }
}
