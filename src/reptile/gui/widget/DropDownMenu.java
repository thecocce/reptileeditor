package reptile.gui.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import reptile.gui.ResourceManager;

/**
 * A drop-down menu activated by a button with a down arrow
 * 
 * @author Joe Williamson <huruey@gmail.com>
 */

public class DropDownMenu extends JButton implements ActionListener {
	
	//Instance Variables
	private JPopupMenu popupMenu;
	
	/**
	 * Constructor for objects of type DropDownMenu
	 * 
	 * @param popupMenu The JPopupMenu to use
	 */
	public DropDownMenu(JPopupMenu popupMenu) {
		setPopupMenu(popupMenu);
		
		add(new Box.Filler(getMinimumSize(), getMinimumSize(), getMinimumSize()));
		setHorizontalAlignment(LEFT);
		add(new JLabel(ResourceManager.get().getIcon("bullet_arrow_down.png")));
		addActionListener(this);
	}
	
	/**
	 * Constructor for objects of type DropDownMenu
	 */
	public DropDownMenu() {		
		this(new JPopupMenu());
	}
	
	/**
	 * Get the {@link JPopupMenu} associated with this drop-down menu
	 * @return The {@link JPopupMenu} associated with this drop-down menu
	 */
	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}
	/**
	 * Set the {@link JPopupMenu} associated with this drop-down menu
	 */
	public void setPopupMenu(JPopupMenu popupMenu) {
		this.popupMenu = popupMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		popupMenu.show(this, 0, getHeight());
	}
	
	
}
