package main;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.Locale;
//import org.springframework.context.support.ResourceBundleMensageResource;
import java.util.Scanner;

import gestion.Gestion;
import gestion.GestionSQL;
import menuAndMessages.MensajesSistema;

/*
ANALISIS: El programa servirá para facilitar la conexion con una base de datos para gestionar un inventario
RESTRICCIONES:
ENTRADAS: iniciar el programa, opcion de menu
SALIDAS:
PSEUDOCODIGO:
	INICIO
		PREGUNTAR SI INICIAR
		MIENTRAS QUIERA INICIAR
			HACER
				LEER Y VALIDAR OPCION MENU PRINCIPAL
				SI OPCION MENU DISTINTO DE SALIR
					SEGUN OPCION //MENU 1
						OPCION 1: LEER Y VALIDAR OPCION MENU CONSULTA
						OPCION 2: LEER Y VALIDAR OPCION MENU Aï¿½ADIR 
						OPCION 3: LEER Y VALIDAR OPCION MENU ELIMINAR  
					FIN SEGUN
				FIN SI
			MIENTRAS OPCION MENU != 0
			PREGUNTAR SI INICIAR OTRA VEZ
		FIN MIENTRAS
	FIN
*/

public class MainInventarioSQL {

	public static void main(String[] args) throws SQLException, IOException {
		
	//INICIO
		//DECLARACION DE VARIABLES
		GestionSQL gestionadoraSQL = new GestionSQL();
		Gestion gestionadora = new Gestion();
		Scanner teclado = new Scanner(System.in);
		int iniciar = 0;
		int opcionMenu = 0;
		
		//PREGUNTAR SI INICIAR
		System.out.println("Está apunto de entrar en un lugar del que no querrá salir. ¿Está seguro?"
				+ "\nPulse 1 en caso afirmativo");
		iniciar = teclado.nextInt();
		
		//MIENTRAS QUIERA INICIAR
		while(iniciar == 1) {
			
			MensajesSistema.BIENVENIDA.print();
			
			//HACER
			do {
				
				//LEER Y VALIDAR OPCION MENU PRINCIPAL
				do {
					MensajesSistema.MENU_PRINCIPAL.print();
					opcionMenu = teclado.nextInt();
				} while (opcionMenu < 0 || opcionMenu > 3);
			
				//SI OPCION DISTINTO DE SALIR
				if(opcionMenu != 0) {
			
					//SEGUN OPCION MENU 1
					switch(opcionMenu) {
					
						//OPCION 1: MOSTRAR MENU CONSULTA
						case 1: 
							do {
								MensajesSistema.MENU_CONSULTAS.print();
								opcionMenu = teclado.nextInt();
							} while (opcionMenu < 0 || opcionMenu > 4);
							
							switch(opcionMenu) {
								case 1: gestionadoraSQL.imprimirMateriales();
								break;
								case 2: gestionadoraSQL.imprimirHerramientas();
								break;
								case 3: gestionadoraSQL.imprimirFerreteria();
								break;
								case 4: gestionadoraSQL.imprimirElectricidad();
								break;
							}
						break;
						
						//OPCION 2: MOSTRAR MENU Aï¿½ADIR 
						case 2: 
							do {
								MensajesSistema.MENU_AÑADIR.print();
								opcionMenu = teclado.nextInt();
							} while (opcionMenu < 0 || opcionMenu > 4);
							
							switch(opcionMenu) {
								case 1: gestionadora.insertarHerramienta();
								break;
								case 2: gestionadora.insertarFerreteria();
								break;
								case 3: gestionadora.insertarElectricidad();
								break;
								case 4: gestionadora.insertarLugar();
								break;
							}
						break;
						
						//OPCION 3: MOSTRAR MENU ELIMINAR  
						case 3: 
							do {
								MensajesSistema.MENU_ELIMINAR.print();
								opcionMenu = teclado.nextInt();
							} while (opcionMenu < 0 || opcionMenu > 4);
							
							switch(opcionMenu) {
								case 1: gestionadora.eliminarMaterial(1);
								break;
								case 2: gestionadora.eliminarMaterial(2);
								break;
								case 3: gestionadora.eliminarMaterial(3);
								break;
								case 4: gestionadora.eliminarLugar();
								break;
							}
						break;
						
					}//FIN SEGUN
		
				}//FIN SI
				
			//MIENTRAS OPCION NO SEA SALIR
			}while(opcionMenu != 0);
				
			//PREGUNTAR SI INICIAR OTRA VEZ
			MensajesSistema.REINICIOPREGUNTA.print();
			iniciar = teclado.nextInt();
				
		}//FIN MIENTRAS
		
		teclado.close();
	}//FIN
}
