package db;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java3.Customer;

/**
 * Servlet implementation class InsertCustomers
 */
@WebServlet("/InsertCustomers")
public class InsertCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertCustomers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// construct a DaoItem instance with the specified database
			DaoCustomers dao = new DaoCustomers("shopping");
			
			ArrayList<Customer> arrCust = dao.readFromCsv("C://example.csv");
			int success = 0;
			
			for(int i = 0; i < arrCust.size(); i++) {
					
				// insert an item with the retrieved data and get number of rows affected
				success = dao.insertCustomers(arrCust.get(i));
			}
			
			System.out.println(success); // debug(TBD)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
