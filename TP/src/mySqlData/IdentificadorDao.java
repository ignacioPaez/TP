package mySqlData;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidades.Electrodomestico;
import entidades.Identificador;
import entidades.Lavarropa;
import entidades.Televisor;


/**
 * Clase que permite el acceso a la base de datos
 */
public class IdentificadorDao
{

	public void registrarId()
	{
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO identificador VALUES ("+Identificador.getId()+")");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro id");
		}
	}

	public void buscarIdentificador() 
	{
		Conexion conex= new Conexion();		
		boolean existe=false;
		try {
			//Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT id FROM identificador");
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				if(res.getString("id")==null){
					Identificador.setId();
				}
				else{
					Identificador.setId((Integer.parseInt(res.getString("id"))));
				}
			 } 
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
	}

	public void modificarId() {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE identificador SET id= ?  ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, Identificador.getId()-1);
            estatuto.executeUpdate();
         
        }catch(SQLException	 e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void eliminarPersona(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM persona WHERE id='"+codigo+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
