/* DemoWindowComposer.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 13, 2008 10:36:53 AM , Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkdemo.userguide;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 * @author jumperchen
 */
public class DemoWindowComposer extends GenericForwardComposer {
	Window view;
	Tab demoView;
	Textbox codeView;
	Button reloadBtn;
	Button tryBtn;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		((Window)comp).setContentSclass("demo-main-cnt");
		((Window)comp).setSclass("demo-main");
		final Include inc = new Include();
		inc.setSrc("/userguide/bar.zul");
		inc.setStyle("float:right");
		comp.insertBefore(inc, comp.getFirstChild());
		if (view != null) execute();
	}
	public void execute() {
		Components.removeAllChildren(view);
		Executions.createComponentsDirectly(codeView.getValue(), "zul", view, null);
	}
	public void onClick$reloadBtn(Event event) {
		demoView.setSelected(true);
		Path.getComponent("//userGuide/xcontents").invalidate();
	}
	public void onClick$tryBtn(Event event) {
		demoView.setSelected(true);
		execute();
	}
}
