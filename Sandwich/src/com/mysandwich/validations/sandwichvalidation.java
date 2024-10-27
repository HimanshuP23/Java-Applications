package com.mysandwich.validations;

import java.util.Map;

import com.mysandwich.core.SANDWICHTYPE;
import com.mysandwich.core.Sanwich;
import com.mysandwich.cutomException.SandwichException;

public class sandwichvalidation {
	
	public static void validateName(String name) throws SandwichException {
		
		if(name.length()<6)
			throw new SandwichException("Invalid name, it should be greater than 6 characters");	
	}
	
	public static void validatePrice(double Price) throws SandwichException {
		if(Price<100)
			throw new SandwichException("Invalid price");
	}
}