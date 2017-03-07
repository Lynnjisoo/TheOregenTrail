package Location;

public class River extends Location{
	private static int ferry_cost = 5;
	private static int guide_clothes_cost = 5;
	
	int depth;
	int width;
	int ferry;  
	/* 0 ~ 7, 1 = sunday, 7= saturday, 0 = no ferry*/
	
	boolean guide;
	
	public River(String name, int depth, int width, int ferry, boolean guide) {
		super(name);
		this.depth = depth;
		this.width = width;
		this.ferry = ferry;
		this.guide = guide;
	}

}
