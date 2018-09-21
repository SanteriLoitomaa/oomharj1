package oomharj1;

import java.util.InputMismatchException;

public class Colour {
	
	String colour;

	/**
	 * Creates a colour object.
	 * 
	 * @.pre !colour.equals(null)
	 * @.post true
	 * 
	 * @param colour
	 */
	public Colour(String colour) throws InputMismatchException{
		if(Colours.getColours().contains(colour)) {
			this.colour = colour;
		} else {
			throw new InputMismatchException("This colour is not supported.");
		}
	}
	
	/**
	 * Returns true if the colours are the same.
	 * 
	 * @.pre !colour.equals(null)
	 * @.post true
	 * 
	 * @param colour
	 * @return
	 */
	public boolean equals(Colour colour) {
		if(this.colour.equals(colour.colour))
			return true;
		return false;
	}
	
	public String getColour(){
		return colour;
	}

}