package es.indra.formacion.springmvc.editor;

import java.beans.PropertyEditorSupport;

public class PrecioEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Float precio = Float.parseFloat(text);
			this.setValue(precio);
		} catch (NumberFormatException nfe) { 
			this.setValue(0f);
		}
	}
	
	@Override
	public String getAsText() {
		return (this.getValue() != null)?this.getValue().toString():null;
	}
}
