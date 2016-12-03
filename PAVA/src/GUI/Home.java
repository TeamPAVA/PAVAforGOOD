package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel {
	
	public Home() {
		setBackground(Color.GRAY);
		JLabel welcome = new JLabel("Welcome");
		setLayout(new BorderLayout());
		add(welcome, BorderLayout.SOUTH);
	}

}
