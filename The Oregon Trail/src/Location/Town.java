package Location;

import Oregon.Store;

public class Town extends Location {
	public Store store;
	
	//* Talk to locals - return some given String*//
	public Town(String name, Store store) {
		super(name);
		this.store = store;
	}

}
