package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecipientOptionsPanel extends JPanel {
	public RecipientOptionsPanel () {
		super();
		setBackground(Color.GRAY);
		
		JLabel currentRemBal = new JLabel("Current Remaining Balance:");
		JLabel amtToDate = new JLabel("Total Amount Recieved To Date:");
		JLabel amtThisYear = new JLabel("Total Amount Recieved This Year:");
		
		this.add(currentRemBal);
		this.add(amtToDate);
		this.add(amtThisYear);
		
		
		
		
	}

}
