package test.servlet;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Properties;

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
		int numPrimes = utils.getIntParameter(request, "numPrimes", 50);
		int numDigits = utils.getIntParameter(request, "numDigits", 20);
		String title = numPrimes + " Primes with " + numDigits +" Digits."; 
		
		PrimeList primelist = findPrimeList(numPrimes, numDigits);
		
		if(primelist == null) {
			primelist = new PrimeList(numPrimes, numDigits);
			synchronized(primeListCollection){
				if(primeListCollection.size()>=maxLists) {
					primeListCollection.remove(0);
				}
				primeListCollection.add(primelist);
			}
		}
		
		ArrayList<BigInteger> currentlist = primelist.getPrimes();
		int currentPrimeNumber = currentlist.size();
		int primeRemain = numPrimes - currentPrimeNumber;
		boolean isLastResult = primelist.isDone();
		if(!isLastResult) {
			response.setIntHeader("Refresh", 1);
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>"+
					"<body bgcolor=\"#FDF5E6\">\n"+
					"<h2 align=center>" + title + "</h2>\n"
		);
		if(!isLastResult) {
			out.println("<B> Still looking for </B>" + primeRemain + "...\n");
		}
		else{
			out.println("<B> Done Searching </B>");
		}
		out.println("<OL>");
		for(int i=0;i<currentPrimeNumber;i++) {
			out.println("<LI>" + currentlist.get(i));
		}
		out.println("</OL>");
        out.println("</body></html>");
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

	private PrimeList findPrimeList(int numPrimes, int numDigits) {
		synchronized(primeListCollection) {
			for(int i=0; i<primeListCollection.size(); i++) {
				PrimeList primes = (PrimeList) primeListCollection.get(i);
				if(primes.numPrimes == numPrimes && primes.numDigits == numDigits) {
					return(primes);
				}
			}
			return(null);
		}
	}
}
