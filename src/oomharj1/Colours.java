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

public class Colours {
	
	static ArrayList<String> Colours = new ArrayList<String>();
	
	/**
	 * Creates the Colours.txt with the default 10 colours if it doesn't exsist and creates an ArrayList
	 * out of it.
	 * 
	 * @.post !Colours.equals(null or new ArrayList<String>())
	 */
	@SuppressWarnings("unchecked")
	public static void Init() {
		try {
			FileInputStream colours = new FileInputStream("Colours.txt");
			ObjectInputStream load = new ObjectInputStream(colours);
			Colours = (ArrayList<String>) load.readObject();
			load.close();
		} catch (FileNotFoundException e) {
			Colours = new ArrayList<String>(Arrays.asList("Red", "Blue", "Yellow", "Purple", "Green", "Orange",
					"Brown", "Black", "Gray", "White"));
			try {
				FileOutputStream colours = new FileOutputStream("Colours.txt");
				ObjectOutputStream save = new ObjectOutputStream(colours);
				save.writeObject(Colours);
				save.close();
			} catch (IOException e1) {
				
			}
		} catch (IOException e) {
			Colours = new ArrayList<String>(Arrays.asList("Red", "Blue", "Yellow", "Purple", "Green", "Orange",
					"Brown", "Black", "Gray", "White"));
		} catch (ClassNotFoundException e) {
			Colours = new ArrayList<String>(Arrays.asList("Red", "Blue", "Yellow", "Purple", "Green", "Orange",
					"Brown", "Black", "Gray", "White"));
		}
	}
	
	/**
	 * This method is used to add a colour to the Colours ArrayList.
	 * 
	 * @.pre !s.equals(null)
	 * @.post Colours = OLD.Colours + colour
	 * 
	 * @param colour (to add)
	 */
	public static void addColour(String colour){
		Colours.add(colour);
		try {
			FileOutputStream colours = new FileOutputStream("Colours.txt");
			ObjectOutputStream save = new ObjectOutputStream(colours);
			save.writeObject(Colours);
			save.close();
		} catch (IOException e1) {
			
		}
	}
	
	/**
	 * A getter for the Colours ArrayList.
	 * 
	 * @return Colours
	 */
	public static ArrayList<String> getColours(){
		return Colours;
	}
	
	/**
	 * A method that will return an ArrayList that contains a random amount of colours from the Colours
	 * ArrayList.
	 * 
	 * @return a random list of colours.
	 */
	public static ArrayList<String> getRandomColours(){
		ArrayList<String> ran = new ArrayList<String>();
		Random r = new Random();
		for(int i = r.nextInt(Colours.size()-1); i < Colours.size(); i++) {
			String c = Colours.get(r.nextInt(Colours.size()));
			if(!ran.contains(c)) ran.add(c);
		}
		return ran;
	}
}