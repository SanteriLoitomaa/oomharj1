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
	 * 2. The ability to randomize the usable colours and to reset them to default 10.
	 * 3. The ability to test for similarities between 2 colours.
	 * and of course the ability to leave the infinite loop.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Colours.Init();
		boolean r = false;
		boolean ra = false;
		String s = "";
		ArrayList<String> usableColours = new ArrayList<String>();
		ArrayList<String> usedColours = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			int i = 0;
			System.out.println("What do you want to do?");
			System.out.println("1. Use a colour");
			System.out.println("2. Add a colour");
			System.out.println("3. Reset colours to default");
			System.out.println("4. Get random colours");
			System.out.println("5. Test similarity of colours");
			System.out.println("6. Exit");
			if(!r && !ra) {
				usableColours = Colours.getColours();
			} else if(!ra && r) {
				usableColours = Colours.getRandomColours();
				ra = true;
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
				if(i > 0 && i <= 6) {
					break;
				}
			}
			if(i == 1) {
				System.out.print("Type the name of the colour you want to use: ");
				while(true) {
					s = scan.nextLine();
					if(usableColours.contains(s)) break;
				}
				try {
					Colour c = new Colour(s);
					usedColours.add(c.getColour());
				} catch(InputMismatchException e) {
					e.printStackTrace();
				}
			}
			if(i == 2) {
				System.out.print("Type the name of the colour you want to add: ");
				while(scan.hasNextLine()) {
					s = scan.nextLine();
					if(!s.equals("")) break;
				}
				Colours.addColour(s);
			}
			if(i == 3) {
				File file = new File("Colours.txt");
				try {
					boolean result = Files.deleteIfExists(file.toPath());
					System.out.println("Deletion: " + result);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Colours.Init();
			}
			if(i == 4) {
				r = true;
				ra = false;
			}
			if(i == 5) {
				String s2 = "";
				System.out.print("Type the first colour: ");
				while(true) {
					s = scan.nextLine();
					if(usableColours.contains(s)) break;
				}
				System.out.print("Type the second colour: ");
				while(true) {
					s2 = scan.nextLine();
					if(usableColours.contains(s)) break;
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
			if(i == 6) {
				break;
			}
		}
		scan.close();
	}

}
