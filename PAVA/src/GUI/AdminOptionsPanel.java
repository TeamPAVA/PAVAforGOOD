package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel for admin options
 * @author Verena
 *
 */
public class AdminOptionsPanel extends JPanel{
	public AdminOptionsPanel () {
		super();
		setBackground(Color.GRAY);
		setLayout(new GridLayout (2,2));
		JLabel recName = new JLabel("Total Donated: ");
		recName.setFont(recName.getFont().deriveFont(25.0F));
		add(recName);

		File users = new File("donorDatabase.csv");
		 try {
		    	BufferedReader fileScanner = new BufferedReader(new FileReader(users));	
		        String database;
		        Double total = 0.0;
		        while((database = fileScanner.readLine()) != null){
		           String[] user = database.split(",");
		        		   total += Double.parseDouble(user[2]);
		        }
		        JLabel tot = new JLabel("$" +total);
		        add(tot);
		        fileScanner.close();
		   } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 /////////////////////////////////////////////////////////////////////////
		 int count = 0;
		 try {
		    	BufferedReader fileScanner = new BufferedReader(new FileReader(users));	
		        String database;
		        
		        while((database = fileScanner.readLine()) != null){
		        	count++;       
		        }
		        fileScanner.close();
		   } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		 JLabel recCount = new JLabel("Recipient Count: ");
			recCount.setFont(recCount.getFont().deriveFont(25.0F));
			add(recCount);
			
			JLabel rc = new JLabel(count + "");
			rc.setFont(rc.getFont().deriveFont(25.0F));
			add(rc);
			
			
		 
		 
		 
		 
		 
	}
}
