package java3;

/**
 * This class models a simple customer with the other information.
 *
 * @author SeungChan Kim
 */
public class Customer {
   
	private int id;
    private String name;
    private String phone;
    private String email;
    private String account;
    private double balance = 0;
   
    public Customer() {}
   
    public Customer(int id, String name, String phone, String email, String account, double balance) {
    	
    	setId(id);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setAccount(account);
        setBalance(balance);
    }
    
    public Customer(String name, String phone, String email, String account, double balance) {
        
        setName(name);
        setPhone(phone);
        setEmail(email);
        setAccount(account);
        setBalance(balance);
    }

    public Customer(String name, String phone, String email, String account) {
        
        setName(name);
        setPhone(phone);
        setEmail(email);
        setAccount(account);
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    /**
     * Retrieves the name of this customer.
     *
     * @return this customer's name
     */
    public String getName() {
        return name;
    }
	
    public void setName(String name) {
       
        // make sure name isn't empty
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else { // name is not valid
            throw new IllegalArgumentException("Error: name can't be empty.");
        }
    }

    /**
     * Retrieves the phone number of this customer.
     *
     * @return this customer's phone number
     */
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		
        // make sure phone isn't empty
        if (name != null && !name.trim().isEmpty()) {
            this.phone = phone;
        } else if (!phone.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")){
            throw new IllegalArgumentException("Error: phone is not valid.");
        } else { // name is not valid
            throw new IllegalArgumentException("Error: phone can't be empty.");
        }
	}

    /**
     * Retrieves the email of this customer.
     *
     * @return this customer's email
     */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		if(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			this.email = email;
		else
			throw new IllegalArgumentException("Please include "
				+ "an '@' in the email address");
	}

    /**
     * Retrieves the account number of this customer.
     *
     * @return this customer's account number
     */
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		
        // make sure account isn't empty
        if (account != null && !account.trim().isEmpty()) {
            this.account = account;
        } else { // account is not valid
            throw new IllegalArgumentException("Error: account can't be empty.");
        }
	}

	/**
     * Retrieves the balance of this customer.
     *
     * @return this customer's balance
     */
    public double getBalance() {
        return balance;
    }
   
    public void setBalance(double balance) {
       
        // make sure volume is valid
        if (balance >= 0) {
            this.balance = balance;
        } else { // volume is not valid
            throw new IllegalArgumentException("Error: balance must be greater than"
                + " pr equal to 0.");
        }
    }
   
	/**
     * Gets this customer as a String.
     *
     * @return this customer as a formatted string
     */
    public String toString() {
       
        // formatted container name and volume
        return String.format("%s: %.2f", name, balance);
    }
}