package reptile.core.gameobject;

import java.util.LinkedList;

/**
 * An ObjectType is a user define game object type that may have instances
 * created on a map. It allows the user to define a set of properties, their
 * types, default values and validation conditions.3
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class ObjectType {
	
	private String name;
	private LinkedList<ObjectPropertyDefinition> propertyDefs;
	
	public ObjectType() {
		
	}
	
	/**
	 * Create an {@link GameObject} instance of this object type
	 * @return A {@link GameObject} representing an instance of this ObjectType
	 */
	public GameObject getInstance() {
		return new GameObject(this);
	}
	
}
