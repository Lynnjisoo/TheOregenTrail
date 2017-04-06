package Location;
import Oregon.Store;


public class Location {
		String name;
		static int currentLocation = 0;
		static int currentDestination = 1;
		static int travelledDistance = 0;	

	public Location(String name) {
			this.name = name;
			 }
	
	public Location[] locations = {
			new Town("Independence" , new Store(1)),
			new River("Kansas River" , 7, 100, 3, false),
			new River("Big Bluew River" , 7, 100, 5, false),
			new Town("Fort Kearney" , new Store(1.25)),
			new Landmark("Chimney Rock"),
			new Town("Fort Laramie" , new Store(2)),
			new Landmark("Independence Rock"),
			new Town("Southpass" , new Store(1.75)),
			new River("Green River Crossing" , 7, 100, 1, true),
			new Landmark("Soda Springs"),
			new Town("Fort Hall" , new Store(1.75)), 
			new River("Snake River Crossing" , 7, 100, 4, false), 
			new Town("Fort Boise" , new Store(2)),
			new Landmark("Blue Mountains"), 
			new Town("Fort Walla Walla" , new Store(3)),
			new Landmark("The Dalles"), 
			new Landmark("Columbia River Highway"), //Maybe change later 
			new Landmark("Oregon City")
	};
	
	public int findDistance(int from, int to) {
		int[][] edges = adjacencyList[from];
		for(int i = 0; i < edges.length; i++) {
			if(edges[i][0] == to) {
				return edges[i][1];
			}
		}
		return - 1;
	}
	
	/*public int findDistanceInEdgelist(int from, int to) {
		for(int i = 0; i < edgeList.length; i++) {
			if(edgeLIst[i][0] == from && edgeList[i][1] == to) {
				return edgeList[i][2];
			}
		}
		return - 1;
	}*/
			
	
	public static int[][][] adjacencyList = 
		{
				/* 0 */ { {1, 102} },
				/* 1 */ { {2, 83} },
				/* 2 */ { {3, 119} },
				/* 3 */ { {4, 250} },
				/* 4 */ { {5, 86} },
				/* 5 */ { {6, 190} },
				/* 6 */ { {7, 102} },
				/* 7 */ { {8, 94} },
				/* 8 */ { {9, 94} },
				/* 9 */ { {10, 144} },
				/* 10 */ { {11, 57} },
				/* 11 */ { {12, 182} },
				/* 12 */ { {13, 114} },
				/* 13 */ { {14, 160} },
				/* 14 */ { {15, 3} },
				/* 15 */ { {16, 52} },
				/* 16 */ { {17, 132} },
				/* 17 */ { {18, 232} },
				/* 18 */ { {19, 122} },
				/* 19 */ { {20, 124} }
				
		};
	
}

