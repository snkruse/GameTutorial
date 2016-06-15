package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

//import our artist class
import static helpers.Artist.*;

public class Boot {
	
	public Boot(){
		// Title in header bar
		BeginSession();
		
		//while display is not requested to be closed 
		while(!Display.isCloseRequested()){
			
			DrawQuad(50,50,100,100);

			DrawQuad(150,150,100,100);
			
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
