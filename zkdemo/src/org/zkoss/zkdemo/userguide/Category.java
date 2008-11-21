/* Category.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 12, 2008 10:37:09 AM , Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkdemo.userguide;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jumperchen
 */
public class Category {
	private String _id;
	private String _icon;
	private String _iconIE6;
	private String _label;
	private List _items;
	public Category(String id, String icon, String label) {
		_id = id;
		_icon = icon;
		if (icon != null) _iconIE6 = icon.replaceAll(".png", ".gif");
		_label = label; 
		_items = new LinkedList() {
			public Object remove(int index) {
				throw new UnsupportedOperationException();
			}
		};
	}
	public void addItem(DemoItem item) {
		_items.add(item);
	}
	public List getItems() {
		return _items;
	}
	
	public String getId() {
		return _id;
	}
	public String getIcon() {
		return _icon;
	}
	public String getIconIE6() {
		return _iconIE6;
	}
	public String getLabel() {
		return _label;
	}
}
