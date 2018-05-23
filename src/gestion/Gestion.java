package gestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import menuAndMessages.MensajesSistema;

public class Gestion {
	
	private GestionSQL gestionadoraSQL = new GestionSQL();
	
	/**
	 * El método pide por teclado los datos necesarios para insertar una nueva herramienta en la base de datos
	*/
	public void insertarHerramienta() throws SQLException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner teclado = new Scanner(System.in);
		
		MensajesSistema.HERRAMIENTA_PEDIR_NOMBRE.print();
		String nombreHerramienta = br.readLine();

		gestionadoraSQL.imprimirLugaresAlmacenamiento();
		MensajesSistema.LUGAR_PEDIR_ID.print();
		int IDLugar = teclado.nextInt();
		
		MensajesSistema.HERRAMIENTA_PEDIR_TIPO.print();
		String tipoHerramienta = br.readLine();
		
		MensajesSistema.HERRAMIENTA_PEDIR_SIZE.print();
		int tamañoCm = teclado.nextInt();
		
		gestionadoraSQL.insertarHerramientaSQL(nombreHerramienta, IDLugar, tipoHerramienta, tamañoCm);
		
		//teclado.close();
		//br.close();
	}
	
	/**
	 * El método pide por teclado los datos necesarios para insertar un nuevo material electrico en la base de datos
	*/
	public void insertarElectricidad() throws SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner teclado = new Scanner(System.in);
		
		MensajesSistema.ELECTRICIDAD_PEDIR_NOMBRE.print();
		String nombreElectricidad = br.readLine();

		gestionadoraSQL.imprimirLugaresAlmacenamiento();
		MensajesSistema.LUGAR_PEDIR_ID.print();
		int IDLugar = teclado.nextInt();
		
		MensajesSistema.ELECTRICIDAD_PEDIR_COLOR.print();
		String colorElec = br.readLine();
		
		MensajesSistema.ELECTRICIDAD_PEDIR_DIMENSIONES.print();
		String dimensiones = br.readLine();
		
		gestionadoraSQL.insertarElectricidadSQL(nombreElectricidad, IDLugar, colorElec, dimensiones);
		
		//teclado.close();
		//br.close();
	}

	/**
	 * El método pide por teclado los datos necesarios para insertar un material de ferreteria en la base de datos
	*/
	public void insertarFerreteria() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner teclado = new Scanner(System.in);
		
		MensajesSistema.FERRETERIA_PEDIR_NOMBRE.print();
		String nombreFerreteria = br.readLine();

		gestionadoraSQL.imprimirLugaresAlmacenamiento();
		MensajesSistema.LUGAR_PEDIR_ID.print();
		int IDLugar = teclado.nextInt();
		
		MensajesSistema.FERRETERIA_PEDIR_TIPO.print();
		String tipoFerreteria = br.readLine();
		
		MensajesSistema.FERRETERIA_PEDIR_DIMENSIONES.print();
		String dimensiones = br.readLine();
		
		gestionadoraSQL.insertarFerreteriaSQL(nombreFerreteria, IDLugar, tipoFerreteria, dimensiones);
		
		//teclado.close();
		//br.close();
	}

	/**
	 * El método pide por teclado los datos necesarios para insertar un nuevo lugar de almacenaje en la base de datos
	*/
	public void insertarLugar() throws SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		MensajesSistema.LUGAR_PEDIR_NOMBRE.print();
		String nombreLugar = br.readLine();
	
		gestionadoraSQL.insertarLugarSQL(nombreLugar);
		
		
		//br.close();
	}
	
	/**
	 * El método pide por teclado los datos necesarios para eliminar materiales de la base de datos
	*/
	public void eliminarMaterial(int MaterialEliminar) throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		
		switch(MaterialEliminar) {
			case 1: gestionadoraSQL.imprimirHerramientas();
			break;
			case 2: gestionadoraSQL.imprimirFerreteria();
			break;
			case 3: gestionadoraSQL.imprimirElectricidad();
			break;
		}
		
		MensajesSistema.MATERIAL_PEDIR_ID.print();
		int IDaEliminar = teclado.nextInt();
	
		gestionadoraSQL.eliminarMaterialSQL(IDaEliminar);
		
		//teclado.close();
	}
	
	/**
	 * El método pide por teclado los datos necesarios para insertar una nueva herramienta en la base de datos
	*/
	public void eliminarLugar() throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		
		gestionadoraSQL.imprimirLugaresAlmacenamiento();
		
		MensajesSistema.LUGAR_PEDIR_ID.print();
		int IDaEliminar = teclado.nextInt();
	
		gestionadoraSQL.eliminarLugarSQL(IDaEliminar);
		
		//teclado.close();
	}
}
