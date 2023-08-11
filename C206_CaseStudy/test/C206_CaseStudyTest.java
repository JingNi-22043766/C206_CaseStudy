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
		private Quotes q1;
		private Quotes q2;
		
		private ArrayList<Quotes> QuotesList;

		
		public C206_CaseStudyTest() {
			super();
		}
		
		@Before
		public void setUp() {
			// prepare test data
			q1 = new Quotes("Sam", 132, 123, 100.0, "new quote");
			q2 = new Quotes("Sam", 222, 333, 1000.0, "new quote");
			QuotesList= new ArrayList<Quotes>();
			
		}

		
		@Test
		public void testRetrieveAllQuotes() {
			// Test if Item list is not null but empty -boundary
			assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", QuotesList);
			
			//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
			String allQuotes= C206_CaseStudy.retrieveAllQuotes(QuotesList);
			String testOutput = C206_CaseStudy.retrieveAllQuotes(QuotesList);
			assertEquals("Check that ViewAllQuoteslist", testOutput, allQuotes);
			
			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
			C206_CaseStudy.inputQuotes(QuotesList, q1);
			C206_CaseStudy.inputQuotes(QuotesList, q2);
			assertEquals("Test that Camcorder arraylist size is 2", 2, QuotesList.size());
			
			//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
			allQuotes= C206_CaseStudy.retrieveAllQuotes(QuotesList);
			testOutput = String.format("%-20s %-10s %-10s %-10S %-10s ","CC0012", "Sony DSC-RX100M7", "Yes", "", "20" );
			testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CC0012", "Sony DSC-RX100M7", "Yes", "", "20" );
		
			assertEquals("Test that ViewAllCamcorderlist", testOutput, allQuotes);
			
		}
		
		
		@Test
	    public void testDeleteQuote_Success() {
			 assertNotNull("Check if there is valid service provider arraylist to delete from", QuotesList);

		    
		     C206_CaseStudy.inputQuotes(QuotesList, q1);
		     C206_CaseStudy.inputQuotes(QuotesList, q2);
			
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
		     
		     // Test deleting a service provider thats not in the list
		     String nonexistentQuotes= "nonexistentServiceProvider";
		     isDeleted = C206_CaseStudy.confirmDeleteQuotes(QuotesList, nonexistentQuotes, 'y');
		     assertEquals("Test that nonexistent quote is not deleted", false, isDeleted);
		     assertEquals("Test that quote arraylist size is still 1", 1, QuotesList.size());
		     assertSame("Test that q2 is still in the list", q2, QuotesList.get(0));
			
	    }
		
		@After
		public void tearDown() throws Exception {
			q1 = null;
			q2 = null;
			QuotesList = null;

		}
		
		
	

	}
