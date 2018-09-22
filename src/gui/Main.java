package gui;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import oomharj1.*;

public class Main {

	/**
	 * The main class. Creates an infinite while loop to run a makeshift command line program that lets you
	 * try out the features of the oomharj1 package. Also keeps track of the usable and used colours.
	 * 
	 * The main functions of this program are:
	 * 1. The ability to use and add a colour from/to the usable colours and the file where they are stored.
	 * 2. The ability to reset the colours to the default 10.
	 * 3. The ability to randomize the usable colours and derandomize them.
	 * 4. The ability to test for similarities between 2 colours.
	 * and of course the ability to leave the infinite loop.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Colours.init();
		boolean r = false;
		String s = "";
		ArrayList<String> usableColours = new ArrayList<String>();
		ArrayList<String> usedColours = new ArrayList<String>();
		ArrayList<Colour> temp = new ArrayList<Colour>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			int i = 0;
			System.out.println("What do you want to do?");
			System.out.println("1. Use a colour");
			System.out.println("2. Add a colour");
			System.out.println("3. Reset colours to the default 10");
			System.out.println("4. Get random colours");
			System.out.println("5. Derandomize the colours");
			System.out.println("6. Test similarity of colours");
			System.out.println("7. Exit");
			if(!r) {
				temp = new ArrayList<Colour>(Colours.getColours());
				usableColours = new ArrayList<String>();
				for(int x = 0; x < temp.size(); x++) {
					Colour c = temp.get(x);
					usableColours.add(c.getColour());
				}
			} else {
				temp = new ArrayList<Colour>(Colours.getRandomColours());
				usableColours = new ArrayList<String>();
				for(int x = 0; x < temp.size(); x++) {
					Colour c = temp.get(x);
					usableColours.add(c.getColour());
				}
			}
			System.out.println("Current colours usable: " + usableColours);
			System.out.println("Colours used in this session: " + usedColours);
			while(true) {
				System.out.print("Give a number: ");
				while (!scan.hasNextInt()) {
					scan.next();
					System.out.print("Give a number: ");
				}
				i = scan.nextInt();
				if(i > 0 && i <= 7) {
					break;
				}
			}
			
			if(i == 1 && !r) {
				System.out.print("Type the name of the colour you want to use: ");
				while(true) {
					s = scan.nextLine();
					if(Colours.canUseColour(new Colour(s))) break;
				}
				try {
					Colour c = new Colour(s);
					usedColours.add(c.getColour());
				} catch(InputMismatchException e) {
					System.out.println(e.getMessage());
				}
			}
			else if(i == 1 && r) {
				System.out.print("Type the name of the colour you want to use: ");
				while(true) {
					s = scan.nextLine();
					if(Colours.canUseRandomColour(new Colour(s))) break;
				}
				try {
					Colour c = new Colour(s);
					usedColours.add(c.getColour());
				} catch(InputMismatchException e) {
					System.out.println(e.getMessage());
				}
			}
			
			else if(i == 2 && !r) {
				System.out.print("Type the name of the colour you want to add: ");
				while(scan.hasNextLine()) {
					s = scan.nextLine();
					if(!s.equals("")) break;
				}
				Colours.addColour(new Colour(s));
			}
			else if(i == 2 && r) {
				System.out.print("Type the name of the colour you want to add: ");
				while(scan.hasNextLine()) {
					s = scan.nextLine();
					if(!s.equals("")) break;
				}
				Colours.addRandomColour(new Colour(s));
			}
			
			else if(i == 3) {
				File file = new File("Colours.txt");
				try {
					boolean result = Files.deleteIfExists(file.toPath());
					System.out.println("Deletion: " + result);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Colours.init();
			}
			
			else if(i == 4) {
				r = true;
				Colours.createRandomColours();
			}
			
			else if(i == 5) {
				r = false;
			}
			
			else if(i == 6) {
				String s2 = "";
				System.out.print("Type the first colour: ");
				while(true) {
					s = scan.nextLine();
					if(Colours.canUseColour(new Colour(s))) break;
				}
				System.out.print("Type the second colour: ");
				while(true) {
					s2 = scan.nextLine();
					if(Colours.canUseColour(new Colour(s))) break;
				}
				try {
					Colour c = new Colour(s);
					Colour c2 = new Colour(s2);
					if(c.equals(c2)) System.out.println("These are the same colour.");
					else System.out.println("These colours are different");
				} catch(InputMismatchException e) {
					e.printStackTrace();
				}
			}
			
			else if(i == 7) {
				break;
			}
		}
		scan.close();
	}

}
