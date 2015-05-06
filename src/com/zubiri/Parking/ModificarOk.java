package com.zubiri.Parking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class ModificarOk
 */
public class ModificarOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarOk() {
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
		
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("NUEVOS DATOS:<hr>");
		out.println("Matrícula: " + request.getParameter("matricula") + "<br>");
		out.println("Marca: " + request.getParameter("marca") + "<br>");
		out.println("Combustible: " + request.getParameter("combustible") + "<br>");
		out.println("Consumo: " + Integer.parseInt(request.getParameter("consumo")) + "<br>");
		out.println("Automático: " + Boolean.valueOf(request.getParameter("automatico")) + "<br>");
		out.println("Número de ruedas: " + Integer.parseInt(request.getParameter("ruedas")) + "<br>");
		stmt.executeUpdate("UPDATE vehiculos SET marca = '"+request.getParameter("marca")
				+"', combustible = '"+request.getParameter("combustible")
				+"', consumo = "+Integer.parseInt(request.getParameter("consumo"))
				+", automatico = '"+Boolean.valueOf(request.getParameter("automatico"))
				+"', ruedas = "+Integer.parseInt(request.getParameter("ruedas"))
				+" WHERE matricula = '"+ request.getParameter("matricula") +"')");
		//stmt.executeUpdate("INSERT INTO vehiculos (matricula, marca, combustible, consumo, automatico, ruedas) VALUES ('2222aaa','audi','diesel',3,'true',2)");
		out.println("<a href='index.html'><input type='button' value='Volver'></a>");
		out.println("</body></html>");
		cone.close();
		}catch(Exception ex){
			//Tratar el error
		}
	}

}
