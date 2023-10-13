package LIBRARY;

public class show {
	bookdetails d;
	void getshow(bookdetails d) {
		this.d=d;
		   System.out.println("Title: " + d.getTitle());
           System.out.println("Author: " + d.getAuthor());
           System.out.println("ISBN: " + d.getIsbn());
           System.out.println("Year: " + d.getYear());
           System.out.println("quantity"+ d.getQuantity());
	}

}
