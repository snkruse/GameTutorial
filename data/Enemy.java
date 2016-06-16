package data;

import static helpers.Artist.DrawQuadTex;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import static helpers.Clock.*;

public class Enemy {
	private int width,height, health;
	private float speed, x, y;
	private Texture texture;
	private Tile startTile;
	private TileGrid grid;	
	private boolean first = true;
	
	private ArrayList<Checkpoint> checkpoints;
	private int[] directions;
	
	
	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed){
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.grid = grid;
		
		this.checkpoints = new ArrayList<Checkpoint>();
		this.directions = new int[2];
		// X direction
		this.directions[0] = 0;
		// Y direction
		this.directions[1] = 0;
		directions = FindNextD(startTile);
	}
	
	
	public void Update(){
		if(first)
			first = false;
		else{
			x += Delta() * directions[0];
			y += Delta() * directions[1];
			
		}
	}
	
	private Checkpoint FindNextC(Tile s, int[] dir){
		Tile next = null;
		Checkpoint c = null;
		
		// Boolean to decide if next checkpoint is found
		boolean found = false;
		// Intger to increment each loop
		int counter = 1;
		
		while(!found){
			if(s.getType() != grid.getTile(s.getXPlace() + dir[0] * counter, 
					s.getYPlace() + dir[1] * counter).getType()){
				found = true;
				//  move counter back to 1 to find before new tiletype 
				counter -= 1;
				next = grid.getTile(s.getXPlace() + dir[0] * counter, 
						s.getYPlace() + dir[1] * counter);
			}
				
			counter++;
		}
		
		c = new Checkpoint(next, dir[0], dir[1]);
		return c;
	}
	
	private int[] FindNextD(Tile s){
		int[] dir = new int[2];
		Tile u = grid.getTile(s.getXPlace(), s.getYPlace()-1);
		Tile r = grid.getTile(s.getXPlace() + 1 , s.getYPlace());
		Tile d = grid.getTile(s.getXPlace() , s.getYPlace() +1);
		Tile l = grid.getTile(s.getXPlace() - 1, s.getYPlace());
		
		if(s.getType() == u.getType()){
			dir[0] = 0;
			dir[1] = -1;
		}
		else if(s.getType() == r.getType())
		{
			dir[0] = 1;
			dir[1] = 0;
		}
		else if(s.getType() == d.getType())
		{
			dir[0] = 0;
			dir[1] = 1;
		}
		else if(s.getType() == l.getType())
		{
			dir[0] = -1;
			dir[1] = 0;
		}else{
			System.out.println("NO DIRECTION FOUND");
		}
		
		return dir;
	}
	
	/*
	private boolean pathContinues(){
		boolean answer = true;
		// tile our enemy is currently on
		Tile myTile = grid.getTile((int)(x / 64), (int) (y /64));
		Tile nextTile = grid.getTile((int)(x / 64) + 1, (int) (y /64));
		if(myTile.getType() != nextTile.getType())
			answer = false;
		return answer;
	}
	*/
	
	public void Draw(){
		DrawQuadTex(texture, x, y, width, height);	
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public TileGrid getTileGrid(){
		return grid;
	}
	
	
}
