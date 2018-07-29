package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import db.Accounts;
import java3.Customer;

public class DaoCustomers {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private String dbName;  // the name of database to connect to
	
	public DaoCustomers() {}
	
	public DaoCustomers(String dbName) {
		this.dbName = dbName;
	}
	
	// connect to the database server and select the database to use
	private Connection getConnection() throws Exception {
		
		// load and register the JDBC driver before making a connection to the database
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		// store ADMIN account for the database in a variable
		Accounts account = Accounts.ADMIN;
		
		// returns an active connection to a database with a specific user and password
		return DriverManager.getConnection(DB_URL + dbName, account.getUser(), account.getPass());
	}

	// gets a specific data to insert to a database and execute the insert query
	public int insertCustomers(Customer cust) throws Exception {
		
		Connection conn = getConnection(); // connect to the database
		
		// declare a INSERT SQL query to execute on the database
		String sql = "INSERT INTO customers (name, phone, email, account, balance) VALUES (?, ?, ?, ?, ?);";
		
		// declare statement with the SQL query
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// replace the parameter markers with actual values
		stmt.setString(1, cust.getName());    
		stmt.setString(2, cust.getPhone());
		stmt.setString(3, cust.getEmail());
		stmt.setString(4, cust.getAccount());
		stmt.setDouble(5, cust.getBalance());
		
		// execute the provided SQL statement and returns number of rows affected
		int result = stmt.executeUpdate();

		// close the connection and return the result
		conn.close();  
		return result;
	}
	
	public ArrayList<Customer> readFromCsv(String path) throws Exception {
		
		String csvFile = path;    // the path to the csv file
		String line = "";         // each line of the file
		String csvSplitBy = ",";  // delimiter of each line in the file
		
		// ArrayList for storing Customer instance retrieved from the file
		ArrayList<Customer> arrCust = new ArrayList<Customer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			
			while ((line = br.readLine()) != null) {
				
				System.out.println(line); // debug(TBD)
				
				String[] cInfo = line.split(csvSplitBy); // store input values in array for a customer info 
				
				// create a new customer object using the csv file
				Customer cust = new Customer(cInfo[0], cInfo[1], cInfo[2], cInfo[3], Double.parseDouble(cInfo[4]));
				arrCust.add(cust);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return arrCust; // return an ArrayList of Customer instances
	}
}
