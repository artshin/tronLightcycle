package engine;

/** 
 * Button class inherits everything from field class
 * and provides some functionality for pressing 
 * the button. 
 *
 * 
 * @author Artur Shinkevich
 *
 */

public class Button extends Field{
	
	public Button(String button_text, String background,float x, float y){
		super(button_text);
		
		try{
			if(background == "Orange")
				super.set_image("data/img/orange_button.png",x,y);
			else 
				super.set_image("data/img/blue_button.png",x,y);
			check_size();
			set_centers();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public void draw(){
		super.draw();
	}
	
	public boolean mouse_on_button(int mouse_x, int mouse_y){
		boolean result = false;
    	
    	if( (mouse_x >= super.pos_x && mouse_x <= super.pos_x + image_width) &&
    	    (mouse_y >= super.pos_y && mouse_y <= super.pos_y + image_height) )
    	    result = true;
    	
    	return result;
	}
	
	public void change_text(String new_text){
		text = new_text;
	}
}
