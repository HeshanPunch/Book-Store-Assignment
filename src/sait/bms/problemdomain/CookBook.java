package sait.bms.problemdomain;

public class CookBook extends Book{
	private String publisher;
	private char diet;
	
	public CookBook(){
		
	}

	public CookBook(String isbn, String callNumber, int available, int total, String title, String publisher,
			char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public char getDiet() {
		return diet;
	}

	public void setDiet(char diet) {
		this.diet = diet;
	}

	@Override
	public String toString() {
		return "CookBooks [super.toString() + publisher=" + publisher + ", diet=" + diet + ", toString()=" + "]";
	}
	
		


}
