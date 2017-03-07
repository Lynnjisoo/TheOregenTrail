package Oregon;

public class Game {
	
	
	public static void main(String[] ARGS) {
		//Mode[] modes = Mode.setupModes();
		//Mode mode = Mode.chooseMode(modes);
		//Character[] members = Character.setMembersName();
		//System.out.println("Yay, we did it!");
		
		CurrentDate date = CurrentDate.getCurrentDate();
		
		//Inventory inventory = Inventory.getInventory(mode);
		
		//System.out.println(inventory.readMoney());
		
		//Store first = new Store(1);
		//test
		//System.out.println("Ox at first store costs: " + first.getPrice(first.ox));
		//Store second = new Store(1.25);
		//System.out.println("Ox at second store costs: " + second.getPrice(second.ox));
		
		System.out.println("Today is: " +date.outputDate());
	
	}

}
