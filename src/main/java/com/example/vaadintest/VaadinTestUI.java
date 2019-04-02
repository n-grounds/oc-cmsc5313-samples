package com.example.vaadintest;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

import java.util.Arrays;

import com.vaadin.annotations.Theme;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;

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
		final CheckBox cb = new CheckBox("Free form entry");
		final ComboBox combo = new ComboBox<>(
			"Color",
			Arrays.asList( "Red", "Yellow", "Green", "Blue" ) );
		final TextField tf = new TextField();
		tf.setVisible(false);
		// final AbsoluteLayout al = new AbsoluteLayout();
		// al.addComponent(combo, "left: 0; width: 100px; height: 20px");
		// al.addComponent(tf, "left: 0; width: 100px; height: 20px");
		final HorizontalLayout al = new HorizontalLayout(combo, tf);
		cb.addValueChangeListener(new ValueChangeListener<Boolean>() {
			@Override
			public void valueChange(ValueChangeEvent<Boolean> event) {
				if(event.getValue()) {
					combo.setVisible(false);
					tf.setVisible(true);
				}
				else {
					combo.setVisible(true);
					tf.setVisible(false);
				}
			}
		});

		setContent(new VerticalLayout(lbl, b, l, cb, al));
	}
}
