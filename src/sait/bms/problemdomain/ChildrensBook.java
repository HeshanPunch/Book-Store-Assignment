package sait.bms.problemdomain;

public class ChildrensBook extends Book {

	private String authors;
	private char format;

	public ChildrensBook() {

	}

	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String authors,
			char format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public char getFormat() {
		return format;
	}

	public void setFormat(char format) {
		this.format = format;
	}

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
