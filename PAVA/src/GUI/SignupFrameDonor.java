package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Frame for holding signing up
 * @author Phillip
 *
 */
public class SignupFrameDonor extends JFrame {
	
	public SignupFrameDonor(String user, String pw) {
	
		setSize(400,550);
		try {
        	setIconImage(ImageIO.read(getClass().getResource("/p.png"))); // http://wiro.donweb-homeip.net/p-2/
        } catch (IOException e) {
        	
        }
		setLayout(new GridLayout(0,2));
		
		JLabel askInfo = new JLabel("Please enter your card information");
		JLabel blank = new JLabel();
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		
		JLabel cardName = new JLabel("Name on Card:");
		JLabel cardNum = new JLabel("Card Number:");
		JLabel expDate = new JLabel("Exp. Date:");
		JLabel cvc = new JLabel("CVC:");
		JLabel zip = new JLabel("Zip Code:");

		JTextField userName = new JTextField("", 7);
		JTextField userNum = new JTextField("",10);
		JTextField userExpDate = new JTextField("",6);
		JTextField userCvc = new JTextField("");
		JTextField userZip = new JTextField("");

		JButton ok = new JButton("Okay");
		JButton cancel = new JButton("Cancel");

		add(askInfo);
		add(blank);
		add(cardName);
		add(userName);
		add(cardNum);
		add(userNum);
		add(expDate);
		add(userExpDate);
		add(cvc);
		add(userCvc);
		add(zip);
		add(userZip);
		add(blank1);
		add(blank2);

		add(ok);
		add(cancel);
		pack();
		setLocationRelativeTo(null);
	
	
	ok.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				FileWriter w = new FileWriter("donorDatabase.csv", true);
				StringBuilder sb = new StringBuilder();
				if (!userName.getText().isEmpty() && !userNum.getText().isEmpty() && !userExpDate.getText().isEmpty()
						&& !userCvc.getText().isEmpty() && !userZip.getText().isEmpty()) {
					sb.append(user);
					sb.append(',');
					sb.append(pw);
					sb.append(',');
					sb.append('0');
					sb.append(',');
					sb.append(userName.getText());
					sb.append(',');
					sb.append(userNum.getText());
					sb.append(',');
					sb.append(userExpDate.getText());
					sb.append(',');
					sb.append(userCvc.getText());
					sb.append(',');
					sb.append(userZip.getText());
					sb.append('\n');
					w.write(sb.toString());
					w.close();
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
