package com.example.citygisproject;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class Message extends MessageDesign {

	public Message() {
		
		// Create a sub-window and set the content
        Window subWindow = new Window("Sub-window");
        VerticalLayout subContent = new VerticalLayout();
        subContent.setMargin(true);
        subWindow.setContent(subContent);
        
        // Put some components in it
        subContent.addComponent(new Label("Meatball sub"));
        subContent.addComponent(new Button("Awlright"));
        
        // Center it in the browser window
        subWindow.center();
		
		//Message Buttons 
        message_btn1.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				/// Add it to the root component
		        UI.getCurrent().addWindow(subWindow);
				
			}
		});
        
		message_btn2.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				/// Add it to the root component
		        UI.getCurrent().addWindow(subWindow);
				
			}
		});
		
		message_btn3.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				/// Add it to the root component
		        UI.getCurrent().addWindow(subWindow);
				
			}
		});
		
		message_btn4.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				/// Add it to the root component
		        UI.getCurrent().addWindow(subWindow);
				
			}
		});
		
	}

}
