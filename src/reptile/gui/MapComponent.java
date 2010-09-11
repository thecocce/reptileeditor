package reptile.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class MapComponent extends JComponent implements KeyListener {
	
	private Point selectedTile;
	
	
	/** Constructor for objects of class MapComponent */
	public MapComponent(){
		
		selectedTile = new Point(0,0);
				
		addKeyListener(this);
		setFocusable(true);

	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		drawGrid(g, Color.LIGHT_GRAY);
		g.setColor(Color.red);
		g.drawRect((int)selectedTile.getX(), (int)selectedTile.getY(), 32, 32);
	}
	
	public void drawGrid(Graphics g, Color color){		
		g.setColor(color);
		
		for (int i = 1; i < 10000; i++){
			g.drawLine(i*32, 0, i*32, 10000);
			g.drawLine(0, i*32, 10000, i*32);			
		}		
		
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			selectedTile.translate(32, 0);
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			selectedTile.translate(-32, 0);
		if (e.getKeyCode() == KeyEvent.VK_UP)
			selectedTile.translate(0, -32);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			selectedTile.translate(0, 32);
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

}
