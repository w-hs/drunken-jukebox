package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.client.admin.presenter.SongPresenter;
import de.whs.drunkenjukebox.client.admin.view.SongDetailView;
import de.whs.drunkenjukebox.client.admin.view.SongListView;
import de.whs.drunkenjukebox.client.voteapp.DISlider;
import de.whs.drunkenjukebox.client.voteapp.PlayListView;
import de.whs.drunkenjukebox.client.voteapp.VoteAppPresenter;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VoteApp implements EntryPoint {
	
	
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final DialogBox dialogBox = createDialogBox();
		dialogBox.setGlassEnabled(true);
		dialogBox.setAnimationEnabled(true);
		
		Button diButton = new Button("Send DI",new ClickHandler() { public void onClick(ClickEvent sender) {
			dialogBox.center();
	        dialogBox.show();
	    }});
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel root = RootPanel.get("root");
		root.add(diButton);
		
		//PlayListView songs = new PlayListView();
		//root.add(songs);
		
		VoteAppPresenter presenter = new VoteAppPresenter( new PlayListView());
		presenter.go(root);
		
	}
	
	 private DialogBox createDialogBox() {
		   	// Create a dialog box and set the caption text
		    final DialogBox dialogBox = new DialogBox();
		  
		    dialogBox.setText("Hallo");
		    
		    Button acceptButton = new Button(
			        "Accept", new ClickHandler() {
			          public void onClick(ClickEvent event) {
			            dialogBox.hide();
			          }
			        });
		    
		    Button cancelButton = new Button(
			        "Cancel", new ClickHandler() {
			          public void onClick(ClickEvent event) {
			            dialogBox.hide();
			          }
			        });
		    
		   
			DISlider diSlider = new DISlider(20,"100%");
			//diSlider.drawMarks("white",6);		    
			
			
			VerticalPanel mainPanel = new VerticalPanel();
			mainPanel.setWidth("300px");
			mainPanel.setHeight("200px");
			
			HorizontalPanel titles = new HorizontalPanel();
			titles.setWidth("100%");
			Label startLabel = new Label("Sober");
			Label middleLabel = new Label("Funny");
			Label endLabel = new Label("Drunk");
			titles.add(startLabel);
			titles.add(middleLabel);
			titles.add(endLabel);
			
			titles.setCellHorizontalAlignment(middleLabel, HasHorizontalAlignment.ALIGN_CENTER);
			titles.setCellHorizontalAlignment(endLabel, HasHorizontalAlignment.ALIGN_RIGHT);
			
			HorizontalPanel buttonBar = new HorizontalPanel();
			buttonBar.setWidth("100%");
			buttonBar.add(acceptButton);
			buttonBar.add(cancelButton);
			
			buttonBar.setCellHorizontalAlignment(cancelButton, HasHorizontalAlignment.ALIGN_RIGHT);
			
			mainPanel.add(titles);
			mainPanel.add(diSlider);
			mainPanel.add(buttonBar);

		    dialogBox.setWidget(mainPanel);
		    
		    // Return the dialog box
		    return dialogBox;
		  }
}
