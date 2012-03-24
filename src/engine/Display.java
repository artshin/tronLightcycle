package engine;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import tron_lightcycle_game.TronLightCycle;
/** 
 * Display class is used for launching game and
 * setting the screen height.
 * Due to the lack of time, screen is set to 800x600
 *
 * 
 * @author Artur Shinkevich
 *
 */

public class Display {
	
	private int display_height;
	private int display_width;
	private static AppGameContainer app;
	
	
	public Display(int x,int y){
		
		display_height = x;
		display_width = y;
		
		try {
        	app = new AppGameContainer(new TronLightCycle());
			app.setDisplayMode(display_height, display_width, false);
			app.setVSync(true);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	    
	}
	
	public void start(){
		
		try {
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void set_fullscreen(boolean dsp){
		try {
			app.setFullscreen(dsp);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
}