package helpers;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

// what we want to do in the game and what we want to do with the GL
public class Artist {
	
	
	public static final int WIDTH = 1280, HEIGHT = 9960;

	
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
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		//ModelView is the matrix that represents your camera (position, pointing, and up vector).
		glMatrixMode(GL_MODELVIEW);
		//Draw our textures
		//glEnable(GL_Texture_2D);

		
	}
	
	public static void DrawQuad(float x, float y, float width, float height)
	{
		//draw a rectangle
		glBegin(GL_QUADS);
		glVertex2f(x,y);  					//top left corner
		glVertex2f(x + width,y);  			//Top  right corner
		glVertex2f(x + width, y + height); 	//Bottom right corner
		glVertex2f(x,y + height);  		//Bottom left corner
		glEnd();
	}
	
	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height){
		tex.bind();
		glTranslatef(x,y,0);
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0,0);
		glTexCoord2f(1,0);
		glVertex2f(width,0);
		glTexCoord2f(1,1);
		glVertex2f(width,height);
		glTexCoord2f(0,1);
		glVertex2f(0,height);
		glLoadIdentity();
		glEnd();
	}
	
	


	
}
