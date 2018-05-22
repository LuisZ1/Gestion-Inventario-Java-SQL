package menuAndMessages;

public class Menuses {

	public static void imprimirMenuPrincipal() {
		System.out.println("\n\nElija una opcion:\n   1-Mostrar Menu de consultas\n   2-A?adir...\n   3-Eliminar...\n   0-Salir ");
	}
	
	public static void imprimirMenuConsulta() {
		System.out.println("\n\nElija lo que quiera consultar:\n   1-Todo el material\n   2-Herramientas\n   3-Ferreteria\n   4-Electricidad");
	}
	
	public static void imprimirMenuAnadir() {
		System.out.println("\n\nQue quiere a?adir:\n   1-Herramientas\n   2-Ferreteria\n   3-Electricidad\n   4-Lugar de almacenaje");
	}
	
	public static void imprimirMenuEliminar() {
		System.out.println("\n\nQue quiere eliminar:\n   1-Herramientas\n   2-Ferreteria\n   3-Electricidad\n   4-Lugar de almacenaje");
	}
}
