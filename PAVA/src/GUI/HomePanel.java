package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5958726568815914406L;

	private class FamilyUpdatePanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4261502008723939345L;
		private int userStoryID;
		private String title;
		private String story;
		private String pathToImage;
		private ImageIcon image;
		public FamilyUpdatePanel(int id) {
			super();
			userStoryID = id;
			setBackground(Color.GRAY);
			setLayout(new BorderLayout());
			
			loadIn();
			setUp();
		}
		public void loadIn() {
			Boolean lineFound = false;
			Scanner fileScanner;
		    try {
		    	fileScanner = new Scanner(new File("src/famStory/table.csv"));
		    	fileScanner.useDelimiter(",");
		    	while(fileScanner.hasNext() && lineFound == false){
		    		String tempVar = fileScanner.next();
		    		if (tempVar.equals(String.valueOf(userStoryID))) {
		    			lineFound = true;
		    		}
		    	}
		    	if (lineFound) {
		    		title = fileScanner.next();
		    		story = fileScanner.next();
		    		pathToImage = fileScanner.next();
		    	}
		    } catch (FileNotFoundException e1) {
		     e1.printStackTrace();
		   }
		}
		private void setUp() {
			
			JLabel famPic = new JLabel( new ImageIcon(pathToImage));
			this.add(famPic, BorderLayout.NORTH);
			this.add(new JLabel(title), BorderLayout.CENTER);
			this.add(new JLabel("<html><body style='width: 250 px'>" + story), BorderLayout.SOUTH);
			
		}

	}

	public HomePanel() {
		super();
		this.setPreferredSize(new Dimension(1024,768));
		setBackground(Color.GRAY);
		setLayout(new BorderLayout());

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
	
	public void setUp() {
		FamilyUpdatePanel west = new FamilyUpdatePanel(1);
		FamilyUpdatePanel center = new FamilyUpdatePanel(2);
		FamilyUpdatePanel east = new FamilyUpdatePanel(3);
		this.add(east, BorderLayout.EAST);
		this.add(west, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
	}

}
