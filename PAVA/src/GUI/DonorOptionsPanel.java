package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel for Donor options
 * @author Addison
 *
 */
public class DonorOptionsPanel extends JPanel {
	private String cardName;
	private String cardNum;
	private String cardEXP;
	public DonorOptionsPanel(String username) {
		super();
		setBackground(Color.GRAY);
		setLayout(new GridLayout(0,1)); 
		String donations = "";
		try {
	    	BufferedReader fileScanner = new BufferedReader(new FileReader("donorDatabase.csv"));	
	        String database;
	        while((database = fileScanner.readLine()) != null){
	           String[] users = database.split(",");
	           if (users[0].equals(username)) {
	        	   donations = users[2]; 
	        	   cardName = users[3];
	        	   cardNum = users[4];
	        	   cardEXP = users[6];
	           }
	        	   
	        }
	        fileScanner.close();
	   } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel donorName = new JLabel("Account Username: " + username);
		JLabel currCard = new JLabel("Current card on file: ");
		JLabel cardN = new JLabel("               Card Name: " + cardName);
		JLabel cardNumber = new JLabel("               Card Number: " + cardNum);
		JLabel cardE = new JLabel("               Card Expiration Date: " + cardEXP);
		
		JLabel amountDonated = new JLabel("Amount Donated: $" + donations);
		
		
		this.add(donorName);
		this.add(currCard);
		this.add(cardN);
		this.add(cardNumber);
		this.add(cardE);
		this.add(amountDonated);
	
	}		
}
