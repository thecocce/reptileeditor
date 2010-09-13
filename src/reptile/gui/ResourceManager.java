package reptile.gui;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A singleton class for managing resources.
 * 
 * TODO: Use config to create manager based on user preferences
 * 
 * @author Joe Williamson <huruey@gmail.com> 
 */

public class ResourceManager {
	//Member variables
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
				getClass().getPackage().getName() + "resources.lang", locale);
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
	 */
	public String getImage(String filename) {
		//TODO: do it (using config)
		return null;
	}
	
	/**
	 * Get singleton ResourceManager
	 * @return The ResourceManager singleton
	 */
	public static ResourceManager getResourceManager() {
		return resourceManager;
	}
}
