package engine;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

/**
 * ImageManager class is used for storing 
 * multiple manages in one place.
 *
                          
 * 
 * <p>
 * Most of the methods are used for handling images
 *
 *@author Artur Shinkevich
 */

import java.util.*;

public class ImageManager {
	
	private static final ImageManager instance = new ImageManager();
	private Map<String,Texture> images;
	
	public ImageManager(){
		images = new HashMap<String,Texture>();
	}
	
	public static ImageManager getInstance(){
		return instance;
	}
	
	public void load(String name,String file) {
		try {
			Image image = new Image(file);
			images.put(name,image.getTexture());
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void erase(String file) {
		images.put(file, null);
	}
	
	public void clear() {
		images.clear();
	}
	
	public Image get(String file_path) {
		return new Image(images.get(file_path));
	}
	
	
}