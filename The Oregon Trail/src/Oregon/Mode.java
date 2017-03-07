package Oregon;
import java.awt.Choice;
import java.util.Scanner;

public class Mode {

		int budget;
		String desc;
		String name;
		
		public Mode(int budget, String desc, String name) {
			this.budget = budget;
			this.desc = desc;
			this.name = name;
		}
		
		public static Mode[] setupModes() {
			Mode[] modes = new Mode[3];
			
			modes[0] = new Mode(1600, "A rich, fat man."
					+ " The wealth of the banker may help getting started on the trip to Oregon.", "Banker" );
			modes[1] = new Mode(800, "A middle-class guy. He has a smaller budget than a banker, "
					+ "but will earn more points for his success. ", "Carpenter");
			modes[2] = new Mode(400, "A poor farmer. He always works hard. ", "Farmer");
					
			return modes;
		}
		
		public static Mode chooseMode(Mode[] modes) {
			Scanner input = new Scanner(System.in);
			System.out.println("Which character would you like to play? \n");

			for(int i = 0; i < modes.length; i++){
				if(modes[i] == null) continue;
				System.out.printf("%d. %-9s: %s \n", i + 1, modes[i].name, modes[i].desc );
				
			}
			
			while (true) {
				if(input.hasNextInt()) {
				int choice = input.nextInt();
					if((choice < 1 || choice > modes.length) || modes[choice - 1] ==  null){
					continue;
				}
				return modes[choice - 1];
			}
				else{
					System.out.println("Please enter a number. ");
					input.nextLine();

				}
				
			}
			
		}
	}

