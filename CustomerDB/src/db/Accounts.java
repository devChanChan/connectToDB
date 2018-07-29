package db;

public enum Accounts {
	
	// database accounts info
	GUEST("guest", "EnterYourPassword"),
	ADMIN("Admin", "EnterYourPassword");
	
	private String user; // username
	private String pass; // password
	
	public String getUser() {
		return user;
	}
	
	public String getPass() {
		return pass;
	}
	
	private Accounts(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
}
