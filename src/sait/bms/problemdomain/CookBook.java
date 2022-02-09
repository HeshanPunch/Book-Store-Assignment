package sait.bms.problemdomain;

public class CookBook extends Book {
	private String publisher;
	private char diet;

	public CookBook() {

	}

	public CookBook(long isbn, String callNumber, int available, int total, String title, String publisher, char diet) {
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
		String dietString = "";

		switch (diet) {
		case 'D':
			dietString = "Diabetic";
			break;
		case 'V':
			dietString = "Vegetarian";
			break;
		case 'G':
			dietString = "Gluten-free";
			break;
		case 'I':
			dietString = "International";
			break;
		case 'N':
			dietString = "None";
			break;
		default:
			System.out.println("Error in Cook Book Diet Switch");

		}

		return (super.toString() + String.format("%-15s%s\n%-15s%s\n", "Publisher:", publisher, "Diet:", dietString));
	}

}
