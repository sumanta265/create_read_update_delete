package Reg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	
	public static Connection getConnection() throws SQLException
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3308/Corona","root","root");
			
			
		} catch (ClassNotFoundException e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static int save(Employee e) throws SQLException
	{
		
		int status=0;
		String sql="insert into employee_table(name,fathername,post_address,personal_address ,gender,city ,course,district,state,pincode,email,dob,mobile)values(?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,e.getName());
		ps.setString(2,e.getFathername());
		ps.setString(3, e.getPost_address());
		ps.setString(4, e.getPersonal_address());
		ps.setString(5, e.getGender());
		ps.setString(6, e.getCity());
		ps.setString(7,e.getCourse());
		ps.setString(8, e.getDistrict());
		ps.setString(9,e.getState());
		ps.setString(10, e.getPincode());
		ps.setString(11,e.getEmail());
		ps.setString(12, e.getDob());
		ps.setString(13,e.getMobile());
		
		status=ps.executeUpdate();
		con.close();
		
		
		
		
		
		
		return status;
		
	}
	
	public static List<Employee> getAllEmployees() throws SQLException
	{
		
		List<Employee> list=new ArrayList<Employee>();
		
		
		Connection con=EmpDao.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from employee_table");  
        ResultSet rs=ps.executeQuery();  
		while(rs.next())
		{
			Employee e =new Employee();
			e.setName(rs.getString(1));
			e.setFathername(rs.getString(2));
			e.setEmail(rs.getString(11));
			e.setPersonal_address(rs.getString(4));
			e.setMobile(rs.getString(13));
			
			list.add(e);
			
		}
		
		
		
		return list;
		
		
		
		
		
	}
	
	
}
