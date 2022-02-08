package sait.bms.problemdomain;

public class Paperback extends Book {
	
	private String authors;
	private int year;
	private char genre;
	
	public Paperback() {
		
	}

	public Paperback(String isbn, String callNumber, int available, int total, String title, String authors, int year,
			char genre) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Paperbacks " + super.toString() + "[authors=" + authors + ", year=" + year + ", genre=" + genre +"]";
	}
	
	
	

}
