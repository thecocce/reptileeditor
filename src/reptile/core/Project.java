package reptile.core;

import java.util.Vector;

import reptile.core.gameobject.ObjectType;

/**
 * Projects are responsible for the management of related maps, tilesets, object
 * types and brushed such that they may be reusable throughout the project.
 * 
 * At the root level of a project, there are four folders:-
 * <ul>
 * 	<li>Maps - Contains maps</li>
 * 	<li>Tilesets - Contains tilesets</li>
 * 	<li>Objects - Contains object type libraries, which in turn contain object types</li>
 * 	<li>Brushes - Contains brush libraries, which in turn contain brushes</li>
 * </ul>
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class Project {

	//Instance Variables
	private String name;
	private Vector<Map> maps;
	private Vector<TileSet> tileSets;
	private Vector<ObjectLibrary> objectLibraries;
	private Vector<BrushLibrary> brushLibraries;
	
	/**
	 * Constructor for objects of type Project
	 */
	public Project() {
		
	}
	
}
