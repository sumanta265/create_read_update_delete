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
		
		
		out.println("<h1>Employees List</h1>");  
        
        List<Employee> list = null;
		try {
			list = EmpDao.getAllEmployees();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>FatherName</th><th>Email</th><th>personalAddress</th><th>Mobile No</th><th>Edit</th><th>Delete</th></tr>");  
        for(Employee e1:list){  
         out.print("<tr><td>"+e1.getName()+"</td><td>"+e1.getFathername()+"</td><td>"+e1.getEmail()+"</td>   <td>"+e1.getPersonal_address()+"</td><td>"+e1.getMobile()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
		
		
	}

}
