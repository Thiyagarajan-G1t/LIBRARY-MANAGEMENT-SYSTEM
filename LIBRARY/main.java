package LIBRARY;
import java.util.Scanner;
public class main {
	public static void main(String[] args) {

		while(true) {
			
			System.out.println("PRESS : 1 to view |"+" 2 to add |"+" 3 to delete |"+" 4 to update |"+" 5 to search");

			Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a number: ");

	        if(scanner.hasNextInt()) {
	            int number = scanner.nextInt();
	            switch(number){
	    		case 1:
	    			operations.show();
	    			break;
	    		case 2: 
	    			operations.add();
	    			break;
	    		case 3:
	    			operations.delete();
	    			break;
	    		case 4: 
	    			operations.update();
	    			break;
	    		case 5: 
	    			operations.search();
	    			break;
	    		default:
	    			System.out.println("please enter valid option");
	    			break;
	    		}
	        } 
	        else {
	            String input = scanner.next(); // Consume non-numeric input
	            System.out.println("Invalid input. Please enter a number.");
	        }
			
				}
	}
}