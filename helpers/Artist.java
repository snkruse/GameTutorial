package helpers;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

// what we want to do in the game and what we want to do with the GL
public class Artist {
	
	
	public static final int WIDTH = 600, HEIGHT = 400;
	
	public static void BeginSession(){
		Display.setTitle("FirstGame");
		try {
			Display.setDisplayMode(new DisplayMode(600,400));
			//create screen
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		//ProjectionView is the matrix that represents your camera's lens (aperture, far-field, near-field, etc).
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		//set up our camera
		glOrtho(0, 600, 400, 0, 1, -1);
		//ModelView is the matrix that represents your camera (position, pointing, and up vector).
		glMatrixMode(GL_MODELVIEW);
	}
	
}
