package infoSystem;

import java.util.ArrayList;
import java.util.List;

public class InfoSystem {

	/**
	 * @return string that is formatted the @param isbnNumber with the ISBN format
	 *         ISBN 13 digit format (979-3-16-148410-1)
	 */
	String formattingIsbn(String isbnNumber) {

		return String.format("%s-%s-%s-%s-%s", isbnNumber.substring(0, 3), // first group- 3 digits
				isbnNumber.substring(3, 4), // second group-1 digit
				isbnNumber.substring(4, 6), // third group-2 digits
				isbnNumber.substring(6, 12), // fourth group-6 digits
				isbnNumber.substring(12, 13));// fifth group-1 digit
	}

	/**
	 * @return true if the given @param isbn is matched with ISBN format
	 * 
	 * @return false if the given @param isbn is not matched with ISBN format
	 * 
	 *         format 13 digit (979-3-16-148410-1)
	 */
	public static boolean isIsbn(String isbn) {
		String removeRegex = "-";
		String replacement = "";
		String isbnText = isbn.replaceAll(removeRegex, replacement);

		String isbnRegex = "([0-9]{13})";
		return isbnText.matches(isbnRegex);
	}

// Searching algorithm implementation
	/**
	 * Abstract method of binarySearchISBN
	 * 
	 * @return index of book element in a given array that match with the
	 *         given @param isbn
	 * 
	 * @return -1 if the book is not found in the given @param bookDataAry array
	 */
	public int searchIsbn(Book[] bookDataAry, String isbn) {
		quickSortBook(bookDataAry, BookProperty.ISBN); // sorting the array before calling binary search
		String pureIsbn = isbn.replaceAll("-", "");
		return binarySearchIsbn(bookDataAry, pureIsbn);
	}

	/**
	 * @return middle-the index of book element in a given @param sortedIsbnAry
	 *         array that match with the given @param tagetIsbn
	 * 
	 * @return -1 if the book is not found in the given @param sortedIsbnAry array
	 */
	public int binarySearchIsbn(Book[] sortedIsbnAry, String tagetIsbn) {

		int leftMost = 0;
		int rightMost = sortedIsbnAry.length - 1;

		while (leftMost <= rightMost) {
			int middle = leftMost / 2;
			int condition = tagetIsbn.compareTo(sortedIsbnAry[middle].getIsbn());
			if (condition == 0) {
				return middle;
			} else if (condition > 0) {
				// greater than middle element
				leftMost = middle + 1;
			} else {
				// less than middle element
				rightMost = middle - 1;
			}
		}
		return -1;
	}

	/**
	 * @return A Book array that contains all books that matched with the
	 *         given @param keyword
	 * 
	 * @return null if there is no book that matched with the given @param keyword
	 */
	public Book[] searchBookProperty(Book[] bookAry, String keyword, BookProperty property, boolean caseSensitive) {
		if (!caseSensitive) {
			keyword = keyword.toLowerCase();
		}
		ArrayList<Book> matchBookList = new ArrayList<Book>();
		// Java regular expression
		String regex = ".*" + keyword + ".*";
		int length = bookAry.length;
		for (int i = 0; i < length; i++) {
			String bookValue = bookAry[i].getValue(property);
			if (!caseSensitive) {
				bookValue = bookValue.toLowerCase();
			}
			// Using regular expression to check the bookValue is matched or not
			if (bookValue.matches(regex)) {
				// Adding the books that matched with search keyword
				matchBookList.add(bookAry[i]);
			}
		}
		return matchBookList.size() > 0 ? listToBookAry(matchBookList) : null;
	}

	/* For type conversion from Book list to book array */
	public Book[] listToBookAry(List<Book> bookList) {
		int size = bookList.size();
		Book[] possibleBooks = new Book[size];
		for (int i = 0; i < size; i++) {
			possibleBooks[i] = (Book) bookList.get(i);
		}
		return possibleBooks;
	}

// sorting algorithm implementation
	// overload method
	public void quickSortBook(Book[] bookAry, BookProperty sortType) {
		quickSortBook(bookAry, 0, bookAry.length - 1, sortType);
	}

	public void quickSortBook(Book[] bookAry, int lowIndex, int highIndex, BookProperty property) {
		if (lowIndex >= highIndex) {
			return;
		}
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		// choosing the last index as a pivot index
		int pivotIndex = highIndex;
		String pivot = bookAry[pivotIndex].getValue(property);

		while (leftPointer < rightPointer) {
			while (leftPointer < rightPointer
					&& bookAry[leftPointer].getValue(property).compareToIgnoreCase(pivot) <= 0) {
				leftPointer++;
			}
			while (leftPointer < rightPointer
					&& bookAry[rightPointer].getValue(property).compareToIgnoreCase(pivot) >= 0) {
				rightPointer--;
			}
			swap(bookAry, leftPointer, rightPointer);
		}
		swap(bookAry, leftPointer, pivotIndex);
		// left partition sorting
		quickSortBook(bookAry, lowIndex, leftPointer - 1, property);
		// right partition sorting
		quickSortBook(bookAry, leftPointer + 1, highIndex, property);
	}

	public void swap(Book[] bookAry, int firstIndex, int secondIndex) {
		Book temp = bookAry[firstIndex];
		bookAry[firstIndex] = bookAry[secondIndex];
		bookAry[secondIndex] = temp;
	}

}
