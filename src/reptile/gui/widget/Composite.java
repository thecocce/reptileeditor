package reptile.gui.widget;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * A space shared by two JComponents
 * 
 * @author Joe Williamson
 */

public class Composite extends JSplitPane implements Compositable {
	
	public Composite(int orientation, JComponent component1, JComponent component2) {
		super(orientation, component1, component2);
		setBorder(null);
		
	}
	
	
}
