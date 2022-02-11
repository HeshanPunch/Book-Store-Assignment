/**
 * Class to manage CookBook object, subclass of Book
 * @author Paolo Araujo
 * @author Heshan Punchihewa
 * @author Lauren (Gukhee) Sung
 * @version February 11, 2021
 */

package sait.bms.problemdomain;

public class CookBook extends Book {
	private String publisher;
	private char diet;

	/*
	 * Default constructor for the CookBook object, subclass of Book
	 */
	public CookBook() {

	}

	/*
	 * Constructor for CookBook object, subclass of Book
	 * 
	 * @param isbn which is a standardized 13-digit code to identify the book
	 * 
	 * @param callNumber which is the standardized number for locating the book
	 * 
	 * @param available number of books that can be checked out
	 * 
	 * @param total number of books that are available
	 * 
	 * @param title of the book
	 * 
	 * @param publisher of the book
	 * 
	 * @param diet is a category of the CookBook that is identified by a single
	 * character D - Diabetic, V - Vegetarian, G - Gluten-free, I - International, N
	 * - None.
	 */
	public CookBook(long isbn, String callNumber, int available, int total, String title, String publisher, char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	/*
	 * Gets the publisher of the book
	 * 
	 * @return getPublisher which identifies the publisher of the book
	 */
	public String getPublisher() {
		return publisher;
	}

	/*
	 * Sets the publisher of the book
	 * 
	 * @param getPublisher which identifies the publisher of the book
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/*
	 * Gets the diet of the book
	 * 
	 * @return diet which identifies the diet category of the book, shorthand -
	 * D/V/G/I/N
	 */
	public char getDiet() {
		return diet;
	}

	/*
	 * Sets the diet of the book
	 * 
	 * @param diet which identifies the diet category of the book, shorthand -
	 * D/V/G/I/N
	 */
	public void setDiet(char diet) {
		this.diet = diet;
	}

	/*
	 * Return CookBook object information in vertical string format for easy
	 * readability
	 * 
	 * @return isbn which is a standardized 13-digit code to identify the book
	 * 
	 * @return callNumber which is the standardized number for locating the book
	 * 
	 * @return available number of books that can be checked out
	 * 
	 * @return total number of books that are available
	 * 
	 * @return title of the book
	 * 
	 * @return publisher of the book
	 * 
	 * @return diet is a category of the CookBook
	 */

	@Override
	public String toString() {
		String dietString = "";

		switch (diet) {
		case 'D':
			dietString = "Diabetic";
			break;
		case 'V':
			dietString = "Vegetarian";
			break;
		case 'G':
			dietString = "Gluten-free";
			break;
		case 'I':
			dietString = "International";
			break;
		case 'N':
			dietString = "None";
			break;
		default:
			System.out.println("Error in Cook Book Diet Switch");

		}

		return (super.toString() + String.format("%-15s%s\n%-15s%s\n", "Publisher:", publisher, "Diet:", dietString));
	}

}
