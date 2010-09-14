package reptile.gui;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import bibliothek.extension.gui.dock.theme.flat.FlatButtonTitle;
import bibliothek.gui.DockController;
import bibliothek.gui.DockTheme;
import bibliothek.gui.Dockable;
import bibliothek.gui.dock.FlapDockStation;
import bibliothek.gui.dock.action.ActionType;
import bibliothek.gui.dock.action.ButtonDockAction;
import bibliothek.gui.dock.action.DropDownAction;
import bibliothek.gui.dock.action.MenuDockAction;
import bibliothek.gui.dock.action.SelectableDockAction;
import bibliothek.gui.dock.action.view.ActionViewConverter;
import bibliothek.gui.dock.action.view.ViewGenerator;
import bibliothek.gui.dock.action.view.ViewTarget;
import bibliothek.gui.dock.station.stack.tab.layouting.TabPlacement;
import bibliothek.gui.dock.themes.BasicTheme;
import bibliothek.gui.dock.themes.ThemeProperties;
import bibliothek.gui.dock.themes.basic.action.BasicButtonHandler;
import bibliothek.gui.dock.themes.basic.action.BasicButtonModel;
import bibliothek.gui.dock.themes.basic.action.BasicDropDownButtonHandler;
import bibliothek.gui.dock.themes.basic.action.BasicMenuHandler;
import bibliothek.gui.dock.themes.basic.action.BasicSelectableHandler;
import bibliothek.gui.dock.themes.basic.action.BasicTitleViewItem;
import bibliothek.gui.dock.themes.basic.action.BasicTrigger;
import bibliothek.gui.dock.themes.basic.action.buttons.BasicMiniButton;
import bibliothek.gui.dock.themes.basic.action.buttons.DropDownMiniButton;
import bibliothek.gui.dock.themes.basic.action.buttons.MiniButton;
import bibliothek.gui.dock.title.DockTitleFactory;
import bibliothek.gui.dock.title.DockTitleRequest;
import bibliothek.gui.dock.util.Priority;

/**
 * A simple but elegant {@link DockTheme theme}
 * @author Joe Williamson <huruey@gmail.com>
 */

@ThemeProperties(
	nameBundle = "theme.simple", 
	descriptionBundle = "theme.simple.description",
	authors = {"Joe Williamson"},
	webpages = {})

public class SimpleTheme extends BasicTheme {
	
	public SimpleTheme() {
		setTabPlacement(TabPlacement.TOP_OF_DOCKABLE, Priority.DEFAULT);
	}
	
	public void install(DockController controller) {
		super.install(controller);
		controller.getDockTitleManager().registerTheme(FlapDockStation.BUTTON_TITLE_ID, new DockTitleFactory(){
			public void install(DockTitleRequest request){
				// ignore	
			}
			
			public void uninstall(DockTitleRequest request){
				// ignore	
			}
			
			public void request(DockTitleRequest request){
				request.answer(new FlatButtonTitle(request.getTarget(), request.getVersion()));
			}
		});

		controller.getActionViewConverter().putTheme(ActionType.BUTTON, ViewTarget.TITLE, 
				new ViewGenerator<ButtonDockAction, BasicTitleViewItem<JComponent>>(){
			public BasicTitleViewItem<JComponent> create(ActionViewConverter converter, ButtonDockAction action, Dockable dockable){
				BasicButtonHandler handler = new BasicButtonHandler(action, dockable);
				MiniButton<BasicButtonModel> button = createTitleMiniButton(handler);
				handler.setModel(button.getModel());
				return handler;
			}
		});

		controller.getActionViewConverter().putTheme(ActionType.CHECK, ViewTarget.TITLE, 
				new ViewGenerator<SelectableDockAction, BasicTitleViewItem<JComponent>>(){
			public BasicTitleViewItem<JComponent> create(ActionViewConverter converter, SelectableDockAction action, Dockable dockable){
				BasicSelectableHandler.Check handler = new BasicSelectableHandler.Check(action, dockable);
				MiniButton<BasicButtonModel> button = createTitleMiniButton(handler);
				handler.setModel(button.getModel());
				return handler;
			}
		});

		controller.getActionViewConverter().putTheme(ActionType.MENU, ViewTarget.TITLE, 
				new ViewGenerator<MenuDockAction, BasicTitleViewItem<JComponent>>(){
			public BasicTitleViewItem<JComponent> create(ActionViewConverter converter, MenuDockAction action, Dockable dockable){
				BasicMenuHandler handler = new BasicMenuHandler(action, dockable);
				MiniButton<BasicButtonModel> button = createTitleMiniButton(handler);
				handler.setModel(button.getModel());
				return handler;
			}
		});

		controller.getActionViewConverter().putTheme(ActionType.RADIO, ViewTarget.TITLE, 
				new ViewGenerator<SelectableDockAction, BasicTitleViewItem<JComponent>>(){
			public BasicTitleViewItem<JComponent> create(ActionViewConverter converter, SelectableDockAction action, Dockable dockable){
				BasicSelectableHandler.Radio handler = new BasicSelectableHandler.Radio(action, dockable);
				MiniButton<BasicButtonModel> button = createTitleMiniButton(handler);
				handler.setModel(button.getModel());
				return handler;
			}
		});

		controller.getActionViewConverter().putTheme(ActionType.DROP_DOWN, ViewTarget.TITLE,
				new ViewGenerator<DropDownAction, BasicTitleViewItem<JComponent>>(){
			public BasicTitleViewItem<JComponent> create(ActionViewConverter converter, DropDownAction action, Dockable dockable){
				BasicDropDownButtonHandler handler = new BasicDropDownButtonHandler(action, dockable);
				DropDownMiniButton button = new DropDownMiniButton(handler);
				handler.setModel(button.getModel());
				button.setMouseOverBorder(BorderFactory.createEtchedBorder());
				return handler;
			}
		});
	}
	
	
	protected MiniButton<BasicButtonModel> createTitleMiniButton(BasicTrigger trigger) {
		BasicMiniButton button = new BasicMiniButton(trigger);
		button.setMouseOverBorder(BorderFactory.createEtchedBorder());
		button.setNormalSelectedBorder(BorderFactory.createEtchedBorder());
		
		return button;
	}
	
}