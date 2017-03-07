package Oregon;

public class Settings {
	
	//Steady, Strenuous, Grueling 
	public enum Paces {
		STEADY(1, "steady") , 
		STREMUOUS(2, "strenuous") , 
		GRUELING(3, "grueling"); 
		
		private int speed;
		private String type;
		
		private Paces(int speed, String type) {
			this.speed = speed;
			this.type = type;
		}
		
		public int getSpeed() {return speed;}
		public String getType() {return type;}
		public void setSpeed(int speed) {this.speed = speed; }
		public void setType(String type) {this.type = type;}
		
	}
	
	public Paces pace;
	
	public void setPace(int i) {
		this.pace = Paces.values()[i];
		

	}
	
	public Settings() {
		this.pace = Paces.STEADY;

	}
	
	public static void main(String[] ARGS) {
		Settings s = new Settings();
		System.out.println(s.pace.type);
		s.outputPaceOptions();
		s.setPace(3);
		System.out.println(s.pace.type);
	}
	
	public enum Rations{
		FILLING(1, "filling"),
		MEAGER(2, "meager"), 
		BARE_BONES(3, "bare_bones");
		
		private int ration;
		private String type;
		
		private Rations(int ration, String type) {
			this.ration = ration;
			this.type = type;
		}
		
		public int getRation() {return ration;}
		public String getType() {return type;}
		public void setRation(int ration) {this.ration = ration;}
		public void setType(String type) {this.type = type;}

		
	}
	
	public void outputPaceOptions() {
		int i = 0;
		for(Paces p : Paces.values()) {
			System.out.println(i + 1 + "," + p.getType());
			i++;
		}
	}

}
