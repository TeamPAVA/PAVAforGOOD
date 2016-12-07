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


public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5151041547543472432L;
	File users; 
	public Frame() {
		super();
		setTitle("PAVAP");
		users = new File("userDatabase.csv");
		setLocationRelativeTo(null);
		setResizable(false);
		//createMenuBar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createFirstScreen();
        this.pack();
	}
	
	private void createFirstScreen() {
		JPanel initial = new JPanel();
		initial.setLayout(new BorderLayout());
		JPanel north  = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		initial.add(north, BorderLayout.NORTH);
		initial.add(center, BorderLayout.CENTER);
		initial.add(south, BorderLayout.SOUTH);
		
		
		JLabel usernameWord = new JLabel("Username");
		JTextField username = new JTextField("", 5);
		JLabel passwordWord = new JLabel("Password");

		JPasswordField password = new JPasswordField(5);
		JButton login = new JButton("Login");
		JButton signup = new JButton("Sign Up");
		JButton about = new JButton("About");
		
		
		north.add(usernameWord, BorderLayout.WEST);
		north.add(username, BorderLayout.EAST);
		center.add(passwordWord, BorderLayout.WEST);
		center.add(password, BorderLayout.EAST);
		//center.add(photo, BorderLayout.CENTER);
		
		south.add(signup, BorderLayout.WEST);
		south.add(login, BorderLayout.CENTER);
		south.add(about, BorderLayout.EAST);
		
		this.add(initial, BorderLayout.CENTER);
		
		//////////////////////////////////////////////////////
		//create actions here. turn into method?
		
		login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Scanner fileScan;
			    try {
			    	fileScan = new Scanner(users);
			    	fileScan.useDelimiter(",");
			    	while(fileScan.hasNextLine()){
			    		String currentLine = "";
			    		currentLine = fileScan.nextLine();
			    		Scanner second = new Scanner(System.in);
			    		
			    		
		                String username = currentLine.next();
		                String p = currentLine.next();
		                if (username.equals(usernameWord.getText()) && p.equals(password.getText())) {
		            	   Home myHome = new Home();
		            	   add(myHome, BorderLayout.CENTER);
		                               
		                }
		            } 
			    } catch (FileNotFoundException e1) {
			   
			     e1.printStackTrace();
			   }

			}
			
		});
		
		
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
			}
			
		});
		
	}
	
	
	 private void createMenuBar() {

	        JMenuBar menubar = new JMenuBar(); 
	        setLayout(new BorderLayout());
	        JButton login = new JButton("Login");
	        JButton about = new JButton("About");
	        JButton signup = new JButton("Sign Up");
	        
	        menubar.add(login);
	        menubar.add(signup);
	        menubar.add(about);
	        login.setMnemonic(KeyEvent.VK_L);

	        menubar.add(Box.createHorizontalGlue());
	        login.setMnemonic(KeyEvent.VK_E);
	        login.setToolTipText("Exit application");
	 
	        
	        login.addActionListener((ActionEvent event) -> {
	        	String name = JOptionPane.showInputDialog(this,
                        "Username:", null);
	        	String nam1e = JOptionPane.showInputDialog(this,
                        "Pass:", null);
	        	
	        });

	        menubar.add(login);

	        setJMenuBar(menubar);
	        setVisible(true);
	    }
	

	
}