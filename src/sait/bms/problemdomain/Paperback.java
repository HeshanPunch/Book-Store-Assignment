/**
 * Class to manage Paperback object, subclass of Book
 * @author Paolo Araujo
 * @author Heshan Punchihewa
 * @author Lauren (Gukhee) Sung
 * @version February 11, 2021
 */

package sait.bms.problemdomain;

public class Paperback extends Book {

	private String authors;
	private int year;
	private char genre;

	/*
	 * Default constructor for the Paperback object, subclass of Book
	 */
	public Paperback() {

	}

	/*
	 * Constructor for Paperback object, subclass of Book
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
	 * @return authors can be multiple names of authors
	 * 
	 * @param year of the book
	 * 
	 * @param diet is a genre of the Paperback that is identified by a single
	 * character A - Adventure, D - Drama, E - Education, C - Classic, F - Fantasy,
	 * or S - Science Fiction.
	 * 
	 */
	public Paperback(long isbn, String callNumber, int available, int total, String title, String authors, int year,
			char genre) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
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
	 * Gets the year of the book
	 * 
	 * @return year of the book
	 */
	public int getYear() {
		return year;
	}
	
	/*
	 * Sets the year of the book
	 * 
	 * @param year of the book
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/*
	 * Gets the genre of the book
	 * 
	 * @return genre of the book identified by a single character - A/D/E/C/F/S
	 */
	public char getGenre() {
		return genre;
	}
	
	/*
	 * Sets the genre of the book
	 * 
	 * @return genre of the book identified by a single character - A/D/E/C/F/S
	 */
	public void setGenre(char genre) {
		this.genre = genre;
	}
	
	/*
	 * Return Paperback object information in vertical string format for easy
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
	 * @return year of the book
	 * 
	 * @return diet is a genre of the Paperback
	 */
	@Override
	public String toString() {
		String genreString = "";

		switch (genre) {
		case 'A':
			genreString = "Adventure";
			break;
		case 'D':
			genreString = "Drama";
			break;
		case 'E':
			genreString = "Education";
			break;
		case 'C':
			genreString = "Classic";
			break;
		case 'F':
			genreString = "Fantasy";
			break;
		case 'S':
			genreString = "Science Fiction";
			break;
		default:
			System.out.println("Error in Paperback Genre Switch");
		}

		return (super.toString() + String.format("%-15s%s\n%-15s%d\n%-15s%s\n", "Authors:", authors, "Year:", year,
				"Genre:", genreString));

	}

}
