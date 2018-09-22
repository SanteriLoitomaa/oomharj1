package oomharj1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Colours {
	
	static ArrayList<Colour> colours = new ArrayList<Colour>();
	static ArrayList<Colour> randomColours = new ArrayList<Colour>();
	
	/**
	 * Creates the Colours.txt with the default 10 colours if it doesn't exsist and creates an ArrayList out of it.
	 * 
	 * @.post !Colours.equals(new ArrayList<Colour>())
	 */
	@SuppressWarnings("unchecked")
	@BeforeAll
	public static void init() {
		try {
			FileInputStream file = new FileInputStream("Colours.txt");
			ObjectInputStream load = new ObjectInputStream(file);
			colours = (ArrayList<Colour>) load.readObject();
			load.close();
		} catch (FileNotFoundException e) {
			colours = new ArrayList<Colour>(Arrays.asList(new Colour("Red"), new Colour("Blue"), new Colour("Yellow"), new Colour("Purple"),
					new Colour("Green"), new Colour("Orange"), new Colour("Brown"), new Colour("Black"), new Colour("Gray"),
					new Colour("White")));
			try {
				FileOutputStream file = new FileOutputStream("Colours.txt");
				ObjectOutputStream save = new ObjectOutputStream(file);
				save.writeObject(colours);
				save.close();
			} catch (IOException e1) {
				
			}
		} catch (IOException e) {
			colours = new ArrayList<Colour>(Arrays.asList(new Colour("Red"), new Colour("Blue"), new Colour("Yellow"), new Colour("Purple"),
					new Colour("Green"), new Colour("Orange"), new Colour("Brown"), new Colour("Black"), new Colour("Gray"),
					new Colour("White")));
		} catch (ClassNotFoundException e) {
			colours = new ArrayList<Colour>(Arrays.asList(new Colour("Red"), new Colour("Blue"), new Colour("Yellow"), new Colour("Purple"),
					new Colour("Green"), new Colour("Orange"), new Colour("Brown"), new Colour("Black"), new Colour("Gray"),
					new Colour("White")));
		}
	}
	
	/**
	 * This method returns true if the Colour can be used and false if it cannot be used.
	 * 
	 * @param Colour c
	 * @return true if can be used, otherwise false
	 */
	@Test
	public static boolean canUseColour(Colour colour) {
		if(colour == null) return false;
		else if(colours.contains(colour)) return true;
		return false;
	}
	
	/**
	 * This method returns true if the Colour can be used and false if it cannot be used.
	 * 
	 * @param Colour c
	 * @return true if can be used, otherwise false
	 */
	@Test
	public static boolean canUseRandomColour(Colour colour) {
		if(colour == null) return false;
		else if(randomColours.contains(colour)) return true;
		return false;
	}
	
	/**
	 * This method is used to add a colour to the colours ArrayList.
	 * 
	 * @.post colours = OLD.colours + colour
	 * 
	 * @param colour (to add)
	 */
	@Test
	public static void addColour(Colour colour){
		if(colour == null) return;
		colours.add(colour);
		try {
			FileOutputStream colours = new FileOutputStream("Colours.txt");
			ObjectOutputStream save = new ObjectOutputStream(colours);
			save.writeObject(colours);
			save.close();
		} catch (IOException e1) {
			
		}
	}
	
	/**
	 * This method is used to add a colour to the colours ArrayList.
	 * 
	 * @.post colours = OLD.colours + colour
	 * 
	 * @param colour (to add)
	 */
	@Test
	public static void addRandomColour(Colour colour){
		if(colour == null) return;
		randomColours.add(colour);
	}
	
	/**
	 * A method that will randomize colours for an ArrayList that contains a random amount of colours from the colours
	 * ArrayList.
	 * 
	 * @.post The contents of the randomColours ArrayList changes.
	 */
	@Test
	public static void createRandomColours() {
		randomColours = new ArrayList<Colour>();
		Random r = new Random();
		for(int i = r.nextInt(colours.size()-1); i < colours.size(); i++) {
			Colour c = colours.get(r.nextInt(colours.size()));
			if(!randomColours.contains(c)) randomColours.add(c);
		}
	}
	
	/**
	 * A getter for the randomColours ArrayList.
	 * 
	 * @return randomColours
	 */
	public static ArrayList<Colour> getRandomColours(){
		return randomColours;
	}
	
	/**
	 * A getter for the colours ArrayList.
	 * 
	 * @return colours
	 */
	public static ArrayList<Colour> getColours(){
		return colours;
	}
}