package com.infosys.irs.utility;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyDateEditor extends PropertyEditorSupport {
	SimpleDateFormat format;

	public MyDateEditor(SimpleDateFormat format) {
		this.format = format;
	}

	@Override
	public void setAsText(String arg0) throws IllegalArgumentException {
		try {
			if (arg0.equals("")) {
				this.setValue(null);
			} else {
				this.setValue(format.parse(arg0));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
