package com.baodian.overload_override;

public class Monkey {

	private String color;
	private String name;
	public Monkey(){
		
	}
	public Monkey(String color,String name){
		this.color=color;
		this.name=name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
