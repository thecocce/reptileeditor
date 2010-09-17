package reptile.core.gameobject;


/**
 * A GameObject is an instance of a user-defined {@link ObjectType}
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class GameObject {
	
	private ObjectType type;
	
	public GameObject(ObjectType type) {
		this.type = type;
	}
	
}
