package com.myconstruction.iplacex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.myconstruction.iplacex.ConectorDB;
import java.sql.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("myconstruction.iplacex: Hola Mundo ! ! !");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*System.out.println("Llegue al post");
		System.out.println("Request Parameter Usuario: " + request.getParameter("username"));
		System.out.println("Request Parameter Password: " + request.getParameter("password"));
		
		String usuario = request.getParameter("username");
		
		System.out.println("Usuario " + usuario);
		
		request.setAttribute("usuario", usuario);
		
		
		response.sendRedirect(request.getContextPath()+"/inicio.jsp?usuario=" + usuario);
		*/
		
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    if (validate(username, password)) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("inicio.jsp");
        } else {
        	request.getSession().setAttribute("mensaje", "Error, el usuario: " + username + " no se encuentra registrado.");
            response.sendRedirect("login.jsp");
        }
	     
	     


		
		// doGet(request, response);
	}
	
	private boolean validate(String username, String password) {
        Connection conn = ConectorDB.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM Usuarios WHERE usuario=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
