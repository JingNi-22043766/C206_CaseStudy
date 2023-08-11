import java.util.ArrayList;


public class C206_CaseStudy {

	
		// TODO Auto-generated method stub
		

		 
		 private static final int OPTION_QUIT = 5;
		private static final boolean True = false;
		
	
		 public static void main(String[] args) {

		  ArrayList<Quotes> QuotesList = new ArrayList<Quotes>();
		  Quotes newQuote = new Quotes("Sam", 132, 123, 100.0, "new quote");

		  QuotesList.add(newQuote);
		  

		  int option = 0;

		  while (option != OPTION_QUIT) {

		   C206_CaseStudy.menu();
		   option = Helper.readInt("Enter an option > ");

		   if (option == 1) {
		    // View all items
		    C206_CaseStudy.viewAllQuotes(QuotesList);
		   

		   } else if (option == 2) {
		    // 
			C206_CaseStudy.inputQuotes(QuotesList, null);
		    

		    } else if (option == 3) {
		     
		    	C206_CaseStudy.inputQuotes(QuotesList, null);
		     String nameToDelete = Helper.readString("Enter name of quote to delete > ");


		   } else if (option == OPTION_QUIT) {
		    System.out.println("Bye!");
		   } else {
		    System.out.println("Invalid option");
		   }

		  }

		 }


		 public static void menu() {
		  C206_CaseStudy.setHeader("C206_CaseStudy ");
		  System.out.println("1. View All Quotes");
		  System.out.println("2. Create a new Quotes");
		  System.out.println("3. Delete Quotes");
		  System.out.println("4. Quit");
		  Helper.line(80, "-");

		 }

		 public static void setHeader(String header) {
		  Helper.line(80, "-");
		  System.out.println(header);
		  Helper.line(80, "-");
		 }

		 public static String showStatus(boolean setStatus ) {
			  String qstatus;

			  if (setStatus == true) {
			   qstatus = "Yes";
		  } else {
		   qstatus = "No";
		  }
		  return qstatus;
		 }

		 // ================================= Option 1 View (CRUD - Read)
		 // =================================
		 public static String retrieveAllQuotes(ArrayList<Quotes> QuotesList) {
		  String output = "";

		for (int i = 0; i < QuotesList.size(); i++) {

		   output += String.format("%-10s %-10s %-20s %-10S\n", QuotesList.get(i).getname(), QuotesList.get(i).getPrice(), QuotesList.get(i).getDescription(), QuotesList.get(i).getStatus());
		     
		  }
		  return output;
		 }

		 public static void viewAllQuotes(ArrayList<Quotes> QuotesList) {
		  C206_CaseStudy.setHeader("QUOTES LIST");
		  String output = String.format("%-10s %-10s %-20s %-10s \n", "NAME", "PRICE", "DESCRIPTION", "STATUS");
		  output += retrieveAllQuotes(QuotesList);
		  System.out.println(output);
		 }

		 

		// ================================= Option 2 Add (CRUD -
		 // Create)=================================
		 public static Quotes inputQuotes(ArrayList<Quotes> QuotesList, Quotes q) {
		  String name = "Sam";
		  Double price = 100.00;
		  int SPID = 100;
		  int quote_ID = 100;
 		  String description = "Hello";
		  

		  Quotes q1 = new Quotes(name, SPID, quote_ID, price, description);
		  QuotesList.add(q1);
		  return q1;

		 }

	


		 // ================================= Option 3 Delete
		 // =================================
		 public static boolean DeleteQuote(ArrayList<Quotes> QuotesList, String name) {

		  boolean status = false;
		  if (QuotesList.isEmpty()) {
		        return status; // No quotes to delete
		    }
		  
		  for (int i = 0; i < QuotesList.size(); i++) {
		        if (name.equalsIgnoreCase(QuotesList.get(i).getname()) && QuotesList.get(i).getStatus()) {
		            QuotesList.get(i).setStatus(false); // Set the status to false to "delete" the quote
		            status = true; // Mark the quote as deleted
		            break; // Exit the loop since the quote is found and deleted
		        }
		    }
		    return status;
		 }


		public static boolean confirmDeleteQuotes(ArrayList<Quotes> quotesList, String deletedQuote, char c) {
			// TODO Auto-generated method stub
			return false;
		}
		 
}
		