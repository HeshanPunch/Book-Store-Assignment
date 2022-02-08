package sait.bms.problemdomain;

public class ChildrensBook extends Book {

	private String authors;
	private char format;
	
	public ChildrensBook() {

	}

	public ChildrensBook(String isbn, String callNumber, int available, int total, String title, String authors,
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
		return "ChildrensBook super.toString() + [authors=" + authors + ", format=" + format + ", toString()=" +  "]";
	}
	
	
	
	
}
