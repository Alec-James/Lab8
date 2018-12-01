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
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getNumberOfPages() {
		return numberOfPages;
	}



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

	public void addImage(Image image) {
		this.images.add(image);
	}
	
	public void removeAllImages() {
		this.images.removeAll(images);
	}
	
	public void removeAllDesc() {
		this.descriptions.removeAll(descriptions);
	}

	public void addDesc(String desc) {
		this.descriptions.add(desc);
	}

	public void loadStory1() {
		removeAllImages();
		removeAllDesc();
		loadImages("data/story1");
		loadText("data/story1/story.txt");
		this.name = "Amity";
		this.numberOfPages = this.images.size();
	}

	public void loadStory2() {
		removeAllImages();
		removeAllDesc();
		loadImages("data/story2");
		loadText("data/story2/story.txt");
		this.name = "Jurassic";
		this.numberOfPages = this.images.size();
	}

	public void loadImages(String path) {

		File imageFolder = new File(path);
		//System.out.println(imageFolder);

		for (File file : imageFolder.listFiles()) {
			String imagePath = file.getPath();

			if (imagePath.matches(".*\\.(png|jpg)")) {
				try {
					this.addImage(new Image(new FileInputStream(imagePath)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(imagePath);
			}
		}
	}

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
