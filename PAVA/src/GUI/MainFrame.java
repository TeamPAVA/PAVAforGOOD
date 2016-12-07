package GUI;



import javax.swing.JFrame;
// 
public class MainFrame extends JFrame { //toolbar gets added to this class
	
	//Jframe instead of JPanel. This home frame will hold and show all of the other panels.
	// Dimensions, names and such are just placeholders.
	public MainFrame(String userType) {
		super();
		int userTypeNum = Integer.parseInt(userType); //**********THIS IS WHAT WE PASS TO TOOLBAR
		setTitle("PAVAP");
		setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DonorPanel myP = new DonorPanel();
        add(myP);
        
        if(userTypeNum == 0) {
        	//admin
        } else if (userTypeNum == 1) {
        	//donor
        } else if (userTypeNum == 2) {
        	//recipient
        }
        //verena work on option panel for recipients
        
        
        
        
        
        pack();
        setLocationRelativeTo(null);
	}


}




