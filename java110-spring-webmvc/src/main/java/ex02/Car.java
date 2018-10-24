package ex02;

import java.sql.Date;
//  SQL Date가 날짜 형식이 더 깔끔

public class Car {
    String Model;
    String maker;
    Boolean auto;
    Date createdDate; 
    Engine engine;
    
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
    public Boolean getAuto() {
        return auto;
    }
    public void setAuto(Boolean auto) {
        this.auto = auto;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
