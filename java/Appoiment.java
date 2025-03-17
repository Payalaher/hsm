
import java.sql.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Appoiment
 */
public class Appoiment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appoiment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		String name= req.getParameter("name");
		String email= req.getParameter("email");
		String subject= req.getParameter("subject");
		String number= req.getParameter("number");
		String Department= req.getParameter("Department");
		String date=req.getParameter("date");
		String Time=req.getParameter("Time");
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/hms","kadi","123");
			String sql="insert into apoinment (name,email,purpose ,number,department ,date,time)values(?,?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, subject);
			ps.setString(4, number);
			ps.setString(5, Department);
			ps.setString(6, date);
			ps.setString(7, Time);
			ps.executeUpdate();
			out.println("<script>"
					+ "alert('Appoinment Registor Succesfully')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("appointment.html");
			rd.include(req,resp);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured ->"+e);
			
		}
	}

}