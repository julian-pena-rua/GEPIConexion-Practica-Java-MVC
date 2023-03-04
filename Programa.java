import java.awt.Color;

public class Programa {

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//									CONFIGURACION PRINCIPAL
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	//									INFORMACIÓN GENERAL
	//
	
	static String programa_tituloVentana = "PEÑANTASTICO - UTF-8"; 			// titulo del programa
	
	static String programa_logo = 											// Logo del programa
			"imagenes/coderProgrammer.png";
		
	static String programa_nombre = "Peñantástico"; 						// Nombre del programa 

	static String programa_version = "1.0.0.201911";						// Versión instalada 
	
	static String programa_fechaCreacion = "10/2019";						// Fecha creación

	static String programa_descripcion =									// Descripción del programa 
			"Sistema de gestión y control de contactos, en él puede administrar datos de amigos, "
			+ "\n familiares, compañeros de trabajo y clientes.";
	
	static String programa_descripcionCorta =								// Descripción en 100 caracteres 
			"Sistema de Control de Usuarios";

	static String programa_advertencia =									// Descripción del programa 
			"Nota: Para conocer más visite la página: "
			+ "<html><a href='www.heighten.c1.biz'>heighten</a></html>";
		
	static String fabrica_nombre = "heighten"; 								// Compañía fabricante o autor
	
	static String fabrica_copyRight = 										// Derechos de autor o CopyRight
			"CoypRight (c) 2019 - heighten";

	static String fabrica_url_logo = 										// Logo de la compañía fabricante o marca/sello del autor 
			"http://heighten.c1.biz/images/logo.png";

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 										BASE DE DATOS
	//
	static String programa_baseDeDatos =									// dirección o ubicación de la base de datos 
			"basedatos/bd.accdb";
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 											MEDIDAS
	//
	static int altura_Programa = 800; 										// altura del programa
	static int anchura_Programa = 600; 										// anchura del programa
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 											COLORES
	//
	static Color color_tema_app = new Color (71, 132, 222, 100); 			// color del fondo programa
	static Color color_tema_texto  = new Color(000, 000, 000,000); 			// color del fondo del botón
	static Color color_tema_bordes = new Color (12, 64, 139,100); 			// color de los bordes 
	static Color color_tema_botones = new Color (43, 17, 0,100);	 		// color de los botones

	/**
	 *
	 * TODO colores
Color color_tema_app_hover = new Color(0, 0, 0,0); 		// color del fondo programa
Color color_tema_texto_hover  = new Color(0, 0, 0,0); 	// color del fondo del botón
Color color_tema_bordes_hover = new Color (0, 0, 0,0);	// color del texto principal

Color color_tema_claro = new Color (0, 0, 0,0); 		// color del texto en títulos
Color color_tema_oscuro = new Color (0, 0, 0,0); 		// color del fondo de texto
Color color_tema_accion = new Color (0, 0, 0,0);		// color del fondo de texto


#####  Color Palette by Paletton.com
#####  Palette URL: http://paletton.com/#uid=70o0u0kw0quTufIFL5qnSP0nSP0


	 *** Primary color:

shade 0 = #D35300 = rgb(211, 83,  0) = rgba(211, 83,  0,1) = rgb0(0.827,0.325,0)
shade 1 = #7D3100 = rgb(125, 49,  0) = rgba(125, 49,  0,1) = rgb0(0.49,0.192,0)
shade 2 = #2B1100 = rgb( 43, 17,  0) = rgba( 43, 17,  0,1) = rgb0(0.169,0.067,0)
shade 3 = #FF8C41 = rgb(255,140, 65) = rgba(255,140, 65,1) = rgb0(1,0.549,0.255)
shade 4 = #FF8C41 = rgb(255,140, 65) = rgba(255,140, 65,1) = rgb0(1,0.549,0.255)

	 *** Secondary color (1):

shade 0 = #0C408B = rgb( 12, 64,139) = rgba( 12, 64,139,1) = rgb0(0.047,0.251,0.545)
shade 1 = #022253 = rgb(  2, 34, 83) = rgba(  2, 34, 83,1) = rgb0(0.008,0.133,0.325)
shade 2 = #020C1C = rgb(  2, 12, 28) = rgba(  2, 12, 28,1) = rgb0(0.008,0.047,0.11)
shade 3 = #4784DE = rgb( 71,132,222) = rgba( 71,132,222,1) = rgb0(0.278,0.518,0.871)
shade 4 = #4784DE = rgb( 71,132,222) = rgba( 71,132,222,1) = rgb0(0.278,0.518,0.871)

	 *** Secondary color (2):

shade 0 = #D38500 = rgb(211,133,  0) = rgba(211,133,  0,1) = rgb0(0.827,0.522,0)
shade 1 = #7D4F00 = rgb(125, 79,  0) = rgba(125, 79,  0,1) = rgb0(0.49,0.31,0)
shade 2 = #2B1B00 = rgb( 43, 27,  0) = rgba( 43, 27,  0,1) = rgb0(0.169,0.106,0)
shade 3 = #FFB941 = rgb(255,185, 65) = rgba(255,185, 65,1) = rgb0(1,0.725,0.255)
shade 4 = #FFB941 = rgb(255,185, 65) = rgba(255,185, 65,1) = rgb0(1,0.725,0.255)

	 *** Complement color:

shade 0 = #00876C = rgb(  0,135,108) = rgba(  0,135,108,1) = rgb0(0,0.529,0.424)
shade 1 = #005040 = rgb(  0, 80, 64) = rgba(  0, 80, 64,1) = rgb0(0,0.314,0.251)
shade 2 = #001C16 = rgb(  0, 28, 22) = rgba(  0, 28, 22,1) = rgb0(0,0.11,0.086)
shade 3 = #38DDBC = rgb( 56,221,188) = rgba( 56,221,188,1) = rgb0(0.22,0.867,0.737)
shade 4 = #38DDBC = rgb( 56,221,188) = rgba( 56,221,188,1) = rgb0(0.22,0.867,0.737)


#####  Generated by Paletton.com (c) 2002-2014
	 **/

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 										ELEMENTOS VISUALES
	//
	static String programa_imagen_marco_rectangulo =						// marco dentro del frame. Estiliza panel o contenedores 
			"imagenes/marco_rectangulo.png";								
	static String programa_imagen_marco_cuadrado =							// marco dentro del frame. Estiliza panel o contenedores 
			"imagenes/marco_cuadrado.png";
	static String programa_imagen_boton_circular =							// estilo prediseñado del botón 
			"imagenes/boton_circular.png";
	static String programa_imagen_boton_rectangular =						// estilo prediseñado del botón 
			"imagenes/boton_rectangulo.png";
	
	
	public static void main(String[] args) {

		new Vista(programa_tituloVentana);									// inicia el programa

	}
}