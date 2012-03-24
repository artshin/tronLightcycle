
package engine; 

import java.awt.Font;
import java.io.FileInputStream;

/**
 * Entity class is a basic class for other engine classes
 *
                          
 * 
 * <p>
 * This class provides functionality to get
 * custom font
 * 
 *
 *@author Artur Shinkevich
 */

public class Font_Getter {
	
	private static Font tron_font = null;
	static FileInputStream font_file = null;
	
	
	public static Font tron_font(int size){
		 Font temp;
		 
		 try {
			 font_file = new FileInputStream("data/tron.ttf");
			 temp = Font.createFont(Font.TRUETYPE_FONT, font_file);
			 
			 if (size < 14) 
				 tron_font = temp.deriveFont(Font.PLAIN, size);
			 else 
				 tron_font = temp.deriveFont(Font.BOLD, size);
		 } 
		 catch (Exception e) {
			 e.printStackTrace();
			 if (size < 14) 
				 tron_font = new Font("Arial", Font.PLAIN, size);
			 else 
				 tron_font = new Font("Arial", Font.BOLD, size);
		 }
		  return tron_font.deriveFont(12f);
	}
}