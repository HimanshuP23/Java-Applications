package com.stylewithpen.operations;

import com.stylewithpen.custom_exception.PenExcepion;

public interface PenOperations {
	void addPen(String brand, String color, String inkColor, String Material, int Stock,double discount);
	void updateStock(int id,int quantity) throws PenExcepion;
	void setDiscount(double discount) ;
	void removePens();
	void display();
}
