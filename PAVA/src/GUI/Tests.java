package GUI;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * JUnit testing
 * @author Adrian, Addison, Patrick, Verena, Phillip
 *
 */
public class Tests {

	@Test
	public void familyUpdateCSVTest() {
		FamilyUpdatePanel tester = new FamilyUpdatePanel(1); // MyClass is tested

		// assert statements
		assertEquals("There is a 1 line in the FamStoriesDatabase", true, tester.loadIn(1));
		assertEquals("There is not a 10 line in the FamStoriesDatabase", false, tester.loadIn(10));
	}
	
	public double donorPanelTestFramework(double testVal) {
		DonorPanel tester = new DonorPanel("admin"); // MyClass is tested
		tester.recipientData(testVal);
		double total = 0;
		
		try {
	    	BufferedReader fileScanner = new BufferedReader(new FileReader(new File("recipientDatabase.csv")));	
	        String database;
	        while((database = fileScanner.readLine()) != null){
	           String[] user = database.split(",");
	        	   if (user[0].equals("admin")) {
	        		   total = Double.parseDouble(user[2]);
		            }
	        }
	        fileScanner.close();
	   } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	   }
		return total;
	}
	
	@Test
	public void donorPanelTest() {
		// assert statements
		assertEquals("With one Recipient TOTAL should equal input!", 10, (int) donorPanelTestFramework((double) 10));
	}
	
}