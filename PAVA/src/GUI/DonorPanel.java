package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DonorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4761523114634863561L;

	public DonorPanel () {
		super();
		setSize(400,185);
		setBackground(Color.GRAY);

		//menuBar();
		
		setUp();
		
	}

	private void menuBar() {
		JMenuBar menubar = new JMenuBar();
        JButton login = new JButton("Login");
        JButton about = new JButton("About");
        
        menubar.add(login);
        menubar.add(about);
        login.setMnemonic(KeyEvent.VK_L);

        menubar.add(Box.createHorizontalGlue());
        login.setMnemonic(KeyEvent.VK_E);
        login.setToolTipText("Exit application");
 
        
         login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String text = "";
    
            }
         });

        menubar.add(login);

        add(menubar,BorderLayout.NORTH);
        setVisible(true);
		
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
		helpText.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		
		
		JTextField donateAmount = new JTextField("$", 10);
		donateAmount.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));

		JButton newCard = new JButton("New Card");
		newCard.setFont(new Font(labelFont.getName(), Font.PLAIN, 10));
		newCard.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JPanel panel = new JPanel();
            	panel.setLayout(new GridLayout(0, 2));
       		    panel.add(new JLabel("Name on card:"));
       		 	panel.add(new JTextField("", 7));
       		 	panel.add(new JLabel("Card number:"));
    		 	panel.add(new JTextField("",10));
    		 	panel.add(new JLabel("Exp. Date:"));
       		 	panel.add(new JTextField("",6));
       		    panel.add(new JLabel("Security Code:"));
    		 	panel.add(new JTextField(""));
    		 	panel.add(new JLabel("Zip Code:"));
    		 	panel.add(new JTextField(""));
    		 	
       		 	
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
       		 	panel.add(new JTextField("User Name", 7));
       		 	panel.add(new JLabel("Card number:"));
    		 	panel.add(new JTextField("5555-5555-5555-5555"));
    		 	panel.add(new JLabel("Exp. Date:"));
       		 	panel.add(new JTextField("10/17",6));
       		    panel.add(new JLabel("Security Code:"));
    		 	panel.add(new JTextField("123"));
    		 	panel.add(new JLabel("Zip Code:"));
    		 	panel.add(new JTextField("97845"));
    		 	
       		 	
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

		
		add(initial2,BorderLayout.CENTER);
	}
}
