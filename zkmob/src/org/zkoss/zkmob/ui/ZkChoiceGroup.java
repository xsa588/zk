/* ListableChoiceGroup.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		May 22, 2007 9:40:16 AM, Created by henrichen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zkmob.ui;

import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;

import org.zkoss.zkmob.Itemable;
import org.zkoss.zkmob.Listable;
import org.zkoss.zkmob.ZkComponent;



/**
 * Implement Listable ChoiceGroup.
 * 
 * @author henrichen
 *
 */
public class ZkChoiceGroup extends ChoiceGroup implements Listable, ZkComponent, Itemable {
	private String _id;
	private Boolean _onSelect;
	private ZkDesktop _zk;
	private Form _form;
	private Vector _listitems = new Vector(32);
	
	public ZkChoiceGroup(ZkDesktop zk, String id, String title, int choiceType, Boolean onSelect) {
		super(title, choiceType);
		_id = id;
		_zk = zk;
		_onSelect = onSelect;
	}
	
	public Vector getItems() {
		return _listitems;
	}
	
	//--Listable--//
	public int append(ZkComponent li, String stringPart, Image imagePart) {
		final int j = append(stringPart, imagePart);
		_listitems.addElement(li);
		return j;
	}
		
	public void insert(int index, ZkComponent li, String stringPart, Image imagePart) {
		insert(index, stringPart, imagePart);
		_listitems.insertElementAt(li, index);
	}

	public int indexOf(ZkComponent li) {
		return _listitems.indexOf(li);
	}
	
	public void delete(int index) {
		super.delete(index);
		_listitems.removeElementAt(index);
	}

	public Boolean getOnSelect() {
		return _onSelect;
	}

	//--ZkComponent--//
	public String getId() {
		return _id;
	}
	
	public ZkComponent getParent() {
		return (ZkComponent) _form;
	}
	
	public void setParent(ZkComponent parent) {
		//do nothing
	}
	
	public ZkDesktop getZkDesktop() {
		return _zk;
	}

	public void setAttr(String attr, String val) {
		//TODO:
	}
	
	//--Itemable--//
	public Form getForm() {
		return _form;
	}
	
	public void setForm(Form form) {
		_form = form;
	}
}
