package com.example;

import java.time.LocalDate;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
// -> construiesc ceea ce le zice numele fara a scrie cod
public class Door {
	
	private int id;
	private String material;
	private double height, width;
	private LocalDate installationDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public LocalDate getInstallationDate() {
		return installationDate;
	}
	public void setInstallationDate(LocalDate installationDate) {
		this.installationDate = installationDate;
	}
	
	public Door(int id, String material, double height, double width, LocalDate installationDate) {
		super();
		this.id = id;
		this.material = material;
		this.height = height;
		this.width = width;
		this.installationDate = installationDate;
	}
	
	public Door( String material, double height, double width, LocalDate installationDate) {
		this.material = material;
		this.height = height;
		this.width = width;
		this.installationDate = installationDate;
	}
	
	public Door() {
	}
	
}
