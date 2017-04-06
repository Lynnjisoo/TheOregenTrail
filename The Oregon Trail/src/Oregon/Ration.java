package Oregon;

import Oregon.Settings.Rations;
import java.util.Scanner;

public class Ration {
	
	public void changePaceSetting() {
		outputRationOptions();
		int selection = getUserInput(1, Ration.values().length) - 1;
		this.rations = Rations.values()[selection];
		
	}
	
	public enum Rations {
		FLILLING(3, "filling", 5),
		MEAGER(2, "meager", 3),
		BAREBONES(1, "bare-bones", 1);
		
		int amount;
		String type;
		int health_added;
		
		private Rations(int amount, String type, int health_added) {
			this.amount = amount;
			this.type = type;
			this.health_added = health_added;
		}
		
		public int getAmount() { return amount; }
		public String getType() { return type; } 
		public int getHealthAdded() { return health_added; }
	}
	
	public void outputRationOptions() {
		int i = 0;
		for(Rations r : Rations.values()) {
			System.out.println(i + 1 + " . " + r.getType());
			i++;
		}
	}
	
	public Rations rations;
	
	public int getUserInput(int min, int max) {
		Scanner input = new Scanner(System.in);
		int selection;
		while(true) {
			System.out.println("Please enter a whole number!");
			input.nextLine();
			selection = input.nextInt();
			if(selection >= min && selection <= max) {
				return selection;
			}
			System.out.println("Please select a number between " + min + " and " + max);
			}
		}
	
		public Ration() {
			this.rations = Rations.FLILLING;
		}
	
	public static void main(String[] ARGS) {
		Ration r = new Ration();
		System.out.println(r.rations.type);
		r.changeRationSettings();
		System.out.println(r.rations.type);
		
	}
	
	}

