/* Input.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 29 21:59:11     2005, Created by tomyeh
}}IS_NOTE

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zhtml;

import java.lang.Object; //since we have org.zkoss.zhtml.Object

import org.zkoss.lang.Objects;

import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zhtml.impl.AbstractTag;

/**
 * The input tag.
 *
 * @author tomyeh
 */
public class Input extends AbstractTag {
	private transient boolean _byClient;

	public Input() {
		this("input");
	}
	protected Input(String tagnm) {
		super(tagnm);
		setValue("");
	}

	/** Returns the value of this input.
	 */
	public String getValue() {
		return (String)getDynamicProperty("value");
	}
	/** Sets the vallue of this input.
	 */
	public void setValue(String value) throws WrongValueException {
		setDynamicProperty("value", value);
	}

	//super//
	protected void smartUpdate(String attr, Object value) {
		if (!_byClient)
			super.smartUpdate(attr, value);
	}

	/** Processes an AU request.
	 *
	 * <p>Default: in addition to what are handled by {@link XulElement#process},
	 * it also handles onChange, onChanging and onError.
	 * @since 5.0.0
	 */
	public void process(org.zkoss.zk.au.AuRequest request, boolean everError) {
		final String name = request.getName();
		if (name.equals(Events.ON_CHANGE)) {
			InputEvent evt = InputEvent.getInputEvent(request);

			final String value = evt.getValue();
			_byClient = true;
			try {
				setValue(value);
			} finally {
				_byClient = false;
			}

			Events.postEvent(evt);
		} else
			super.process(request, everError);
	}
}
