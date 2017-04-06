package Oregon;

import java.util.Scanner;
import location.Location;

public class Game implements Runnable{ 
	static CurrentDate date;
	static Weather weather;
	static Pace pace;
	static Mode mode;
	
	/*Chapter 11 - Multi-threaded programs 
	 * pg.372
	 */
	
	public void run() {
		while (true) {
			date.daysForward(1);
			Location.travelledDistance += pace.calculatedSpeed();
			//Checks for if we'be reached our destination 
			weather.updateTemperature(CurrentDate.getCurrentDate().getDayInYear());
			weather.updateWeather();
			pace.updateSpeed(mode, weather);
			
			System.out.println("Current location: " + Location.Locations[Location.currentLocation]);
			System.out.println("Progress to " + Location.Locations[Location.currentDestination]);
			System.out.println(Location.travelledDistance + "/" + 
			Location.findDistance(Location.currentLocation, Location.currentDestination));
			System.out.println("Current Weather: " + weather.weather.getName());
			System.out.println("Current Temperature: " + weather.getTemperature());
			try {
				System.out.println("Wagon moving...");
				Thread.sleep(7500);
			}
			catch (InterruptedException e) {
				return;
			}
		}
	}
	
	
	
	public static void main(String[] ARGS) {
		Game game = new Game();
		Mode[] modes = Mode.setupModes();
		mode = Mode.chooseMode(modes);
		Character[] members = Character.setMembersName();

		date = CurrentDate.getCurrentDate();
		weather = new Weather();
		pace = new Pace();
		pace.updateSpeed(mode, weather);
		Inventory inventory = Inventory.getInventory(mode);
		Scanner input = new Scanner(System.in);
		
		Thread t = new Thread(game);
		t.start();
		
		//System.out.println("Yay, we did it!");
		//CurrentDate date = CurrentDate.getCurrentDate();
		//System.out.println(inventory.readMoney());
		//Store first = new Store(1);
		//test
		//System.out.println("Ox at first store costs: " + first.getPrice(first.ox));
		//Store second = new Store(1.25);
		//System.out.println("Ox at second store costs: " + second.getPrice(second.ox));	
		
		if(input.hasNextLine()) {
			t.interrupt();
			System.out.println("Wagon stops. ");
		}	
	}
}
