package infoSystem;

public class Book {

	private String isbn;
	private String title;
	private String category;
	private String author;
	private String edition;
	private String publisher;

	public Book(String isbn, String title, String category, String author, String publisher, String edition) {
		this.isbn = isbn;
		this.title = title;
		this.category = category;
		this.author = author;
		this.edition = edition;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getValue(BookProperty property) {
		String value = "";
		switch (property) {
		case ISBN:
			value = getIsbn();
			break;
		case TITLE:
			value = getTitle();
			break;
		case AUTHOR:
			value = getAuthor();
			break;
		case CATEGORY:
			value = getCategory();
			break;
		case EDITION:
			value = getEdition();
			break;
		case PUBLISHER:
			value = getPublisher();
			break;
		default:
			value = getIsbn();
			break;
		}
		return value;
	}
}
