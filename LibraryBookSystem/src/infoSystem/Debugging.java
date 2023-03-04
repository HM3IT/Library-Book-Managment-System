package infoSystem;

public class Debugging {
	public static void main(String[] args) {
		Debugging debug = new Debugging();
		InfoSystem infoSystem = new InfoSystem();
		Book[] bookDataAry = BookDatabase.getInstance().getBookAry();// Getting book arrays

		infoSystem.quickSortBook(bookDataAry, BookProperty.ISBN); // sorting the array

		boolean condition = true;
		for (Book book : bookDataAry) {
			String isbn = book.getIsbn();

			int index = debug.binarySearchISBN(bookDataAry, isbn);

			if (index < 0) {
				condition = false;
				break;
			}
		}
		System.out.print(condition);

	}

	// binary search method from infoSystem.java
	// return the index that matched with the given ISBN
	public int binarySearchISBN(Book[] sortedIsbnAry, String tagetIsbn) {

		int leftMost = 0;
		int rightMost = sortedIsbnAry.length - 1;

		while (leftMost <= rightMost) {
			int middle = rightMost / 2;
			String comparedIsbn = sortedIsbnAry[middle].getIsbn();
			int condition = tagetIsbn.compareTo(comparedIsbn);
			if (condition == 0) {// is equal to the middle element
				return middle;
			} else if (condition > 0) { // greater than middle element
				leftMost = middle + 1;
			} else { // less than middle element
				rightMost = middle - 1;
			}
		}
		return -1;
	}

}
