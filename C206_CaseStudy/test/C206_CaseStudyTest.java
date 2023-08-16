import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
		private User user1;
		private User user2;
		private ArrayList<User> userList;
    
		
		private Quotes q1;
		private Quotes q2;
		private ArrayList<Quotes> QuotesList;

		private ServiceProvider provider1;
		private ServiceProvider provider2;
		private static ArrayList<ServiceProvider> serviceProvider;
		
		private Request request1;
	    private Request request2;
	    private ArrayList<Request> requestList;
		
		@Before
		public void setUp()throws Exception {
			// prepare test data
			user1 = new User("user1", "user1@example.com", "password1", 123456789, "Address 1");
		    user2 = new User("user2", "user2@example.com", "password2", 987654321, "Address 2");
		    userList = new ArrayList<User>();
		    
		    provider1 = new ServiceProvider("user1", "user1@example.com", "Allbest Marine", "Renovator");
		    provider2 = new ServiceProvider("user2", "user2@example.com", "Allbest Equipment", "Designer");
		    serviceProvider = new ArrayList<ServiceProvider>();
		        
			q1 = new Quotes("Sam", 132, 123, 101, 100.0, "new quote", "Quote Created");
			q2 = new Quotes("Sam", 222, 333, 978, 1000.0, "new quote", "Quote Created");
			QuotesList= new ArrayList<Quotes>();
			
		
			request1 = new Request(4, "30/08/2023", "Quote for floor services", "18/09/2023", 1300);
			request2 = new Request(6, "31/08/2023", "Quote for installation services", "18/09/2023", 1400);
			requestList = new ArrayList<>();
		}
		
	    @Test
	    public void testAddUser() {
	     // Item list is not null, so that can add a new item - boundary
	        assertNotNull("Check if there is valid user arraylist to add to", userList);
	       //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	       //The item just added is as same as the first item of the list
	        C206_CaseStudy.addUser(userList, user1);
	        assertEquals("Test that user arraylist size is 1", 1, userList.size());
	        assertSame("Test that user is added", user1, userList.get(0));

	        // Test adding another user
	        C206_CaseStudy.addUser(userList, user2);
	        assertEquals("Test that user arraylist size is 2", 2, userList.size());
	        assertSame("Test that user is added", user2, userList.get(1));
	    }
		
	    @Test
	    public void testRetrieveAllUsers() {
	     // Test if Item list is not null but empty -boundary
	     assertNotNull("Test if there is valid User arraylist to retrieve item", userList);
	       
	     //test if the list of users retrieved from the SourceCentre is empty - boundary
	     String allUsers= C206_CaseStudy.retrieveAllUsers(userList);
	     String testOutput = "";
	     assertEquals("Check that ViewAllUserslist", testOutput, allUsers);
	       
	     //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
	     C206_CaseStudy.addUser(userList, user1);
	     C206_CaseStudy.addUser(userList, user2);
	     assertEquals("Test that User arraylist size is 2", 2, userList.size());
	       
	     //test if the expected output string same as the list of users retrieved from the SourceCentre 
	     allUsers= C206_CaseStudy.retrieveAllUsers(userList);
	     testOutput = String.format("%-20s %-30s %-15s %s\n", "user1", "user1@example.com", "123456789", "Address 1");
	     testOutput += String.format("%-20s %-30s %-15s %s\n", "user2", "user2@example.com", "987654321", "Address 2");
	      
	     assertEquals("Test that ViewAllCamcorderlist", testOutput, allUsers);
	    }
	    
	    @Test
	    public void testDeleteUser() {
	     assertNotNull("Check if there is valid user arraylist to delete from", userList);

	     // Adding users for testing
	     C206_CaseStudy.addUser(userList, user1);
	     C206_CaseStudy.addUser(userList, user2);

	     // Test deleting a user
	     String deletedUsername = user1.getUsername();
	     boolean isDeleted = C206_CaseStudy.confirmDeleteUser(userList, deletedUsername, 'y');
	     assertEquals("Test that user1 is deleted", true, isDeleted);
	     assertEquals("Test that user arraylist size is 1", 1, userList.size());
	     assertSame("Test that user2 is still in the list", user2, userList.get(0));

	     // Test cancelling the delete operation
	     String undeletedUsername = user2.getUsername();
	     isDeleted = C206_CaseStudy.confirmDeleteUser(userList, undeletedUsername, 'n');
	     assertEquals("Test that user2 is not deleted", false, isDeleted);
	     assertEquals("Test that user arraylist size is 1", 1, userList.size());
	     assertSame("Test that user2 is still in the list", user2, userList.get(0));

	     // Test attempting to delete a non-existent user
	     String nonexistentUsername = "nonexistentUser";
	     isDeleted = C206_CaseStudy.confirmDeleteUser(userList, nonexistentUsername, 'y');
	     assertEquals("Test that nonexistent user is not deleted", false, isDeleted);
	     assertEquals("Test that user arraylist size is still 1", 1, userList.size());
	     assertSame("Test that user2 is still in the list", user2, userList.get(0));
	     
	     }
	    @Test
	    public void testAddServiceProvider() {
	      // Adding a new service provider
	      // Given an empty list, after adding one service provider, the size of the list
	      // is 1- normal
	      C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
	      assertEquals("Test that the Service Provider arraylist size is 1.", 1, serviceProvider.size());
	      // Adding multiple service providers -boundary
	      C206_CaseStudy.addServiceProvider(serviceProvider, provider2);
	      assertEquals("Test that the Service Provider arraylist size is 2.", 2, serviceProvider.size());
	      // checking if the list size is 2
	      assertEquals(2, serviceProvider.size());
	      // Adding duplicate service providers -error
	      C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
	      assertSame("Test that the service provider added is as same as the previous item added", provider1,
	          serviceProvider.get(0));

	    }
	    @Test
	    public void testRetrieveAllServiceProvider() {
	      // Test Case 1
	      // Test if Item list is not null and empty-boundary
	      assertNotNull("Test if there is valid service provider arraylist to add to", serviceProvider);
	      assertEquals("Test that the serviceProvider arraylist is empty.", 0, serviceProvider.size());
	      // Attempt to retrieve the service providers
	      String allServiceProviders = C206_CaseStudy.retrieveAllServiceProvider(serviceProvider);
	      String testOutput = "";
	      // Test if the output is empty
	      assertEquals("Test that nothing is displayed", testOutput, allServiceProviders);
	      // Test Case 2
	      // Test if can retrieve service providers-normal
	      C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
	      C206_CaseStudy.addServiceProvider(serviceProvider, provider2);
	      // Test that the list is not empty
	      assertEquals("Test that ServiceProvider arraylist size is 2.", 2, serviceProvider.size());
	      // Attempt to retrieve the service providers
	      allServiceProviders = C206_CaseStudy.retrieveAllServiceProvider(serviceProvider);
	      testOutput = String.format("%s %-10s %-15s %-10s\n", "user1", "user1@example.com", "Allbest Marine", "Renovator");
	      testOutput += String.format("%s %-10s %-15s %-10s\n", "user2", "user2@example.com", "Allbest Equipment", "Designer");
	      // Test that the details are displayed correctly
	      assertEquals("Test that the display is correct.", testOutput, allServiceProviders);
	      // Test Case 3
	      // Test can view service providers with updated list- normal
	      // Add new provider
	      ServiceProvider newProvider = new ServiceProvider("user3", "user3@gmail.com", "Allbest delivery", "Constructor");
	      C206_CaseStudy.addServiceProvider(serviceProvider, newProvider);
	      // Attempt to retrieve the service providers
	      allServiceProviders = C206_CaseStudy.retrieveAllServiceProvider(serviceProvider);
	      testOutput = String.format("%s %-10s %-15s %-10s\n", "user1", "user1@example.com", "Allbest Marine", "Renovator");
	      testOutput += String.format("%s %-10s %-15s %-10s\n", "user2", "user2@example.com", "Allbest Equipment", "Designer");
	      testOutput += String.format("%s %-10s %-15s %-10s\n", "user3", "user3@gmail.com", "Allbest delivery", "Constructor");
	      // Test that the details are displayed correctly
	      assertEquals("Test that the display is correct.", testOutput, allServiceProviders);
	    }
	    
	    @Test
	    public void testDeleteServiceProvider() {
	     assertNotNull("Check if there is valid service provider arraylist to delete from", serviceProvider);

	     // Adding service providers for testing
	     C206_CaseStudy.addServiceProvider(serviceProvider, provider1);
	     C206_CaseStudy.addServiceProvider(serviceProvider, provider2);

	     // Test delete a service provider
	     String deletedUsername = provider1.getUsername();
	     boolean isDeleted = C206_CaseStudy.confirmDeleteServiceProvider(serviceProvider, deletedUsername, 'y');
	     assertEquals("Test that user1 is deleted", true, isDeleted);
	     assertEquals("Test that user arraylist size is 1", 1, serviceProvider.size());
	     assertSame("Test that user2 is still in the list", provider2, serviceProvider.get(0));

	     // Test to cancel deletion 
	     String undeletedUsername = provider2.getUsername();
	     isDeleted = C206_CaseStudy.confirmDeleteServiceProvider(serviceProvider, undeletedUsername, 'n');
	     assertEquals("Test that user2 is not deleted", false, isDeleted);
	     assertEquals("Test that user arraylist size is 1", 1, serviceProvider.size());
	     assertSame("Test that user2 is still in the list", provider2, serviceProvider.get(0));

	     // Test deleting a service provider thats not in the list
	     String nonexistentServiceProvider = "nonexistentServiceProvider";
	     isDeleted = C206_CaseStudy.confirmDeleteServiceProvider(serviceProvider, nonexistentServiceProvider, 'y');
	     assertEquals("Test that nonexistent user is not deleted", false, isDeleted);
	     assertEquals("Test that user arraylist size is still 1", 1, serviceProvider.size());
	     assertSame("Test that user2 is still in the list", provider2, serviceProvider.get(0));
	     
	    }
	    @Test
	    public void testAddRequest() { 
			// Valid Request ArrayList is not null and it is empty. (boundary)
			// Size of the ArrayList is 0.
			assertNotNull("Test if there is valid request ArrayList to add to", requestList);
			assertEquals("Test that the Request ArrayList is empty.", 0, requestList.size());

			// Add an request item in Request ArrayList (normal)
			// Size of the ArrayList would be 1.
			C206_CaseStudy.addRequest( requestList, request1);
			assertEquals("Test that the Request arraylist size is now 1.", 1, requestList.size());
			assertSame("Test that the new Request is added successfully to the list.", request1, requestList.get(0));

			// Add a Request item in Request ArrayList where that request item is already added(error)
			// Size of the Request ArrayList would be 1.
			assertEquals("Test that the Request arraylist size is 1.", 1, requestList.size());
			C206_CaseStudy.addRequest(requestList, request1);
			assertEquals("Test that the Request arraylist size is still 1.", 1, requestList.size());
				
			// Add an request that has missing detail(error)
			// "" - Description  has empty fields
			// Size of the ArrayList would remain as 1.
			Request missingDescription = new Request(41, "19/08/23", "", "30/08/2023", 3000);
			C206_CaseStudy.addRequest(requestList,missingDescription );
			assertEquals("Test that the Request arraylist size is unchange.", 1, requestList.size());

		}
	    
	    
	    @Test
	    public void testRetrieveAllRequest() { 
			// Test Case 1
			// Test if Request list is not null and empty (Boundary)
			assertNotNull("Test if there is a valid request arraylist to add to", requestList);
			assertEquals("Test that the request arraylist is empty.", 0, requestList.size());

			// Test Case 2
			// Retrieve the requestList (Boundary)
			String allRequest = C206_CaseStudy.retriveAllRequest(requestList);
			String testing = "";
			// Test if the output is empty (Boundary)
			assertEquals("Test that nothing is displayed", "", allRequest);

			// Test Case 3
			// Add 2 request in requestList (Normal)
			C206_CaseStudy.addRequest(requestList, request1);
			C206_CaseStudy.addRequest(requestList, request2);
			
			// Test that the list is NOT empty. ArrayList size = 2.
			assertEquals("Test that Request arraylist size is 2.", 2, requestList.size());
			// Retrieve the requestList
			allRequest = C206_CaseStudy.retriveAllRequest(requestList);
			
			testing += String.format("%-15d %-20s %-30s %-20s %-23d\n", request1.getCustId(),
				    "30/08/2023", "Quote for floor services", "18/09/2023", 1300);
			testing += String.format("%-15d %-20s %-30s %-20s %-23d\n", request2.getCustId(), 
			        "31/08/2023", "Quote for installation services", "18/09/2023", 1400);

			// Test that the details display accurately
			assertEquals("Test that the display is correct.", testing, allRequest);
			
			
			

		}
		
	    
	    
	    @Test
	    public void testRemoveRequest() { 
			// Test if the request list is not null and empty (boundary)
			assertNotNull("Test if there is valid request ArrayList to remove", requestList);

			C206_CaseStudy.addRequest(requestList, request1); // add request (test to remove)
			// Remove existing Request (normal)
			Boolean confirm = C206_CaseStudy.RemoveRequest(requestList, request1.getCustId());
			assertTrue("Test if an existing request confirms to delete?", confirm);

			// Remove existing request AGAIN (error)
			confirm = C206_CaseStudy.RemoveRequest(requestList, 15);
			assertFalse("Test if an existing request is NOT confirmed to delete again?", confirm);

			// Remove non-existing request (error)
			confirm = C206_CaseStudy.RemoveRequest(requestList, 20);
			assertFalse("Test that non-existing request is NOT confirmed to delete?", confirm);
		}

	    
	    @Test
	    public void testAddQuote () {
	      // Adding a new service provider
	      // Given an empty list, after adding one service provider, the size of the list
	      // is 1- normal
	      inputQuotes();
	      assertEquals("Test that the Quote arraylist size is 1.", 1, QuotesList.size());
	      // Adding multiple service providers -boundary
	      inputQuotes();
	      assertEquals("Test that the quote arraylist size is 2.", 2, serviceProvider.size());
	      // checking if the list size is 2
	      assertEquals(2, QuotesList.size());
	      // Adding duplicate quote -error
	      inputQuotes();
	      assertSame("Test that the quote added is as same as the previous code", q1,
	          QuotesList.get(0));

	    }

		private void inputQuotes() {
			C206_CaseStudy.inputQuotes(QuotesList, q1);
		}
	
		@Test
		public void testRetrieveAllQuotes() {
			// Test if Item list is not null but empty -boundary
			assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", QuotesList);
			
			//test if the list of quotes retrieved from the CaseStudy is empty - boundary
			String allQuotes= C206_CaseStudy.retrieveAllQuotes(QuotesList);
			String testOutput = C206_CaseStudy.retrieveAllQuotes(QuotesList);
			assertEquals("Check that ViewAllQuoteslist", testOutput, allQuotes);
			
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			inputQuotes();
			C206_CaseStudy.inputQuotes(QuotesList, q2);
			assertEquals("Test that Camcorder arraylist size is 2", 2, QuotesList.size());
			
			//test if the expected output string same as the list of quotes retrieved from the CaseStudy	
			allQuotes= C206_CaseStudy.retrieveAllQuotes(QuotesList);
			testOutput = String.format("%-20s %-10s %-10s %-10S %-10s ","CC0012", "Sony DSC-RX100M7", "Yes", "", "20" );
			testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0012", "Sony DSC-RX100M7", "Yes", "", "20" );
		
			assertEquals("Test that ViewAllCamcorderlist", testOutput, allQuotes);
			
		}
		
		
		@Test
	    public void testDeleteQuote_Success() {
			 assertNotNull("Check if there is valid quote arraylist to delete from", QuotesList);

			 // Adding quote for testing
		     inputQuotes();
		     C206_CaseStudy.inputQuotes(QuotesList, q2);
			
		     // Test deleting a quote
		     String deletedQuote = q1.getname();
		     boolean isDeleted = C206_CaseStudy.confirmDeleteQuotes(QuotesList, deletedQuote, 'y');
		     assertEquals("Test that user1 is deleted", true, isDeleted);
		     assertEquals("Test that user arraylist size is 1", 1, QuotesList.size());
		     assertSame("Test that user2 is still in the list", q2, QuotesList.get(0));
		     
		     // Test to cancel deletion 
		     String undeletedQuotes = q2.getname();
		     isDeleted = C206_CaseStudy.confirmDeleteQuotes(QuotesList, undeletedQuotes, 'n');
		     assertEquals("Test that user2 is not deleted", false, isDeleted);
		     assertEquals("Test that user arraylist size is 1", 1, QuotesList.size());
		     assertSame("Test that user2 is still in the list", q2, QuotesList.get(0));
		     
		     // Test deleting a quote thats not in the list
		     String nonexistentQuotes= "nonexistentQuote";
		     isDeleted = C206_CaseStudy.confirmDeleteQuotes(QuotesList, nonexistentQuotes, 'y');
		     assertEquals("Test that nonexistent quote is not deleted", false, isDeleted);
		     assertEquals("Test that quote arraylist size is still 1", 1, QuotesList.size());
		     assertSame("Test that q2 is still in the list", q2, QuotesList.get(0));
			
	    }
		
		
		
		@After
		public void tearDown() throws Exception {
			user1 = null;
			user2 = null;
			userList = null;
			
			provider1 = null;
			provider2 = null;
			serviceProvider = null;
			    
			q1 = null;
			q2 = null;
			QuotesList = null;

		}
		
		  @Test
		  public void c206_test() {
		    //fail("Not yet implemented");
		    assertTrue("C206_CaseStudy_SampleTest ",true);
		  }


	}
