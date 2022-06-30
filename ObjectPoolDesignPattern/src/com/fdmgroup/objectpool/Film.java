package com.fdmgroup.objectpool;

public class Film implements Poolable{
	private String title = "";
	private boolean available = false;
	
	
	public void play() {
		System.out.println("-- Watching the movie " + title + " ...");
	}
	
	public void clear () {
		title = "";
		available = true;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
