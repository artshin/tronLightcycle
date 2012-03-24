package engine;


import java.util.ArrayList;
import java.util.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Wall class is used by a player
 * to draw a wall on the screen that will 
 * follow players path
                          
 * 
 * <p>
 * This class contains ArrayLists to store Image for a wall,
 * its' x cords and y cords.
 * 
 * Constructor gets the image path and holds image in 
 * a variable. 
 * add_wall_piece adds a image to arraylist,
 * as well as adds new cords for this image
 * draw method draw each piece in ArrayList on the screen
 * collides method checks if player hits the wall or not
 
 *Coded by Artur Shinkevich
 */

class Wall{
	private ArrayList<Image> wall;
	private ArrayList<Float> x_cord;
	private ArrayList<Float> y_cord;
	private Image wall_pic;
	
	public Wall(){
		try {
			wall_pic = new Image("data/img/orange_wall.png");
			wall = new ArrayList<Image>();
			x_cord = new ArrayList<Float>();
			y_cord = new ArrayList<Float>();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void add_wall_piece(float x,float y){
		wall.add(wall_pic);
		x_cord.add(x);
		y_cord.add(y);
	}
	
	public void draw(){
		for(int i = 0; i < wall.size(); i++)
			wall.get(i).draw(x_cord.get(i),y_cord.get(i));
	}
	
	public boolean collides(float player_pos_x,float player_pos_y){
		boolean bam = false;
		
		for(int i = 0; i < x_cord.size()-10; i++)
			if(player_pos_x == x_cord.get(i) && player_pos_y == y_cord.get(i))
				bam = true;
		
		return bam;
	}
}