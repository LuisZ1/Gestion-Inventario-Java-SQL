package menuAndMessages;

//import java.util.Locale;
//import org.springframework.context.support.ResourceBundleMessageSource;

public enum MensajesSistema  {

	
	
	//Mensajes genericos
	MENU_PRINCIPAL(Messages.getString("MensajesSistema.menu_principal")),
	MENU_CONSULTAS(Messages.getString("MensajesSistema.menu_consultas")),
	MENU_AÑADIR(Messages.getString("MensajesSistema.menu_añadir")),
	MENU_ELIMINAR(Messages.getString("MensajesSistema.menu_eliminar")),
	BIENVENIDA(Messages.getString("MensajesSistema.BIENVENIDA")), //$NON-NLS-1$
	ELIMINADO(Messages.getString("MensajesSistema.Eliminado")), //$NON-NLS-1$
	ELIM_ERROR(Messages.getString("MensajesSistema.eliminado_Error")), //$NON-NLS-1$
	REINICIOPREGUNTA(Messages.getString("MensajesSistema.preguntar_reinicio")),
	
	//Mensajes sobre el material
	MATERIAL_PEDIR_NOMBRE(Messages.getString("MensajesSistema.material_pedir_nombre")), //$NON-NLS-1$
	MATERIAL_PEDIR_ID(Messages.getString("MensajesSistema.material_pedir_ID")), //$NON-NLS-1$
	
	//Mensajes sobre el lugar
	LUGAR_PEDIR_NOMBRE(Messages.getString("MensajesSistema.lugar_pedir_nombre")), //$NON-NLS-1$
	LUGAR_PEDIR_ID(Messages.getString("MensajesSistema.lugar_pedir_ID")), //$NON-NLS-1$
	
	//Mensajes sobre las herramientas
	HERRAMIENTA_PEDIR_NOMBRE(Messages.getString("MensajesSistema.herramienta_pedir_nombre")), //$NON-NLS-1$
	HERRAMIENTA_PEDIR_ID(Messages.getString("MensajesSistema.herramienta_pedir_ID")), //$NON-NLS-1$
	HERRAMIENTA_PEDIR_SIZE(Messages.getString("MensajesSistema.herramienta_pedir_tamaño")), //$NON-NLS-1$
	HERRAMIENTA_PEDIR_TIPO(Messages.getString("MensajesSistema.herramienta_pedir_tipo")), //$NON-NLS-1$
	
	//Mensajes sobre la ferreteria
	FERRETERIA_PEDIR_NOMBRE(Messages.getString("MensajesSistema.ferreteria_pedir_nombre")), //$NON-NLS-1$
	FERRETERIA_PEDIR_TIPO(Messages.getString("MensajesSistema.ferreteria_pedir_tipo")), //$NON-NLS-1$
	FERRETERIA_PEDIR_DIMENSIONES(Messages.getString("MensajesSistema.ferreteria_pedir_dimensiones")), //$NON-NLS-1$
	FERRETERIA_PEDIR_ID(Messages.getString("MensajesSistema.ferreteria_pedir_ID")), //$NON-NLS-1$
	
	//Mensajes sobre la electricidad
	ELECTRICIDAD_PEDIR_NOMBRE(Messages.getString("MensajesSistema.electricidad_pedir_nombre")), //$NON-NLS-1$
	ELECTRICIDAD_PEDIR_COLOR(Messages.getString("MensajesSistema.electricidad_pedir_color")), //$NON-NLS-1$
	ELECTRICIDAD_PEDIR_DIMENSIONES(Messages.getString("MensajesSistema.electricidad_pedir_dimensiones")), //$NON-NLS-1$
	ELECTRICIDAD_PEDIR_ID(Messages.getString("MensajesSistema.electricidad_pedir_ID")); //$NON-NLS-1$

	private final String text;
	

//	private ResourceBundleMensageResource messageSource = new ResourceBundleMensageResource();
//	private Locale local;
	
	
    private MensajesSistema(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
	 
    /**
     * El metodo sirve para imprimir del tirón hermano!
     */
    public void print() {
    	System.out.println(toString());
    }
    
    
}
