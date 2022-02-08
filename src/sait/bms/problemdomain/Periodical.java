package sait.bms.problemdomain;

public class Periodical extends Book {

	private char frequency;
	
	public Periodical() {
		
	}

	public Periodical(String isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	public char getFrequency() {
		return frequency;
	}

	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Periodicals [" + super.toString() + "frequency=" + frequency + ", toString()=" + "]";
	}
	
	
	
	
	
}

