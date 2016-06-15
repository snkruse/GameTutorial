package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

//import our artist class
import static helpers.Artist.*;

public class Boot {
	
	public Boot(){
		// Title in header bar weell well well
		BeginSession();
		
		float width  = 50;
		float height = 50;
		float x = 100;
		float y = 100;
		
		//while display is not requested to be closed 
		while(!Display.isCloseRequested()){
			//begin drawing a line
			glBegin(GL_LINES);
			//2f = two floats
			//vertex starting point
			glVertex2f(10,10);
			//vertex ending point
			glVertex2f(100,100);
			glEnd();
			
			//draw a rectangle
			glBegin(GL_QUADS);
			glVertex2f(x,y);  					//top left corner
			glVertex2f(x + width,y);  			//Top  right corner
			glVertex2f(x + width, y + height); 	//Bottom right corner
			glVertex2f(x,y + height);  		//Bottom left corner
			glEnd();
			
			
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
