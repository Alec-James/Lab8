/**
 * Main class
 * Main class used to initialize program
 * 
 * for CS 3443
 * Fall 2018
 * 
 * @author Alec Estrada (qtg729)
 */
package application;
	
import application.model.Story;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	public static Story story = new Story();
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		
		try {	
			Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
			primaryStage.setScene(new Scene(root, 800, 800));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * starts the program 
	 * 
	 * @param args - arguments for the program
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
