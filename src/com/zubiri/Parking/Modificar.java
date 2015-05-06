package com.zubiri.Parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Modificar
 */
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificar() {
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
		    
			//stmt.executeUpdate("INSERT INTO vehiculos(matricula, marca, combustible, consumo, automatico, ruedas) VALUES ()");

		    String matricula = request.getParameter("matricula");
		    ResultSet rs = stmt.executeQuery("SELECT * FROM vehiculos WHERE matricula = '"+matricula+"'");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		//String auto = null;
		while (rs.next()) {
		out.print("<fieldset><legend><h2>Modificar vehículo</h2></legend>");
		out.print("<form method='POST' action='modificarok.jr'>");
			out.print("Matrícula: <input type='text' name='matricula' id='matri' value='"+matricula+"' maxlength='7'><br>");
			out.print("Matrícula: "+matricula+"<br>");
			out.print("Marca: <input type='text' name='marca' value='"+rs.getString("marca")+"'><br>");
			out.print("Combustible: <select name='combustible'>");
			if (rs.getString("combustible")=="Gasolina") {
				out.print("<option value='Gasolina' selected>Gasolina</option><option value='Diesel'>Diesel</option></select><br>");
			} else {
				out.print("<option value='Gasolina'>Gasolina</option><option value='Diesel' selected>Diesel</option></select><br>");
			}
			out.print("Consumo: <input type='number' name='consumo' value='"+rs.getInt("consumo")+"'>L/100KM<br>");
			out.print("Automatico: <select name='automatico'>");
			if (rs.getString("automatico")=="true") {
				out.print("<option value='true' selected>Si</option><option value='false'>No</option></select><br>");
			} else {
				out.print("<option value='true'>Si</option><option value='false' selected>No</option></select><br>");
			}
			out.print("Numero de ruedas: <input type='number' name='ruedas' value='"+rs.getInt("ruedas")+"'><br>");
			out.print("<input type='submit' value='Modificar'>");
		out.print("</form>");
		out.print("</fieldset><a href='index.html'><input type='button' value='Volver'></a>");
		}
		out.println("</body></html>");
		
		cone.close();
		}catch(Exception ex){
			//Tratar el error
		}
	}

}
