package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecipientOptionsPanel extends JPanel {
	public RecipientOptionsPanel (String username) {
		super();
		File users = new File("recipientDatabase.csv");

		
		
		setBackground(Color.GRAY);
		setLayout(new GridLayout (3,2));
		JLabel recName = new JLabel("Recipient Name: ");
		recName.setFont(recName.getFont().deriveFont(25.0F));
		add(recName);
		JLabel name = new JLabel(username);
		add(name);
		
		JLabel currentRemBal = new JLabel("Current Remaining Balance On Card: ");
		currentRemBal.setFont(recName.getFont().deriveFont(20.0F));
		add(currentRemBal);
		double total = 0;
				 try {
				    	BufferedReader fileScanner = new BufferedReader(new FileReader(users));	
				        String database;
				        while((database = fileScanner.readLine()) != null){
				           String[] user = database.split(",");
				        	   if (user[0].equals(username)) {
				        		   total = Double.parseDouble(user[2]);
				        		   JLabel tot = new JLabel("$" + user[2]);
				        		   add(tot);
					            }
				        }
				        fileScanner.close();
				   } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
		 JLabel totalRecieved = new JLabel("Total Recieved To Date: ");
		 totalRecieved.setFont(recName.getFont().deriveFont(20.0F));
		 add(totalRecieved);	
		 
		 
		 JLabel totalView = new JLabel("$" + total);
		 add(totalView);
		 
				
				 
		
//		setLayout(null); //POSSIBLY GOING TO CHANGE TO GRID LAYOUT
//		
//		
//		JLabel recName = new JLabel("Recipient Name: ");
//		recName.setFont(recName.getFont().deriveFont(25.0F));
//		recName.setBounds(30, 40, 200, 100);
		
//		JLabel currentRemBal = new JLabel("Current Remaining Balance On Card: ");
//		currentRemBal.setFont(recName.getFont().deriveFont(20.0F));
//		currentRemBal.setBounds(30,80,400,100);
//		JLabel amtToDate = new JLabel("Total Amount Recieved To Date: ");
//		amtToDate.setFont(recName.getFont().deriveFont(20.0F));
//		amtToDate.setBounds(30,120,400,100);
//		JLabel amtThisYear = new JLabel("Total Amount Recieved This Year: ");
//		amtThisYear.setFont(recName.getFont().deriveFont(20.0F));
//		amtThisYear.setBounds(30,160,400,100);
//		
//		this.add(recName);
//		this.add(currentRemBal);
//		this.add(amtToDate);
//		this.add(amtThisYear);
//		
		
		
		
		
	}

}
