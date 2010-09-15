package reptile.core;

import reptile.core.gameobject.ObjectType;

/**
 * Projects are responsible for the management of related maps, tilesets, object
 * types and brushed such that they may be reusable throughout the project.
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class Project {

	//Instance Variables
	private String name;
	private Vector<Map> maps;
	private Vector<ObjectType> objectTypes;
	private Vector<TileSet> tileSets;
	private Vector<Brush> brushes;
	
	/**
	 * Constructor for objects of type Project
	 */
	public Project() {
		
	}
	
}
