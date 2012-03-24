package tron_lightcycle_game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import engine.Button;
import engine.Player;
import engine.Screen;
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

 
public class GameplayState extends BasicGameState {
 
    int stateID = -1;
    private enum STATES {
        GAME_ON_STATE, PAUSE_GAME_STATE, GAME_OVER_STATE
    }
    private STATES currentState = null;
    
    Screen background;
    private Player main_player;
    private Button exit_field;
    private Button pause_field;
    private Button music_field;
    private Music bg_theme;
    
    GameplayState( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
 
    
    @Override
    public void enter(GameContainer gc, StateBasedGame sb) throws SlickException
    {
        super.enter(gc, sb);
        currentState = STATES.GAME_ON_STATE;
        bg_theme.play();
    }
    
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    	background = new Screen("data/img/grid.png",800,600,0,50);
    	main_player = new Player("data/img/blue_lightcycle.png");
    	exit_field = new Button("ESC - main menu","blue",0,0);
    	exit_field.set_image_to_font();
    	pause_field = new Button("P - Pause game","blue",240,0);
    	pause_field.set_image_to_font();
    	music_field = new Button("F11 - switch music","blue",480,0);
    	music_field.set_image_to_font();
    	bg_theme = new Music("data/bg_theme.wav");
    	
 
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gcc) throws SlickException {
    	background.draw();
    	exit_field.draw();
    	pause_field.draw();
    	music_field.draw();
    	main_player.draw();
    	
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
    	Input input = gc.getInput();
    	
    	switch(currentState){
	    	case GAME_ON_STATE:
	    		
	    		if(!main_player.isDead()){
		    		if(input.isKeyPressed(input.KEY_A))
			    		main_player.change_direction("west");
			    	else if(input.isKeyPressed(input.KEY_D))
			    		main_player.change_direction("east");
			    	else if(input.isKeyPressed(input.KEY_W))
			    		main_player.change_direction("north");
			    	else if(input.isKeyPressed(input.KEY_S))
			    		main_player.change_direction("south");
			    	else if(input.isKeyPressed(input.KEY_P)){
			    			currentState = STATES.PAUSE_GAME_STATE;
			    	}
			    	
		    		if(input.isKeyPressed(input.KEY_ESCAPE)){
			    		currentState = STATES.GAME_OVER_STATE;
		    		}
		    		if(input.isKeyPressed(input.KEY_F11)){
		    			if(bg_theme.playing())
		    				bg_theme.stop();
		    			else
		    				bg_theme.play();
		    		}
		    			
			    	main_player.player_move();
			    }
	    		else
	    			currentState = STATES.GAME_OVER_STATE;
		    		
		    	break;
	    	case GAME_OVER_STATE:
	    		bg_theme.stop();
	    		sbg.enterState(TronLightCycle.MAINMENUSTATE);
	    		main_player = null;
	    		this.init(gc, sbg);
	    		break;
	    	case PAUSE_GAME_STATE:
	    		if(gc.isPaused() && input.isKeyPressed(input.KEY_P))
	    			currentState = STATES.GAME_ON_STATE;
	    		else
		    		gc.pause();
	    		input.clearKeyPressedRecord();
	    		break;
    	}
    	
    	
    }
 
}