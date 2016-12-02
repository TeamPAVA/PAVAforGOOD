package core;

public class UserController {
	   private User model;
	   private UserView view;

	   public UserController(User model, UserView view){
	      this.model = model;
	      this.view = view;
	   }

	   public void setUserName(String name){
	      model.setName(name);		
	   }

	   public String getUserName(){
	      return model.getName();		
	   }

	   public void setUserAnnualIncome(int annualIncome){
	      model.setAnnualIncome(annualIncome);		
	   }

	   public int getUserAnnualIncome(){
	      return model.getAnnualIncome();		
	   }

	   public void updateView(){				
	      view.printUserDetails(model.getName(), model.getAnnualIncome());
	   }	
	}