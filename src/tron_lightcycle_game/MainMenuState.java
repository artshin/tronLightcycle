package tron_lightcycle_game;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Input;
import org.newdawn.slick.Color;
import engine.*;

/**
 * MainMenu class is responsible for menu in the game
 * It creates buttons, background and updates everything 
 * depending on mouse input as well as some keys
 *
                          
 * 
 * <p>
 * Methods described here are the same as in 
 * GameplayState
 
 *@author Artur Shinkevich
 */

public class MainMenuState extends BasicGameState {
 
    int stateID = -1;
 
    Button music_switcher;
    Button start_game_button;
    Button exit_button;
    Button fullscreen_button;
    
    Screen background;
    
    Music fx;
    
    float startGameScale = 1;
    float buttonScale = 1;
    
    float scaleStep = 0.0001f;
   
    
    MainMenuState( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
 
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    	
    	fx = new Music("data/main_menu.wav");
    	
    	background = new Screen("data/img/menu.jpg",800,600);
    	//x pos is 68%, y pos starts at 12,5%
    	start_game_button = new Button("Start Game","Blue",550,100);
    	fullscreen_button = new Button("Fullscreen","Blue",550,200);
		music_switcher = new Button("Music On/Off", "Blue",580,300);
			music_switcher.set_image_to_font();	
    	exit_button = new Button("Exit","Orange",550,400);
    	fx.play();
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics gcc) throws SlickException {
    	background.draw();
    	start_game_button.draw();
    	fullscreen_button.draw();
    	music_switcher.draw();
    	exit_button.draw();
    	
    }
 
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
    	Input input = gc.getInput();
 
    	if(start_game_button.mouse_on_button(input.getMouseX(), input.getAbsoluteMouseY())){
    		start_game_button.change_font_color(new Color(Color.gray));
    		if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
    			sb.enterState(TronLightCycle.GAMEPLAYSTATE);
    			fx.stop();
    		}
    	}
    	else start_game_button.change_font_color(new Color(Color.white));
    	
    	if(exit_button.mouse_on_button(input.getMouseX(), input.getAbsoluteMouseY())){
    		exit_button.change_font_color(new Color(Color.orange));
    		if ( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) )
    			gc.exit(); 
    	}
    	else exit_button.change_font_color(new Color(Color.white));
    	
    	if(fullscreen_button.mouse_on_button(input.getMouseX(), input.getAbsoluteMouseY())){
    		fullscreen_button.change_font_color(new Color(Color.gray));
    		if ( input.isMousePressed(Input.MOUSE_LEFT_BUTTON) ){
    			Display.set_fullscreen(true); 
    			fullscreen_button.change_text("Window");
    			flush_input(input);
    		}
    		else{
    			Display.set_fullscreen(false);
    			fullscreen_button.change_text("Fullscreen");
    			flush_input(input);
    		}
    	}
    	else fullscreen_button.change_font_color(new Color(Color.white));
    	
    	if( music_switcher.mouse_on_button(input.getMouseX(), input.getAbsoluteMouseY()) ){
    		music_switcher.change_font_color(new Color(Color.gray));
    		if( input.isMousePressed(Input.MOUSE_LEFT_BUTTON) )
    			switch_music();
    	}
    	else music_switcher.change_font_color(new Color(Color.white));
    		
    	
    	if( input.isKeyPressed(Input.KEY_F11)){
    		switch_music();
    	}
    	
    		
    	
    }
    
    private void switch_music(){
    	if(fx.playing())
    		fx.stop();
    	else{
    		fx.play();
    		fx.setVolume(0.5f);
    	}
    	
    }
    
    private void flush_input(Input a){
    	a.clearKeyPressedRecord();
		a.clearControlPressedRecord();
		a.clearMousePressedRecord();
    	
    }
    	
    	
    }
 
