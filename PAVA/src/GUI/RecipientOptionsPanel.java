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
		JButton remBal = new JButton("Click to see Remaining Balance on Card");
		add(remBal);
		
		remBal.addActionListener(new ActionListener() {
			
			int total;
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
				    	BufferedReader fileScanner = new BufferedReader(new FileReader(users));	
				        String database;
				        while((database = fileScanner.readLine()) != null){
				           String[] users = database.split(",");
				        	   if (users[0].equals(username)) {
				        		   //print out users[2]
				        		
					            }
				        }
				        fileScanner.close();
				   } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}

		});
		
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
