package Oregon;

import java.util.Scanner;

import Oregon.Settings.Paces;

public class Pace {
	public static final double OXEN_MULT = 0.75;
	
	public void changePaceSettings() {
		outputPaceOptions();
		int selection = getUserInput(1, Paces.values().length) - 1;
		this.pace = Paces.values()[selection];
	}
	
	int calculated_speed;
	
	public enum Paces {
		STEADY(0.5, "steady", 1) , 
		STREMUOUS(1, "strenuous", 3) , 
		GRUELING(1.5, "grueling", 6); 
		
		private double speed;
		private String type;
		private double health_reduction;
		
		private Paces(double speed, String type, double health_reduction) {
			this.speed = speed;
			this.type = type;
			this.health_reduction = health_reduction;
		}
		
		public double getSpeed() {return speed;}
		public String getType() {return type;}
		public double getHealthRed() { return this.health_reduction; }
		
	}
	public Paces pace;
	
	
	public void updateSpeed(Mode mode, Weather w) {
		double speed;
		Inventory i = Inventory.getInventory(mode);
		speed = i.oxen.num * OXEN_SPEED_MULT;
		//1. Oxen - which require inventory
		speed *= this.pace.speed;
		//2. pace Setting - Local
		speed *= w.weather.getSpeedMult();
		//3. Weather - which require the weather 
		this.calculated_speed = (int)speed;
	}
	
	public int calculatedSpeed() {
		return this.calculated_speed;
	})
	
	public void outputPaceOptions() {
		int i = 0;
		for(Paces p : Paces.values()) {
			System.out.println(i + 1 + "," + p.getType());
			i++;
		}
	}
	

	
	public int getUserInput(int min, int max) {
		Scanner input = new Scanner(System.in);
		int selection;
		while(true) {
			while(!input.hasNextInt()) {
				System.out.println("Please enter a whole number. ");
				input.nextLine();
			}
			
			selection = input.nextInt();
			if(selection >= min && selection <= max) {
				return selection;
			}
			System.out.println("Please select a number between " + min + " and " + max);
			
		}
	}
	
	public Pace() {
		this.pace = Paces.STEADY;
		
	}
	
	public static void main(String[] ARGS) {
		Pace p = new Pace();
		System.out.println(p.pace.type);
		p.changePaceSettings();
		System.out.println(p.pace.type);
	}
	

}



