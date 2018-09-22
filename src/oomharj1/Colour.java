package oomharj1;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;

public class Colour {
	
	String colour;

	/**
	 * Creates a Colour object.
	 * 
	 * @.post new Colour created.
	 * 
	 * @param colour
	 */
	public Colour(String colour) throws InputMismatchException{
		if(colour == null) {
			throw new InputMismatchException("This colour is not supported.");
		}
		this.colour = colour;
	}
	
	/**
	 * Returns true if the colours are the same.
	 * 
	 * @param colour
	 * @return true if the same Colour, false if not.
	 */
	@Test
	public boolean equals(Colour colour) {
		if(colour == null) {
			return false;
		}
		else if(this.colour.equals(colour.colour))
			return true;
		return false;
	}
	
	/**
	 * Getter for the name of the colour.
	 * @return String colour
	 */
	public String getColour(){
		return colour;
	}

}