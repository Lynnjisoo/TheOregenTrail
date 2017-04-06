package Oregon;

import java.util.Random;

public class Weather {
	
	public double temperature;
	public Weathers weather;
	
	/*
	 * sunny
	 * rainy
	 * snowy
	 * stormy
	 * cloudy
	 * foggy
	 * blizzard
	 * 
	 */
	
	public void updateTemperature(int day) {
		//Getting a linear progression of temperature from the date
		//1 / [(365/2) - 2]
		// mean = (38 * windex) - 8
		// standard deviation = (-2 * windex) + 4
		
		double windex = 2 / Math.abs((double)(182.5) - (double)day);
		System.out.println(windex);
		double mean = (38 * windex) - 8;
		double std = (-2 * windex) + 4;
		System.out.println("Mean: " + mean + " , Standard Deviation");
		Random rand = new Random();
		this.temperature = rand.nextGaussian() * std + mean;
		
	}
	
		
	public enum Weathers {
		RAINY("Rainy", 0.8, 1.2, 0.9),
		SUNNY("Sunny", 1.0, 1.2, 1.2),
		CLOUDY("Cloudy", 1.0, 1.0, 1.0),
		STORMY("Stormy", 0.25, 0.3, 0.5),
		SNOWY("Snowy", 0.5, 0.5, 0.7),
		BLIZZARD("Blizzard", 0.1, 0.0, 0.2);
		
		private String name;
		private double speed_mult;
		private double grass_mult;
		private double health_mult;
		
		private Weathers(String name, double speed_mult, double grass_mult, double health_mult) {
			this.name = name;
			this.speed_mult = speed_mult;
			this.grass_mult = grass_mult;
			this.health_mult = health_mult;
		}
		
			public String getName() { return this.name(); }
			public double getSpeedMult() { return this.speed_mult; }
			public double getGrassMult() { return this.grass_mult; }
			public double getHealthMult() { return this.health_mult; }
		}
		
	
	public void updateWeather() {
		/*
		 * 0~10 Sunny
		 * 11~14 Cloudy
		 * 15~18 Rainy
		 * 19	 Stormy
		 */
		
		Random rand = new Random();
		int random_weather = rand.nextInt(20);
		
		if(random_weather <= 10) {
			//weather sunny
		}
		else if(random_weather <= 14) {
			//weather cloudy
		}
		else if(random_weather <= 18) {
			//weather rainy
			//of temperature low enough, snowy
		}
		else {
			//weather stormy
			//if temperature low enough, blizzard 
		}
	}
	
	public String getTemperature()  {
		return String.format("%.1f°C", this.temperature);
	}
	
	public static void main(String [] ARGS) {
		Weather w = new Weather();
		w.updateTemperature(1);
		System.out.println("Winter: " + w.getTemperature());
		w.updateTemperature(182);
		System.out.println("Summer: " + w.getTemperature());
	}
	
	public Weather() {
		CurrentDate now = CurrentDate.getCurrentDate();
		updateTemperature(now.getDayInYear());
		updateWeather();
	}
}

