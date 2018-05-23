package main;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.Locale;
//import org.springframework.context.support.ResourceBundleMensageResource;
import java.util.Scanner;

import gestion.Gestion;
import gestion.GestionSQL;
import menuAndMessages.MensajesSistema;
import menuAndMessages.Messages;

/*
ANALISIS: El programa servirá para facilitar la conexion con una base de datos para gestionar un inventario
RESTRICCIONES:
ENTRADAS: iniciar el programa, opcion de menu
SALIDAS:
PSEUDOCODIGO:
	INICIO
//		REPETIR
//			MOSTRAR MENU PRINCIPAL
//			SEGUN OPCION MENU PRINCIPAL
//				OPCION 1: 		//MOSTRAR MENU CONSULTAS
//					REPETIR
//						MOSTRAR MENU CONSULTAS
//						SEGUN OPCION MENU CONSULTAS
//							OPCION 1
//							OPCION 2
//							OPCION 3
//							OPCION 4
//							//OPCION 0 SALIR
//						FIN SEGUN
//					MIENTRAS NO QUIERA SALIR DEL SUBMENU
//				OPCION 2: 		//MOSTRAR MENU AÑADIR
//					REPETIR
//						MOSTRAR MENU AÑADIR
//						SEGUN OPCION MENU AÑADIR
//							OPCION 1
//							OPCION 2
//							OPCION 3
//							OPCION 4
//							//OPCION 0 SALIR
//						FIN SEGUN
//					MIENTRAS QUIERA SEGUIR AÑADIENDO
//				OPCION 3: 		//MOSTRAR MENU ELIMINAR
//					REPETIR
//					MIENTRAS QUIERA SEGUIR ELIMINANDO
//						SEGUN OPCION MENU ELIMINAR
//							OPCION 1
//							OPCION 2
//							OPCION 3
//							OPCION 4
//							//OPCION 0 SALIR
//						FIN SEGUN
//					FIN MIENTRAS
//				//OPCION 0 SALIR
//			FIN SEGUN
//		MIENTRAS NO QUIERA SALIR
	FIN
*/

public class MainInventarioSQL {

	public static void main(String[] args) throws SQLException, IOException {

		// INICIO
		// DECLARACION DE VARIABLES
		GestionSQL gestionadoraSQL = new GestionSQL();
		Gestion gestionadora = new Gestion();
		Scanner teclado = new Scanner(System.in);
		int iniciar = 0;
		int opcionMenu = 0, opcionMenuP = 1;
		String seleccionIdioma;

		// IDIOMA
		do {
			System.out.println("Elija el idioma / choose the language: \n es : español \n en : english");
			seleccionIdioma = teclado.nextLine();
		} while (!seleccionIdioma.toLowerCase().equals("es") && !seleccionIdioma.toLowerCase().equals("en"));
		Messages.changeLanguage(seleccionIdioma);

		MensajesSistema.BIENVENIDA.print();

		// REPETIR
		do {
			// MOSTRAR MENU PRINCIPAL
			do {
				MensajesSistema.MENU_PRINCIPAL.print();
				opcionMenuP = teclado.nextInt();
			} while (opcionMenuP < 0 || opcionMenuP > 3);

			// SEGUN OPCION MENU PRINCIPAL
			switch (opcionMenuP) {
			// OPCION 1: //MOSTRAR MENU CONSULTAS
			case 1:
				do {
					MensajesSistema.MENU_CONSULTAS.print();
					opcionMenu = teclado.nextInt();

					switch (opcionMenu) {
					case 1:
						gestionadoraSQL.imprimirMateriales();
						break;
					case 2:
						gestionadoraSQL.imprimirHerramientas();
						break;
					case 3:
						gestionadoraSQL.imprimirFerreteria();
						break;
					case 4:
						gestionadoraSQL.imprimirElectricidad();
						break;
					}
				} while (opcionMenu < 0 || opcionMenu > 4);
				break;
			// OPCION 2: //MOSTRAR MENU AÑADIR
			case 2:
				do {
					MensajesSistema.MENU_AÑADIR.print();
					opcionMenu = teclado.nextInt();

					switch (opcionMenu) {
					case 1:
						gestionadora.insertarHerramienta();
						break;
					case 2:
						gestionadora.insertarFerreteria();
						break;
					case 3:
						gestionadora.insertarElectricidad();
						break;
					case 4:
						gestionadora.insertarLugar();
						break;
					}

				} while (opcionMenu < 0 || opcionMenu > 4);
				break;
			// OPCION 3: //MOSTRAR MENU ELIMINAR
			case 3:
				do {
					MensajesSistema.MENU_ELIMINAR.print();
					opcionMenu = teclado.nextInt();

					switch (opcionMenu) {
					case 1:
						gestionadora.eliminarMaterial(1);
						break;
					case 2:
						gestionadora.eliminarMaterial(2);
						break;
					case 3:
						gestionadora.eliminarMaterial(3);
						break;
					case 4:
						gestionadora.eliminarLugar();
						break;
					}
				} while (opcionMenu < 0 || opcionMenu > 4);
				break;
			// OPCION 0 SALIR
			}// FIN SEGUN
			// MIENTRAS OPCION NO SEA SALIR
		} while (opcionMenuP != 0);
		teclado.close();
	}// FIN
}
