
import java.text.DecimalFormat;

public class Inventory {
	int money;
	
	
	int oxen;
	int clothing;
	int food;
	int bullets;
	
	int wheels;
	int axels;
	int tongues;
	
	private static Inventory inv;
	
	public String readMoney() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format((double)money / 100);
	}
	
	
	private Inventory(int money) {
		this.money = money * 100;
	}
	
	public static Inventory getInventory(Mode mode) {
		if(inv == null) {
			inv = new Inventory(mode.budget);
			
		}
		return inv;
		
	}

}
