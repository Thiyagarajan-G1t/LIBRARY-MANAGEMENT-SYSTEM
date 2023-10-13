package LIBRARY;
public class bookdetails {
	String title;
	String author;
	long isbn;
	int year;
	int quantity;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//	@Override
//	public String toString() {
//		return "title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
//				+ ", quantity=" + quantity ;
//
//	}
}
