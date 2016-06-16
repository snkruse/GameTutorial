package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

//import our artist class
import static helpers.Artist.*;

public class Boot {
	
	public Boot(){
		// Title in header bar
		BeginSession();
		
		int[][] map= {
				{0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,2,2,2,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0},
				{0,2,2,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,0},
				{0,2,2,2,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		};
		
		
		TileGrid grid = new TileGrid(map);
		grid.SetTile(3, 3, grid.getTile(2, 3).getType());
		
		
		
		//while display is not requested to be closed 
		while(!Display.isCloseRequested()){

			grid.Draw();
			
			Display.update();
			Display.sync(60);
		}
		// Destroy display (end game)
		Display.destroy();
	}
	
	//entry point
	public static void main(String[] args){
		new Boot();
	}
}
