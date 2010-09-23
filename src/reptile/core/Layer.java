package reptile.core;

import java.awt.Dimension;
import java.util.Properties;

/**
 * A layer of a {@link Map}.
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public abstract class Layer implements Cloneable {
	
	//Instance Variables
	protected String name;
	protected double opacity;
	protected boolean isVisible,
					  isLocked;
	protected Properties properties;
	
	/**
	 * Constructor for objects of type Layer
	 */
	public Layer() {
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return True if this layer is visible, false otherwise
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible Whether or not this layer should be visible
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	/**
	 * @return True is this layer is locked, false otherwise
	 */
	public boolean isLocked() {
		return isLocked;
	}

	/**
	 * @param isLocked Whether or not this layer should be locked
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	/**
	 * @return The properties of this layer
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties The properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * @return The opacity of this layer
	 */
	public double getOpacity() {
		return opacity;
	}

	/**
	 * @param opacity The opacity to set
	 */
	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}
	
	/**
	 * Determine if this layer is editable or not
	 * @return True if this layer is editable, false otherwise
	 */
	public boolean isEditable() {
		return !isLocked() && isVisible();
	}
	
	
	public abstract void mergeOnto(Layer layer);
	
	
}
