package com.fdmgroup.objectpool;



public class ObjectPool {
	private final int max = 20;
	private ReusablePool pool = new ReusablePool();
	
	public String get() {
		String instance = null;
		
		if (pool.getElements().size()<max) {
			pool.add(new String());
		}
		
		return instance;
	}
	
	
}
