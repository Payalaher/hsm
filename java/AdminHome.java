
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
/**
 * Servlet implementation class AdminHome
 */
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/hms","kadi","123");
			String sql = "select *from apoinment ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			out.println("<!DOCTYPE html>\n"
					+ "<html lang=\"en\">\n"
					+ "<head>\n"
					+ "    <meta charset=\"UTF-8\">\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
					+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n"
					+ "    <title>Hospital Management</title>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "   <a href=index.html> <button type=\"button\" class=\"btn btn-outline-dark position-fixed mx-5 px-3\">Back</button> </a>\n"
					+ "    <h1 class=\"text-center text-dark m-4\">Details</h1>\n"
					+ "    <table class=\"table\">\n"
					+ "        <thead>\n"
					+ "          <tr>\n"
					+ "            <th scope=\"col\">Name</th>\n"
					+ "            <th scope=\"col\">email</th>\n"
					+ "            <th scope=\"col\">Purpose</th>\n"
					+ "            <th scope=\"col\">Number</th>\n"
					+ "            <th scope=\"col\">Department</th>\n"
					+ "            <th scope=\"col\">Date</th>\n"
					+ "            <th scope=\"col\">Time</th>\n"
					+ "          </tr>\n"
					+ "        </thead>\n"
					+ "        <tbody>");
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String purpose = rs.getString("purpose");
				String number = rs.getString("number");
				String department = rs.getString("department");
				String date = rs.getString("date");
				String time = rs.getString("time");
				
				out.println("<tr>" + "<td>" + name + "</td>" + "<td>" + email + "</td>" + "<td>" + purpose + "</td>"
						+ "<td>" + number + "</td>" + "<td>" + department + "</td>" + "<td>" + date + "</td>" + "<td>" + time + "</td> </tr>");
			}
			out.println("</tbody>\n"
					+ "      </table>\n"
					+ "      <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n"
					+ "</body>\n"
					+ "</html>");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}

}