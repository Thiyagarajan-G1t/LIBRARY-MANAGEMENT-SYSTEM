package LIBRARY;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.ResultSet;

public class operations {
	static Scanner o=new Scanner(System.in);
	static bookdetails book = new bookdetails();
	static Long isbn=0L;

	static show show= new show();
	static void count() {
		do {
			System.out.println("A valid ISBN should have 10 or 13 digits.");
			isbn=o.nextLong();
		}while(Long.toString(isbn).length()!=10 && Long.toString(isbn).length()!=13);
	}
	public static void show() {


		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/library";
			String name="root";
			String pass="12345678";
			Connection con=DriverManager.getConnection(url,name,pass);
			Statement s=con.createStatement();
			
			String query="select * from bookdetails;";
			
			ResultSet r= s.executeQuery(query);
			
			while (r.next()) {
				

		            book.setTitle(r.getString(1));
		            book.setAuthor(r.getString(2));
		            book.setIsbn(r.getLong(3));
		            book.setYear(r.getInt(4));
		            book.setQuantity(r.getInt(5));

		         show.getshow(book);
			}
		}catch(Exception e){
			System.out.println("Error.Something went wrong");
		}	
	}
	public static void search() {



	try {
		String c=o.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/library";
			String name="root";
			String pass="12345678";
			Connection con=DriverManager.getConnection(url,name,pass);

			PreparedStatement s=con.prepareStatement("select * from bookdetails where title like ? or author like ?");
			
			s.setString(1,"%"+ c+"%");
			s.setString(2,"%"+ c+"%");
			
			ResultSet r=s.executeQuery();
			
			while (r.next()) {

		            book.setTitle(r.getString(1));
		            book.setAuthor(r.getString(2));
		            book.setIsbn(r.getLong(3));
		            book.setYear(r.getInt(4));
		            book.setQuantity(r.getInt(5));

		            show.getshow(book);
			}
				
		}catch(Exception e){
			System.out.println("Error.Something went wrong");
		}
	}
	public static void add() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("enter the book details by title,author, isbn, year, quantity");
		String title=o.nextLine();
		
		String author=o.nextLine();
		
		if (o.hasNextLong()) {
			count();
				}
		else {
			 String input = o.next(); // Consume non-numeric input
	            System.out.println("Invalid isbn. A proper isbn comprises of 10 or 13 digits");
		}
		
		int y=o.nextInt();
		int q=o.nextInt();
		
		String url="jdbc:mysql://localhost:3306/library";
		String name="root";
		String pass="12345678";
		Connection con=DriverManager.getConnection(url,name,pass);
		
		PreparedStatement s=con.prepareStatement("insert into bookdetails values(?,?,?,?,?)");
			
		s.setString(1, title);
		s.setString(2, author);
		s.setLong(3, isbn);
		s.setInt(4, y);
		s.setInt(5, q);
		
		int e=s.executeUpdate();
		if(e==1) {
			System.out.println("adding done");
		}
		else {
			
			System.out.println("action denied");
		}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Error.Something went wrong");
		}	
	}
	public static void update() {
	try {
		System.out.println("please enter the name of the book which you want to alter the quantity");
		String tt=o.next();
		
		System.out.println("for increasing press + for deducing press -");
		String s=o.next();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/library";
		String name="root";
		String pass="12345678";
		Connection con=DriverManager.getConnection(url,name,pass);
		if(s.equals("+")) {
			PreparedStatement t=con.prepareStatement("update bookdetails set quantity=quantity+1 where title like ?;");
			t.setString(1,"%"+tt+"%");
			int e=t.executeUpdate();
			if(e==1) {
				System.out.println("quantity increased");
			}
			else {
				System.out.println("action denied");
			}
		}
		else if(s.equals("-")) {
			PreparedStatement t=con.prepareStatement("update bookdetails set quantity=quantity-1 where title like ?;");
			t.setString(1,"%"+tt+"%");
			int e=t.executeUpdate();
			if(e==1) {
				System.out.println("quantity deduced");
			}
			else {
				System.out.println("action denied");
			}
		}
		
		}catch(Exception e){
			System.out.println("Error.Something went wrong");
		}	
	}
	public static void delete() {
	try {
		System.out.println("enter a detail to delete a book");
		String del=o.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/library";
		String name="root";
		String pass="12345678";
		Connection con=DriverManager.getConnection(url,name,pass);
			
		PreparedStatement t=con.prepareStatement("delete from bookdetails where title like ? or author like ? or isbn like ?;");
		 t.setString(1, "%"+del+"%");
		 t.setString(2, "%"+del+"%");
		 t.setString(3, "%"+del+"%");
		
		 int r=t.executeUpdate();
		 if(r==1) {
			 System.out.println("book detail containing '"+del+"' was deleted");
		 }
		}catch(Exception e){
			System.out.println("Error.Something went wrong");
		}
	}	
}