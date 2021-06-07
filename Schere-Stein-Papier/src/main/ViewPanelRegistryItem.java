package main;

import java.util.ArrayList;

public class ViewPanelRegistryItem {

	public final ViewPanel panel;
	public final ArrayList<ViewPanelKeyListener> keyListeners = new ArrayList<ViewPanelKeyListener>();
	
	public ViewPanelRegistryItem(ViewPanel panel) {
		this.panel = panel;
	}
	
	public void addKeyListener(ViewPanelKeyListener listener) {
		this.keyListeners.add(listener);
	}
	
}
