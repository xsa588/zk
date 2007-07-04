/* ListFactory.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		May 15, 2007 3:12:00 PM, Created by henrichen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkmob.factory;

import org.xml.sax.Attributes;
import org.zkoss.zkmob.ZkComponent;
import org.zkoss.zkmob.ui.ZkList;

/**
 * An UiFactory used to create a List Ui component.
 * 
 * @author henrichen
 *
 */
public class ListFactory extends AbstractUiFactory {
	public ListFactory(String name) {
		super(name);
	}

	public ZkComponent create(ZkComponent parent, String tag, Attributes attrs, String hostURL) {
		final String id = attrs.getValue("id"); //id
		final String title = attrs.getValue("tt"); //title
		final String listTypeStr = attrs.getValue("tp"); //listType
		final int listType = Integer.parseInt(listTypeStr);
		
		final ZkList list = new ZkList(((ZkComponent)parent).getZkDesktop(), id, title, listType);
		return list;
	}

}
