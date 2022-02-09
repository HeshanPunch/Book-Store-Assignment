package sait.bms.managers;

import java.util.*;
import java.io.*;

import sait.bms.problemdomain.*;

public class BooksManager {
	private ArrayList<Book> books = new ArrayList<>();
	private static final String PATH = "res/books.txt";

	public void LoadBooksFromFile() throws IOException {
		// final int ISBN_NUM_LENTH = 13;

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

			// only for testing
			int i = 1;
			for (Book b : books) {

				if (b instanceof Periodical) {
					System.out.println(b);
					System.exit(0);
				}

			}

		}

	}

	public BooksManager() throws IOException {
		LoadBooksFromFile();

		System.out.println("Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1\tCheckout Book");
		System.out.println("2\tFind Books by Title");
		System.out.println("3\tDisplay Books by Type");
		System.out.println("4\tProduce Random Book List");
		System.out.println("5\tSave & Exit");

	}

}
