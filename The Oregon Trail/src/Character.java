import java.util.Scanner;

public class Character {
	String name;
	
	private int health;

	public Character(String name) {
		this.name = name;
		this.health = 100;
		
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
		System.out.println("Please input the names of the remaining members. ");
		
		for(int i = 1; i < members.length; i++ ) {
			System.out.printf("%d. ", i);
			String memberName = input.nextLine();
			members[i] = new Character(memberName);
			
		}
		return members;
		
	}

}
