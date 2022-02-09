package sait.bms.problemdomain;

public class Periodical extends Book {

	private char frequency;

	public Periodical() {

	}

	public Periodical(long isbn, String callNumber, int available, int total, String title, char frequency) {
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
