package sait.bms.managers;

import java.util.*;
import java.io.*;

import sait.bms.problemdomain.*;

public class BooksManager {
	private ArrayList<Book> books = new ArrayList<>();
	private static final String PATH = "res/books.txt";

	public BooksManager() throws IOException {
		LoadBooksFromFile();
		DisplayMenu();

	}

	public void LoadBooksFromFile() throws IOException {

		Scanner in = new Scanner(new File(PATH));

		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");
			long isbn = Long.parseLong(fields[0]);
			int lastNum = (int) (isbn % 10);

			switch (lastNum) {
			case 0:
			case 1:
				books.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
				break;
			case 2:
			case 3:
				books.add(new CookBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
				break;
			case 4:
			case 5:
			case 6:
			case 7:
				books.add(new Paperback(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]),
						fields[7].charAt(0)));
				break;
			case 8:
			case 9:
				books.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5].charAt(0)));
				break;
			default:
				System.out.println("Error sorting through input array");

			}
		}
	}

	public void DisplayMenu() throws FileNotFoundException {
		int option = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1\tCheckout Book");
		System.out.println("2\tFind Books by Title");
		System.out.println("3\tDisplay Books by Type");
		System.out.println("4\tProduce Random Book List");
		System.out.println("5\tSave & Exit\n");
		System.out.print("Enter option: ");

		option = input.nextInt();

		while (option != 5) {

			switch (option) {

			case 1: {
				// System.out.print("Enter ISBN of book: ");
				// long isbn = input.nextLong();
				checkoutBook();
				break;
			}
			case 2: {
				findBook();
				break;
			}
			case 3: {
				// displayTypeBook();
				System.out.println("# Type");
				System.out.println("1	Children's Books");
				System.out.println("2	Cookbooks");
				System.out.println("3	Paperbacks");
				System.out.println("4	Periodicals");
				int type = input.nextInt();
				// displayTypeBook(type);
				break;
			}
			case 4: {
				// randomList();
				System.out.println("case4");
				break;
			}
			case 5: {
				saveBooks();
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Invalid Input!You should enter a number between 1 and 5.");

			}
			// input.close();

			}
		}

	}

	private void checkoutBook() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter ISBN of book: ");
		long isbn = input.nextLong();

		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				// System.out.println(book.getAvailable() + "before");
				if (book.getAvailable() > 0) {
					System.out.println("\nThe book \"" + book.getTitle() + "\" has been checked out.");
					System.out.println("It can be located using a call number: " + book.getCallNumber() + "\n");
					book.setAvailable(book.getAvailable() - 1);
					// System.out.println(book.getAvailable() + "after");
				} else {
					System.out.println("\nThe book \"" + book.getTitle() + "\" is not available.\n");
				}
			}
		}
	}

	public void findBook() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter title to search for: ");
		String userInput = input.nextLine().toLowerCase();

		for (Book thisBook : books) {
			String thisTitle = thisBook.getTitle().toLowerCase();
			if (thisTitle.contains(userInput)) {
				System.out.println("Matching books:");
				System.out.println(thisBook);
			}

		}

	}

	public void saveBooks() throws FileNotFoundException {

		PrintWriter bookSaver = new PrintWriter(PATH);

		for (Book book : books) {

			if (book instanceof ChildrensBook) {

				bookSaver.write(book.getIsbn() + ";" + book.getCallNumber() + ";" + book.getAvailable() + ";"
						+ book.getTotal() + ";" + book.getTitle() + ";" + ((ChildrensBook) book).getAuthors() + ";"
						+ ((ChildrensBook) book).getFormat() + System.lineSeparator());

			} else if (book instanceof CookBook) {

				bookSaver.write(book.getIsbn() + ";" + book.getCallNumber() + ";" + book.getAvailable() + ";"
						+ book.getTotal() + ";" + book.getTitle() + ";" + ((CookBook) book).getPublisher() + ";"
						+ ((CookBook) book).getDiet() + System.lineSeparator());

			} else if (book instanceof Paperback) {

				bookSaver.write(book.getIsbn() + ";" + book.getCallNumber() + ";" + book.getAvailable() + ";"
						+ book.getTotal() + ";" + book.getTitle() + ";" + ((Paperback) book).getAuthors() + ";"
						+ ((Paperback) book).getYear() + ";" + ((Paperback) book).getGenre() + System.lineSeparator());

			} else if (book instanceof Periodical) {

				bookSaver.write(book.getIsbn() + ";" + book.getCallNumber() + ";" + book.getAvailable() + ";"
						+ book.getTotal() + ";" + book.getTitle() + ";" + ((Periodical) book).getFrequency()
						+ System.lineSeparator());

			}
		}
		bookSaver.close();

	}
}
