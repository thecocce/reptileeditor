package reptile.gui;

import java.awt.Image;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * A singleton class for managing resources.
 * 
 * TODO: Use config to create manager based on user preferences
 * 
 * @author Joe Williamson <huruey@gmail.com> 
 */

public class ResourceManager {
	//Instance Variables
	private ResourceBundle resourceBundle;
	
	//Instantiate singleton
	private static final ResourceManager resourceManager = new ResourceManager();
	
	/**
	 * Constructor for objects of type ResourceManager
	 */
	private ResourceManager() {
		setLocale(new Locale("en", "GB"));
	}
	
	/**
	 * Set the current locale
	 * @param locale The new locale for the ResourceBundle to use
	 */
	public void setLocale(Locale locale) {
		//TODO: get baseName from config
		resourceBundle = ResourceBundle.getBundle(
				getClass().getPackage().getName() + ".resources.lang", locale);
	}
	
	/**
	 * Get a string in the current locale from the ResourceBundle
	 * @param key The property key of the string
	 * @return The string in the current locale
	 */
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	/**
	 * Get an image from the resources directory
	 * @param filename The filename of the image
	 * @return The image loaded from the file
	 * @throws IOException 
	 */
	public Image getImage(String filename) throws IOException {
		//TODO: do it (using config)
		return ImageIO.read(
				getClass().getResourceAsStream("resources/" + filename));
	}
	
	/**
	 * Get an icon from the icon directory as an ImageIcon
	 * @param filename The filename of the icon in the icon directory
	 * @return The icon requested
	 * @throws IOException
	 */
	public Icon getIcon(String filename) {
		//TODO: path from config
		String filePath = "icons/" + filename;
		try {
			return new ImageIcon(getImage(filePath));
		} catch (IOException e) {
			System.out.println("Failed to load icon: " + filePath);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get singleton ResourceManager
	 * @return The ResourceManager singleton
	 */
	public static synchronized ResourceManager getResourceManager() {
		return resourceManager;
	}
	
	/**
	 * Synonym for getResourceManagere
	 * Get singleton ResourceManager
	 * @return The ResourceManager singleton
	 */
	public static synchronized ResourceManager get() {
		return getResourceManager();
	}
	
	/**
	 * Override clone method to prevent cloning and throw
	 * CloneNotSupportedException
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
