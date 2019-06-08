package com.ecodeup.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Producto;

public class ProductoDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Producto producto) throws SQLException {
		try {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		connection.setAutoCommit(false);
		sql="INSERT INTO Productos(id,nombre,cantidad,precio,fecha_crear) VALUES(NULL,?,?,?,?) ";
		statement=connection.prepareStatement(sql);
		statement.setString(1,producto.getNombre());
		statement.setInt(2,producto.getCantidad());
		statement.setDouble(3,producto.getPrecio());
		statement.setString(4, producto.getFechaCrear());
		//statement.setDate(5,producto.getFechaActualizar());
		estadoOperacion=statement.executeUpdate()>0;
		connection.commit();
		statement.close();
		connection.close();
		}catch(SQLException e) {
			connection.rollback();
			e.printStackTrace();
			
		}
		
		return estadoOperacion;
	}
	
	public boolean editar(Producto producto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql="UPDATE Productos SET "
					+ "nombre=?,"
					+ "cantidad=?,"
					+ "precio=?,"
					+ "fecha_actualizar=? "
					+ "WHERE id=?";
			statement=connection.prepareStatement(sql);
			statement.setString(1,producto.getNombre());
			statement.setDouble(2,producto.getCantidad());
			statement.setDouble(3,producto.getPrecio());
			statement.setString(4,producto.getFechaActualizar());
			statement.setInt(5,producto.getId());
			estadoOperacion=statement.executeUpdate()>0;
			System.out.println(estadoOperacion);
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public boolean eliminar(int idproducto) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql="DELETE FROM Productos"
					+ " WHERE id=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1,idproducto);

			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
		
		

	}
	
	public ArrayList<Producto> obtenerTodos() throws SQLException {
		ResultSet resultSet=null;
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		ArrayList<Producto> listaProductos= new ArrayList<Producto>();
		
		int index=0;
		try {
			sql="SELECT * FROM Productos";
			statement= connection.prepareStatement(sql) ;
			resultSet=statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Producto product =new Producto();
				product.setId(resultSet.getInt(1));
				product.setNombre(resultSet.getString(2));
				product.setPrecio(resultSet.getDouble(3));
				product.setCantidad(resultSet.getInt(4));
				product.setFechaCrear(resultSet.getString(5));
				product.setFechaActualizar(resultSet.getString(6));
			
				listaProductos.add(product);

				
				//System.out.println(listarProductos.lastIndexOf(product));
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		statement.close();
		connection.close();
		//System.out.println(listaProductos);
		return listaProductos;
	}
	
	public Producto obtenerProducto(int id_producto) throws SQLException {
	
		ResultSet resultSet=null;
		Producto product =new Producto();
		String sql=null;
		connection=obtenerConexion();
		try {
			
			sql="SELECT * FROM Productos WHERE id="+id_producto;
			//System.out.println(sql+" "+id_producto);
			statement=connection.prepareStatement(sql);		
			//statement.setInt(1,id_producto);
			resultSet=statement.executeQuery(sql);	
			
			if(resultSet.next()) {

				product.setId(resultSet.getInt(1));
				product.setNombre(resultSet.getString(2));
				product.setPrecio(resultSet.getDouble(3));
				product.setCantidad(resultSet.getInt(4));
				product.setFechaCrear(resultSet.getString(5));
				product.setFechaActualizar(resultSet.getString(6));
		

				
				//listaProductos.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		statement.close();
		connection.close();
		//System.out.println("despues de query");
		//System.out.println(product);
		
		return product;
	}
	
	//obtener coneccion del pool de conecciones
	public Connection obtenerConexion() throws SQLException{
		
		return Conexion.getConnection();
	}
	
	
}
