package sait.bms.problemdomain;

public class Book {
private String isbn;
private String callNumber;
private int available;
private int total;
private String title;


public Book() {
	
}


public Book(String isbn, String callNumber, int available, int total, String title) {
	super();
	this.isbn = isbn;
	this.callNumber = callNumber;
	this.available = available;
	this.total = total;
	this.title = title;
}


public String getIsbn() {
	return isbn;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public String getCallNumber() {
	return callNumber;
}


public void setCallNumber(String callNumber) {
	this.callNumber = callNumber;
}


public int getAvailable() {
	return available;
}


public void setAvailable(int available) {
	this.available = available;
}


public int getTotal() {
	return total;
}


public void setTotal(int total) {
	this.total = total;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


@Override
public String toString() {
	return "Book [isbn=" + isbn + ", callNumber=" + callNumber + ", available=" + available + ", total=" + total
			+ ", title=" + title + "]";
}


	
}
