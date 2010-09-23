package reptile.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import reptile.gui.theme.CustomTheme;
import reptile.gui.widget.CellInspector;
import reptile.gui.widget.EditorStation;
import reptile.gui.widget.HistoryExplorer;
import reptile.gui.widget.LayerManager;
import reptile.gui.widget.MapPalette;
import reptile.gui.widget.MiniMap;
import reptile.gui.widget.ObjectInspector;
import reptile.gui.widget.ProjectExplorer;
import bibliothek.extension.gui.dock.station.split.DockFrontendSizeManager;
import bibliothek.extension.gui.dock.station.split.LbSplitLayoutManager;
import bibliothek.extension.gui.dock.theme.FlatTheme;
import bibliothek.gui.DockFrontend;
import bibliothek.gui.dock.DefaultDockable;
import bibliothek.gui.dock.SplitDockStation;
import bibliothek.gui.dock.station.split.SplitDockGrid;
import bibliothek.gui.dock.station.stack.tab.layouting.TabPlacement;
import bibliothek.gui.dock.themes.BasicTheme;
import bibliothek.gui.dock.themes.NoStackTheme;


/**
 * The main class of the Reptile Map Editor
 * 
 * @author Joe Williamson <huruey@gmail.com>
 * @version 13/09/2010
 */

public class ReptileEditor extends JFrame {
	
	//Instance Variables
	//Toolbars
	private MenuBar menuBar;
	private ToolBar toolBar;
	
	//Dockable Widgets
	private MiniMap miniMap;
	private ProjectExplorer projectExplorer;
	private LayerManager layerManager;
	private CellInspector cellInspector;
	private ObjectInspector objectInspector;
	private MapPalette mapPalette;//Palette for selecting tiles/objects etc
	private HistoryExplorer historyExplorer;
	private EditorStation editorStation;//Independent SplitDockStation widget for editors
	
	//Dockables (Widget Views)
	private DefaultDockable projectExplorerView,
							layerManagerView,
							cellInspectorView,
							objectInspectorView,
							mapPaletteView,
							historyExplorerView,
							editorStationView,
							miniMapView;
	
	//
	
	/**
	 * Constructor for objects of type ReptileEditor
	 */
	public ReptileEditor() {
		
		//Set frame properties
		setTitle("Reptile Map Editor");
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);//Maximise
		setSize(800, 500);
		setMinimumSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setResizable(true);
		
		//Set application icon
		try {
			setIconImage(ResourceManager.get().getImage("icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Set default close operation		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create and set Menu Bar
		menuBar = new MenuBar();		
		setJMenuBar(menuBar);
		
		//Set layout
		getContentPane().setLayout(new BorderLayout());
		
		//Create and add toolbar
		toolBar = new ToolBar();
		add(toolBar, BorderLayout.PAGE_START);
		
		//Create and add status bar
		JToolBar statusBar = new JToolBar();
		statusBar.add(new JLabel("Status Bar"));
		statusBar.add(new JButton("Status Bar"));
		add(statusBar, BorderLayout.PAGE_END);
		
		//Create and add container panel
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 0), 4));
		add(container);
		
		//Create and add docking station
		DockFrontend dockFrontend = new DockFrontend(this);
		SplitDockStation dockStation = new SplitDockStation();
		dockStation.setDividerSize(4);
		DockFrontendSizeManager sizeManager = new DockFrontendSizeManager();
		//TODO: Doesn't do correct resizing?
		sizeManager.setFrontend(dockFrontend);
		dockStation.setSplitLayoutManager(new LbSplitLayoutManager(sizeManager));
		dockFrontend.addRoot("root", dockStation);
		NoStackTheme theme = new NoStackTheme(new CustomTheme());
		dockStation.getController().setTheme(theme);
		dockFrontend.setDefaultHideable(true);
		container.add(dockStation);
		
		//Create widgets and views
		projectExplorer = new ProjectExplorer();
		projectExplorerView = new DefaultDockable(projectExplorer, "Project Explorer");
		layerManager = new LayerManager();
		layerManagerView = new DefaultDockable(layerManager, "Layers");
		miniMap = new MiniMap();
		miniMapView = new DefaultDockable(miniMap, "Mini Map");
		editorStation = new EditorStation();
		editorStationView = new DefaultDockable(editorStation, "Editor");
		mapPalette = new MapPalette();
		mapPaletteView = new DefaultDockable(mapPalette, "Palette");
		objectInspector = new ObjectInspector();
		objectInspectorView = new DefaultDockable(objectInspector, "Object Inspector");
		cellInspector = new CellInspector();
		cellInspectorView = new DefaultDockable(cellInspector, "Cell Inspector");
		historyExplorer = new HistoryExplorer();
		historyExplorerView = new DefaultDockable(historyExplorer, "History");
		
		//Layout widgets and drop to docking station
		SplitDockGrid grid = new SplitDockGrid();
		grid.addDockable(0, 0, 1, 1, projectExplorerView);
		grid.addDockable(0, 1, 1, 1, layerManagerView);
		grid.addVerticalDivider(1, 0, 1);
		grid.addDockable(2, 0, 2, 2, editorStationView);
		grid.addDockable(2, 1, 2, 1, mapPaletteView);
		grid.addVerticalDivider(4, 0, 1);
		grid.addDockable(5, 0, 1, 1, miniMapView);
		grid.addDockable(5, 1, 1, 1, cellInspectorView);
		grid.addDockable(5, 1, 1, 1, objectInspectorView);
		grid.addDockable(5, 2, 1, 1, historyExplorerView);
		dockStation.dropTree(grid.toTree());
		
	}
	
	/**
	 * Main method to instantiate ReptileEditor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Set the look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
		
		ReptileEditor app = new ReptileEditor();
		app.setVisible(true);
	}

}
