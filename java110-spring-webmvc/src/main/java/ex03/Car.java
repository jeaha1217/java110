package ex03;

import java.sql.Date;
//  SQL Date가 날짜 형식이 더 깔끔
import java.util.Arrays;

public class Car {
    
    int no;
    String Model;
    String maker;
    Boolean auto;
    Date createdDate; 
    String[] musics;
    Tire[] tires;
    Engine engine;
    
    public Car() {}
    public Car(String model, String maker, Boolean auto, Date createdDate, String[] musics, Tire[] tires,
            Engine engine) {
        super();
        Model = model;
        this.maker = maker;
        this.auto = auto;
        this.createdDate = createdDate;
        this.musics = musics;
        this.tires = tires;
        this.engine = engine;
    }
    
    
    public String getModel() {
        return Model;
    }
    public void setModel(String model) {
        Model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Boolean isAuto() {
        return auto;
    }
    public void setAuto(Boolean auto) {
        this.auto = auto;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String[] getMusics() {
        return musics;
    }
    public void setMusics(String[] musics) {
        this.musics = musics;
    }
    public Tire[] getTires() {
        return tires;
    }
    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Boolean getAuto() {
        return auto;
    }
    
    @Override
    public String toString() {
        return "Car [no=" + no + ", Model=" + Model + ", maker=" + maker + ", auto=" + auto + ", createdDate="
                + createdDate + ", musics=" + Arrays.toString(musics) + ", tires=" + Arrays.toString(tires)
                + ", engine=" + engine + "]";
    }
    
}
