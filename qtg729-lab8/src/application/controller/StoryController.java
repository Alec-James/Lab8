/**
 * StoryController class
 * used to control the story view of the program
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
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class StoryController implements Initializable {

	@FXML
	Label title;

	@FXML
	Label storyDescription;

	@FXML
	ImageView storyImage;

	@FXML
	Label seconds;

	@FXML
	Label currentPage;

	@FXML
	Label maxPage;

	@FXML
	Button endButton;

	private int time = 2 * (Main.story.getNumberOfPages());
	
	/**
	 * intitalizes the story view with the variables from the story
	 */

	public void initialize(URL location, ResourceBundle resources) {

		title.setText(Main.story.getName());
		maxPage.setText(String.valueOf(Main.story.getNumberOfPages()));
		storyDescription.setText(Main.story.getDescriptions().get(0));
		storyImage.setImage(Main.story.getImages().get(0));
		endButton.setVisible(false);
		runThreadedTask();
		//endButton.setVisible(true);
	}

	public void handle(ActionEvent event) {
		loadMenu();
	}

	public void loadMenu() {

		// load the library view
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Runs a threaded task to use for the program to run through the story
	 * 
	 */
	public void runThreadedTask() {
		//System.out.println("Running long task...with a thread!");
		try {

			Thread th = new Thread(new Task() { // put the task in its own
												// thread
				@Override
				protected Integer call() throws Exception {

					int status = 0;
					for (int i = 0; i <= time; i++) {
						status = i;
						final int fstat = status;

						// update the label on the JavaFx Application Thread!
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								setStatus(fstat);
							}
						});
						Thread.sleep(1000);
					}
					endButton.setVisible(true);
					return status;
				}
			});

			// init and run the new thread
			th.setDaemon(true);
			th.start();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * used to keep the view updated when running through the program
	 * @param i
	 */
	public void setStatus(int i) {

		int currentTime = this.time - i;
		this.seconds.setText(String.valueOf(currentTime));

		if ((i % 2 == 0) && (currentTime != 0)) {
			this.currentPage.setText(String.valueOf((i/2)+1));

			storyImage.setImage(Main.story.getImages().get((i/2)));
			storyDescription.setText(Main.story.getDescriptions().get(i/2));
		}

	}

}
