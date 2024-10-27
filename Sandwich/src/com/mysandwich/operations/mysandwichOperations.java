package com.mysandwich.operations;

import com.mysandwich.core.SANDWICHTYPE;
import com.mysandwich.cutomException.SandwichException;

public interface mysandwichOperations {

	public void addSandwich(int sandwichId, String name, String type, double price, String description)throws SandwichException;
	public void display();
	public void SearchsandwichByType(String type)throws SandwichException;
	public void sortingByPrice();
	public void filterMethod();
	public void Remove(String name);
}
