package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupFrame extends JFrame {
	
	public SignupFrame(File users) {
	
		setSize(400,550);
		try {
        	setIconImage(ImageIO.read(getClass().getResource("/p.png"))); // http://wiro.donweb-homeip.net/p-2/
        } catch (IOException e) {
        	
        }
		setLayout(new GridLayout(0,2));
		JLabel usernameWord = new JLabel("Enter a Username:");
		
		JTextField username = new JTextField("", 20);
		JLabel accountType = new JLabel("What type of user are you?");
		JLabel passwordWord = new JLabel("Enter a Password:");

		JLabel blank = new JLabel();
		JPasswordField password = new JPasswordField("",5);
		JButton next = new JButton("Next");
		JButton signup = new JButton("Sign Up");
		JButton cancel = new JButton("Cancel");
		JRadioButton donor = new JRadioButton("Donor");
		JRadioButton recipient = new JRadioButton("Recipient");
		ButtonGroup accounts = new ButtonGroup();
		accounts.add(donor);
		accounts.add(recipient);
		add(usernameWord);
		add(username);
		add(passwordWord);
		add(password);
		add(accountType);
		add(blank);
		add(donor);
		add(recipient);
		add(next);
		add(cancel);
		pack();
		setLocationRelativeTo(null);
	
	
	next.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				FileWriter w = new FileWriter(users, true);
				StringBuilder sb = new StringBuilder();
				if (!username.getText().isEmpty() && !password.getText().isEmpty()) {
					
					sb.append(username.getText());
					sb.append(',');
					sb.append(password.getPassword());
					sb.append(',');
					if (donor.isSelected()) {
						sb.append("1");
					} else {
						sb.append("2");
					}

					sb.append('\n');
					w.write(sb.toString());
					w.close();
					if (donor.isSelected()) {	// Prompt user for card info to fill donor csv
						SignupFrameDonor mySignupDonorPanel = new SignupFrameDonor(username.getText(), password.getText());
						mySignupDonorPanel.setVisible(true);						
					} else {	// Write to recipient csv the user/pass + initial amount received
						FileWriter writeRecipient = new FileWriter("recipientDatabase.csv", true);
						StringBuilder info = new StringBuilder();
						info.append(username.getText());
						info.append(',');
						info.append(password.getPassword());
						info.append(',');
						info.append('0');
						info.append('\n');
						writeRecipient.write(info.toString());		
						writeRecipient.close();
					}
				}
			} catch (FileNotFoundException e1) {
								//if cant find file, do this
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		}
	});
	cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		
	});
}
}
