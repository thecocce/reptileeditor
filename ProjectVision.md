# Project Vision #

The Reptile Map Editor project has come about due to a lack of quality 2D tile map editors that are flexible, easy to use and free. This document aims to highlight the main issues in existing editors, and provide a vision for the Reptile Map Editor.


---


## Analysis of an Existing Editor ##

[Tiled](http://www.mapeditor.org/) is probably the best existing free map editor.
Its key features include:-
  * Cross-platform
  * Slightly customisable interface (With nice animation in Qt version)
  * XML-based map format with layer compression
  * Support for both orthogonal and isometric maps
  * Custom objects may be placed with pixel precision
  * Action history support (undo/redo)
  * Copy/paste support
  * Add custom properties to tiles, layers, objects and the map
  * Maps may be resized and offset
  * Tile editing tools include brushes, fill tool and stamp tool
  * Supports plug-ins for other map formats
  * Layer opacity can be changed

The following are some limitations of Tiled:-
  * Despite the functionality being available by other means, there is no move tool
  * Offset is unnecessary if entire map/layer can be moved, and requires additional programming by games/plug-ins to use
  * No support for animated tiles`*`
  * Tileset management is difficult especially if tiles are moved about in the image file
  * No way of saving custom brushes
  * No way of defining object types (every object must have all its properties set individually)
  * Lack of "snap-in" feature for objects
  * No way of managing reusable brushes, tilesets, objects and maps under a single project`*`
  * It can be difficult to move things from layer to layer
  * UI for managing layers could be a lot better
  * Cannot have multiple files open at the same time
  * It is difficult to see all the things in a single cell
  * It can be difficult to navigate the map when editing

`*` These are features that were planned in the Java version, and may potentially be implemented in the Qt version later.

Tiled is open source under GPL, and the now discontinued Java version is still available to download. Because of this, it might seem reasonable to resurrect Tiled and implement the features it lacked. However, there are several reasons why designing an editor from scratch would be beneficial:-
  * Some of the source is not well documented or commented making it tricky to maintain
  * Existing program structure makes the desired model for projects difficult to implement
  * User interface needs a dramatic makeover
  * Existing concepts might clash with concepts required for projects and reusable components

However, some tiled code may still be useful in places, so at times it may be reasonable to reuse tiled code. If this ever becomes the case, please keep a record so credit can be given.


---


## General Requirements ##

Taking into consideration existing benefits and problems, the following general requirements have been drawn for the system.

  * The editor must be cross-platform
  * Reusable components should be managed under projects
  * The user interface should be highly customizable, allowing for the editing of multiple files at the same time with a customisable layout of said files
  * Projects and maps should be saved in an XML format with optional compression where appropriate
  * The editor must support for orthogonal maps, with the ability to extend to support other types of map
  * A feature must be provided to create and manage tilsets, also giving the ability to add custom properties to tiles
  * t must be easy to manage changes made to the tileset image such that the layout can be reformatted without breaking the tileset
  * It must be possible to define custom object types with properties, which can then be instantiated on a map with pixel precision or snapped into cell coordinates
  * It must be easy to view a history of actions and undo/ redo actions as required
  * It must be easy to copy and paste parts of a map, brush or tileset
  * Map properties should be editable, and properties should include map name, size, type and cell size
  * The following tools must be included for editing maps and custom brushes:-
    * Select area/select all
    * Copy
    * Paste
    * Move selection
    * Transform selection (Rotate/flip etc.)
    * Draw from tileset/Draw from brush
    * Delete
    * Add object
  * Custom brushes should be editable in the same way as a map
  * It should be easy to swap layer, change layer visibility (opacity) and layer properties, as well as being able to easily see the contents of all layers at a specific map location and change the layer of tiles
  * It should be possible to define and add animated tiles, and also preview the tile animation while editing a map
  * A mini map should be provided to aid map navigation

---


## Core Concepts ##

  1. Project
  1. Tileset
  1. Map
  1. Brush
  1. Object Type
  1. Object (Game Object)
  1. Layer
    1. Tile Layer
    1. Object Layer




