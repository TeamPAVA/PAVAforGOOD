package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * The Panel class for the Donor Panel
 * @author Patrick Stevens
 */
public class DonorPanel extends JPanel {

	private static final long serialVersionUID = 4761523114634863561L;
	public JTextField name;
	public JTextField cNum = new JTextField("",10);
	public JTextField expDate;
	public JTextField cvc;
	public JTextField zip;

	public DonorPanel () {
		super();
		setBackground(Color.GRAY);
		setUp();
	}


	private void setUp() {
		JPanel initial = new JPanel();
		JPanel initial2 = new JPanel();
		initial.setLayout(new BorderLayout());
		initial2.setLayout(new BorderLayout());
		
		JPanel north  = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JLabel helpText = new JLabel("How much can you help today?");
		
		Font labelFont = helpText.getFont();
		helpText.setFont(new Font(labelFont.getName(), Font.PLAIN, 30));
		
		
		JTextField donateAmount = new JTextField("$", 10);
		donateAmount.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));

		JButton newCard = new JButton("New Card");
		newCard.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		newCard.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
       		 	name = new JTextField("", 7);
				cNum = new JTextField("",10);
				expDate = new JTextField("",6);
				cvc = new JTextField("");
				zip = new JTextField("");
            	
            	
            	
            	
            	
            	
            	JPanel panel = new JPanel();
            	panel.setLayout(new GridLayout(0, 2));
       		    panel.add(new JLabel("Name on card:"));
       		 	panel.add(name);
       		 	panel.add(new JLabel("Card number:"));
    		 	panel.add(cNum);
    		 	panel.add(new JLabel("Exp. Date:"));
       		 	panel.add(expDate);
       		    panel.add(new JLabel("Security Code:"));
    		 	panel.add(cvc);
    		 	panel.add(new JLabel("Zip Code:"));
    		 	panel.add(zip);
    		 	
       		 	
       		 	JOptionPane.showMessageDialog(null,panel,"New Card Information" ,JOptionPane.INFORMATION_MESSAGE);
            }
        });
		
		
		JButton currCard = new JButton("Card on File");
		currCard.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		currCard.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JPanel panel = new JPanel();
            	panel.setLayout(new GridLayout(0, 2));
       		 	//panel.add(new JButton("Click"));
       		    panel.add(new JLabel("Name on card:"));
       		 	panel.add(new JLabel(name.getText()));
       		 	panel.add(new JLabel("Card number:"));
    		 	panel.add(new JLabel(cNum.getText()));
    		 	panel.add(new JLabel("Exp. Date:"));
       		 	panel.add(new JLabel(expDate.getText()));
       		    panel.add(new JLabel("Security Code:"));
    		 	panel.add(new JLabel(cvc.getText()));
    		 	panel.add(new JLabel("Zip Code:"));
    		 	panel.add(new JLabel(zip.getText()));
    		 	
       		 	
       		 	JOptionPane.showMessageDialog(null,panel,"Card Information",JOptionPane.INFORMATION_MESSAGE);
            }
        });
		 
		
		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		
		submit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
                 JOptionPane.showMessageDialog(initial2,"Thank you for your donation!");
            }
        });
		
		north.add(helpText, BorderLayout.NORTH);	
		
		center.add(donateAmount, BorderLayout.WEST);
		south.add(newCard, BorderLayout.CENTER);
		south.add(currCard, BorderLayout.NORTH);
		
		initial2.add(submit, BorderLayout.SOUTH);
		
		initial.add(north, BorderLayout.NORTH);
		initial.add(center, BorderLayout.CENTER);
		initial.add(south, BorderLayout.SOUTH);

		initial2.add(initial, BorderLayout.NORTH);
		
		initial.setPreferredSize(new Dimension(475,200));

		setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		add(initial2,BorderLayout.CENTER);
	}
}
