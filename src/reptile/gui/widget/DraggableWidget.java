package reptile.gui.widget;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXTitledPanel;

/**
 * A basic movable widget.
 * 
 * @author Joe Williamson
 */
public class DraggableWidget extends JXTitledPanel implements Compositable {
	
	private JPanel container;//Contains main components
	private String title;
	
	public DraggableWidget(String title, JComponent component) {
		
	}
	
}
