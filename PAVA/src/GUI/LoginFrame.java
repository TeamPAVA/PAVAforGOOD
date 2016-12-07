package GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;








public class LoginFrame extends JFrame {




	/**
	 * 
	 */
	private static final long serialVersionUID = -5151041547543472432L;
	File users; 
	public LoginFrame()  {
		super();
		setTitle("PAVAP");
		users = new File("userDatabase.csv");
		setLocationRelativeTo(null);
		setResizable(false);
		//createMenuBar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LoginPanel imagePanel = new LoginPanel(this);
        add(imagePanel);
        this.setSize(300, 450);
        try {
        	setIconImage(ImageIO.read(new File("p.png"))); // http://wiro.donweb-homeip.net/p-2/
        } catch (IOException e){
        	
        }
        setLocationRelativeTo(null);
	}
}
	
	class LoginPanel extends JPanel {


		
	private BufferedImage myImage;
	
	private JFrame myMainFrame;
	
	public LoginPanel(JFrame theFrame) {
		File users = new File("userDatabase.csv");
		myMainFrame = theFrame;
		setLayout(null);
		
		
		try {
        	myImage = ImageIO.read(new File("login.jpg")); // http://www.mobileswall.com/tag/abstract/page/3/
        } catch (IOException e){
        	//blow up the program.
        }
		JLabel usernameWord = new JLabel("Username");
	
		JTextField username = new JTextField("", 20);
		JLabel passwordWord = new JLabel("Password");




		JPasswordField password = new JPasswordField("",5);
		JButton login = new JButton("Login");
		JButton signup = new JButton("Sign Up");
		JButton about = new JButton("About");
		
		// login button below username and password.
		usernameWord.setBounds(37,80,120,100);
		username.setBounds(100,120,100,25);
		passwordWord.setBounds(37,120,120,100);
		password.setBounds(100,160,100,25);
		login.setBounds(100,200,100,25);
		signup.setBounds(100,240,100,25);
			
		// login button to side of username and password
//		usernameWord.setBounds(20,80,120,100);
//		username.setBounds(80,120,100,25);
//		passwordWord.setBounds(20,120,120,100);
//		password.setBounds(80,160,100,25);
//		login.setBounds(180,120,100,66);	
//		signup.setBounds(100,350,100,25);
		
		about.setBounds(100,390,100,25);
		add(usernameWord);
		add(username);
		add(passwordWord);
		add(password);
		add(login);
		add(signup);
		add(about);
		
		//////////////////////////////////////////////////////
		//create actions here. turn into method?
		
		login.addActionListener(new ActionListener() {




			public void actionPerformed(ActionEvent e) {
			    try {
			    	BufferedReader fileScanner = new BufferedReader(new FileReader(users));	
			        String database;
			        while((database = fileScanner.readLine()) != null){
			           String[] users = database.split(",");
			        	   if (users[0].equals(username.getText()) && users[1].equals(password.getText())) {
			        		   MainFrame homeFrame = new MainFrame(users[2]); // Create a new JFrame for all panel changes starting at home not login.
			        		   setSize(700,700);
			        		   homeFrame.setVisible(true);
			        		   myMainFrame.setVisible(false); //dispose of the login frame because we no longer need it, just make a new one.
			        		   myMainFrame.dispose();
				            }
			        }
			        fileScanner.close();
			   } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}		
		});
		
		
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupPanel mySignupPanel = new SignupPanel(users);
				mySignupPanel.setVisible(true);
//				try {
//					
//					PrintWriter w = new PrintWriter(users);
//					StringBuilder sb = new StringBuilder();
//					sb.append(username.getText());
//					sb.append(',');
//					sb.append(password.getPassword());
//					sb.append('\n');
//				} catch (FileNotFoundException e1) {
//					//if cant find file, do this
//				}
			}
			
		});
		
		about.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      JOptionPane.showMessageDialog(null,"PAVAP is an absolute dream team. I first met PAVAP, or THE PAVAP as I call them, "
		       + '\n' + "at an audition for 2001: A Space Odyssey. Yes, you read that correctly, "
		        + '\n' + "their brief stint in cinema brought you the cinematic masterpiece of the ages. ("
		       + '\n' + "I unfortunately didn’t get the part, but I digress.) PAVAP moved onto to develop the "
		       + '\n' + "first iPhone prototype before Steve Jobs “acquired” it (His words, not mine.) PAVAP "
		       + '\n' + "believes in clean energy and has contributed miles of code to Tesla’s autopilot "
		       + '\n' + "software. Fun Fact: At least one of the PAVAP team is from the same planet as Elon "
		       + '\n' + "Musk*, but they don’t like talking about that much... Long story short Team PAVAP is no "
		       + '\n' + "fly-by-night operation. If you are looking for the tried and true, then you, kind person, "
		       + '\n' + "are without a doubt, looking for PAVAP.", "About PAVAP", JOptionPane.PLAIN_MESSAGE);
		    }
		   });
		
	}
	
	@Override
	  protected void paintComponent(Graphics g) {


	    super.paintComponent(g);
	        g.drawImage(myImage, 0, 0, null);
	}
	
	
		
}
