package com.fdmgroup.objectpool;

import java.util.ArrayList;
import java.util.List;

public class ReusablePool {
	private List<String> elements = new ArrayList<String>();

	public List<String> getElements() {
		return elements;
	}

	public void add(String element) {
		elements.add(element);
	}
	
	
}
