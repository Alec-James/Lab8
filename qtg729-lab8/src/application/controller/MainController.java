/**
 * Main Controller Class
 * used to control the main menu view of the program
 * 
 * for CS 3443
 * Fall 2018
 * 
 * @author Alec Estrada (qtg729)
 */
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
	
	/**
	 * handle to be used on button press
	 * 
	 * @param event - mousee clisck
	 */
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
	
	
	/**
	 * 
	 * loads the story view of the program
	 */
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
