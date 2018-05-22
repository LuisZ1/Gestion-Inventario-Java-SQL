package gestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import menuAndMessages.MensajesSistema;

public class Gestion {

	//MensajesSistema msg = new MensajesSistema(); //No instanciable, constructor private
	
	private GestionSQL gestionadoraSQL = new GestionSQL();
	
	/**
	 * El método pide por teclado los datos necesarios para insertar una nueva herramienta en la base de datos
	*/
	public void insertarHerramienta() throws SQLException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner teclado = new Scanner(System.in);
		
		MensajesSistema.HERRAMIENTA_PEDIR_NOMBRE.print();
		String nombreHerramienta = br.readLine();
		
		MensajesSistema.LUGAR_PEDIR_ID.print();
		gestionadoraSQL.imprimirLugaresAlmacenamiento();
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
		
		System.out.println("Introduzca el NOMBRE del material Electrico que quiere insertar");
		String nombreElectricidad = br.readLine();
		
		System.out.println("Introduzca la ID DONDE estará guardado el material que quiere insertar");
		gestionadoraSQL.imprimirLugaresAlmacenamiento();
		int IDLugar = teclado.nextInt();
		
		System.out.println("Introduzca el COLOR el material que quiere insertar");
		String colorElec = br.readLine();
		
		System.out.println("Introduzca las DIMENSIONES del material que quiere insertar");
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
		
		System.out.println("Introduzca el NOMBRE del material ferretero que quiere insertar");
		String nombreFerreteria = br.readLine();
		
		System.out.println("Introduzca la ID DONDE estará guardado el material que quiere insertar");
		gestionadoraSQL.imprimirLugaresAlmacenamiento();
		int IDLugar = teclado.nextInt();
		
		System.out.println("Introduzca el TIPO el material que quiere insertar");
		String tipoFerreteria = br.readLine();
		
		System.out.println("Introduzca las DIMENSIONES del material que quiere insertar");
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
