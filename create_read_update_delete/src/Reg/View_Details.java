package Reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View_Details
 */
@WebServlet("/View_Details")
public class View_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out =response.getWriter();
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
        	String x=String.valueOf(e1.getId());
         out.print("<tr><td>"+e1.getId()+"</td><td>"+e1.getName()+"</td><td>"+e1.getFathername()+"</td><td>"+e1.getEmail()+"</td>   <td>"+e1.getPersonal_address()+"</td>  <td>"+e1.getMobile()+"</td><td><a href='EditServlet?id="+e1.getId()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+x+"'>delete</a></td></tr>");  
        }  
        out.print("</table>"); 
        out.close(); 
	}

	

}
