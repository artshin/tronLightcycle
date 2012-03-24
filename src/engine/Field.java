package engine;

import org.newdawn.slick.Color;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;


/** 
 * Field class inherits everything from Entity class
 * It stores text as UnicodeFont and gets a custom
 * font from Font getter. Very usefull.
 * 
 * <p>
 * Most of the methods control where and how text is 
 * displayed.
 * 
 * @author Artur Shinkevich
 *
 */
public class Field extends Entity{
	
	protected UnicodeFont font;
	protected String text = "Start Game";
	protected float text_center_x;
	protected float text_center_y;
	protected int text_width;
	protected int text_height;
	protected Color color = Color.white;
	
	public Field(String field_text){
		super();
		text = field_text;
        
		try{
			font = new UnicodeFont(Font_Getter.tron_font(12));
			font.addAsciiGlyphs(); 
	        font.getEffects().add(new ColorEffect(java.awt.Color.WHITE)); 
	        font.loadGlyphs();
	        text_width = font.getWidth(text);
			text_height = font.getHeight(text);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	protected void check_size(){
		
		if(image_width <= text_width)
			image = image.getScaledCopy(text_width+20, image.getHeight());
		if(image_width <= text_height)
			image = image.getScaledCopy(image_width, text_height+20);
		super.reset_image_properties();
	}
	
	protected void set_centers(){
		text_center_x = super.pos_x+(image_width - text_width)/2;
		text_center_y = super.pos_y+(image_height - text_height)/2;		
	}
	
	public void draw(){
		super.draw();
		font.drawString(text_center_x,text_center_y,text, color);
	}
	
	public void change_font_color(Color new_color){
		color = new_color;
	}
	
	public void set_image_to_font(){
		super.set_image_size(text_width+30,text_height+30);
		set_centers();
	}
}