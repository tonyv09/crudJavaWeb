package com.ecodeup.controller;

import java.awt.List;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.ProductoDAO;
import com.ecodeup.model.Producto;
import com.google.gson.Gson;


/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para tabla productos", urlPatterns = { "/productos" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion=request.getParameter("opcion");
		ProductoDAO productoDAO =new ProductoDAO();
		Producto producto = new Producto();
		if(opcion.equals("crear"))
		{
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
			
			System.out.println("Crear");
		}
		else if(opcion.equals("listar")) {

			ArrayList listaProductos=new ArrayList<Producto>();
			//Gson json=new Gson();
			//String jsonProductos; 	
			
			try {
				listaProductos=productoDAO.obtenerTodos();
				request.setAttribute("jsonProductos",listaProductos);
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}else if(opcion.equals("meditar")) {
			int id=Integer.parseInt(request.getParameter("id"));
				try {
					producto=productoDAO.obtenerProducto(id);
					request.setAttribute("producto",producto);
					//System.out.println("producto"+producto);
					RequestDispatcher requestDispatcher= request.getRequestDispatcher("/views/detalle.jsp");
					requestDispatcher.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}else if(opcion.equals("eliminar")) {
			int idproducto=Integer.parseInt(request.getParameter("id"));
			try {
				productoDAO.eliminar(idproducto);
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String opcion =request.getParameter("opcion");
			
		if(opcion.equals("crear")) {

			Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
			ProductoDAO productoDAO =new ProductoDAO();
			Producto producto= new Producto();
			//Date fecha=new Date(new java.sql.Date().getTime());
			
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
			producto.setFechaCrear(fechaActual.toString());
			System.out.println(fechaActual);			
			try {
				productoDAO.guardar(producto);
				System.out.println("REGISTRO ALMANCENADO CON EXITO");
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		

			
		}else if(opcion.equals("editar")) {
			
			Timestamp fechaActual2 = new Timestamp(System.currentTimeMillis());
			ProductoDAO productoDAO2 =new ProductoDAO();
			Producto producto2= new Producto();
			producto2.setNombre(request.getParameter("nombre"));
			producto2.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			producto2.setPrecio(Double.parseDouble(request.getParameter("precio")));
			producto2.setFechaActualizar(fechaActual2.toString());
			producto2.setId(Integer.parseInt(request.getParameter("id")));
			try {
				if(productoDAO2.editar(producto2)) {
					RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);	
				}else {
					System.out.println("Error al editar");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
			
			
			
			
					//doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}

}
