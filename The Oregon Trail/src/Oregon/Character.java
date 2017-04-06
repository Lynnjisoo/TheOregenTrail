package Oregon;
import java.util.Random;
import java.util.Scanner;

public class Character {
	String name;
	private int health;
	boolean alive;
	private static final int MAX_HEALTH = 100;
	private static final int MIN_HEALTH = 0;
	public static Character[] characters = new Character[5];

	public Character(String name) {
		this.name = name;
		this.health = 100;
		this.alive = true;
	}
	
	private static Character setWagonLeaderName() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the first name of the wagon leader?");
		String name = input.nextLine();
		Character leader = new Character(name);
		return leader;
		
	}
	
	public static Character[] setMembersName() {
		Scanner input = new Scanner(System.in);
		Character[] members = new Character[5];
		members[0] = setWagonLeaderName();
		characters[0] = setWagonLeaderName();
		System.out.println("Please input the names of the remaining members. ");
		
		for(int i = 1; i < characters.length; i++ ) {
			System.out.printf("%d. ", i);
			String memberName = input.nextLine();
			members[i] = new Character(memberName);
			characters[i] = new Character(memberName);
			
		}
		return characters;
		
	}
	
	
	public static void updateHealth(Ration r, Weather w, Pace p) {
		Random rand = new Random();
		
		double health_change = r.rations.getHealthAdded();
		health_change *= w.weather.getHealthMult();
		health_change -= p.pace.getHealthRed();
		
		for(int i = 0; i < characters.length; i++) {
			if(characters[i].alive) {
				characters[i].health += health_change + rand.nextInt(5) - 2;
				if(characters[i].health <= MIN_HEALTH) characters[i].die();
				if(characters[i].health > MAX_HEALTH) characters[i].health = MAX_HEALTH;
				}
			}
	}
	
	public static boolean checkGameOver() {
		//for loop, if anyone is found to be alive, return true
		for(int i = 0; i < characters.length; i++) {
			if(characters[i].alive) return true;
		}
		return false;
	}
	
	public String getGroupOverallHealth() {
		int membersAlive = 0;
		int partyTotalHealth = 0; 
		
		for(int i = 0; i < characters.length; i++) {
			if(characters[i].alive) {
				membersAlive++;
				partyTotalHealth += characters[i].health;
			}
		}

		int avgHealth = (partyTotalHealth / membersAlive);
		
		if(avgHealth >= 75) return "Good";
		else if(avgHealth >= 50) return "Fair";
		else if(avgHealth >= 25) return "Poor";
		else return "Very poor";
	}
	
	public void die() {
		this.alive = false;
		System.out.println("*****************************************");
		System.out.printf("*        %10s has died.            *\n", this.name);
		System.out.println("*****************************************");
	}

}
