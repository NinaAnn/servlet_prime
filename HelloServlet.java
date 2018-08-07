package test.servlet;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;



/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList primeListCollection = new ArrayList();
    private int maxLists = 3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/**
		response.setContentType("text/html");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailAddress = request.getParameter("emailaddress");
		System.out.println("Emaillist servlet emailaddress: "+emailAddress);
		String userAgent = request.getHeader("searchEngine");
		PrintWriter out = response.getWriter();
		String DOCTYPE = "<!docktype thml public \"-//W3C//DTD HTML 4.0 " +
		"Transitional//EN\"\n>";
		out.println(DOCTYPE
				+ "<html>\n"
				+ "<head>\n"
				+ "	<title> Email Servlet</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<p> here is your information:</p>\n"
				+ "	<table border=\"1\">\n"
				+ " <tr><td align=\"right\">Name:</td>\n"
				+ " <td>" + firstName +" " + lastName + "</td>\n"
				+ " <td>" + userAgent + "</td>\n"
				+ " </table>"
				+ "</body>\n"
				+ "</html>"
				);
				**/
		
		/**
		 * Use User Agent head to recognize & redirect safari & chrome
		 * 
		String userAgent = request.getHeader("User-Agent");
		if((userAgent != null) && 
				(userAgent.indexOf("Chrome") != -1)) {
			response.sendRedirect("https://remicongee.github.io/");
		
		else {
			response.sendRedirect("https://ninaann.github.io/");
		}
		**/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}


}
