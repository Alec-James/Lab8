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

public class StoryController implements Initializable{

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

	public void initialize(URL location, ResourceBundle resources) {

		title.setText(Main.story.getName());
		maxPage.setText(String.valueOf(Main.story.getNumberOfPages()));
		endButton.setVisible(false);
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
	 * Runs a time-consuming task (wastes time) to demonstrate how threads help
	 * prevent the GUI from hanging waiting on this long task.
	 */
	public void runThreadedTask() {
		System.out.println("Running long task...with a thread!");
		try {

			Thread th = new Thread(new Task() { // put the task in its own
												// thread
				@Override
				protected String call() throws Exception {

					String status = "";
					for (int i = 1; i <= 10; i++) {
						status = "Processing " + i + " of " + 10;
						final String fstat = status;

						// update the label on the JavaFx Application Thread!
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								setStatus(fstat);
							}
						});
						Thread.sleep(1000);
					}
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
	
	public void setStatus(String text) {
		
	}

}
