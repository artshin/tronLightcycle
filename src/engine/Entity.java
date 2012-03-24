package engine;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Entity class is a basic class for other engine classes
 *
                          
 * 
 * <p>
 * This class stores image and its' properties and location
 * 
 * All of the methods used here are mostly for resizing or
 * setting image properties. Draw method is obvious.
 
 *@author Artur Shinkevich
 */


public class Entity {
	protected Image image;
	protected int image_width;
	protected int image_height;
	protected float pos_x;
	protected float pos_y;
	
	protected Entity(){};
	
	protected Entity(String file_path,float x, float y){
		try{
			set_image(file_path,x,y);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void draw(){
		image.draw(pos_x, pos_y);
	}
	
	
	protected void reset_image_properties(){
		image_width = image.getWidth();
		image_height = image.getHeight();
	}
	
	protected void set_image(String file_path,float x, float y){
		try {
			image = new Image(file_path);
			pos_x = x;
			pos_y = y;
			image_width = image.getWidth();
			image_height = image.getHeight();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void set_image_size(int x, int y){
		image = image.getScaledCopy(x,y);
		reset_image_properties();
	}
	
}