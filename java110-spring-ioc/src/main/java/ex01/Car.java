package ex01;

import java.sql.Date;

public class Car {
	private int no;
	private String model;
	private String maker;
	private int cc;
	private Date createdDate;
	
	public Car() {
		System.out.println("Called Car()");
	}
	
	public Car(String model, int cc) {
		this.model = model;
		this.cc = cc;
		System.out.println("Called Car(Sting, int)");
	}
	
	public Car(int cc, String model) {
		this.model = model;
		this.cc = cc;
		System.out.println("Called Car(int, String)");
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

	@Override
	public String toString() {
		return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
				+ "]";
	}
	
	
}
