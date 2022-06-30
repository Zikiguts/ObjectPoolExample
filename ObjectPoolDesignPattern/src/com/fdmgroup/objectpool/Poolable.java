package com.fdmgroup.objectpool;

public interface Poolable {

	public void clear ();
	public boolean isAvailable();
	public void setAvailable(boolean available);

}
