package reptile.gui.theme;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import reptile.gui.ResourceManager;
import reptile.util.RoundedBorder;
import bibliothek.extension.gui.dock.theme.EclipseTheme;
import bibliothek.extension.gui.dock.theme.FlatTheme;
import bibliothek.gui.DockController;
import bibliothek.gui.DockStation;
import bibliothek.gui.Dockable;
import bibliothek.gui.dock.action.ActionType;
import bibliothek.gui.dock.action.DropDownAction;
import bibliothek.gui.dock.action.view.ActionViewConverter;
import bibliothek.gui.dock.action.view.ViewGenerator;
import bibliothek.gui.dock.action.view.ViewTarget;
import bibliothek.gui.dock.dockable.DockableMovingImageFactory;
import bibliothek.gui.dock.dockable.MovingImage;
import bibliothek.gui.dock.dockable.TrueMovingImage;
import bibliothek.gui.dock.station.stack.tab.layouting.TabPlacement;
import bibliothek.gui.dock.themes.BasicTheme;
import bibliothek.gui.dock.themes.basic.BasicDisplayerFactory;
import bibliothek.gui.dock.themes.basic.BasicDockableDisplayer;
import bibliothek.gui.dock.themes.basic.action.BasicButtonModel;
import bibliothek.gui.dock.themes.basic.action.BasicDropDownButtonHandler;
import bibliothek.gui.dock.themes.basic.action.BasicTitleViewItem;
import bibliothek.gui.dock.themes.basic.action.BasicTrigger;
import bibliothek.gui.dock.themes.basic.action.buttons.BasicMiniButton;
import bibliothek.gui.dock.themes.basic.action.buttons.DropDownMiniButton;
import bibliothek.gui.dock.themes.basic.action.buttons.MiniButton;
import bibliothek.gui.dock.util.IconManager;
import bibliothek.gui.dock.util.Priority;
import bibliothek.gui.dock.util.font.DockFont;
import bibliothek.gui.dock.util.font.FontModifier;
import bibliothek.gui.dock.util.font.GenericFontModifier;
import bibliothek.gui.dock.station.DockableDisplayer.Location;
import bibliothek.gui.dock.title.DockTitle;
import bibliothek.gui.dock.title.DockTitleVersion;
import bibliothek.gui.dock.title.UpdatingTitleMovingImage;

public class CustomTheme extends FlatTheme {
	
	public CustomTheme() {
		super();
		
		setTabPlacement(TabPlacement.TOP_OF_DOCKABLE);
		
		setSplitDisplayFactory(new BasicDisplayerFactory(){
			protected BasicDockableDisplayer create( DockStation station, Dockable dockable, DockTitle title, Location location ){
				BasicDockableDisplayer displayer = new BasicDockableDisplayer(station, dockable, title, location){
					@Override
					protected Border getDefaultBorder(){
						return new RoundedBorder(new Color(0, 0, 0, 0), new Color(0, 0, 0, 90), null, 2, 1);
					}
				};
				return displayer;
			}
		});
		
	}
	
	public void install(DockController controller) {
		super.install(controller);
		
		IconManager icons = controller.getIcons();
		ResourceManager res = ResourceManager.get();
		
		icons.setIconTheme("split.maximize", res.getIcon("application-resize.png"));
		icons.setIconTheme("split.normalize", res.getIcon("application-resize-actual.png"));
		icons.setIconTheme("screen.maximize", res.getIcon("application-resize.png"));
		icons.setIconTheme("screen.normalize", res.getIcon("application-resize-actual.png"));
		icons.setIconTheme("close", res.getIcon("application-small-blue.png"));
		icons.setIconTheme("delete.small", res.getIcon("cross-small.png"));
		icons.setIconTheme("default.small", res.getIcon("application-small-blue.png"));
		
		GenericFontModifier fontMod = new GenericFontModifier();
		fontMod.setSizeDelta(false);
		fontMod.setSize(11);
		controller.getFonts().put(Priority.THEME, DockFont.ID_TITLE_ACTIVE, fontMod);
		controller.getFonts().put(Priority.THEME, DockFont.ID_TITLE_INACTIVE, fontMod);
		controller.getFonts().put(Priority.THEME, DockFont.ID_TAB_FOCUSED, fontMod);
		controller.getFonts().put(Priority.THEME, DockFont.ID_TAB_SELECTED, fontMod);
		controller.getFonts().put(Priority.THEME, DockFont.ID_TAB_UNSELECTED, fontMod);
		controller.getFonts().put(Priority.THEME, DockFont.ID_FLAP_BUTTON_ACTIVE, fontMod);
		
		
		controller.getActionViewConverter().putTheme( ActionType.DROP_DOWN, ViewTarget.TITLE,
			new ViewGenerator<DropDownAction, BasicTitleViewItem<JComponent>>(){
			public BasicTitleViewItem<JComponent> create( ActionViewConverter converter, DropDownAction action, Dockable dockable ){
				BasicDropDownButtonHandler handler = new BasicDropDownButtonHandler( action, dockable );
				DropDownMiniButton button = new DropDownMiniButton( handler );
				button.setPreferredSize(new Dimension(16, 16));
				handler.setModel( button.getModel() );
				button.setMouseOverBorder( BorderFactory.createEtchedBorder() );
				return handler;
			}
		});
	}
	
	protected MiniButton<BasicButtonModel> createTitleMiniButton( BasicTrigger trigger ){
		BasicMiniButton button = new BasicMiniButton( trigger ){
			@Override
			public void paintFocus( Graphics g ){
			}
		};
		button.setMouseOverBorder( new RoundedBorder(new Color(0, 0, 0, 0), new Color(150, 150, 150), new Color(250, 250, 250), 4, 0) );
		button.setNormalSelectedBorder( new RoundedBorder(new Color(0, 0, 0, 0), new Color(150, 150, 150), new Color(250, 250, 250), 4, 0) );
		button.setMousePressedBorder( new RoundedBorder(new Color(0, 0, 0, 0), new Color(150, 150, 150), new Color(250, 250, 250), 4, 0) );
		button.setPreferredSize(new Dimension(16, 16));
		return button;
	}
	
}
