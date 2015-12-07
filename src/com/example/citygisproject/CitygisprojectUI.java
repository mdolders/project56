package com.example.citygisproject;

import entities.User;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;

import com.example.citygisproject.Message;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


@SuppressWarnings("serial")
@Theme("citygisproject")
public class CitygisprojectUI extends UI {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CityGisProject");
    EntityManager em = emf.createEntityManager();

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = CitygisprojectUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final ApplicationDesign applicationDesign = new ApplicationDesign();
		final MessageDesign messageDesign = new MessageDesign();
		
		setContent(applicationDesign);
	
	
	//Hide panels
			applicationDesign.messageList.setVisible(false);
			
			//Set focus on home
			applicationDesign.headerLabel.setValue("Home");
			applicationDesign.homeButton.focus();
			
	    	//Add 10 messages to MessageListPanel
			for(int i=0; i<10; i++){
				
				Query findUsers = em.createQuery("SELECT u FROM User u");
				List<User> userList = (List<User>) findUsers.getResultList();
				
				Message newMessage = new Message();
				newMessage.message_header.setCaption(userList.get(i).getFirstName());
				
				applicationDesign.messageList.addComponent(newMessage);
			}
			
			//Add Click listener to Home button
			applicationDesign.homeButton.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					
					//Hide panel messagList
					applicationDesign.messageList.setVisible(false);
					
					//Set header label
					applicationDesign.headerLabel.setValue("Home");
					
				}
			});
			
			
			// Add Click listener to Carpark button 
			applicationDesign.carparkButton.addClickListener(new Button.ClickListener() {
			    
				@Override
				public void buttonClick(ClickEvent event) {
					
					//Show panel messagList
					applicationDesign.messageList.setVisible(true);
					
					//Set header label
					applicationDesign.headerLabel.setValue("Carpark");

			    }
			});

		}


}