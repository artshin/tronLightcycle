package engine;

/**
 * Screen class is actually just a 
 * background picture. Nothing fancy here,
 * just image properties.
 *
                          
 * 
 * <p>
 * This class stores image and its' properties and location
 * 
 * All of the methods used here are mostly for resizing or
 * setting image properties. Draw method is obvious.
 
 *@author Artur Shinkevich
 */


public class Screen extends Entity{
	
	public Screen(String file_path,int x,int y){
		super(file_path,0,0);
		
		set_image_size(x,y);
	}
	
	public Screen(String file_path,int x,int y, int p_x, int p_y){
		this(file_path,x,y);
		pos_x = p_x;
		pos_y = p_y;
	}
	
	public void draw(){
		super.draw();
	}
	
}