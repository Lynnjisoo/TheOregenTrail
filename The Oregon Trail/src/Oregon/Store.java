package Oregon;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Store {
	double multiplier;
	
	public void Interact(Mode mode) {
		itemList(mode);
		int item = getUserInput(mode);
		if(item == 0) return;
		getQuantity(item, mode);
	}

	//Implement the default price of items as static values 
	/*private static int food_def = 		0_20;
	private static int oxen_def = 		20_00;
	private static int clothing_def =	10_00;
	private static int ammo_def = 0_10;
	private static int wheel_def = 10_00;
	private static int tongue_def = 10_00;
	private static int axle_def = 10_00;

	//private static int oxen...
	
	public int food;
	public int oxen;
	public int clothing;
	public int ammo;
	public int tongue;
	public int wheel;
	public int axle;

	//private int oxen...
	
	public Store(double multiplier) {
		food = (int)(food_def * multiplier);
		oxen = (int)(oxen_def * multiplier);
		clothing = (int)(clothing_def * multiplier);
		ammo = (int)(ammo_def * multiplier);
		wheel = (int)(wheel_def * multiplier);
		tongue = (int)(tongue_def * multiplier);
		axle = (int)(axle_def * multiplier);

	} */
	
	public Store(double multiplier) {
		this.multiplier = multiplier;
	}
	
	public String getPrice(int value) {
		value = (int)((double)value * this.multiplier);
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format((double) value / 100);

	}
	
	public void itemList(Mode mode) {
		Inventory inv = Inventory.getInventory(mode);
		
		for(int i = 0; i < inv.items.size(); i++){
				//1. Oxen			$20.00
				//2. Clothing		$10.00
			System.out.printf("%d. %8s%t$%s\n", i+1, inv.items.get(i).name, this.getPrice((inv.items.get(i).def_price)));
		}
		System.out.println("-----------------------------------------");
		System.out.println("You have: $" + inv.readMoney());
		System.out.println();
		System.out.println("Hey, let me know if you're interested in something!");
		System.out.println("Enter 0 to exit the store.");
		
	}
	
	public int getUserInput(Mode mode) {
		Inventory inv = Inventory.getInventory(mode);
		Scanner input = new Scanner(System.in);
		int choice;
		
		while(true) {
			while(!input.hasNextInt()) {
			System.out.println("Please enter a number between 1 and " + inv.items.size() + "!"); 
			input.nextLine();
			
		}
		choice = input.nextInt();
		choice--;
		
		
		if(choice >= 0 && choice <= inv.items.size() - 1) {
			return choice;
			
			}
		System.out.println("Your options are between 1 and " + inv.items.size()+ "!");
		}

	}
	
	public void getQuantity(int item_num, Mode mode) {
		Inventory inv = Inventory.getInventory(mode);
		Scanner input = new Scanner(System.in);
		int choice;
		System.out.println("How many " + inv.items.get(item_num).name+" do you want to buy?");
		
		while(true) {
			while(!input.hasNextInt()) {
			System.out.println("Please enter a whole number!"); 
			input.nextLine();
			
		}
		choice = input.nextInt();
		
		if(choice >= 0 && (inv.items.get(item_num).def_price * this.multiplier) * choice <= inv.money) {
			//increase the item number by choice
			//decrease money by choice*default price *multiplier
			//Output on purchase (Bought 3 oxen)
			}
		//Give better situational error output
		System.out.println("Your options are between 1 and " + inv.items.size()+ "!");
		}
			
	}

}
