package engine;

import org.newdawn.slick.Color;


/**
 * GameplayState class extends BasicGameState
 * and is used for the actual game process 
                          
 * 
 * <p>
 * This class contains buttons, background image and
 * main player
 * 
 * init, render, enter and update methods are standard
 * methods of slick library to update screen and initialize
 * variables
 
 *Coded by Artur Shinkevich
 */


public class Player extends Entity{
	private boolean dead = false;
	private boolean derezzing = false;
	private String direction="north";
	private Color color;
	private float alpha = 1.0f;
	private Wall wall;
	/*private boolean close_to_Yborder(){
		boolean close = false;
		if( //pos_y + 6f == 800f ||
		    pos_y - 6f == 25)
			close = true;
		
		return close;		
	}
	
	private boolean close_to_Xborder(){
		boolean close = false;
		
		return close;		
	}*/
	
	public Player(String file_path){
		super(file_path,400,560);
		color = new Color(1f,1f,1f,alpha);
		wall = new Wall();
	}
	
	public void draw(){
		if(derezzing == false){
			wall.draw();
			image.drawCentered(pos_x, pos_y);
			
		}
		else{
			image.drawCentered(pos_x, pos_y);
			wall.draw();
			alpha -= 0.01f;
			color = new Color(1f,1f,1f,alpha);
			if(alpha == 0f)
				dead = true;
		}
	}
	
	public void player_move(){
		
		if(wall.collides(pos_x, pos_y))
			derezzing = true;
		
		if(!derezzing){
			if(direction == "north" && pos_y - 2f >= 70f)
				pos_y -= 10f;
			else if(pos_y == 70f)
				derezzing = true;
			
			if(direction == "south" && pos_y + 2f <= 580f)
				pos_y += 10f;
			else if(pos_y  == 580f)
				derezzing = true;
			
			if(direction == "west" && pos_x - 2f >= 20f)
				pos_x -= 10f;
			else if(pos_x  == 20f)
				derezzing = true;
			
			if(direction == "east" && pos_x + 2f <= 780f)
				pos_x += 10f;
			else if(pos_x == 780f)
				derezzing = true;
			
			
			
			if(!derezzing){
					wall.add_wall_piece(pos_x-2, pos_y);
			}
				
			
		}		
	}
	
	public void change_direction(String new_direction){
		if(direction != new_direction && !derezzing){
			
			if(direction == "west" &&
			   new_direction != "east"){
				direction = new_direction;
				if(direction == "north")
					image.rotate(90);
				if(direction == "south")
					image.rotate(-90);
			}
			
			if(direction == "north" && 
			   new_direction != "south"){
				direction = new_direction;
				if(direction == "west")
					image.rotate(-90);
				if(direction == "east")
					image.rotate(90);
			}
			
			if(direction == "east" &&
			   new_direction != "west"){
				direction = new_direction;
				if(direction == "north")
					image.rotate(-90);
				if(direction == "south")
					image.rotate(90);
			}
			
			if(direction == "south" && 
				new_direction != "north"){
				direction = new_direction;
				if(direction == "west")
					image.rotate(90);
				if(direction == "east")
					image.rotate(-90);
			}
		}
	}
	
	public boolean isDead(){
		return dead;
	}
	
	//public String test(){
	//	return "X: " + pos_x + " Y: " + pos_y + wall.test();
	//}
	
}