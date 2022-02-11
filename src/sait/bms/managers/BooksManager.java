package sait.bms.managers;

import java.util.*;
import java.io.*;

import sait.bms.problemdomain.*;

/**
 * This program manages the books of The ABC Book Company. This system is
 * intended to allow both employees and patrons to checkout, find, and list
 * books.
 * 
 * @author Paolo Araujo, Lauren (Gukhee) Sung, Heshan Punchihewa
 * @version 2022-02-11
 *
 */
public class BooksManager {
	private ArrayList<Book> books = new ArrayList<>();
	private static final String PATH = "res/books.txt";

	public BooksManager() throws IOException {
		LoadBooksFromFile();
		DisplayMenu();

	}

	/**
	 * Method LoadBooksFromFile. This method parses the supplied “books.txt” file
	 * into a single array list. The array list contains all Book types (cookbooks,
	 * children’s books, and paperbacks). The method uses the last digit of the ISBN
	 * to determine what a valid type of book needs to be created.
	 * 
	 * @throws IOException
	 */
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

	/**
	 * Method DisplayMenu. This method displays the main menu. The user can choose
	 * the options: checkout book, find book by title, display book by type, produce
	 * a random list of books and save and exit.
	 * 
	 * @throws FileNotFoundException
	 */
	public void DisplayMenu() throws FileNotFoundException {
		String option = "";
		while (!option.equals("5")) {
			Scanner input = new Scanner(System.in);

			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.println("1\tCheckout Book");
			System.out.println("2\tFind Books by Title");
			System.out.println("3\tDisplay Books by Type");
			System.out.println("4\tProduce Random Book List");
			System.out.println("5\tSave & Exit\n");
			System.out.print("Enter option: ");

			option = input.nextLine();
			if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")
					|| option.equals("5")) {
				int convertOption = Integer.parseInt(option);

				switch (convertOption) {

				case 1: {
					checkoutBook();
					break;
				}
				case 2: {
					findBook();
					break;
				}
				case 3: {
					displayTypeBook();
					break;
				}
				case 4: {
					randomList();
					break;
				}
				case 5: {
					saveBooks();
					System.out.println("The program has saved the information and finished.");
					System.exit(0);
					break;
				}
				default: {
					System.out.println("Invalid Input!You should enter a number between 1 and 5.\n");

				}
				}
			} else {
				System.out.println("Invalid Input!You should enter a number between 1 and 5.\n");
			}
			// input.close();

		}
	}

	/**
	 * Method checkoutBook. This method allows a patron to checkout a book. The user
	 * enters the ISBN of a book and the method checks the availability and if it is
	 * available it will checkout the book. If the book is not available, the
	 * program shows that the book is unavailable. If the ISBN is wrong the method
	 * shows an error message.
	 * 
	 * @throws FileNotFoundException
	 */
	private void checkoutBook() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter ISBN of book: ");
		while (!input.hasNextLong()) {
			System.out.print("Enter ISBN of book with 13 numeric digits: ");
			input.next();
		}
		long isbn = input.nextLong();

		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				if (book instanceof Periodical) {
					System.out.println("Periodicals cannot be checked out\n");
				} else if (book.getAvailable() > 0) {
					System.out.println("\nThe book \"" + book.getTitle() + "\" has been checked out.");
					System.out.println("It can be located using a call number: " + book.getCallNumber() + "\n");
					book.setAvailable(book.getAvailable() - 1);
				} else if (book.getAvailable() == 0) {
					System.out.println("\nThe book \"" + book.getTitle() + "\" is not available.\n");
				}
			}

		}
	}

	/**
	 * Method findBook. This method displays the books that contain a title. The
	 * user enters a title of a book or a part of a title and the method displays
	 * all the books that contain the title.
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
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

	/**
	 * Method saveBooks. This method takes the books stored in the array list and
	 * persists them back to the file books.txt when the program exits.
	 * 
	 * @throws FileNotFoundException
	 */

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

	/**
	 * Method randomList - this method displays a number of random books. The user
	 * inputs a number and the method returns that number of random books.
	 */
	public void randomList() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of books: ");
		int randomNumber = input.nextInt();
		Collections.shuffle(books);
		for (int i = 0; i < randomNumber; i++) {
			System.out.println(books.get(i) + "\n");
		}
	}

	/**
	 * Method displayTypeBook. This method displays books of a type. The user
	 * chooses a type of book and the method displays all the books of that type.
	 */
	public void displayTypeBook() {
		Scanner input = new Scanner(System.in);
		System.out.println("# Type");
		System.out.println("1	Children's Books");
		System.out.println("2	Cookbooks");
		System.out.println("3	Paperbacks");
		System.out.println("4	Periodicals");
		System.out.print("Enter Type of Book: ");
		int type = 0;
		String userInput = input.next();

		if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4")) {
			type = Integer.parseInt(userInput);
		} else {
			System.out.println("Invalid Input!You should enter a number between 1 and 4\n");
		}

		switch (type) {

		case 1: {
			System.out.print("Enter P for Picture book, E for Early Readers, or C for Chapter ");
			char format = input.next().charAt(0);
			String format1 = String.valueOf(format);
			for (Book book : books) {
				if (book instanceof ChildrensBook) {
					char thisFormat = ((ChildrensBook) book).getFormat();
					String StringFormat = String.valueOf(thisFormat);
					if (format1.equalsIgnoreCase(StringFormat)) {
						System.out.println("Matching books:");
						System.out.println(book.toString() + "\n");
					}
				}
			}
			break;
		}
		case 2: {
			System.out.print(
					"Enter D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None: ");
			char format = input.next().charAt(0);
			String format1 = String.valueOf(format);
			for (Book book : books) {
				if (book instanceof CookBook) {
					char thisFormat = ((CookBook) book).getDiet();
					String StringFormat = String.valueOf(thisFormat);
					if (format1.equalsIgnoreCase(StringFormat)) {
						System.out.println("Matching books:");
						System.out.println(book.toString() + "\n");
					}
				}
			}
			break;
		}
		case 3: {
			System.out.print(
					"Enter A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction: ");
			char format = input.next().charAt(0);
			String format1 = String.valueOf(format);
			for (Book book : books) {
				if (book instanceof Paperback) {
					char thisFormat = ((Paperback) book).getGenre();
					String StringFormat = String.valueOf(thisFormat);
					if (format1.equalsIgnoreCase(StringFormat)) {
						System.out.println("Matching books:");
						System.out.println(book.toString() + "\n");
					}
				}
			}
			break;
		}
		case 4: {
			System.out.print("Enter D for Daily, W for Weekly, M for Monthly, B for Bimonthly, and Q for Quarterly: ");
			char format = input.next().charAt(0);
			String format1 = String.valueOf(format);
			for (Book book : books) {
				if (book instanceof Periodical) {
					char thisFormat = ((Periodical) book).getFrequency();
					String StringFormat = String.valueOf(thisFormat);
					if (format1.equalsIgnoreCase(StringFormat)) {
						System.out.println("Matching books:");
						System.out.println(book.toString() + "\n");
					}
				}
			}
			break;

		}
		default: {
			System.out.println("Invalid Input!You should enter a number between 1 and 4.\n");
		}
		}

	}

}