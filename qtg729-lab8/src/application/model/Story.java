/**
 * Story class
 * used to handle all the model functions for the stor
 * 
 * for CS 3443
 * Fall 2018
 * 
 * @author Alec Estrada (qtg729)
 */

package application.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;

public class Story {

	private ArrayList<Image> images;
	private ArrayList<String> descriptions;
	private String name;
	private int numberOfPages;

	/**
	 * Constructor
	 * 
	 */
	public Story() {

		images = new ArrayList<Image>();
		descriptions = new ArrayList<String>();
		name = "";
		numberOfPages = 0;

	}

	/**
	 * getter for the name of the object
	 * 
	 * @return - String that's the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name of object
	 * @param name - String that is the used to set the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for number of pages that the story will have
	 * 
	 * @return - int number of pages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * setter for number of pages for the story
	 * 
	 * @param numberOfPages - int number of pages
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * getter for the array list
	 * 
	 * @return
	 */
	public ArrayList<Image> getImages() {
		return images;
	}

	/**
	 * setter for the arrayList
	 * 
	 * @param images
	 */
	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}

	/**
	 * getter for the description
	 * 
	 * @return
	 */
	public ArrayList<String> getDescriptions() {
		return descriptions;
	}

	/**
	 * setter for description
	 * 
	 * @param descriptions
	 */
	public void setDescriptions(ArrayList<String> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * adder to add images to image array list
	 * 
	 * @param image - Image that is added to the array list
	 */
	public void addImage(Image image) {
		this.images.add(image);
	}

	/**
	 * removes all images from the array list
	 * 
	 */
	public void removeAllImages() {
		this.images.removeAll(images);
	}

	/**
	 * removes all strings from description array list
	 */
	public void removeAllDesc() {
		this.descriptions.removeAll(descriptions);
	}

	/**
	 * adder to add description strings to the array list
	 * 
	 * @param desc
	 */
	public void addDesc(String desc) {
		this.descriptions.add(desc);
	}

	/**
	 * loads the information for story 1
	 */
	public void loadStory1() {
		removeAllImages();
		removeAllDesc();
		loadImages("data/story1");
		loadText("data/story1/story.txt");
		this.name = "Amity";
		this.numberOfPages = this.images.size();
	}

	/**
	 * loads the information for story2
	 */
	public void loadStory2() {
		removeAllImages();
		removeAllDesc();
		loadImages("data/story2");
		loadText("data/story2/story.txt");
		this.name = "Jurassic";
		this.numberOfPages = this.images.size();
	}

	/**
	 * load images from specified directory
	 * 
	 * @param path - String the directory or folder where images are located
	 */
	public void loadImages(String path) {

		File imageFolder = new File(path);
		// System.out.println(imageFolder);

		for (File file : imageFolder.listFiles()) {
			String imagePath = file.getPath();

			if (imagePath.matches(".*\\.(png|jpg)")) {
				try {
					this.addImage(new Image(new FileInputStream(imagePath)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(imagePath);
			}
		}
	}

	/**
	 * loads the descriptions from a specified text file.
	 * 
	 * @param filePath - String the path of the specific text file
	 */
	public void loadText(String filePath) {
		File file = new File(filePath);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String rmNumber = line.substring(3);
				addDesc(rmNumber);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
