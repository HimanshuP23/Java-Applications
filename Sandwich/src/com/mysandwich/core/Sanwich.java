package com.mysandwich.core;

public class Sanwich {
	
	private int sandwichId;
	private String name;
	private SANDWICHTYPE type;
	private double price;
	private String description;
	
	public Sanwich(int sandwichId, String name, SANDWICHTYPE type, double price, String description) {
		super();
		this.sandwichId = sandwichId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.description = description;
	}
	
	

	public Sanwich(SANDWICHTYPE type) {
		super();
		this.type = type;
	}



	public Sanwich(String type2) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Sanwich [sanwichId=" + sandwichId + ", name=" + name + ", type=" + type + ", price=" + price
				+ ", description=" + description + "]";
	}

	public int getSanwichId() {
		return sandwichId;
	}

	public void setSanwichId(int sanwichId) {
		this.sandwichId = sanwichId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SANDWICHTYPE getType() {
		return type;
	}

	public void setType(SANDWICHTYPE type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
