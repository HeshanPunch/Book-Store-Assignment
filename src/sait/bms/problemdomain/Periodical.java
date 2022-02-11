/**
 * Class to manage Paperback object, subclass of Book
 * This type of Book cannot be checked out using checkoutBook() method
 * @author Paolo Araujo
 * @author Heshan Punchihewa
 * @author Lauren (Gukhee) Sung
 * @version February 11, 2021
 */

package sait.bms.problemdomain;

public class Periodical extends Book {
	private char frequency;

	/*
	 * Default constructor for the Paperback object, subclass of Book
	 */
	public Periodical() {

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
	 * @param frequency is the frequency of publication, identified by a single
	 * character D - Daily, W - Weekly, M - Monthly, B - Bimonthly, and Q - Quarterly
	 * 
	 * 
	 */
	public Periodical(long isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	/*
	 * Gets the publication frequency of the book
	 * 
	 * @return frequency of the book as a single character - D/W/M/B/Q
	 */
	public char getFrequency() {
		return frequency;
	}
	/*
	 * Sets the publication frequency of the book
	 * 
	 * @return frequency of the book as a single character - D/W/M/B/Q
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}

	/*
	 * Return Periodical object information in vertical string format for
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
	 * @return frequency is the frequency of publication 
	 * 
	 */
	@Override
	public String toString() {
		String frequencyString = "";

		switch (frequency) {
		case 'D':
			frequencyString = "Daily";
			break;
		case 'W':
			frequencyString = "Weekly";
			break;
		case 'M':
			frequencyString = "Monthly";
			break;
		case 'B':
			frequencyString = "Bimonthly";
			break;
		case 'Q':
			frequencyString = "Quarterly";
			break;
		default:
			System.out.println("Error in Periodicals Genre Switch");
		}

		return (super.toString() + String.format("%-15s%s\n", "Frequency:", frequencyString));

	}

}
