package tron_lightcycle_game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import engine.Display;

/**
 * TronLightCycle class is a main class 
 * that gets invoked when program is launched
 * and it calls all other classes
 *
                          
 * 
 * <p>
 * The library I was using is called Slick. 
 * It is licensed under BSD License. No stealing. No cheating.
 
 *@author Artur Shinkevich
 */

public class TronLightCycle extends StateBasedGame 
{
 
    public static final int MAINMENUSTATE          = 0;
    public static final int GAMEPLAYSTATE          = 1;
    
    public TronLightCycle()
    {
    	super("TronLightCycle");
 
        this.addState(new MainMenuState(MAINMENUSTATE));
        this.addState(new GameplayState(GAMEPLAYSTATE));
        this.enterState(MAINMENUSTATE);
    }
 
    public static void main(String[] args) throws SlickException
    {
         Display game = new Display(800,600);
         game.start();
    }
 
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
 
        this.getState(MAINMENUSTATE).init(gameContainer, this);
        this.getState(GAMEPLAYSTATE).init(gameContainer, this);
    }
}