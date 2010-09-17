package reptile.gui.widget;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTree;

public class ProjectExplorer extends JTree {
	
	public ProjectExplorer() {
		setPreferredSize(new Dimension(180, 210));
		setMinimumSize(new Dimension(180, 210));
		setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
}
