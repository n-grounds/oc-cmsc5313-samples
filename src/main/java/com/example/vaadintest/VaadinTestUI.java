package com.example.vaadintest;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.annotations.Theme;

@Theme("VaadinTest")
public class VaadinTestUI extends UI{
	private int clickCount;
	@Override
	protected void init(VaadinRequest request){
		Label lbl = new Label("Hello, user");
		Button b = new Button("Click Me");
		Label l =  new Label("");
		b.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				clickCount++;
				l.setValue("You clicked the button " + clickCount + " times");
			}
		});
		setContent(new VerticalLayout(lbl, b, l));
	}
}
