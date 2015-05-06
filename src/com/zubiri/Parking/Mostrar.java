package com.zubiri.Parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.zubiri.parking.*;
import java.sql.*;

/**
 * Servlet implementation class Mostrar
 */
public class Mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mostrar() {
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
		    //ResultSet rs = stmt.executeQuery("SELECT matricula, marca, combustible, consumo, automatico, ruedas FROM vehiculos");
		    ResultSet rs = stmt.executeQuery("SELECT * FROM vehiculos");
			//stmt.executeUpdate("INSERT INTO vehiculos(matricula, marca, combustible, consumo, automatico, ruedas) VALUES ()");

		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//--Vehiculo vehiculo = new Vehiculo();
		
		//--String matricula = request.getParameter("matricula");
		//--ParkingVehiculos.findVehiculo(matricula);
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		//String auto = null;
		while (rs.next()) {
	    	//String matricula = rs.getString("matricula");
	    	out.println("Matrícula: " + rs.getString("matricula") + "<br>");
	    	out.println("Marca: " + rs.getString("marca") + "<br>");
	    	out.println("Combustible: " + rs.getString("combustible") + "<br>");
	    	out.println("Consumo: " + rs.getInt("consumo") + "<br>");
	    	/*if (rs.getString("automatico")=="true") {
	    		auto = "Si";
			} else {
				auto = "No";
			}
	    	out.println("Automático: " + auto + "<hr>");*/
	    	out.println("Automático: " + rs.getString("automatico") + "<br>");
	    	out.println("Número de ruedas: " + rs.getInt("ruedas") + "<hr>");
	    }
		//out.print(ParkingVehiculos.formattedParking());
		
		out.println("<br/><a href='index.html'><input type='button' value='Volver'></a>");
		out.println("</body></html>");
		rs.close();
		}catch(Exception ex){
			//Tratar el error
		}
	}

}
