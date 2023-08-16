import java.util.ArrayList;


public class C206_CaseStudy {

	
		// TODO Auto-generated method stub
		 
		private static final int OPTION_QUIT = 15;
		private static final boolean True = false;
		private static final Quotes Quotes = null;
		
		
		 public static void main(String[] args) {
			 
		// Define a list to store users
		  ArrayList<User> userList = new ArrayList<User>();
		  userList.add(new User("Eric", "eric1205@gmail.com", "Pas#686213*", 23456678, "AB street CD city DE state"));
		  userList.add(new User("Rachel", "rachel0520@gmail.com", "Vop$32478%", 67763892, "AA street BB city CC state"));
		    
		  
		 // Define a list to store quotes
		 ArrayList<Quotes> QuotesList = new ArrayList<Quotes>();
		 Quotes newQuote = new Quotes("Sam", 132, 101, 123, 100.0, "new quote", "Quote created");

		 QuotesList.add(newQuote);
		 
		 
		// Define a list to store service provider
		 ArrayList<ServiceProvider> serviceProvider = new ArrayList<ServiceProvider>();
		 ServiceProvider provider1 = new ServiceProvider("user1", "user1@example.com", "Allbest Marine", "Renovator");
	   	 ServiceProvider provider2 = new ServiceProvider("user2", "user2@example.com", "Allbest Equipment", "Designer");

		 serviceProvider.add(provider1);
		 serviceProvider.add(provider2);
		 
		 
		// Define a list to store request
		 ArrayList<Request> requestList = new ArrayList<Request>();
		
	    // Adding requests
		requestList.add(new Request(1, "11/08/2023", "Quote for plumbing services", "15/08/2023", 1000));
		requestList.add(new Request(2, "12/08/2023", "Quote for electrical repair", "20/08/2023", 800));
		requestList.add(new Request(3, "13/08/2023", "Quote for painting job", "18/08/2023", 1200));
		
		
		 ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

		  int option = 0;

		  while (option != OPTION_QUIT) {

		   C206_CaseStudy.menu();
		   option = Helper.readInt("Enter an option > ");
		   
		   if (option == 1) {
               // Add a new user
            setHeader("ADD USER");
            User newUser = inputUser();
            if (newUser != null) {
                   C206_CaseStudy.addUser(userList, newUser);
               }
            
           } else if (option == 2) {
            // View all users
            C206_CaseStudy.viewAllUsers(userList);
               
           } else if (option == 3) {
               // Delete an existing user
            setHeader("DELETE USER");
               C206_CaseStudy.deleteUser(userList);
		   
           } else if (option == 4) {
				// Add service provider
				ServiceProvider newProvider = inputProvider();
				
				for(ServiceProvider provider : serviceProvider) {
					if(newProvider.equals(serviceProvider)) {
						System.out.println("There is an existing service provider");
					}else {
						C206_CaseStudy.addServiceProvider(serviceProvider, newProvider);
					}
				}
				
			} else if (option == 5) {
				// View all service providers
				C206_CaseStudy.viewServiceProviders(serviceProvider);
			} else if (option == 6) {
				//Display list of service providers to choose from
				C206_CaseStudy.viewServiceProviders(serviceProvider);
				// Delete an existing service provider
				C206_CaseStudy.deleteServiceProvider(serviceProvider);

			} else if (option == 7) {
				
				C206_CaseStudy.viewAllRequest(requestList);
		
			}else if (option == 8) {
				
				C206_CaseStudy.inputQuotes(QuotesList, Quotes);
			
				
			}else if (option == 9) {
				
				C206_CaseStudy.inputCourseDetails();
			
				
			}else if (option == 10) {
		    // View all items
		    C206_CaseStudy.viewAllQuotes(QuotesList);
		   

		   } else if (option == 11) {
		    // 
			C206_CaseStudy.inputQuotes(QuotesList, null);
		    

		    } else if (option == 12) {
		     
		    	C206_CaseStudy.DeleteQuotes(QuotesList, null);
		     String nameToDelete = Helper.readString("Enter name of quote to delete > ");


		   } else if (option == 4) {
		        // View all items
		        C206_CaseStudy.viewAllAppointments(appointmentList);

		      } else if (option == 5) {
		        //
		        C206_CaseStudy.addAppointments(appointmentList);


		        } else if (option == 6) {
		           C206_CaseStudy.deleteAppointment(appointmentList, null);
		     String nameToDelete = Helper.readString("Enter name of Appointment to delete > ");
		    
		    
		        }else if (option == OPTION_QUIT) {
		    System.out.println("Bye!");
		   } else {
		    System.out.println("Invalid option");
		   }

		  }

		 }
		 
		 
		 private static void DeleteQuotes(ArrayList<Quotes> quotesList, Object object) {
			// TODO Auto-generated method stub
			
		}


		public static void menu() {
		  C206_CaseStudy.setHeader("RENOVATION PORTAL APP");
		  System.out.println("1. Add user");
		  System.out.println("2. Display Users");
		  System.out.println("3. Delete user");
		  System.out.println("4. Add service provider");
		  System.out.println("5. View all service provider");
		  System.out.println("6. Delete an existing service provider");
		  System.out.println("7. View All Request");
		  System.out.println("8. Add Request");
		  System.out.println("9. Delete Request");
		  System.out.println("7. View All Quotes");
		  System.out.println("8. Create a new Quotes");
		  System.out.println("9. Delete Quotes");
		  System.out.println("15. Quit");
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
		 
		 //=================================== Option 1 Add user ===========================================
		 public static User inputUser() {

		        String username = "";
		        boolean validusername = false; 
		        while (!validusername){
		            username =  Helper.readString("Enter username > ");
		            if (username.length() > 8) {
		                validusername = true;
		            } else {
		                System.out.println("Invalid username. Please enter more than 8 characters.");
		            }
		        }
		        
		        String email = "";
		        boolean validemail = false; 
		        while (!validemail){
		            email =  Helper.readString("Enter email > ");
		            if (email.contains("@")&&email.contains(".")) {
		                validemail = true;
		            } else {
		                System.out.println("Invalid email.");
		            }
		        }
		        
		        String password = "";
		        boolean validpassword = false; 
		        while (!validpassword){
		            password =  Helper.readString("Enter password > ");
		            if (password.length() > 8 ) {
		                validpassword = true;
		            } else {
		                System.out.println("Invalid password. Please enter more than 8 characters.");
		            }
		        }
		        
		        int contactNumber = Helper.readInt("Enter contact number > ");
		        boolean validContactNumber = false;

		        while (!validContactNumber) {
		            String cnum = String.valueOf(contactNumber);
		            if (cnum.length() == 8 && contactNumber > 0) {
		                validContactNumber = true;
		            } else {
		                System.out.println("Invalid contact number. Please enter a positive 8-digit integer.");
		                contactNumber = Helper.readInt("Enter contact number > ");
		            }
		        }
		        
		        String address = "";
		        boolean validaddress = false; 
		        while (!validaddress){
		            address =  Helper.readString("Enter address > ");
		            if (!address.isEmpty() ) {
		                validaddress = true;
		            } else {
		                System.out.println("Invalid address. Cannot be empty address.");
		            }
		        }
		          

		         User newUser = new User(username, email, password,contactNumber , address);
		         return newUser;
		     }
		 
		 public static void addUser(ArrayList<User> userList, User newUser) {
		      if (newUser != null) { // Check if newUser is not null
		          for (int i = 0; i < userList.size(); i++) {
		              User existingUser = userList.get(i);
		              if (existingUser.getUsername().equalsIgnoreCase(newUser.getUsername())) {
		                  System.out.println("Username already exists. User not added.");
		                  return;
		              }
		          }
		          System.out.println("User added");
		          userList.add(newUser);
		      }
		  }
		  
		 //=================================== Option 2 View users ===========================================
		  public static String retrieveAllUsers(ArrayList<User> userList) {
		      String output = "";

		      for (int i = 0; i < userList.size(); i++) {
		          User user = userList.get(i);
		          output += String.format("%-20s %-30s %-15s %s\n",
		              user.getUsername(), user.getEmail(), user.getContactNumber(), user.getAddress());
		      }

		      return output;
		  }
		 
		  public static void viewAllUsers(ArrayList<User> userList) {
		      setHeader("USER LIST");
		      String output = String.format("%-20s %-30s %-15s %s\n", "Username", "Email", "Contact", "Address");
		      output += retrieveAllUsers(userList);
		      System.out.println(output);
		  }
		  
		//=================================== Option 3 Delete user ===========================================
		  
		  public static boolean confirmDeleteUser(ArrayList<User> userList, String username, char confirm) {
		    
		   for (int i = 0; i < userList.size(); i++) {
		              User user = userList.get(i);
		     if (user.getUsername().equalsIgnoreCase(username)) {
		               if(confirm == 'y' || confirm == 'Y') {
		                userList.remove(user);
		                return true;
		               }
		              }
		          }
		          return false;
		   }
		  
		  
		  public static void deleteUser(ArrayList<User> userList) {
			    String username = Helper.readString("\nEnter Username to delete: ");
			    char confirm = Helper.readChar("Are you sure do you want to delete (y/n): ");
			          boolean isDeleted = confirmDeleteUser(userList, username, confirm);
			          
			          if (isDeleted) {
			           System.out.println("\n* User has been deleted successfully. *\n");
			          }else if(confirm == 'n' || confirm == 'N') {
			           System.out.println("\n* Deletion cancel! *\n");
			          }else {
			              System.out.println("\n* Invalid User! *\n");
			          }
			}
		  
		  
		  public static ServiceProvider inputProvider() {
				String username = Helper.readString("Enter username >");
				String email = Helper.readString("Enter email >");
				String company = Helper.readString("Enter company >");
				String credentials = Helper.readString("Enter credentials >");
				

				ServiceProvider newProvider = new ServiceProvider(username, email, company, credentials);
				return newProvider;

			}

		  
			public static void addServiceProvider(ArrayList<ServiceProvider> serviceProvider, ServiceProvider newProvider) {
				serviceProvider.add(newProvider);
			}
			
			
			public static String retrieveAllServiceProvider(ArrayList<ServiceProvider> serviceProvider) {
				String output = "";
				
				for (ServiceProvider provider : serviceProvider) {
					output += String.format("%s %-10s %-15s %-10s\n", provider.getUsername(),
							 provider.getEmail(), provider.getCompany(), provider.getCredentials());
				}
				return output;
				
			}

			
			public static void viewServiceProviders(ArrayList<ServiceProvider> serviceProvider) {
				System.out.println("SERVICE PROVIDER LIST");
				String output = String.format("%s %-10s %-15s %-10s", "Username",
						"Email", "Company", "Credentials");
				output += retrieveAllServiceProvider(serviceProvider);
				System.out.println(output);
			}
			
			
			public static boolean confirmDeleteServiceProvider(ArrayList<ServiceProvider> serviceProvider, String username, char confirm) {
				for(int i =0; i < serviceProvider.size(); i++) {
					ServiceProvider provider = serviceProvider.get(i);
					 if (provider.getUsername().equalsIgnoreCase(username)) {
			               if(confirm == 'y' || confirm == 'Y') {
			                serviceProvider.remove(provider);
			                return true;
			               }
			              }
			          }
			          return false;
				}
			
			
			public static void deleteServiceProvider(ArrayList<ServiceProvider> serviceProvider) {
				String username = Helper.readString("\nEnter Username to delete: ");
			    char confirm = Helper.readChar("Are you sure do you want to delete (y/n): ");
			          boolean isDeleted = confirmDeleteServiceProvider(serviceProvider, username, confirm);
			          
			          if (isDeleted) {
			           System.out.println("\n* User has been deleted successfully. *\n");
			          }else if(confirm == 'n' || confirm == 'N') {
			           System.out.println("\n* Deletion cancel! *\n");
			          }else {
			              System.out.println("\n* Invalid User! *\n");
			          }
				
			}
			
			public static void viewAllRequest(ArrayList<Request> requestList) {
				setHeader(" VIEW ALL REQUEST ");
							String output = "";
							String format = "%-15s %-20s %-20s %-15s\n";	// Extract Variables
					
							output += (String.format(format, "===========", "===========", "===========", "=========="));
							output += (String.format(format, "CustomerID", "RequestDate", "Description", "StartDate", "Budget"));
							output += (String.format(format, "===========", "===========", "===========", "=========="));
							
							
							output += retriveAllRequest(requestList);
							System.out.println(output);

							Helper.line(140, "-");
			}

			public static String retriveAllRequest(ArrayList<Request> requestList) {
				String output = "";

				for (int i = 0; i < requestList.size(); i++) {
					Request req = requestList.get(i);			// Extract Variables
					output += String.format("%-15d %-20s %-20s %-23s\n", req.getCustId(),
							req.getrequestDate(), req.getdescription(),req.getEstStartDate(),req.getEstBudet());
				}
				return output;
			}
						
			// ====================== Add Request ======================
			// Add request
			public static Request inputCourseDetails() {

				int Id = Helper.readInt("Enter Customer ID > ");
				String RequestDate = Helper.readString("Enter Requested Date > ");
				String Description = Helper.readString("Enter Description > ");
				String StartDate = Helper.readString("Enter Start Date > ");
				int Budget = Helper.readInt("Enter Budget > ");
				
				// Create a new course object with the entered information.
				Request req = new Request(Id, RequestDate, Description, StartDate, Budget);
				System.out.println("Request added");
				return req;
			}

			public static void addRequest(ArrayList<Request> requestList, Request req) {
				Request requestAdded;
				
				// Check to see if the course already exists in the list.
				for (int i = 0; i < requestList.size(); i++) {
					requestAdded = requestList.get(i);
					if (requestAdded.getCustId() == req.getCustId()|| (requestAdded.getEstBudet() == req.getEstBudet())) {
						// The course code already exists, don't add it again to course list.
						System.out.println("course code  existed !!");
						return;
					}
				}
				// Check to make sure that the description and dates are not empty.
				if (req.getrequestDate().isEmpty() || (req.getdescription().isEmpty()) || (req.getEstStartDate().isEmpty())) {
					// The course code and course title is empty, don't add them in
					// course ArrayList.
					System.out.println(" Customer ID and Description cant be empty!");
					return;
				}

				// Add the new course to the list when everything is correctly filled in.
				requestList.add(req);

			}
			
							
			// ====================== Delete/Remove Request ======================
			// Delete Request 
			
			public static boolean RemoveRequest(ArrayList<Request> requestList, int CustId) {
				boolean isWithdraw = false;

				if (CustId < 1) {
					return false;
				}

				for (int i = 0; i < requestList.size(); i++) {
					
					
					if (CustId == requestList.get(i).getCustId()) {
						requestList.remove(requestList.get(i));
						isWithdraw = true;
						break;
					}
				}

				return isWithdraw;

			}
			
			public static void RemoveRequest(ArrayList<Request> requestList) { 

				viewAllRequest(requestList);

				int CustId = Helper.readInt("Enter Customer ID  > ");
				char confirm = Helper.readChar("Are you sure to delete this Customer ID " + CustId + "? (Y/N) > ");
				if (confirm == 'Y' || confirm == 'y') {

					// If user confirm to delete, call the RemoveRequest() method to remove the
					// Request from the list.
					Boolean withdraw = RemoveRequest(requestList, CustId);

					// If the Request was successfully removed, print a message to confirm.
					if (withdraw) { // withdraw == true
						System.out.println("\n Custoemr Requests " + CustId + " successfully delete!\n");
					}
					// Otherwise, print a message to indicate that the Request id is invalid.
					else {
						System.out.println("\nInvalid Custommer ID .\n");
					}
				}

			}


		 
		 // ================================= View Quote  =================================
		
		 public static String retrieveAllQuotes(ArrayList<Quotes> QuotesList) {
		  String output = "";

		for (int i = 0; i < QuotesList.size(); i++) {

		   output += String.format("%-10s %-10s %-20s %-10S\n", QuotesList.get(i).getname(), QuotesList.get(i).getQuote_ID(),
				   QuotesList.get(i).getPrice(), QuotesList.get(i).getDescription());
		     
		  }
		  return output;
		 }

		 public static void viewAllQuotes(ArrayList<Quotes> QuotesList) {
		  C206_CaseStudy.setHeader("QUOTES LIST");
		  String output = String.format("%-10s %-10s %-20s %-10s %-20s \n", "NAME", "Quote ID","Request ID","PRICE", "DESCRIPTION");
		  output += retrieveAllQuotes(QuotesList);
		  System.out.println(output);
		 }

		 

		// ================================= Add Quote  =================================
	
		 public static void inputQuotes(ArrayList<Quotes> QuotesList, Quotes q) {
			 String name = "";
		        boolean validQuote = false; 
		        while (!validQuote){
		            name =  Helper.readString("Enter Name of Quote > ");
		            if (name != Quotes.getname() ) {
		                validQuote = true;
		            } else {
		                System.out.println("This quote name have already been used");
		            }
		            
		            int SP_ID = 0;
		            SP_ID =  Helper.readInt("Enter ID of service provider> ");
		            int request_ID = 0;
		            SP_ID =  Helper.readInt("Enter ID of Request> ");
		            int quote_ID = 0;
		            SP_ID =  Helper.readInt("Enter ID of service provider> ");
		            double price = 0.0;
		            price =  Helper.readDouble("Enter the price> ");
		            String description = "";
		            description =  Helper.readString("Enter the description> ");
		            String status="Quote created";
		            

		  Quotes q1 = new Quotes(name, SP_ID, request_ID, quote_ID, price, description,status);
		  QuotesList.add(q1);
		  

		 }

		}


		 // ================================= Delete Quote =================================
		 
		 public static boolean DeleteQuote(ArrayList<Quotes> QuotesList, String name) {

		  boolean status = false;
		  String userinput = "";
		  if (QuotesList.isEmpty()) {
		        return status; // No quotes to delete
		    }
		  
		  for (int i = 0; i < QuotesList.size(); i++) {
		        if (QuotesList.get(i).getname() == userinput) {
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
		
		// option 4 View appointments
		  public static String retrieveAllAppointments(ArrayList<Appointment> appointmentList) {
		    String output = "";

		    for (int i = 0; i < appointmentList.size(); i++) {

		      output += String.format("%-.2f %-10s %-20s %-10s\n", appointmentList.get(i).getAppointmentTime(),
		          appointmentList.get(i).getAppointmentStatus(), appointmentList.get(i).getAppointmentName(),
		          appointmentList.get(i).getCustomerID());
		    }
		    return output;
		  }

		  public static void viewAllAppointments(ArrayList<Appointment> appointmentList) {
		    C206_CaseStudy.setHeader("Appointment LIST");
		    String output = String.format("%-10s %-10s %-20s %-10s \n", "Time", "Status", "Name", "ID");
		    output += retrieveAllAppointments(appointmentList);
		    System.out.println(output);
		  }

		  // option 5 Add appointments
		  public static void addAppointments(ArrayList<Appointment> appointmentList) {
		      C206_CaseStudy.setHeader("ADD NEW APPOINTMENT");
		      
		      // Gather input from the user
		      double appointmentTime = Helper.readDouble("Enter appointment time: ");
		      String appointmentStatus = Helper.readString("Enter appointment status: ");
		      String appointmentName = Helper.readString("Enter appointment name: ");
		      int customerID = Helper.readInt("Enter customer ID: ");
		      
		      // Create a new Appointment object
		      Appointment newAppointment = new Appointment(appointmentName, customerID, appointmentTime, appointmentStatus, appointmentName, customerID);
		      
		      // Add the new appointment to the list
		      appointmentList.add(newAppointment);
		      
		      System.out.println("New appointment added successfully!");
		      }








		  // option 6 delete appointments
		//================================= Option 6 Delete appointments =================================
		  public static boolean deleteAppointment(ArrayList<Appointment> appointmentList, String appointmentName) {
		    boolean status = false;

		    for (int i = 0; i < appointmentList.size(); i++) {
		      if (appointmentList.get(i).getAppointmentName().equalsIgnoreCase(appointmentName)) {
		        appointmentList.remove(i);
		        status = true;
		        break;
		      }
		      
		    }
		    return status;
		  }
		 
		 
}
		