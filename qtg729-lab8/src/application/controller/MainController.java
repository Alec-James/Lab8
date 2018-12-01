package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Story;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;

public class MainController {
	

	
	@FXML
	private RadioButton storyOne;
	
	@FXML
	private RadioButton storyTwo;
	
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void handle(ActionEvent event) {
		
		if(storyOne.isSelected()) {
			// load story 1 into story
			Main.story.loadStory1();
		}
		
		if(storyTwo.isSelected()) {
			// load story 2 into story
			Main.story.loadStory2();
		}
		
		loadStory();
	}
	
	public void loadStory() {

		// load the library view
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Story.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
