package main;

import java.sql.SQLException;

import gestion.GestionSQL;

public class conductorInventario {

	public static void main(String[] args) throws SQLException {
		
		GestionSQL gestionadora = new GestionSQL();
		
//		String nombreHerramienta = "Carracav2";
//		int IDLugar = 4;
//		String tipoHerramienta = "llaves de tubo2";
//		int tamañoCm = 10;
//		
//		try {
//			gestionadora.insertarHerramientaSQL(nombreHerramienta, IDLugar, tipoHerramienta, tamañoCm);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		gestionadora.eliminarMaterialSQL(4);
		
	}

}
