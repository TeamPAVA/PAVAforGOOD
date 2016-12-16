package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

/**
* Panel for recipient Options
* @author Verena Nicolaou, Adrian 
*/
public class RecipientOptionsPanel extends JPanel {
	public RecipientOptionsPanel (String username) {
		super();
		File users = new File("recipientDatabase.csv");

		
		
		setBackground(Color.GRAY);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel recName = new JLabel("Recipient Name: ");
		recName.setFont(recName.getFont().deriveFont(25.0F));
		
		c.gridx = 0;
		c.gridy = 0;
		add(recName, c);
		
		JLabel name = new JLabel(username);
		
		c.gridx = 1;
		c.gridy = 0;
		add(name, c);
		
		
		
		JLabel currentRemBal = new JLabel("Current Remaining Balance On Card: ");
		currentRemBal.setFont(recName.getFont().deriveFont(20.0F));
		
		c.gridx = 0;
		c.gridy = 1;
		add(currentRemBal, c);
		
		double total = 0;
				 try {
				    	BufferedReader fileScanner = new BufferedReader(new FileReader(users));	
				        String database;
				        while((database = fileScanner.readLine()) != null){
				           String[] user = database.split(",");
				        	   if (user[0].equals(username)) {
				        		   total = Double.parseDouble(user[2]);
				        		   JLabel tot = new JLabel("$" + user[2]);
				        		   c.gridx = 1;
				        		   c.gridy = 1;
				        		   add(tot, c);
					            }
				        }
				        fileScanner.close();
				   } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
		 JLabel totalRecieved = new JLabel("Total Recieved To Date: ");
		 totalRecieved.setFont(recName.getFont().deriveFont(20.0F));
		 
		 c.gridx = 0;
		 c.gridy = 2;
		 add(totalRecieved, c);	
		 
		 
		 JLabel totalView = new JLabel("$" + total);
		 
		 c.gridx = 1;
		 c.gridy = 2;
		 add(totalView,c);
		 
		 
		 JButton addFamStory = new JButton("Add Family Story");
		 addFamStory.setSize(100,100);
		 addFamStory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					FamStoryFrame myFamStoryFrame = new FamStoryFrame();
					myFamStoryFrame.setVisible(true);
				}
				
			});
		 
		 
		 c.gridx = 0;
		 c.gridy = 3;
		 add(addFamStory, c);
				
				 
		
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
