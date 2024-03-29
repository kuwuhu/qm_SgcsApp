package SgSuperStore.app;

import javax.swing.JTextField;

public class CargoItem {
	private String number;
	private String name;
	private double price;
	private String unit;

	public CargoItem() {}
	
	public CargoItem(String number, String name, double price, String unit) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
