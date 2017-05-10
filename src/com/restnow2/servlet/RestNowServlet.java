package com.restnow2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest2.jni.ActiveDispatcher;

public class RestNowServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public RestNowServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doDelete method of the servlet. <br>
		 *
		 * This method is called when a HTTP delete request is received.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
	*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.setContentType("text/html");
		
		/*PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		
		out.println("; path ="+request.getPathInfo());
		out.println("; querystrng ="+request.getQueryString());
		out.println("; port ="+request.getLocalPort());
		
		out.println(" url ="+request.getRequestURI());
		
		out.println(", using the GET method");
		
		out.println("  </BODY>");
		out.println("</HTML>");
		
		
		out.flush();
		out.close();
		*/
		
		String url=request.getHeader("dburl");
		String port=request.getHeader("dbport");
		String tableName=request.getHeader("tablename");
		
		ActiveDispatcher dispatcher=new ActiveDispatcher(url,Integer.parseInt(port));
		String jstr=dispatcher.getAllRecords(tableName);
		response.setContentType("application/json");
		
		PrintWriter out =response.getWriter();
		out.println("result="+jstr);
		
		out.flush();
		out.close();
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		*/
		
		String url=request.getHeader("dburl");
		String port=request.getHeader("dbport");
		String query=request.getHeader("query");
		
		ActiveDispatcher dispatcher=new ActiveDispatcher(url,Integer.parseInt(port));
		int x=dispatcher.createRecords(query);
		response.setContentType("application/json");
		
		//PrintWriter out =response.getWriter();
		//out.println("result="+jstr);
		
		//out.flush();
		//out.close();
		
	}

	/**
		 * The doPut method of the servlet. <br>
		 *
		 * This method is called when a HTTP put request is received.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Put your code here
	}

	/**
		 * Returns information about the servlet, such as 
		 * author, version, and copyright. 
		 *
		 * @return String information about this servlet
		 */
	public String getServletInfo() {
		return "This is my default servlet created by Eclipse";
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
