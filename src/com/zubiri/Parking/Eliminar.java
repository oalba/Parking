package com.zubiri.Parking;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
//import com.zubiri.parking.ParkingVehiculos;

/**
 * Servlet implementation class Eliminar
 */
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
			Connection cone = DriverManager.getConnection("jdbc:mysql://localhost/parking","root","zubiri");
			Statement stmt = cone.createStatement();
			
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String matricula = request.getParameter("matricula");
	
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		
		stmt.executeUpdate("DELETE FROM vehiculos WHERE matricula = '"+matricula+"'");
		//ParkingVehiculos.deleteVehiculo(matricula);
		out.println("<br/><a href='index.html'><input type='button' value='Volver'></a>");
		out.println("</body></html>");
		cone.close();
		}catch(Exception ex){
			//Tratar el error
		}
	}

}
