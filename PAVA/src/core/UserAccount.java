package core;
// TODO: Auto-generated Javadoc
/**
 * Very Rough user account class, just trying to remember how to write in Java.
 * Prob over did it with getters and setters, but I don't know where the team
 * stands on them yet so...
 * 
 * @author aolives
 *
 */
public abstract class UserAccount {
    
	/** The email address. */
	private String emailAddress;
	
	/** The password. */
	private String password;
	
	/** The name. */
	private String name;
	
	/** The birthdate. */
	private String birthdate;
	
	/** The gender. */
	private String gender;
	
	/** The address. */
	private String address;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The annual income. */
	private int annualIncome;
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the birthdate.
	 *
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * Sets the birthdate.
	 *
	 * @param birthdate the new birthdate
	 */
	public void setBirthdate(final String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the annual income.
	 *
	 * @return the annual income
	 */
	public int getAnnualIncome() {
		return annualIncome;
	}

	/**
	 * Sets the annual income.
	 *
	 * @param annualIncome the new annual income
	 */
	public void setAnnualIncome(final int annualIncome) {
		this.annualIncome = annualIncome;
	}

	/**
	 * Instantiates a new user account.
	 */
	public UserAccount() {
    }
	
	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Update income. Separated out, on a hunch.
	 *
	 * @param newIncome the new income
	 */
	public void updateIncome(final int newIncome) {
		setAnnualIncome(newIncome);
	}
	
	
	
	public abstract void seeFamilyUpdate();
	
}
