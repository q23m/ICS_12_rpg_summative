import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Object.*;

/*Map Legend:
0 - wall/trees
1 - free space/grass
2 - resource collector
3 - last map/spawnpoint
4 - zombies
5 - shop
6 - water
7 - next map
8 - harder zombie
9 - actions (Starts tutorial/Gives instruction)
10 - final boss
91 - buttons <- extends 9
 */

class Map{
	static int [][] map = new int [1][1];
	public int playerX = 1;
	public int playerY = 1;
	int mapnum = 0;
	public Map(int mapn){ 
		mapnum = mapn;
		map = createMap(mapnum);
		System.out.println("Creating Maps...\nPlease Wait");
	}

	// returns desired map given key number
	public static int[][] createMap(int mapnum){
		if(mapnum == 0) return startMap;
		if(mapnum == 1) return homeMap;
		if(mapnum == 2) return canadaMap;
		if(mapnum == 3) return europeMap;  // need boat
		if(mapnum == 4) return russiaMap;  // need plane
		if(mapnum == 5) return vietnamMap;
		if(mapnum == 6) return finalMap;
		if(mapnum == 7) return endMap;
		System.out.println("Map could not be loaded.");
		return new int[][]{{}};
	}

	public static int[][] getMap(){
		return map;
	}

	public static int [][] startMap = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,11,1,1,0},
			{0,9,1,1,1,1,1,1,1,1,11,1,1,0},
			{0,1,9,1,0,1,1,1,1,0,11,1,1,7},
			{0,9,1,1,1,1,1,1,1,1,11,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,11,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	};

	public static int [][] homeMap = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,1,1,1,0,1,1,0,1,1,0,0,1,1,4,1,0,2,2,2,0},
			{0,2,1,1,0,1,1,1,4,1,0,0,0,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,4,1,0,2,2,2,0},
			{0,2,1,1,1,1,1,1,4,1,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0,4,1,0,1,1,0,1,1,0,1,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,1,1,0,1,1,4,1,0,1,1,0,1,1,0,1,1,0,1,2,1,1},
			{0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,4,1,0,0,1,1,0,1,1,1,1,0,1,1,0,1,1,0,1,0,0,4,1,0,1},
			{0,0,0,11,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,0,1,1,0,1,1,0,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1},
			{0,9,4,11,1,1,1,0,1,1,1,13,5,1,1,1,1,1,1,0,0,0,1,0,1,1,0,0,1,4,1,0,1,1,0,1,1,0,4,0,0,1},
			{3,9,4,11,1,1,1,1,1,1,1,13,5,1,1,1,1,1,4,0,0,4,4,0,1,4,1,0,4,1,0,1,1,1,0,1,4,0,1,1,0,1},
			{0,9,4,11,1,1,1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,4,0,1,0,0,0,0,1,0,1,1,0,1},
			{0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,1,1,4,1,1,1,4,0,2,2,0,1,0,4,0,0,1},
			{0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,4,1,0,0,4,1,4,0,1,1,0,1,0,1,1,0,2,2,0,1,0,1,1,0,1},
			{0,2,1,1,1,1,1,1,4,1,0,0,0,0,0,0,0,1,4,0,0,0,0,1,0,1,1,0,0,0,0,0,0,2,2,0,1,0,0,1,0,1},
			{0,2,1,1,0,1,1,1,4,1,0,0,0,0,0,0,1,1,1,1,4,1,1,1,0,1,1,4,1,1,1,0,1,0,0,0,1,4,1,4,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,7},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

	};

	public static int [][] canadaMap = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,4,1,1,0,1,1,1,4,4,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,4,1,1,1,4,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,4,1,1,4,1,0,4,4,4,4,4,1,1,2,2,5,0,0,0},
			{0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,4,0,1,1,1,1,1,4,1,1,0,1,1,1,1,1,0,1,1,0,4,1,1,1,0,1,1,4,0,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0},//middle zeroes are removed once boat is bought
			{3,9,4,0,1,1,1,1,4,1,1,1,0,1,1,1,1,1,1,1,1,4,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,4,1,1,1,1,1,1,4,0,1,1,1,0,1,1,1,0,1,1,1,1,4,1,1,1,1,1,1,1,0,1,1,1,1,1,7,0},
			{0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,4,1,0,5,1,0,1,1,4,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,4,1,0,4,4,4,4,4,1,1,2,2,5,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},

	};

	public static int [][] europeMap = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,4,0,1,1,1,1,1,1,1,4,1,1,5,1,1,1,1,1,0,1,1,1,1,0}, 
			{0,1,1,1,1,4,1,1,0,1,1,4,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,0}, 
			{0,2,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,0,1,0,0,0,0,1,0}, 
			{0,0,0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,1,0,5,0,0,1,0}, 
			{0,0,0,0,0,1,1,4,1,1,1,4,1,1,1,1,1,1,1,1,1,0,1,9,1,1,1,4,7}, //Guess the pattern;  number of unique patterns: 24
			{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,1,9,1,1,1,4,0}, // 9's at the end warn the player of cold weather and to buy some gear
			{0,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,0,1,0,5,0,0,1,0}, 
			{3,9,1,1,5,1,1,1,1,1,4,1,1,0,1,1,1,1,1,1,0,0,1,0,0,0,0,1,0}, 
			{0,1,1,1,0,1,1,4,1,1,1,1,1,1,1,1,4,1,1,1,1,0,1,0,1,1,1,1,0}, 
			{0,1,4,1,1,1,1,1,1,1,0,1,1,1,4,1,1,5,1,1,0,0,1,0,1,1,1,1,0}, 
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
	};

	public static int [][] russiaMap = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,2,2,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0}, //Remove the 0's to clear the path once the player buys cold weather gear
			{3,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,0,0,1,0}, //9's tell player to buy a sled and gear to go to the next level
			{3,1,1,1,5,1,1,0,0,1,1,1,1,1,4,1,1,1,1,1,4,1,1,1,1,1,1,1,0}, //If the player does not have enough resources, they can harvest at the 2 
			{0,0,0,0,0,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0}, //If the player does not have enough coins, they have to go back to the europe level
			{0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,4,1,0,1,1,1,1,1,1,4,1,1,0}, //Make sleds relatively cheap (<1 min of grinding) 
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0}, 
			{0,1,1,1,4,1,1,4,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,4,1,1,0}, 
			{0,1,1,0,2,0,1,1,1,1,0,1,1,1,1,4,1,1,0,1,1,1,0,0,0,2,1,1,0}, 
			{0,1,1,1,0,1,1,1,1,4,0,0,0,0,0,0,0,4,0,1,1,1,1,1,1,1,1,1,0}, 
			{0,1,4,1,1,1,1,1,4,2,0,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,0}, 
			{0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
	};
	
	public static int [][] vietnamMap = {
			{0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,1,1,2,1,1,0,0,1,1,2,1,1,0,0,1,1,0,1,1,1,1,1,0,1,1,1,0,1,0,0},
			{0,0,9,0,0,0,0,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,2,1,1,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,4,4,4,4,4,0,0,4,4,4,4,4,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,2,2,2,0,1,1,1,1,0,0},
			{0,0,0,0,0,4,0,0,1,1,0,0,0,1,1,1,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,4,4,4,4,4,0,0,4,4,4,4,4,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0},
			{0,0,1,0,0,0,0,0,2,2,0,0,4,4,4,4,4,0,0,4,4,4,4,4,0,0,4,4,4,4,4,4,1,1,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,4,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,4,0,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,5,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,4,1,4,1,1,1,1,0},
			{0,1,1,1,1,1,0,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,4,1,4,1,8,1,1,0},
			{0,1,1,1,1,1,0,2,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,4,1,4,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,4,4,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0},
			{0,0,4,1,1,0,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
			{0,0,1,0,1,1,0,4,0,4,0,1,1,0,0,4,4,4,4,0,0,4,4,4,4,0,0,1,4,1,4,1,4,1,0,0,0,0,0,0,0,0},
			{0,0,1,0,1,0,1,1,0,1,1,4,4,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,4,1,1,1,0,1,1,0},
			{0,0,4,0,1,4,1,0,1,4,0,1,1,0,0,1,1,2,1,0,0,1,2,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0},
			{0,0,1,0,0,0,0,0,1,0,0,1,1,0,0,1,0,1,1,0,0,1,1,0,1,0,0,1,1,0,1,1,1,1,4,1,1,1,4,1,1,0},
			{0,1,1,1,0,0,1,1,0,1,1,4,4,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0},
			{0,1,2,1,0,0,1,0,0,4,0,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,4,1,1,0,1,1,1,1,1,1,0,1,1,0},
			{0,1,1,1,0,0,1,4,1,1,0,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,4,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,7,0},
	};

	public static int[][] finalMap = {
			{0,3,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,9,0,1,4,1,0,1,4,1,0,4,4,7},
			{0,1,0,1,0,1,0,1,0,1,0,4,0,0},
			{0,1,0,4,0,4,0,4,0,4,0,4,0,2},
			{0,1,0,1,0,1,0,1,0,1,0,4,0,2},
			{0,1,4,1,0,1,4,1,0,1,4,4,0,2},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	};

	public static int[][] endMap = {
			{0,0,0,0,0,0,0},
			{0,2,2,2,2,2,0},
			{0,2,2,2,2,2,0},
			{3,9,2,2,2,5,0},
			{0,2,2,2,2,2,0},
			{0,2,2,2,2,2,0},
			{0,0,0,0,0,0,0}
	};

	// used for locating where to transport player upon switching maps
	public static int[] locate_3(int map[][]){
		for (int x = 0; x < map.length; x++){
			for (int y = 0; y < map[x].length; y++){
				if (map[x][y] == 3){
					return new int[] {y,x};
				}
			}
		}
		return new int[] {99,99};
	}

	public static int[] locate_7(int map[][]){
		for (int x = 0; x < map.length; x++){
			for (int y = 0; y < map[x].length; y++){
				if (map[x][y] == 7){
					return new int[] {y,x};

				}
			}
		}
		return new int[] {99,99};
	}  
	
	
	public void drawMap(Graphics g) {
		int xPos = playerX;			// used for deciding which tiles to load/display (only 7x7 can be shown at any one time)
		int yPos = playerY;
		int colStart = xPos-3;
		int rowStart = yPos-3;
		BufferedImage img = null;

		int lastXID = map[0].length - 1;
		int lastYID = map.length - 1;

		// handling out of bounds rendering (render from edge inwards if needed)
		if (xPos - 3 < 0)						// player is too close to left
			colStart = 0;
		else if (xPos + 3 > lastXID)		// player is too close to right
			colStart = map[0].length-7;
		if (yPos - 3 < 0)						// player is too close to top (yPos = 0)
			rowStart = 0;
		else if (yPos + 3 > lastYID) {			// player is too close to bottom
			rowStart = map.length-7;
		}

		for (int row = rowStart; row < rowStart+7; row++)// number of rows
		{
			for (int col = colStart; col < colStart+7; col++)// length of first row
			{
				String imageName = "";

				if (map [row] [col] == 0) { 	 	// wall
					imageName = "wallPho.png";
				}
				else if (map [row] [col] == 1 || map [row] [col] == 9 || map [row] [col] == 11 || map [row] [col] == 13) { // grass
					imageName = "grassPho.png";
				}

				else if (map [row] [col] == 2) { // coins/treasure box
					imageName = "chestPho.png";
				}

				else if (map [row] [col] == 3) { // go to last map
					g.setColor (Color.cyan);
					g.fillRect ((col-colStart) * 70, (row-rowStart) * 70, 70, 70); 
					continue;
				}

				else if (map [row] [col] == 4) { // zombie
					imageName = "zombPho.png";
				}
				
				else if (map [row] [col] == 5) { // map
					imageName = "shopPho.png";
				}

				else if (map [row] [col] == 7) { // go to next map
					g.setColor (Color.red);
					g.fillRect ((col-colStart) * 70, (row-rowStart) * 70, 70, 70); 
					continue;
				}
				// set buffered image by loading appropriate file set just above
				try {
					img = ImageIO.read(new File(imageName));
				} catch (Exception e) {}
		
				
				g.drawImage(img, (col-colStart) * 70, (row-rowStart) * 70, null);	// draw image
				
				g.setColor(Color.black); // outline each block to form grid
				g.drawRect ((col-colStart) * 70, (row-rowStart) * 70, 70, 70); // draw border
			}
			// load player image lastly
			try {
				img = ImageIO.read(new File("playerPho.png"));
			} catch (Exception e) {}
			g.drawImage(img, (xPos-colStart) * 70, (yPos-rowStart) * 70, null);	// draw image
			
		}
	}

	public void moveRight() {
		try {
			if (map[playerY][playerX+1] == 0) {
				System.out.println(map[playerY][playerX+1]);
				return;
			}
			else
				playerX += 1;
		}
		catch(Exception e) {
		}
	}
	public void moveLeft() {
		try {
			if (map[playerY][playerX-1] == 0)
				return;
			else
				playerX -= 1;
		}
		catch(Exception e) {
		}
	}
	public void moveUp() {
		try {
			if (map[playerY-1][playerX] == 0)
				return;
			else
				playerY -= 1;
		}
		catch(Exception e) {
		}
	}
	public void moveDown() {
		try {
			if (map[playerY+1][playerX] == 0)
				return;
			else
				playerY += 1;
		}
		catch(Exception e) {
		}
	}

}	


