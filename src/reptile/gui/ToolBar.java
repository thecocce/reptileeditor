package reptile.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import reptile.gui.widget.DropDownMenu;

public class ToolBar extends JToolBar {
	
	//Instance Variables
	private DropDownMenu newFileDropDown;
	private JButton openButton,
					saveButton,
					saveAllButton;
	private JToggleButton selectToggle,
						  moveToggle,
						  drawToggle,
						  eraserToggle,
						  objectToggle;
	
	public ToolBar() {
		ResourceManager res = ResourceManager.get();
		
		newFileDropDown = new DropDownMenu(new NewFileMenu().getPopupMenu());
		newFileDropDown.setIcon(res.getIcon("application_add.png"));
		newFileDropDown.setToolTipText("New");
		openButton = new JButton(res.getIcon("folder.png"));
		openButton.setToolTipText("Open Project");
		saveButton = new JButton(res.getIcon("disk.png"));
		saveButton.setToolTipText("Save");
		saveAllButton = new JButton(res.getIcon("disk_multiple.png"));
		saveAllButton.setToolTipText("Save All");
		
		add(newFileDropDown);
		add(openButton);
		add(saveButton);
		add(saveAllButton);
		addSeparator();
		
		ButtonGroup tools = new ButtonGroup();
		selectToggle = new JToggleButton(res.getIcon("selection.png"));
		selectToggle.setToolTipText("Select");
		tools.add(selectToggle);
		moveToggle = new JToggleButton(res.getIcon("arrow-move.png"));//TODO: Better icon
		moveToggle.setToolTipText("Move");
		tools.add(moveToggle);
		drawToggle = new JToggleButton(res.getIcon("pencil.png"));
		drawToggle.setToolTipText("Draw");
		tools.add(drawToggle);
		eraserToggle = new JToggleButton(res.getIcon("eraser.png"));
		eraserToggle.setToolTipText("Eraser");
		tools.add(eraserToggle);
		objectToggle = new JToggleButton(res.getIcon("brick.png"));//TODO: blue icon
		objectToggle.setToolTipText("Object Tool");
		tools.add(objectToggle);
		
		add(selectToggle);
		add(moveToggle);
		add(drawToggle);
		add(eraserToggle);
		add(objectToggle);
	}
	
}
