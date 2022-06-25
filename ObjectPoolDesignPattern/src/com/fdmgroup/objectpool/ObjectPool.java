package com.fdmgroup.objectpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObjectPool<T extends Poolable>  {
	private final int max;
	private final List<T> elements = new ArrayList<>();
    private final Class<T> type;

	public ObjectPool (int max,Class<T> type) {
	    this.type = type;
		this.max = max;
	}

	public Optional<T> get() {

		for (T current : elements ) {
			if (current.isAvailable()) {
				return Optional.ofNullable(current);
			}
		}
		if (elements.size()<max) {
			T newElement = null;
			try {
				newElement = (T) type.newInstance();
			} catch (InstantiationException e) {
				System.err.println("error initializing new object in pool");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.err.println("error initializing new object in pool");
				e.printStackTrace();
			}
			newElement.setAvailable(false);
			elements.add(newElement);
			return Optional.ofNullable(newElement);
		}
		
		return Optional.empty();
	}
	
	public void release(T element) {
		element.clear();
	}
	
	public int getAvailableAmount() {
		int available = 0;
		for (T current : elements ) {
			if (current.isAvailable()) {
				available += 1;
			}
		}
		return available;
	}
	

	public int getTotalObjects() {
		return elements.size();
	}
}
