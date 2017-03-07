package Oregon;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Inventory {
	int money;
	
	
	Item oxen;
	Item clothing;
	Item food;
	Item ammo;
	
	Item wheels;
	Item axles;
	Item tongues;
	
	ArrayList<Item> items = new ArrayList<>();
	
	private static Inventory inv;
	
	public String readMoney() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format((double) money / 100);
	}
	
	
	private Inventory(int money) {
		this.money = (money * 100) - 1;
	}
	
	public static Inventory getInventory(Mode mode) {
		if(inv == null) {
			inv = new Inventory(mode.budget);
			inv.food = new Item("food", 0_20);
			inv.oxen = new Item("oxen", 20_00);
			inv.clothing = new Item("clothing", 10_00);
			inv.ammo = new Item("ammo", 0_10);
			inv.wheels = new Item("wheel", 10_00);
			inv.tongues = new Item("tongue", 10_00);
			inv.axles = new Item("axles", 10_00);
			
			inv.items.add(inv.food);
			inv.items.add(inv.oxen);
			inv.items.add(inv.clothing);
			inv.items.add(inv.ammo);
			inv.items.add(inv.wheels);
			inv.items.add(inv.tongues);
			inv.items.add(inv.axles);

			
		}
		return inv;
		
	}

}
