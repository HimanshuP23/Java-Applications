package com.stylewithpen.operations;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import com.stylewithpen.core.Brand;
import com.stylewithpen.core.Material;
import com.stylewithpen.core.Pen;
import com.stylewithpen.custom_exception.PenExcepion;

public class PenOperationsImpl implements PenOperations{
	private Map<Integer, Pen> pens;
	private static int idCounter = 0;
	private int id;
	public PenOperationsImpl() {
		// TODO Auto-generated constructor stub
		pens = new HashMap<Integer, Pen>();
		id = ++idCounter;
		pens.put(id, new Pen(id, Brand.CELLO, "Black", "blue",
				Material.METAL, 95, LocalDate.now(), LocalDate.parse("2024-06-05"), 20, 0));
		id = ++idCounter;
		pens.put(id, new Pen(id, Brand.PARKER, "Black", "blue",
				Material.ALLOYSTEEL, 65, LocalDate.now(), LocalDate.parse("2024-07-05"), 250, 0));
		id = ++idCounter;
		pens.put(id, new Pen(id, Brand.CELLO, "White", "black",
				Material.PLASTIC, 150, LocalDate.now(), LocalDate.parse("2023-12-05"), 10, 0));
	}
	@Override
	public void addPen(String brand,String color,String inkColor,String material,int stock,double price) {
		// TODO Auto-generated method stub
		LocalDate listing = LocalDate.now();
		Brand b = Brand.valueOf(brand.toUpperCase());
		Material m = Material.valueOf(material.toUpperCase());
		LocalDate stockUpdated = LocalDate.now();
		int id = ++idCounter;
		pens.put(id, new Pen(id, b, color, inkColor, m, stock, stockUpdated, listing, price, 0));
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		pens.values().forEach(p->System.out.println(p));
	}

	@Override
	public void updateStock(int id,int quantity) throws PenExcepion{
		// TODO Auto-generated method stub
		if(!pens.containsKey(id))
			throw new PenExcepion("Pen not found");
		Pen pen = pens.get(id);
		pen.setStock(quantity);
		pen.setStockUpdateDate(LocalDate.now());
		pens.replace(id, pen);
		System.out.println("Stock updated successfully");
			
	}

	@Override
	public void setDiscount(double discount){
		// TODO Auto-generated method stub
		for(Pen pe: pens.values()) {
			LocalDate d = pe.getStockListingDate().plusMonths(3L);
			System.out.println(d);
			if(d.isBefore(LocalDate.now())) {
				pe.setDiscount(discount);
			}	
		}
	
	}

	@Override
	public void removePens() {
		// TODO Auto-generated method stub
		pens.values().removeIf(p->p.getStockListingDate().plusMonths(9L).isBefore(LocalDate.now()));
		
	}
	
}
