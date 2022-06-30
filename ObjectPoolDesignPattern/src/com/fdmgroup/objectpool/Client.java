package com.fdmgroup.objectpool;

import java.util.Optional;

public class Client {

	public static void main(String[] args) {
		
		ObjectPool<Film> objectPool = new ObjectPool<>(3,Film.class);
		
		System.out.println("Total objects in pool     = " + objectPool.getTotalObjects());
		System.out.println("Available objects in pool = " + objectPool.getAvailableAmount());
		
		for (int i = 1; i<=6; i++) {
			Film film1;
			Optional<Film> film1opt = objectPool.get();
			if (film1opt.isPresent()) {
				film1 = film1opt.get();
				System.out.println(i + ": Succesfully returned a film.");
				film1.setTitle("Dragons " + i);
				film1.play();
				objectPool.release(film1);
			}
			else {
				System.out.println(i + ": No film returned.");
			}
		}
		
		System.out.println("Total objects in pool     = " + objectPool.getTotalObjects());
		System.out.println("Available objects in pool = " + objectPool.getAvailableAmount());
		
		
	}

}
