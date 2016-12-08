package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecipientOptionsPanel extends JPanel {
	public RecipientOptionsPanel () {
		super();
		setBackground(Color.GRAY);
		setLayout(null); //POSSIBLY GOING TO CHANGE TO GRID LAYOUT
		
		
		JLabel recName = new JLabel("Recipient Name: ");
		recName.setFont(recName.getFont().deriveFont(25.0F));
		recName.setBounds(30, 40, 200, 100);
		JLabel currentRemBal = new JLabel("Current Remaining Balance On Card: ");
		currentRemBal.setFont(recName.getFont().deriveFont(20.0F));
		currentRemBal.setBounds(30,80,400,100);
		JLabel amtToDate = new JLabel("Total Amount Recieved To Date: ");
		amtToDate.setFont(recName.getFont().deriveFont(20.0F));
		amtToDate.setBounds(30,120,400,100);
		JLabel amtThisYear = new JLabel("Total Amount Recieved This Year: ");
		amtThisYear.setFont(recName.getFont().deriveFont(20.0F));
		amtThisYear.setBounds(30,160,400,100);
		
		this.add(recName);
		this.add(currentRemBal);
		this.add(amtToDate);
		this.add(amtThisYear);
		
		
		
		
	}

}
