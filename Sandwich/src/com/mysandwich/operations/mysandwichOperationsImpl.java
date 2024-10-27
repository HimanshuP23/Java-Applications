package com.mysandwich.operations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.mysandwich.validations.sandwichvalidation.*;
import com.mysandwich.core.SANDWICHTYPE;
import com.mysandwich.core.Sanwich;
import com.mysandwich.cutomException.SandwichException;

public class mysandwichOperationsImpl implements mysandwichOperations{
	
	Map<Integer,Sanwich> sandwichMap;
	
	
	
	public mysandwichOperationsImpl() {
		sandwichMap = new HashMap<>();
		
//		101 planevegetable vegetable 130 VeryTast
//		202 abcdsefhsfs ice_cream 150 coldSandwich
//		302 abcdefghijk non_vegetable 250 abcd
//		401 xyz open 150 openSandwich
	}



	@Override
	public void addSandwich(int sandwichId, String name, String type, double price, String description)throws SandwichException {
		// TODO Auto-generated method stub
		SANDWICHTYPE types = SANDWICHTYPE.valueOf(type.toUpperCase());
		validateName(name);
		validatePrice(price);
		Sanwich s = new Sanwich(sandwichId, name, types, price, description);
		sandwichMap.put(s.getSanwichId(), s);
		System.out.println("Sandwich added successfully");
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		sandwichMap.values().forEach(i->System.out.println(i));
	}
	
	@Override
	public void SearchsandwichByType(String type) {
		// TODO Auto-generated method stub
		SANDWICHTYPE stype = SANDWICHTYPE.valueOf(type.toUpperCase());
		sandwichMap.values().stream().filter(c->c.getType().equals(stype)).forEach(i->System.out.println(i));
	}
	
	@Override
	public void sortingByPrice() {
		// TODO Auto-generated method stub
		sandwichMap.values().stream().sorted(Comparator.comparing(Sanwich::getPrice)).forEach(i->System.out.println(i));
	}
	
	@Override
	public void filterMethod() {
		// TODO Auto-generated method stub
		Optional<Sanwich> d = sandwichMap.values().stream().min(Comparator.comparing(Sanwich::getPrice));
		System.out.println(d);
	}
	
	@Override
	public void Remove(String name) {
		// TODO Auto-generated method stub
		sandwichMap.values().removeIf(c->c.getName().equals(name));
		System.out.println("Removed Successfully");
	}
	
	
	
}
