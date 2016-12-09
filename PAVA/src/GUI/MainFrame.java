package GUI;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
// 
public class MainFrame extends JFrame { //toolbar gets added to this class
	
	//Jframe instead of JPanel. This home frame will hold and show all of the other panels.
	// Dimensions, names and such are just placeholders.
	private JMenuBar menuBar;
	private HomePanel homePanel;
	private DonorPanel donorPanel;
	private RecipientOptionsPanel recOptionsPanel;
	//private OptionsPanel optionsPanel; //this is split between recipient and donor, correct?
	//private AboutPanel aboutPanel;
	private JPanel current1;
	public MainFrame(String userType) {
		super();
		int userTypeNum = Integer.parseInt(userType); //**********THIS IS WHAT WE PASS TO TOOLBAR
		
		setTitle("PAVAP");
		setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DonorPanel myP = new DonorPanel();
        add(myP);

        
        //optionsPanel = new OptionsPanel();
        //aboutPanel = new AboutPanel();
        donorPanel = new DonorPanel();
        homePanel = new HomePanel();
        recOptionsPanel = new RecipientOptionsPanel();
        add(homePanel);
        current1 = homePanel;

        menuBar = new JMenuBar();
       
        

        
        if(userTypeNum == 0) {
        	//setupAdmin();
        } else if (userTypeNum == 1) {
        	 setupDonor();
        } else if (userTypeNum == 2) {
        	setupRec();
        }

        //verena work on option panel for recipients

        this.setJMenuBar(menuBar);
        

        
        
        
        
        
        pack();
        setLocationRelativeTo(null);
	}
	/**
	 * Helper method to set the current frame invisible 
	 * @author Patrick Stevens
	 */
	private void setInvis() {
		this.setVisible(false);
	}
	/**
	 * Helper method to set the recipient options panel
	 * 
	 */
	private void addRecipientOptions() {
		this.remove(current1);
		this.add(recOptionsPanel);
		current1 = recOptionsPanel;
		this.revalidate();
		this.repaint();
	}
	/**
	 * Helper method to set the donor panel
	 * @author Patrick Stevens
	 */
	private void addDonor() {
		this.remove(current1);
		this.add(donorPanel);
		current1 = donorPanel;
		this.revalidate();
		this.repaint();
	}
	/**
	 * Helper method to set the home panel
	 * @author Patrick Stevens
	 */
	private void addHome() {
		this.remove(current1);
		this.add(homePanel);
		current1 = homePanel;
		this.revalidate();
		this.repaint();
	}
	/**
	 * Helper method to set the options panel
	 * @author Patrick Stevens
	 */
	
//	private void addDonorOptions() {
//		this.remove(current1);
//		//this.add(donorOptionsPanel);
//		//current1 = donorOptionsPanel;
//		this.revalidate();
//		this.repaint();
//	}
	/**
	 * Helper method to set the about panel
	 * @author Patrick Stevens
	 */
	private void addAbout() {
		this.remove(current1);
		//this.add(aboutPanel);
		//current1 = aboutPanel;
		this.revalidate();
		this.repaint();
	}
	
	/**
	 * Method for setting up the donor menuBar
	 * @author Patrick Stevens
	 *
	 */
	private void setupDonor() {

		        JButton about = new JButton("About");
		        JButton options = new JButton("Options");
		        JButton donate = new JButton("DONATE NOW");
		        JButton home = new JButton("Home");
		        JButton signOut = new JButton("Sign Out");

		        signOut.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						LoginFrame login = new LoginFrame();
						login.setVisible(true);
						setInvis();
					}
		        	
		        });
		       options.addActionListener(new ActionListener() {
		    	   @Override
		    	   public void actionPerformed(ActionEvent e) {
		    		  
		        	}
		        	
		        	
		        });


		       home.addActionListener(new ActionListener() {
		    	   @Override
		    	   public void actionPerformed(ActionEvent e) {
		        		addHome();
		    	   }
		        	
		        	
		        });
		        donate.addActionListener(new ActionListener() {
		        	@Override
		        	public void actionPerformed(ActionEvent e) {
		        		addDonor();
		        	}
		        	
		        	
		        });


		        
		        about.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				      JOptionPane.showMessageDialog(null,"PAVAP is an absolute dream team. I first met PAVAP, or THE PAVAP as I call them, "
				       + '\n' + "at an audition for 2001: A Space Odyssey. Yes, you read that correctly, "
				        + '\n' + "their brief stint in cinema brought you the cinematic masterpiece of the ages. ("
				       + '\n' + "I unfortunately didn�t get the part, but I digress.) PAVAP moved onto to develop the "
				       + '\n' + "first iPhone prototype before Steve Jobs �acquired� it (His words, not mine.) PAVAP "
				       + '\n' + "believes in clean energy and has contributed miles of code to Tesla�s autopilot "
				       + '\n' + "software. Fun Fact: At least one of the PAVAP team is from the same planet as Elon "
				       + '\n' + "Musk*, but they don�t like talking about that much... Long story short Team PAVAP is no "
				       + '\n' + "fly-by-night operation. If you are looking for the tried and true, then you, kind person, "
				       + '\n' + "are without a doubt, looking for PAVAP.", "About PAVAP", JOptionPane.PLAIN_MESSAGE);
				    }
				   });
		        menuBar.add(home);
		        menuBar.add(options);
		        menuBar.add(Box.createHorizontalStrut(275));
		        menuBar.add(donate);
		        
		        menuBar.add(Box.createHorizontalGlue());
		        menuBar.add(about);
		        menuBar.add(signOut);

		    }
	/**
	 * Method for setting up the admin menuBar
	 * @author Patrick Stevens
	 *
	 */
	private void setupAdmin() {
		
		        JButton options = new JButton("Options");
		        JButton about = new JButton("About");
		        JButton home = new JButton("Home");
		        JButton signOut = new JButton("Sign Out");


		        menuBar.add(Box.createHorizontalGlue());


		 
		        
		        signOut.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
		        		//open loginFrame
		        	}
		        	
		        	
		        });
		       options.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
		        		//open optionsPanel
		        	}
		        	
		        	
		        });
		       
		       
		       home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        		//open home
		        	}
		        	
		        	
		        });
		   	        	
		        
		        about.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
		        		//open about
		        	}
		        	
		        	
		        });
		        menuBar.add(options);
		       menuBar.add(home);
		        menuBar.add(signOut);
		        menuBar.add(about);




		 


		    }


	/**
	 * Method for setting up the recipient menuBar
	 * @author Patrick Stevens
	 *
	 */
	private void setupRec() {


		       JButton options = new JButton("Options");
	    	        JButton about = new JButton("About");
		        JButton home = new JButton("Home");
		        JButton signOut = new JButton("Sign Out");


		        menuBar.add(Box.createHorizontalGlue());


		 
		        
		        signOut.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						LoginFrame login = new LoginFrame();
						login.setVisible(true);
						setInvis();
					}
		        	
		        });
		        
		        
		       home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        		addHome();
		        	}
		        	
		        	
		        });
		       
		       
		        
		       about.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				      JOptionPane.showMessageDialog(null,"PAVAP is an absolute dream team. I first met PAVAP, or THE PAVAP as I call them, "
				       + '\n' + "at an audition for 2001: A Space Odyssey. Yes, you read that correctly, "
				        + '\n' + "their brief stint in cinema brought you the cinematic masterpiece of the ages. ("
				       + '\n' + "I unfortunately didn�t get the part, but I digress.) PAVAP moved onto to develop the "
				       + '\n' + "first iPhone prototype before Steve Jobs �acquired� it (His words, not mine.) PAVAP "
				       + '\n' + "believes in clean energy and has contributed miles of code to Tesla�s autopilot "
				       + '\n' + "software. Fun Fact: At least one of the PAVAP team is from the same planet as Elon "
				       + '\n' + "Musk*, but they don�t like talking about that much... Long story short Team PAVAP is no "
				       + '\n' + "fly-by-night operation. If you are looking for the tried and true, then you, kind person, "
				       + '\n' + "are without a doubt, looking for PAVAP.", "About PAVAP", JOptionPane.PLAIN_MESSAGE);
				    }
				   });
		        options.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
        				addRecipientOptions();
        	
		        	}
		        	
		        	
		        });
		        
		        menuBar.add(home);
		        menuBar.add(signOut);
		        menuBar.add(about);
		        menuBar.add(options);




		 


		    }













}



