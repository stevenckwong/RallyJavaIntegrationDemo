package com.stevenckwong.rallyintegration;

import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rallydev.rest.RallyRestApi;

/**
 * Servlet implementation class LoginGetNameServlet
 */
@WebServlet("/LoginGetNameServlet")
public class LoginGetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginGetNameServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		URI uri = URI.create("https://rally1.rallydev.com");
		
		RallyRestApi rally = new RallyRestApi(uri, username, password);
		String QueryString = "(UserName%20%3D%20"+username+")&start=1&pagesize=20";
		String queryURL = "/user?query=" + QueryString + "&order=";

		// Sample request from documentation
		// https://rally1.rallydev.com/slm/webservice/v2.0/user?workspace=https://rally1.rallydev.com/slm/webservice/v2.0/workspace/146174538760&query=(UserName%20%3D%20stevenck.wong%40acme.com)&start=1&pagesize=20
	
		// String queryURL = "/user?workspace=https://rally1.rallydev.com/slm/webservice/v2.0/workspace/146174538760&query=";
		
		
		String result = rally.getClient().doGet(queryURL);

		MyUtility myUtil = new MyUtility();
		
		String displayName = myUtil.parseResultForDisplayName(result);
		
		rally.close();
		
		response.getWriter().append("<h1>Display Name is " + displayName + "</h1>\n");
		response.getWriter().append("<input type=\"hidden\" id=\"displayName\" value=\"" + displayName + "\" />");
		
		doGet(request, response);
		
	}

}
