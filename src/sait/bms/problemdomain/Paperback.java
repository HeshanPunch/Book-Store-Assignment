package sait.bms.problemdomain;

public class Paperback extends Book {

	private String authors;
	private int year;
	private char genre;

	public Paperback() {

	}

	public Paperback(long isbn, String callNumber, int available, int total, String title, String authors, int year,
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
