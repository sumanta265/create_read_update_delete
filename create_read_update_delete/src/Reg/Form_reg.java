package Reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form_reg
 */
@WebServlet("/Form_reg")
public class Form_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form_reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("textnames");
		String fathername=request.getParameter("fathername");
		String post_address=request.getParameter("paddress");
		String personal_address=request.getParameter("personaladdress");
		String gender=request.getParameter("sex");
		String city=request.getParameter("City");
		String course=request.getParameter("Course");
		String district=request.getParameter("District");
		String state=request.getParameter("State");
		String pincode =request.getParameter("pincode");
		String email=request.getParameter("emailid");
		String dob=request.getParameter("dob");
		String mobile=request.getParameter("mobileno");
		Employee e = new Employee();
		e.setName(name);
		e.setFathername(fathername);
		e.setPost_address(post_address);
		e.setPersonal_address(personal_address);
		e.setGender(gender);
		e.setCity(city);
		e.setCourse(course);
		e.setDistrict(district);
		e.setState(state);
		e.setPincode(pincode);
		e.setEmail(email);
		e.setDob(dob);
		e.setMobile(mobile);
		
		try {
			int i=EmpDao.save(e);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		PrintWriter out =response.getWriter();
		
		try {
			Connection con=EmpDao.getConnection();
			if(con!=null)
			{
				out.println("database connected:");
				
			}
			else
			{
				out.println("database not connected");
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		response.encodeRedirectUrl("View_Details");
		
          
        out.close();  
		
		
	}

}
