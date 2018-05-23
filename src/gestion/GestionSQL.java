package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import menuAndMessages.MensajesSistema;

public class GestionSQL{

	private static String sourceURL = "jdbc:sqlserver://localhost";
	private static String usuario = "pepito";
	private static String password = "qq";
		
	/*
	ANALISIS: El modulo imprimira las celdas de el resultSet obtenido de una consulta SQL
	PRECONDICIONES:  
	ENTRADAS: un objeto ResultSet
	SALIDAS: -
	POSTCONDICIONES: imprime en pantalla
	*/
	public void imprimirResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				if (i > 1) System.out.print(", ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue /*+ " " + rsmd.getColumnName(i)*/);
			}
		}
	}
		
	/*
	ANALISIS: El programa imprimirá una consulta sql sobre las herramientas
	PRECONDICIONES: -
	ENTRADAS: -
	SALIDAS: -
	POSTCONDICIONES: -
	*/
	public void imprimirHerramientas() throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "SELECT M.ID, M.nombre ,H.tipo ,H.tamañoCm FROM Materiales AS M JOIN Herramientas AS H ON M.ID = ID_Material";
		ResultSet rs = sentencia.executeQuery (miOrden);
		
		imprimirResultSet(rs);
	}
	
	/*
	ANALISIS: El programa imprimirá una consulta sql sobre la ferreteria
	PRECONDICIONES: -
	ENTRADAS: -
	SALIDAS: -
	POSTCONDICIONES: -
	*/
	public void imprimirFerreteria() throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "SELECT M.ID, M.nombre ,H.tipo ,H.dimensiones FROM Materiales AS M JOIN Ferreteria AS H ON M.ID = ID_Material";
		ResultSet rs = sentencia.executeQuery (miOrden);
		
		imprimirResultSet(rs);
	}
	
	/*
	ANALISIS: El programa imprimirá una consulta sql sobre la electricidad
	PRECONDICIONES: -
	ENTRADAS: -
	SALIDAS: -
	POSTCONDICIONES: -
	*/
	public void imprimirElectricidad() throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "SELECT M.ID, M.nombre ,E.dimensiones,E.color FROM Materiales AS M JOIN Electricidad AS E ON M.ID = ID_Material";
		ResultSet rs = sentencia.executeQuery (miOrden);
		
		imprimirResultSet(rs);
	}
	
	/*
	ANALISIS: El programa imprimirá todos los materiales
	PRECONDICIONES: -
	ENTRADAS: -
	SALIDAS: -
	POSTCONDICIONES: -
	*/
	public void imprimirMateriales() throws SQLException {
		imprimirHerramientas();
		imprimirFerreteria();
		imprimirElectricidad();
	}

	/*
	ANALISIS: el modulo imprimirá en pantalla el resultado de un consulta SQL sobre lugar almacenamiento
	PRECONDICIONES: -
	ENTRADAS:-
	SALIDAS:-
	POSTCONDICIONES:-
	*/
	public void imprimirLugaresAlmacenamiento() throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "SELECT * FROM Lugares";
		ResultSet rs = sentencia.executeQuery (miOrden);
		
		imprimirResultSet(rs);
	}
	
	/*
	ANALISIS: El modulo insertará en las material y herramientas una nueva herramienta
	PRECONDICIONES: datos de entrada validos
	ENTRADAS: dos string y dos enteros
	SALIDAS: -
	POSTCODICIONES: añade a la BD
	*/
	public void insertarHerramientaSQL(String nombreHerramienta, int IDLugar, String tipoHerramienta, int tamañoCm) throws SQLException {
				
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		/*String miOrden = "INSERT INTO [dbo].[Materiales]([nombre],[ID_Lugar])VALUES('"+nombreHerramienta+"',"+IDLugar+") "
				+ "DECLARE @MyCounter int; SET @MyCounter = @@IDENTITY; INSERT INTO [dbo].[Herramientas]([tipo],[tamañoCm],[ID_Material])"
				+ "VALUES('"+tipoHerramienta+"',"+tamañoCm+", @MyCounter)";*/
		
		String miOrden = "EXECUTE insertarHerramienta "+nombreHerramienta+", "+IDLugar+", "+tipoHerramienta+ ", "+tamañoCm;
		
		int rs = sentencia.executeUpdate (miOrden);
		
		if(rs == 1) {
			MensajesSistema.INSERT_SUCCEED.print();
		}else {
			MensajesSistema.INSERT_FAIL.print();
		}
	}
	
	/*
	ANALISIS:El modulo insertará un nuevo material electrico en la BD
	PRECONDICIONES: datos de tipos validos
	ENTRADAS: tres string y un entero
	SALIDAS: -
	POSTCONDICIONES: imprime un mensaje de estado al final
	*/
	public void insertarElectricidadSQL(String nombreElectricidad, int IDLugar, String colorElec, String dimensiones)  throws SQLException{
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "INSERT INTO [dbo].[Materiales]([nombre],[ID_Lugar]) VALUES ('"+nombreElectricidad+"','"+IDLugar+"')" 
				+ "DECLARE @MyCounter int; SET @MyCounter = @@IDENTITY; INSERT INTO [dbo].[Electricidad]([color],[dimensiones],[ID_Material])"
				+ "VALUES('"+colorElec+"','"+dimensiones+"', @MyCounter)";
		int rs = sentencia.executeUpdate (miOrden);
		
		if(rs == 1) {
			MensajesSistema.INSERT_SUCCEED.print();
		}else {
			MensajesSistema.INSERT_FAIL.print();
		}
	}
	
	/*
	ANALISIS: El modulo insertará un material de ferreteria mediante una instruccion SQL
	PRECONDICIONES: datos validos
	ENTRADAS: tres string y un entero
	SALIDAS: -
	POSTCONDICIONES: imprime mensaje de estado al final
	*/
	public void insertarFerreteriaSQL(String nombreFerreteria, int IDLugar, String tipoFerreteria, String dimensiones) throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "INSERT INTO [dbo].[Materiales]([nombre],[ID_Lugar]) VALUES ('"+nombreFerreteria+"','"+IDLugar+"')" 
				+ "DECLARE @MyCounter int; SET @MyCounter = @@IDENTITY; INSERT INTO [dbo].[Ferreteria]([tipo],[dimensiones],[ID_Material])"
				+ "VALUES('"+tipoFerreteria+"','"+dimensiones+"', @MyCounter)";
		int rs = sentencia.executeUpdate (miOrden);
		
		if(rs == 1) {
			MensajesSistema.INSERT_SUCCEED.print();
		}else {
			MensajesSistema.INSERT_FAIL.print();
		}
	}
	
	/*
	ANALISIS: El modulo insertará un lugar de almacenaje mediante una instruccion SQL
	PRECONDICIONES: -
	ENTRADAS: una cadena
	SALIDAS:-
	POSTCONDICIONES: -
	*/
	public void insertarLugarSQL(String nombreLugar) throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "[dbo].[Lugares]([nombre]) VALUES ('"+nombreLugar+"')";
		int rs = sentencia.executeUpdate (miOrden);
		
		if(rs == 1) {
			MensajesSistema.INSERT_SUCCEED.print();
		}else {
			MensajesSistema.INSERT_FAIL.print();
		}
	}
	
	/*
	ANALISIS: El modulo eliminará de la BD usando una instruccion SQL
	PRECONDICIONES: ID positivo
	ENTRADAS: un entero
	SALIDAS: -
	POSTCONDICIONES: -
	*/
	public void eliminarMaterialSQL(int IDaEliminar) throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "DELETE FROM Materiales WHERE ID = "+IDaEliminar;
		int rs = sentencia.executeUpdate (miOrden);
		
		if(rs == 1) {
			MensajesSistema.DELETE_SUCCEED.print();
		}else {
			MensajesSistema.DELETE_FAIL.print();
		}
	}

	public void eliminarLugarSQL(int IDaEliminar) throws SQLException {
		Connection connexionBaseDatos = DriverManager.getConnection(sourceURL,usuario, password);
		
		Statement sentencia = connexionBaseDatos.createStatement();

		String miOrden = "DELETE FROM Lugares WHERE ID = "+IDaEliminar;
		int rs = sentencia.executeUpdate (miOrden);
		
		if(rs == 1) {
			MensajesSistema.DELETE_SUCCEED.print();
		}else {
			MensajesSistema.DELETE_FAIL.print();
		}
	}
}