package com.skilldistillery.jet;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	
	
	public void fly() {
		double timeFly = this.range / this.speed ;
System.out.println(timeFly + " units of time");

	}

	
	
	
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}




	public double getSpeed() {
	double machSpeed = this.speed / 767;
		
		return machSpeed;
	}




	public void setSpeed(double speed) {
		this.speed = speed;
	}




	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}




	public int getRange() {
		return range;
	}




	public void setRange(int range) {
		this.range = range;
	}


}
