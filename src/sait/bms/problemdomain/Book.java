/**
 * Class to manage Book object. This is a superclass.
 * @author Paolo Araujo
 * @author Heshan Punchihewa
 * @author Lauren (Gukhee) Sung
 * @version February 11, 2021
 */

package sait.bms.problemdomain;

public class Book {
	private long isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;

	/*
	 * Default constructor for Book class
	 */
	public Book() {

	}

	/*
	 * Constructor for Book class
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
	 */
	public Book(long isbn, String callNumber, int available, int total, String title) {
		super();
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	/*
	 * Gets ISBN number
	 * 
	 * @return isbn which is a standardized 13-digit code for the book
	 * 
	 */
	public long getIsbn() {
		return isbn;
	}

	/*
	 * Sets ISBN number
	 * 
	 * @param isbn which is a standardized 13-digit code for the book
	 */

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/*
	 * Gets Call Number
	 * 
	 * @return calllNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/*
	 * Sets Call Number
	 * 
	 * @param callNumber
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/*
	 * Gets available number of books
	 * 
	 * @return available
	 */
	public int getAvailable() {
		return available;
	}

	/*
	 * Sets available number of books
	 * 
	 * @param available books
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/*
	 * Gets total number of books
	 * 
	 * @return total number of books
	 */
	public int getTotal() {
		return total;
	}

	/*
	 * Sets total number of books
	 * 
	 * @param total number of books
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/*
	 * Gets title of the book
	 * 
	 * @return title of the book
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * Sets the title of the book
	 * 
	 * @param title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * Return Book object information in vertical string format for easy readability
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
	 */
	@Override
	public String toString() {
		return String.format("%-15s%d\n%-15s%s\n%-15s%d\n%-15s%d\n%-15s%s\n", "ISBN:", isbn, "Call Number:", callNumber,
				"Avalable:", available, "Total:", total, "Title:", title);

	}

}
