/**
 * Class to manage ChildrensBook object, subclass of Book
 * @author Paolo Araujo
 * @author Heshan Punchihewa
 * @author Lauren (Gukhee) Sung
 * @version February 11, 2021
 */

package sait.bms.problemdomain;

public class ChildrensBook extends Book {

	private String authors;
	private char format;

	/*
	 * Default constructor for the ChildrensBook object
	 */
	public ChildrensBook() {

	}

	/*
	 * Constructor for ChildrensBook object, subclass of Book
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
	 * @param authors can be multiple names of authors
	 * 
	 * @param format is a single character P - Picture Book, E - Early Readers, C - Chapter Book
	 * 
	 */
	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String authors,
			char format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	/*
	 * Gets the author(s) of the book
	 * 
	 * @return authors of the book
	 */
	public String getAuthors() {
		return authors;
	}

	/*
	 * Sets the author(s) of the book
	 * 
	 * @param authors of the book
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/*
	 * Gets format of the book in a single character format P for Picture Book, E
	 * for Early Readers, C for Chapter Book
	 * 
	 * @return format of the book
	 */
	public char getFormat() {
		return format;
	}

	/*
	 * Sets the format of the book
	 * 
	 * @param format of the book (P, E, or C)
	 */
	public void setFormat(char format) {
		this.format = format;
	}

	/*
	 * Return ChildrensBook object information in vertical string format for easy
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
	 * @return authors can be multiple names of authors
	 * 
	 * @return format of the book
	 */
	@Override
	public String toString() {
		String formatString = "";

		switch (format) {
		case 'P':
			formatString = "Picture Book";
			break;
		case 'E':
			formatString = "Early Readers";
			break;
		case 'C':
			formatString = "Chapter Book";
			break;
		default:
			System.out.println("Error in Children Book Format Switch");

		}

		return (super.toString() + String.format("%-15s%s\n%-15s%s\n", "Authors:", authors, "Format:", formatString));

	}

}
