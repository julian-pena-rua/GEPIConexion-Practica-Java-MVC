/**
 * @author: JULIAN A. PEÑA
 * @descripción: Clase para el control de la interfaz del usuario.
 * 
 * Copyright (c) 2019 elPena, Inc. Todos los derechos reservados.
 * 
 * elPena le otorga ("Licenciatario") una licencia de uso no exclusiva, libre de regalías,
 * modificar y redistribuir este software en forma de código fuente y binario,
 * siempre que i) este aviso de copyright y licencia aparezcan en todas las copias de
 * El software; y ii) el licenciatario no utiliza el software de manera
 * que desprecia a Sun.
 * *
 * Este software se proporciona "TAL CUAL", sin garantía de ningún tipo. TODAS
 * CONDICIONES, REPRESENTACIONES Y GARANTÍAS EXPRESAS O IMPLÍCITAS, INCLUYENDO CUALQUIERA
 * GARANTÍA IMPLÍCITA DE COMERCIABILIDAD, APTITUD PARA UN PROPÓSITO PARTICULAR O
 * NO INFRACCIÓN, ESTÁN EXCLUIDOS. EL SOL Y SUS LICENCIANTES NO SERÁN
 * RESPONSABLE DE CUALQUIER DAÑO SUFRIDO POR EL LICENCIATARIO COMO RESULTADO DE USAR, MODIFICAR
 * O DISTRIBUIR EL SOFTWARE O SUS DERIVADOS. EN NINGÚN CASO EL SOL O SU
 * LOS LICENCIANTES SERÁN RESPONSABLES POR CUALQUIER INGRESO, GANANCIAS O DATOS PERDIDOS, O POR DIRECTO,
 * DAÑOS INDIRECTOS, ESPECIALES, CONSECUENTES, INCIDENTALES O PUNITIVOS, SIN EMBARGO
 * CAUSADO Y SIN IMPORTAR LA TEORÍA DE RESPONSABILIDAD, DERIVADA DEL USO DE
 * O LA INCAPACIDAD DE USAR EL SOFTWARE, INCLUSO SI EL SOL HA SIDO INFORMADO DE LA
 * POSIBILIDAD DE TALES DAÑOS.
 * *
 * Este software no está diseñado ni destinado para su uso en el control en línea de
 * aeronaves, tráfico aéreo, navegación de aeronaves o comunicaciones de aeronaves; o en
 * el diseño, construcción, operación o mantenimiento de cualquier nuclear
 * instalaciones. El licenciatario declara y garantiza que no utilizará ni
 * redistribuir el Software para tales fines.
 * 
 * */

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.Style;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;




/**
 * Clase vista, contiene los siguientes elementos
 *-----------
 *GUI	    |-> Menú (Barra superior)
 *----		|
 *Vista		|->	Ingresar/Modificar  
 *			|
 *			|->	Eliminar 
 *			|
 *			|->	Búsqueda
 *       	| 
 *         	|-> [Realizar Validaciones]  
 *       	|					De Información {Datos numéricos, formato correo, alfanumérico, contiene caracteres especiales}
 *----------|       			De selección {RadioButton, CheckBox, Dropdown_List, textArea, etc}
 *				     
 *
 * Referentes
 *-----------
 *  Tutorial para el listener: 	https://docs.oracle.com/javase/tutorial/uiswing/examples/events/index.html#MultiListener
 *  Tipos genéricos de clase: 	https://docs.oracle.com/javase/tutorial/java/generics/types.html
 *  30 Atajos de Eclipse:		https://javarevisited.blogspot.com/2018/07/top-30-eclipse-keyboard-shortcuts-java-programming.html
 *	
 *	Tutorial código ejemplo:	https://docs.oracle.com/javase/tutorial/
 *	Diseñar flat:				https://www.youtube.com/watch?v=ieVrk9RnHaI
 *  Diseño  Game:				https://www.freepik.com/premium-vector/casual-game-gui_3931901.htm
 *  Diseño contactos:			https://cdn.dribbble.com/users/625614/screenshots/2946142/my_contact_ui.jpg
 *  Diseño contactos 2:			https://assets.materialup.com/uploads/9fa15ecf-a70d-4866-a7ae-b0a8055cabd4/preview.png
 *  Diseño UX:					https://www.freepik.com/free-vector/set-mobile-screens-with-ui-applications-including-music-player-photos_4027741.htm#page=1&query=ux%20icon%20set&position=1
 *	
 *  GUIA GUI Java 				https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
 *  GUIA GUI Java parte 2		https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI_2.html
 *	
 *	Guia imagenes 				https://docs.oracle.com/javase/tutorial/2d/images/index.html 
 *	Componente ICON				https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
 *
 *  Validacio en TextField		https://www.lawebdelprogramador.com/foros/Java/1677101-VALIDACION-EN-UN-TEXTFIELD.html
 *	Validación correo			https://entredesarrolladores.com/17058/validación-e-mail-en-java
 * 
 * 	MenuBar						https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
 * 								http://zetcode.com/tutorials/javaswingtutorial/menusandtoolbars/
 * 								http://www.java2s.com/Code/JavaAPI/javax.swing/JMenuBarsetLayoutLayoutManagermgr.htm
 * 								http://www.java2s.com/Code/JavaAPI/javax.swing/JMenuBarsetLayoutLayoutManagermgr.htm
 * 
 * 	Salvar o Guardar Exportar	https://coderanch.com/t/333001/java/Save-Open-files-realistically-code
 * 	Convertir Lista en Array	https://devqa.io/convert-list-to-array-in-java/
 * 
 * 	JComboBox autocompletado 	https://www.algosome.com/articles/java-jcombobox-autocomplete.html
 * 	Buscar en JComboBox			https://coderanch.com/t/330315/java/search-JComboBox
 * 
 * 	
 * 	Diseños Splash inspiradores	https://www.justinmind.com/blog/20-inspiring-splash-screen-designs/
 * 
 * 
 * 	Panel 						https://www.codejava.net/java-se/swing/jpanel-basic-tutorial-and-examples
 *  Buenas prácticas Panel		https://stackoverflow.com/questions/18025167/is-there-a-better-way-to-set-an-initial-position-for-a-jpanel-graphic
 *  
 *  HTML CSS JAVA SWING			https://dzone.com/articles/htmlcssjavascript-gui-java-0
 *  StyleSheet Java SWING		https://www.programcreek.com/java-api-examples/index.php?api=javax.swing.text.html.StyleSheet
 */
public class Vista extends JFrame implements WindowListener, ActionListener{

	//												REQUERIDAS

	private static final long serialVersionUID = 1L; 				// ??
	int contador = 0;												// variable de conteo 

	public Vista(String titulo)
	{

		// CREA Y ORGANIZA LA VENTANA
		super(titulo); // TITULO PROGRAMA, Recibe del main
		this.setSize(Programa.altura_Programa,Programa.anchura_Programa); // Tama de ventana {altura, anchura}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 

		// CREA Y CONFIGURA EL CONTENEDOR
		Vista usuarios = this;
		usuarios.setLocationRelativeTo(null); // ubica la ventana en el centro de la pantalla

		//	AÑADE AL FRAME 		
		super.setJMenuBar(layout_barraMenuArriba()); // Barra de menú
		pantalla_Bienvenida(); // pantalla de inicio o bienvenida

		usuarios.setVisible(true); // exhibe la ventana
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//										LAYOUT O ELEMENTOS VISUALES
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public JLabel layout_imagenWeb(String urlLink, String nombreImagen, float[] posicion, int[] dimensiones) {

		// Label con logo 
		URL url;
		try { // try para la URL
			url = new URL( urlLink); // establece la ruta URL
			ImageIcon iconImage = new ImageIcon (url, nombreImagen); //configura un icono con la url y el titulo deseado 
			Image escalada = escalarImagen(iconImage.getImage(), new int[] {dimensiones[0], dimensiones[1]});
			ImageIcon iconEscalado = new ImageIcon(escalada);

			JLabel textoLogo = new JLabel(); // genera una etiqueta de texto
			textoLogo.setIcon(iconEscalado); // establece el icono
			textoLogo.setText(null);
			textoLogo.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas

			return textoLogo; 

		} catch (MalformedURLException e) { // obtiene los errores sobre la URL 

			e.printStackTrace(); // imprime el evento de error obtenido
		}
		return null;
	}
	public JLabel layout_imagenLocal(String urlLink, String nombreImagen, float[] posicion, int[] dimensiones) {


		ImageIcon iconImagen = new ImageIcon (urlLink, nombreImagen); //configura un icono con la url y el titulo deseado 
		Image escalada = escalarImagen(iconImagen.getImage(), new int[] {dimensiones[0], dimensiones[1]});
		ImageIcon iconEscalado = new ImageIcon(escalada);

		JLabel textoLogo = new JLabel(); // genera una etiqueta de texto
		textoLogo.setIcon(iconEscalado); // establece el icono
		textoLogo.setText(null);
		textoLogo.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas

		return textoLogo; 

	}
	public Image escalarImagen(Image imagen, int[] dimensiones) {

		Image escalada = imagen.getScaledInstance(dimensiones[0], dimensiones[1], Image.SCALE_SMOOTH);

		return escalada;
	}
	public void layout_fondoColor(Color color) {

		Vista ventana = this; // establece la ventana actual

		ventana.getContentPane().setBackground(color); // configura los colores

	}
	public JMenuBar layout_barraMenuArriba() {

		Vista ventana = this;  // Genera el frame ("Cuadro") y contenedor

		JMenuBar menuBar = new JMenuBar(); // crea una barra de menú (esta generalmente está ubicada en la parte superior del app
		menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // cambia la orientación

		// OPCION ARCHIVO
		JMenu archivoMenu = new JMenu("Archivo"); // crea un menu

		// TODO SUBMENU ABRIR
		JMenuItem abrirItem = new JMenuItem("Abrir"); // crea un item de menú
		abrirItem.addActionListener(ventana); // interactuar con item de menú
		//archivoMenu.add(abrirItem); // añade item al menú
		abrirItem.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {

				/* ----------------------------ABRIR ARCHIVO------------------------------ */
				JFileChooser selectorArchivo = new JFileChooser();
				selectorArchivo.setCurrentDirectory(new File(System.getProperty("user.dir")));
				selectorArchivo.showOpenDialog(ventana);
				{
					try {
						File archivo = selectorArchivo.getSelectedFile();
						new FileWriter(archivo);

					}
					catch (IOException ioe) {
						System.out.println(ioe);
					};

				}
			}

		});

		// TODO SUBMENU GUARDAR
		JMenuItem guardarItem = new JMenuItem("Guardar"); // crea un item de menú
		guardarItem.addActionListener(ventana); // interactuar con item de menú
		//archivoMenu.add(guardarItem); // añade item al menú

		guardarItem.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {

				/* ----------------------------GUARDAR ARCHIVO------------------------------ */
				JFileChooser selectorArchivo = new JFileChooser();
				selectorArchivo.setCurrentDirectory(new File(System.getProperty("user.dir")));
				selectorArchivo.showSaveDialog(ventana);
				{
					try {
						File archivo = selectorArchivo.getSelectedFile();
						new FileWriter(archivo);

						/*TODO: guardar ventana de datos de contacto */



					}
					catch (IOException ioe) {

					};

				}
			}


		});

		// SUBMENU SALIR
		JMenuItem salirItem = new JMenuItem("Salir"); // crea un item de menú
		abrirItem.addActionListener(ventana); // interactuar con item de menú
		archivoMenu.add(salirItem); // añade item al menú
		salirItem.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {

				ventana.dispose(); // salir del frame

			}

		});


		// OPCION EDICION
		JMenu edicionMenu = new JMenu("Edición"); // crea un menu
		// 

		JMenuItem nuevoItem = new JMenuItem("Ingresar"); // crea un item de menú
		edicionMenu.add(nuevoItem);// añade item al menú

		nuevoItem.addActionListener(new ActionListener() { // interactuar con item de menú
			public void actionPerformed(ActionEvent e) {
				pantalla_ingresarUsuario(); // limpia y pinta la ventana ingresar

			}
		}); 

		JMenuItem eliminarItem = new JMenuItem("Eliminar"); // crea un item de menú
		edicionMenu.add(eliminarItem); // añade item al menú


		eliminarItem.addActionListener(new ActionListener() { // interactuar con item de menú
			public void actionPerformed(ActionEvent e) {
				pantalla_eliminar(); // limpia y pinta la ventana eliminar
			}

		});


		// sistema para OPCION VER
		JMenu verMenu = new JMenu("Ver");  // crea un menu
		// 
		JMenuItem buscarItem = new JMenuItem("Buscar"); // crea un item de menú
		verMenu.add(buscarItem); // añade item al menú
		buscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla_buscar(); // limpia y pinta la ventana buscar
			}

		});

		JMenuItem informeItem = new JMenuItem("Informes"); // crea un item de menú
		//verMenu.add(informeItem); // añade item al menú

		JMenuItem registroItem = new JMenuItem("Registros"); // crea un item de menú
		//verMenu.add(registroItem); // añade item al menú

		// OPCION AYUDA
		JMenu ayudaMenu = new JMenu("Ayuda");  // crea un menu

		JMenuItem creditosItem = new JMenuItem("Creditos"); // crea un item de menú
		ayudaMenu.add(creditosItem); // añade item al menú
		creditosItem.addActionListener(new ActionListener() { // interactuar con item de menú
			public void actionPerformed(ActionEvent e) {
				pantalla_creditos(); // limpia y pinta la ventana créditos
			}

		});

		// AÑADE A BARRA DE MENÚ
		menuBar.add(archivoMenu); // añade menú a la barra de menú 
		menuBar.add(edicionMenu); // añade menú a la barra de menú
		menuBar.add(verMenu); // añade menú a la barra de menú
		menuBar.add(ayudaMenu); // añade menú a la barra de menú

		menuBar.setBackground(Programa.color_tema_app); // establce el color del componente

		return menuBar;

	}
	public JMenuBar layout_barraMenuIzquierda() {

		// TODO: Configurar la barra lateral de menú 

		Vista usuarios = this;  // Genera el frame ("Cuadro") y contenedor

		// BARRA DE MENU LATERAL

		JMenuBar menuBar = new JMenuBar(); // crea una barra de menú (esta generalmente está ubicada en la parte superior del app

		menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.PAGE_AXIS)); // Cambia la orientación del menú
		menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK)); // cambia tamaño y color {importar librerias BorderFactory y Color}


		// OPCION ARCHIVO
		JMenu archivoMenu = new JMenu("Archivo"); // crea un menu

		// SUBMENU ABRIR
		JMenuItem abrirItem = new JMenuItem("Abrir"); // crea un item de menú
		abrirItem.addActionListener(usuarios); // interactuar con item de menú
		archivoMenu.add(abrirItem); // añade item al menú


		// OPCION EDICION
		JMenu edicionMenu = new JMenu("Edición"); // crea un menu
		// 
		JMenuItem editarItem = new JMenuItem("Editar");  // crea un item de menú
		edicionMenu.add(editarItem); // añade item al menú


		JMenuItem nuevoItem = new JMenuItem("Ingresar"); // crea un item de menú
		edicionMenu.add(nuevoItem);// añade item al menú

		nuevoItem.addActionListener(new ActionListener() { // interactuar con item de menú
			public void actionPerformed(ActionEvent e) {
				pantalla_ingresarUsuario(); // limpia y pinta la ventana ingresar

			}
		}); 

		JMenuItem eliminarItem = new JMenuItem("Eliminar"); // crea un item de menú
		edicionMenu.add(eliminarItem); // añade item al menú


		eliminarItem.addActionListener(new ActionListener() { // interactuar con item de menú
			public void actionPerformed(ActionEvent e) {
				pantalla_eliminar(); // limpia y pinta la ventana eliminar
			}

		});


		// sistema para OPCION VER
		JMenu verMenu = new JMenu("Ver");  // crea un menu
		// 
		JMenuItem buscarItem = new JMenuItem("Buscar"); // crea un item de menú
		verMenu.add(buscarItem); // añade item al menú
		buscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla_buscar(); // limpia y pinta la ventana buscar
			}

		});

		JMenuItem informeItem = new JMenuItem("Informes"); // crea un item de menú
		verMenu.add(informeItem); // añade item al menú

		JMenuItem registroItem = new JMenuItem("Registros"); // crea un item de menú
		verMenu.add(registroItem); // añade item al menú


		// OPCION AYUDA
		JMenu ayudaMenu = new JMenu("Ayuda");  // crea un menu


		// OPCION FAQ
		JMenu faqItem = new JMenu("FAQ");  // crea un menu
		ayudaMenu.add(faqItem); // añade item al menú
		JMenuItem creditosItem = new JMenuItem("Creditos"); // crea un item de menú
		ayudaMenu.add(creditosItem); // añade item al menú
		creditosItem.addActionListener(new ActionListener() { // interactuar con item de menú
			public void actionPerformed(ActionEvent e) {
				pantalla_creditos(); // limpia y pinta la ventana créditos
			}

		});


		// AÑADE A BARRA DE MENÚ
		menuBar.add(archivoMenu); // añade menú a la barra de menú 
		menuBar.add(edicionMenu); // añade menú a la barra de menú
		menuBar.add(verMenu); // añade menú a la barra de menú
		menuBar.add(ayudaMenu); // añade menú a la barra de menú


		return menuBar;
	}
	public JTextField layout_ingresarTexto( String textoInicial, String textoConsejo, float[] posicion, int[] dimensiones) {

		Vista ventana = this;  // Genera el frame ("Cuadro") y contenedor

		JTextField entrada = new JTextField();  //cuadro o campo de texto		

		ventana.add(entrada); // agrega el campo de texto al frame 
		entrada.setBounds((int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas
		entrada.setToolTipText(textoConsejo); // establece un texto emergente 
		entrada.setText(textoInicial); //configura un valor para exhibir 
		//entrada.setBackground(color_tema_app); // configura el color
		entrada.setEditable(true); // exhibe el campo de texto

		return entrada;

	}
	public JLabel layout_etiquetadeTexto(String texto, float[] posicion, int[] dimensiones, String nombreFuente, int estiloFuente, int tamanoFuente) {
		Vista ventana = this;  // Genera el frame ("Cuadro") y contenedor

		JLabel texoLayout = new JLabel(); // genera una etiqueta de texto

		ventana.add(texoLayout); // agrega la etiqueta de texto al frame 
		texoLayout.setText("<html> <p style ='color: rgb( " + Programa.color_tema_texto + ")'> " + texto + "</p> </html>"); //configura un valor para exhibir 


		texoLayout.setBounds((int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas
		texoLayout.setFont(new Font(nombreFuente, estiloFuente, tamanoFuente)); // configura la fuente, estilo y tamaño de letra

		return texoLayout;
	} 
	public void layout_tituloVentana(String titulo) {
		Vista ventana = this; // Genera el frame ("Cuadro") y contenedor

		
		JLabel tituloLabel = new JLabel(); // genera una etiqueta de texto

		double posicion[] = {0.25, 0.11}; // establece posición en X - Y
		int[] dimensiones = {2000, 50}; // establece medidas anchura - altura

		String nombreFuente = "cambria"; // establece el nombre de la fuente
		int tamanoFuente = 46; // tamaño de la letra


		ventana.add(tituloLabel); // agrega la etiqueta de texto al frame 
		tituloLabel.setText("<html> <p style ='z-indez=100;  color: rgb( " + Programa.color_tema_texto + ")'> " + titulo + "</p> </html>"); //configura un valor para exhibir 

		tituloLabel.setBounds((int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas
		tituloLabel.setFont(new Font(nombreFuente,Font.ITALIC, tamanoFuente)); // configura la fuente, estilo y tamaño de letra


	}
	public JLabel layout_etiquetaIconoFontAwesome(String nombreIcono, float[] posicion, int[] dimensiones) throws FileNotFoundException {
		// TODO: Finalizar fuente de texto a travéz del css
		
		// https://alvinalexander.com/blogs/post/jfc-swing/how-add-style-stylesheet-jeditorpane-example-code
		// https://www.programcreek.com/java-api-examples/index.php?api=javax.swing.text.html.StyleSheet

		// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
		// https://www.programcreek.com/java-api-examples/index.php?api=javax.swing.text.html.CSS.Attribute
		// https://www.javatips.net/api/javax.swing.text.html.stylesheet
		
		Vista ventana = this; // Genera el frame ("Cuadro") y contenedor

		JEditorPane editorpane = new JEditorPane();
		editorpane.setEditable(false); // sólo lectura
		HTMLEditorKit kit = new HTMLEditorKit();
		editorpane.setEditorKit(kit);
		
		JLabel tituloLabel = new JLabel(); // genera una etiqueta de texto

		String nombreFuente = "cambria"; // establece el nombre de la fuente
		int tamanoFuente = 46; // tamaño de la letra

		//File archivoCSS = new File("css/font_awesome_min.css");  // carga el archivo css
		//Scanner scan = new Scanner(archivoCSS);					 // lee el archivo css
		
		HTMLDocument documento = new HTMLDocument();			
		StyleSheet stylesheet = documento.getStyleSheet();
		Enumeration<?> reglas = stylesheet.getStyleNames();
		
		
		//while (scan.hasNext()) {
			//System.out.println(scan.next());
			
		//}
				
		/*
		while (reglas.hasMoreElements()) {
			String nombre = (String)reglas.nextElement();
			Style regla = stylesheet.getStyle(nombre);
		}
		*/
		
		kit.setStyleSheet(stylesheet);
		
		ventana.add(tituloLabel); // agrega la etiqueta de texto al frame 
		tituloLabel.setText(""                             //configura un valor para exhibir
				+ "<html>"
				+ "<head>"
				+ "<link rel=\'stylesheet\' href=\'css/font_awesome_min.css\'>"
				+ "</head>"
				+ "<body>"
				+ "<i class='fab fa-500px' style='font-size:24px'></i>"
				+ "<i class='" + nombreIcono + "' "
						+ "style='font-size:24px'"
						+ "color: rgb( " + Programa.color_tema_texto 
						+ "></i>"
				+ "</body>"
				+ "</html>"); 

		tituloLabel.setBounds((int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas
		tituloLabel.setFont(new Font(nombreFuente,Font.ITALIC, tamanoFuente)); // configura la fuente, estilo y tamaño de letra

		return tituloLabel;

	}
	public JComboBox<String> layout_listaDesplegable(String[] elementos, String textoSugerencia, float[] posicion, int[] dimensiones) {


		JComboBox<String> listaDesplegable = new JComboBox<String>(elementos); // crea un objeto de la clase ComboBox

		listaDesplegable.setBounds((int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // configura las posiciones [X, Y] y dimensiones [Altura, Anchura]   

		listaDesplegable.setToolTipText(textoSugerencia); // configura un mensaje emergente

		//listaDesplegable.setBackground(color_tema_app); // configura el color

		listaDesplegable.setEditable(true); // permite que se ingrese texto al campo

		// TODO: https://www.logicbig.com/tutorials/java-swing/combo-box-icons.html

		return listaDesplegable; // devuelve el objeto de tipo ComboBox


	}
	public JButton layout_boton(String etiquetaBoton, float[] posicion, int[] dimensiones, boolean estado) {

		JButton boton = new JButton(etiquetaBoton); // 1. Crea un boton 

		boton.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // 2. Dar dimensiones

		boton.setText(etiquetaBoton); // establece el texto del botón

		boton.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas

		//boton.setBackground(Programa.color_tema_botones); // establece un color de fondo

		boton.setEnabled(estado); // establece si está activo

		return boton; 


	}
	public JButton layout_botonImagen(String etiquetaBoton, String urlLinkImagen, String nombreImagen, float[] posicion, int[] dimensiones, boolean estado) {
		// TODO incluir propiedades de BotonNormal, BotonHover, BotonActivo, BotonInactivo, otro estilo/personalizado, botonPresionado

		// TODO puede tener varios estilos; circulo, obalado, cuadrado, rectacgulo, estrella, etc.

		// el estilo puede tener opciones como colores principales, fondo, bordes, margenes, etc.

		// tener opción si puede tener "badge" o notificación (número indicando mensajes, compras, etc)

		// BOTON

		URL url;
		try { // try para la URL
			url = new URL( urlLinkImagen); // establece la ruta URL

			ImageIcon iconImage = new ImageIcon (url, nombreImagen); //configura un icono con la url y el titulo deseado 

			Image escalada = escalarImagen(iconImage.getImage(), new int[] {dimensiones[0], dimensiones[1]}); // establece las dimensiones de la imagen

			ImageIcon iconEscalado = new ImageIcon(escalada); // escala la imagen con las dimensiones

			JButton boton = new JButton(etiquetaBoton); // 1. Crea un boton 

			boton.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // 2. Dar dimensiones

			boton.setIcon(iconEscalado); // establece el icono en el botón

			boton.setText(etiquetaBoton); // establece el texto del botón

			boton.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas

			boton.setBackground(Programa.color_tema_botones); // establece un color de fondo

			boton.setEnabled(estado); // establece si está activo

			return boton; 

		} catch (MalformedURLException e) { // obtiene los errores sobre la URL 

			e.printStackTrace(); // imprime el evento de error obtenido
		}

		return null;

	}
	public void layout_btnVolver() {

		Vista ventana = this; // crea la clase actual

		// 1. Crea un bot�n
		JButton volver = new JButton("Volver"); 

		// 2. Dar dimensiones
		volver.setBounds( (int)(getWidth()*(0.8)), (int)(getHeight()*(0.85)), 120, 20);

		// 3. Agregar al Frame
		ventana.add(volver); 

		// 4. Agregar disparador de evento del frame
		volver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				getContentPane().removeAll();
				//setTitle("MENÚ PRINCIPAL");
				pantalla_Bienvenida();
				ventana.repaint();

			}
		}); 

	}
	public void layout_RadioButtons(String[] opciones, float[] posicion, int[] dimensiones ) {

		Vista ventana = this; // Genera la vista, el frame, contenedor o ventana

		ButtonGroup grupoBotones = new ButtonGroup();  // grupo de radioButton

		for (int i = 0 ; i < opciones.length; i ++) { // crea dinámicamente los radiobutton según la cantidad del array
			JRadioButton radioBtn = new JRadioButton(opciones[i]); // crea un radioButton

			/* 
			System.out.println("Item: " + i   // Busca determinar la posición y dimensiones de los elementos 
					+ " texto: " + opciones[i]
					+ " posicion x : " + ((int)(getWidth()*( posicion[0] + 100 * ( i % 2) )))
					+ " posicion y : " + ((int)(getWidth()*( posicion[1] + 0.1 * (i / 2))))
					+ " dimension w : " + ((int)(getWidth()*( dimensiones[1]  )))
					+ " dimension h : " + ((int)(getWidth()*( dimensiones[1]  )))
					);
			 */

			radioBtn.setActionCommand(opciones[i]); // establece el comando de acción con el nombre

			grupoBotones.add(radioBtn);	// agrega a un grupo de botones el radio button, de esta manera sólo permite registrar una opción

			radioBtn.setBounds((int)(getWidth()*(posicion[0]) + 100 * ( i % 2) ), (int)(getHeight()*(posicion[1] + 0.1 * (i / 2))), dimensiones[0], dimensiones[1]); // 2. Dar dimensiones

			ventana.add(radioBtn); // agrega el botón al frame

			radioBtn.setBackground(Programa.color_tema_bordes);

		}

	}
	public JCheckBox layout_checkBoxButtons(String opcion, float[] posicion, int[] dimensiones) {

		JCheckBox checkBox = new JCheckBox(opcion); // crea un objeto checkBox
		checkBox.setSelected(true); // se establece activdado
		checkBox.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y medidas
		checkBox.setBackground(Programa.color_tema_bordes);

		return checkBox;


	}
	public int layout_counterInputAndButton(float[] posicion, int[] dimensiones) {

		Vista ventana = this; // frame

		JTextField campoContador = new JTextField("0");	// crea un componente para campo de texto
		campoContador.setEditable(false);				// deshabilita la edición del campo de texto

		JButton btnMas = new JButton("+");				// crea un componente botón  
		JButton btnMenos = new JButton("-");			// crea un componente botón

		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				contador = Integer.parseInt((campoContador.getText())) + 1;
				campoContador.setText(contador + ""); // alternativa para mostrar un int como String

			}
		});

		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				contador = Integer.parseInt((campoContador.getText())) - 1;

				if (contador < 0 ) {	// no permite el registro de valores negativos
					contador = 0; 
				}
				campoContador.setText(contador + ""); // alternativa para mostrar un int como String
			}
		});

		// establece la posición y medidas
		campoContador.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); 
		btnMas.setBounds( (int)(getWidth()*(posicion[0] + 0.13)), (int)(getHeight()*(posicion[1] + 0.00)), dimensiones[0], dimensiones[1]/2); 
		btnMenos.setBounds( (int)(getWidth()*(posicion[0] + 0.13)), (int)(getHeight()*(posicion[1] + 0.083)), dimensiones[0], dimensiones[1]/2);

		// Adicion de elementos al frame
		ventana.add(campoContador);
		ventana.add(btnMas);
		ventana.add(btnMenos);

		// adiciona el color
		btnMas.setBackground(Programa.color_tema_botones);
		btnMenos.setBackground(Programa.color_tema_botones);


		return contador;

	}	
	public JProgressBar layout_barraProgreso(int min, int max, float[] posicion, int[] dimensiones) {
		// TODO puede tener dos estilos; circulo o linea
		// https://docs.oracle.com/javase/tutorial/uiswing/components/progress.html

		JProgressBar barraProgreso = new JProgressBar(min, max);	// cre un componente barra de progreso
		barraProgreso.setValue(0);  								// establece en valor inicial
		barraProgreso.setStringPainted(true); 						// pinta el componente

		barraProgreso.setBackground(Programa.color_tema_app); 				// establece color ppal


		barraProgreso.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y dimensiones

		return barraProgreso; 										// devuelve el componente barra de progreso

	}
	public JProgressBar layout_barraNivel(int min, int max, float[] posicion, int[] dimensiones) {
		// esta barra es la que el usuario puede mover su propiedad, como el volumen, medida, etc.
		// TODO puede tener dos estilos; circulo o linea
		// TODO tambien el separador, circulo, cuadrado, calavera, etc

		JProgressBar barraProgreso = new JProgressBar(min, max); 	// cre un componente barra de progreso
		barraProgreso.setValue(0);  								// establece en valor inicial
		barraProgreso.setString("");  								// establece el texto en el componente
		barraProgreso.setBackground(Programa.color_tema_app);

		barraProgreso.setBounds( (int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y dimensiones

		barraProgreso.setOrientation(SwingConstants.VERTICAL);		// establece otra orientación (Sólo VERTICAL / HORIZONTAL)

		return barraProgreso; 										// devuelve el componente barra de progreso


	}
	public void layout_contenedordeTexto(float[] posicion, int[] dimensiones, Color color) {
		// este es el fondo que se usa para cuadros de texto

		Vista ventana = this; 										// crea el frame
		JTextArea fondodeTexto = new JTextArea(); 					// crea un area para texto
		fondodeTexto.setBounds((int)(getWidth()*(posicion[0])), (int)(getHeight()*(posicion[1])), dimensiones[0], dimensiones[1]); // establece la posición y dimensiones
		ventana.add(fondodeTexto);									// adiciona al frame
		fondodeTexto.setBackground(color);							// establece un nuevo color
	}
	public void layout_contenedordeGUI(Color color) {
		// este es el fondo principal de la ventana, tiene el mismo tamaño de la ventana

		Vista ventana = this;										// crea el frame
		JTextArea contenedorGUI = new JTextArea();					// crea un área de texto
		contenedorGUI.setBounds((int)(getWidth()*(0.0)), (int)(getHeight()*(0.0)), 1000, 2000); // establece la posición y dimensiones
		ventana.add(contenedorGUI);								// adiciona al frame
		contenedorGUI.setBackground(color);							// establece un nuevo color

	}
	public void layout_scrollBar(JPanel panel) {

		Vista ventana = this;	// establece el frame

		JScrollPane scroll = new JScrollPane(panel
				, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				,  JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setPreferredSize((new Dimension((int)(Programa.anchura_Programa*0.99), (int)(Programa.altura_Programa*0.5)))); // establece las medidas del scroll));

		scroll.revalidate();

		ventana.add(scroll); 

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//										VENTANAS o PANTALLAS
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void pantalla_Bienvenida() {

		// CREA Y CONFIGURA EL CONTENEDOR
		Vista ventana = this; // Genera el frame ("Cuadro") y contenedor
				
		Container contenedor = ventana.getContentPane(); // crea un contenedor
		
		contenedor.setLayout(null ); //limpia la vista mas info https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html


		// ADICION DE ELEMENTOS DE TEXTO

		ventana.add( layout_etiquetadeTexto(
				Programa.programa_nombre
				, new float[] {(float) 0.28, (float) 0.1 } 
				, new int[] {500, 90}
				, "arial"
				, Font.ITALIC
				, 70) );  

		try {
			ventana.add( layout_etiquetaIconoFontAwesome(
					"fab fa-500px"
					, new float[] {(float) 0.1, (float) 0.3 } 
					, new int[] {200, 90} ));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ventana.add( layout_etiquetadeTexto(
				Programa.programa_descripcionCorta
				, new float[] {(float) 0.34, (float) 0.24 } 
				, new int[] {220, 20}
				, "serif"
				, Font.BOLD
				, 12) );  

		ventana.add( layout_etiquetadeTexto(
				Programa.fabrica_copyRight
				, new float[] {(float) 0.8, (float) 0.85 } 
				, new int[] {500, 20}
				, "Sefir"
				, Font.BOLD
				, 8) );  

		// adiciona una imagen
		ventana.add( layout_imagenLocal(
				Programa.programa_logo
				, "Imagen logo empresa " 
						+ Programa.programa_nombre
						, new float[] {(float) 0.10, (float) 0.08 } 
				, new int[] {150, 150 }));


		// establece el color de fondo
		layout_fondoColor(Programa.color_tema_app);

	}	
	public void pantalla_ingresarUsuario()
	{

		Vista ventana = this; 								// Genera el frame ("Cuadro") y contenedor

		Container contenedor = ventana.getContentPane(); 	// crea un contenedor
		contenedor.setLayout(null ); 						//limpia la vista mas info https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

		super.getContentPane().removeAll(); 				// remueve el contenido del contenedor 

		
		layout_tituloVentana("INGRESAR USUARIO");  			// funcion para establecer el título de la ventana

		JTextField fieldCedula 			= layout_ingresarTexto("0000000", "Ingresar número de cédula", new float[] { (float) 0.2 , (float) 0.25}, new int[] {500,20}); // 

		JTextField fieldNombre 			= layout_ingresarTexto("Nombre Nombre", "Ingresar nombres", new float[] { (float) 0.2 , (float) 0.30}, new int[] {500,20});

		JTextField fieldApellido 		= layout_ingresarTexto("Apellido Apellido", "Ingresar nombres", new float[] {(float) 0.2 , (float) 0.35}, new int[] {500,20});

		JTextField fieldDireccion 		= layout_ingresarTexto("Avenida Siepre viva", "Ingresar dirección", new float[] { (float) 0.2 , (float) 0.40}, new int[] {500,20});

		JTextField fieldCorreo 			= layout_ingresarTexto("nombre@correo.com", "Ingresar correo electrónico", new float[] { (float) 0.2 , (float) 0.45}, new int[] {500,20});

		JTextField fieldNacionalidad 	= layout_ingresarTexto("Árabe", "Ingresar nacionalidad", new float[] { (float) 0.2 , (float) 0.50}, new int[] {500,20});

		JTextField fieldEdad 			= layout_ingresarTexto("15", "Ingresar edad", new float[] { (float) 0.2 , (float) 0.55}, new int[] {500,20});

		JTextField fieldTelefono 		= layout_ingresarTexto("(034) 456 7895", "Ingresar télefono", new float[] { (float) 0.2 , (float) 0.60}, new int[] {500,20});

		JTextField fieldCelular 		= layout_ingresarTexto("311 340 4885", "Ingresar celular", new float[] { (float) 0.2 , (float) 0.65}, new int[] {500,20}); 


		JButton botonIngresar = new JButton(); 		// crea un btoón
		botonIngresar.setBounds((int)(getWidth()*(0.2)), (int)(getHeight()*(0.7)), 500, 20); 	// establece la posición y medidas


		JLabel imprimirTexto = new JLabel();// crea un label o etiqueta de texto
		imprimirTexto.setBounds((int)(getWidth()*(0.14)), (int)(getHeight()*(0.75)), 900, 50);	// establece la posición y medidas

		// al hacer click en el botón
		// esta función busca capturar los datos ingresados
		// en los campos de texto para luego almacenarlos
		// en la base de datos ACCESS
		botonIngresar.addActionListener(new ActionListener() { 	
			public void actionPerformed(ActionEvent e) { 		

				/* TODO: ingreso de usuarios a base de datos ACCESS */

				String texto = 
						" " + fieldNombre.getText() + 
						" " + fieldApellido.getText() + 
						" " + fieldCedula.getText() + 
						" " + fieldDireccion.getText() + 
						" " + fieldCorreo.getText() +
						" " + fieldNacionalidad.getText() + 
						" " + fieldEdad.getText() + 
						" " + fieldTelefono.getText() + 
						" " + fieldCelular.getText() 
						;

				imprimirTexto.setText(texto);	 // configura la etiqueta con texto deseado

				/* VALIDACIONES */

				// OBTENCIÓN DE VALORES CAPTURADOS EN LOS CAMPOS DE TEXTO
				String fieldCedulaString 		= fieldCedula.getText();
				String fieldNombreString 		= fieldNombre.getText();
				String fieldApellidoString 		= fieldApellido.getText();
				String fieldDireccionString 	= fieldDireccion.getText();
				String fieldCorreoString 		= fieldCorreo.getText();
				String fieldNacionalidadString 	= fieldNacionalidad.getText();
				String fieldEdadString 			= fieldEdad.getText();
				String fieldTelefonoString 		= fieldTelefono.getText();
				String fieldCelularString 		= fieldCelular.getText();

				// CONFIGURACIÓN PARA MENSAJE DE ALERTA
				String alertaValidacionTitulo	= "ERROR EN INGRESO DE DATOS";	// Titulo de ventana
				String alertaValidacionMensaje 	= ""; 							// Mensaje inicia vacío y se rellena según el caso


				// TODO: Metodos o funciones de validación de String sea numeros, letras, caracteres especiales, etc.
				if (!fieldCedulaString.matches("[1234567890]*")) {
					alertaValidacionMensaje = alertaValidacionMensaje + "Se esperaba una cédula numérica.";

				}				
				else {
					if((!fieldNombreString.matches("[abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ ]*"))){
						alertaValidacionMensaje = alertaValidacionMensaje + "Se esperaba un nombre sin caractéres especiales o números."; 

					}
					else {
						if((!fieldApellidoString.matches("[abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ ]*"))){
							alertaValidacionMensaje = alertaValidacionMensaje + "Se esperaba un apellido sin caractéres especiales o números."; 
						}
						else {
							Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
									+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");		// patrón de validación
							Matcher semejanza = patron.matcher(fieldCorreoString);				 	// validador de semejanza
							if (semejanza.find() == false) {

								alertaValidacionMensaje = alertaValidacionMensaje + "Se esperaba un correo con el formato: correo@dominio.com. ";

							}
							else {
								if((!fieldNacionalidadString.matches("[abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ ]*"))){
									alertaValidacionMensaje = alertaValidacionMensaje +  "Se esperaba una nacionalidad sin caractéres especiales o números. "; 
								}
								else {
									if((!fieldEdadString.matches("[1234567890]*"))){
										alertaValidacionMensaje = alertaValidacionMensaje + "Se esperaba una edad numérica. "; 
									}
									else {
										if((!fieldTelefonoString.matches("[1234567890 ]*"))){
											alertaValidacionMensaje = alertaValidacionMensaje + "Se esperaba una teléfono numérico. "; 
										}

										else {
											if((!fieldCelularString.matches("[1234567890 ]*"))){
												alertaValidacionMensaje = alertaValidacionMensaje + "Se esperaba una celular numérico."; 
											}
										}
									}
								}
							}
						}
					}
				}


				if (alertaValidacionMensaje == "") { // Valida que no exista algún mensaje


					Usuarios objUsuario = new Usuarios(); // genera un nuevo objeto usuario

					//	ALMACENA LOS DATOS DEL TEXFIELD EN EL OBJETO USUAARIO
					objUsuario.setCedula(fieldCedulaString);
					objUsuario.setNombre(fieldNombreString);
					objUsuario.setApellido(fieldApellidoString);
					objUsuario.setDireccion(fieldDireccionString);
					objUsuario.setCorreo(fieldCorreoString);
					objUsuario.setNacionalidad(fieldNacionalidadString);
					objUsuario.setEdad(Integer.parseInt(fieldEdadString));
					objUsuario.setTelefono(fieldTelefonoString);
					objUsuario.setCelular(fieldCelularString);

					/* INSERTAR EN BASE DE DATOS */

					Controlador conexion = new Controlador(); // Genera un nuevo objeto controlador

					conexion.DB_AbrirConexion(); // establece la conexión con la base de datos

					// Si al ejecutar el comando no devuelve un error entonces puede ingresar el usuario
					if ( conexion.DB_EjecutarQuery(objUsuario.setQueryBuscarUsuario(fieldCedulaString)) == null ) {  
						conexion.DB_EjecutarUpdateQuery(objUsuario.setQueryIngresarUsuario());
						JOptionPane.showMessageDialog(ventana , "El usuario fue ingresado correctamente.", "REGISTRO CORRECTO", getDefaultCloseOperation());
					}
					else
					{												
						Object[] opciones = {
								"Si, por favor"
								, "De ninguna manera"};

						int opcionSeleccioada = JOptionPane.showOptionDialog( // CUADRO DE CONFIRMACIÓN PERSONALIZADO (Se inicia como Int porque sus propiedades o estados están almacenados en un vector)  
								ventana
								, "¿Desea actualizar usuario?"
								, "Vetana emergente"
								, JOptionPane.YES_NO_OPTION
								, JOptionPane.QUESTION_MESSAGE
								, null											// no tiene icono
								, opciones										// titulos de los botones
								, opciones[0]									// titulo predeterminado
								); 

						if (opcionSeleccioada == 0) { // cuando opciones[0] -> 

							conexion.DB_EjecutarUpdateQuery(objUsuario.setQueryModificarUsuario()); // se ejecuta el comando para alterar la base de datos
							JOptionPane.showMessageDialog(ventana , "El usuario fue modificado correctamente.", "ACTUALIZACIÓN CORRECTA", getDefaultCloseOperation());
						}

						if (opcionSeleccioada == 1) { // cuando opciones[1] -> con este refresca la ventana. 
							pantalla_ingresarUsuario(); // Genera la pantalla o ventana de registro de usuario
						}

					}

					conexion.DB_CerrarConexion(); // cierra la conexión de la base de datos

				}else
				{

					JOptionPane.showMessageDialog( // EXHIBE LA ALERTA O MUESTRA UNA VENTANA EMERGENTE CON UNICA OPCION (ACEPTAR - CERRAR)
							ventana
							, alertaValidacionMensaje 
							, alertaValidacionTitulo 
							, getDefaultCloseOperation());
				}
			}
		});

		ventana.add(botonIngresar); // adiciona el botón al frame
		ventana.add(imprimirTexto); // adiciona el botón al frame

		botonIngresar.setText("Registrar"); // establece el texto deseado en el botón

		layout_btnVolver(); // crea el botón para volver a la pantalla bienvenida.

		super.repaint(); // repinta el frame

	}
	public void pantalla_eliminar()
	{

		Vista ventana = this; // Genera el frame ("Cuadro") y contenedor

		ventana.getContentPane().removeAll(); // remueve el contenido del contenedor

		ventana.setLayout(new FlowLayout()); // establece un layout para el frame, necesario para JPanel porque al estar Null no se exhiben datos.

		//MOSTRAR TEXTO

		layout_tituloVentana("ELIMINAR UN USUARIO"); 		// establece el título

		layout_etiquetadeTexto(
				"Seleccionar el usuario que desea eliminar."
				, new float[] {(float) 0.04, (float) 0.2} 
				, new int[] {300, 30}
				, "Serif"
				, Font.PLAIN
				, 14);
		JPanel panel = new JPanel();
		panel = new JPanel (new GridLayout(0,4));	    // crea un nuevo panel con GridLayout

		/* MOSTRAR DEL BD */

		Controlador conexion = new Controlador(); // genera un objeto controlador

		conexion.DB_AbrirConexion();			  // establece una conexión accediendo a la base de datos.	

		Usuarios objUsuarios = new Usuarios();   // genera un objeto usuario

		// ESTABLECE LA POSICIÓN INICIAL PARA MOSTRAR LOS USUARIOS
		float[] posicion = new float[] {(float)0.0,(float)0.0}; // la posición no afecta al GridBagLayout.

		int[] dimensiones = new int[] {50,30};	

		int contadorUsuarios = 0;

		// ejecuta la consulta a la base de datos
		try {

			ResultSet consultaUsuarios = (ResultSet) conexion.DB_EjecutarQuery(objUsuarios.setQueryLeerTodosUsuarios());

			while(consultaUsuarios.next()) { // Ejecuta la sentencia para cada registro encontrado

				String cedula =  consultaUsuarios.getString(1); 
				String nombre = consultaUsuarios.getString(2);
				String apellido = consultaUsuarios.getString(3);

				// TODO: Agregar más detalles como nombres, apellidos, y nacionalidad
				JLabel cedulaLabel = layout_etiquetadeTexto(
						cedula  // cedula en este caso
						, posicion
						, dimensiones
						, "arial"
						, Font.PLAIN
						, 12) ;

				// Agrega componente al panel

				panel.add(cedulaLabel);		// adiciona al panel y su posición en matriz

				JLabel nombreLabel = layout_etiquetadeTexto(
						nombre  // cedula en este caso
						, new float[] {(float) (posicion[0] + 0.1), posicion[1]}
						, dimensiones
						, "arial"
						, Font.PLAIN
						, 12) ;

				// Agrega componente al panel

				panel.add(nombreLabel);		// adiciona al panel y su posición en matriz

				JLabel apellidoLabel = layout_etiquetadeTexto(
						apellido  // cedula en este caso
						, new float[] {(float) (posicion[0] + 0.2), posicion[1]}
						, dimensiones
						, "arial"
						, Font.PLAIN
						, 12) ;

				// Agrega componente al panel

				panel.add(apellidoLabel);		// adiciona al panel y su posición en matriz


				
				JButton botonEliminar = layout_boton(
						"Eliminar"
						, new float[] {(float) (posicion[0] + 0.3), posicion[1]}
						, dimensiones
						, true);


				panel.add(botonEliminar); 		// adiciona al panel y su posición en matriz	

				contadorUsuarios = contadorUsuarios + 1;

				//	TODO: Editar para que la posición se separe en columnas
				posicion = new float[] {(float) (posicion[0]), (float) (posicion[1]+ (0.01*contadorUsuarios))}; // altera la posición según el número de usuarios que lleva. 

				botonEliminar.addActionListener(new ActionListener() { 
					public void actionPerformed (ActionEvent evt) {

						conexion.DB_AbrirConexion(); // establece el acceso de conexión a la base de datos

						conexion.DB_EjecutarUpdateQuery(objUsuarios.setQueryEliminarUsuario(cedula)); // ejecuta el comando de eliminar registro

						JOptionPane.showMessageDialog(	// mensaje de alerta 
								ventana 
								, "El usuario fue eliminado correctamente."
								, "REGISTRO ELIMINADO"
								, getDefaultCloseOperation());

						conexion.DB_CerrarConexion(); // ejecuta comando para terminar la conexión y acceso a la base de datos.

						pantalla_eliminar(); // recarga la pantalla de eliminar
					}
				});

			}
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}

		/* TODO: verificar saltos de linea en textField y pogramar dinámicamente con base de datos */

		//usuarios.pack(); 			  	// compacta el frame al tamaño  según cantidad componentes y posiciones.

		layout_scrollBar(panel); 		// crea un scrollBar

		conexion.DB_CerrarConexion(); 	// ejecuta comando para terminar la conexión y acceso a la base de datos.

		layout_btnVolver(); 		  	// crea un botón para volver a la pestaña de inicio.

		super.repaint(); 				// repinta el frame

	}
	public void pantalla_buscar()
	{

		Vista ventana = this;	// genera el frame

		super.getContentPane().removeAll();	// remueve todo el contenido del frame

		Usuarios objUsuario = new Usuarios(); // genera un objeto usuarios

		List <String> cedulas = new ArrayList<String>();  // genera una lista de string

		/* BUSCAR EN BASE DE DATOS */
		Controlador conexion = new Controlador(); // genera un objeto controlador de conexión a la base de datos

		conexion.DB_AbrirConexion();  // establece una nueva conexión permitiendo el acceso a la base de datos

		// ADICIONA ELEMENTOS VISUALES
		layout_tituloVentana("BUSCAR UN USUARIO");	

		JComboBox<String> listaDesplegable = layout_listaDesplegable( // crea un objeto JComboBox
				new String[] {"0000000"},  // da como parámetro de creación la cédula vector
				"Ingresar unicamente números",
				new float[] {(float) 0.15, (float)0.2}, 
				new int[] {500, 30});


		listaDesplegable.addActionListener(new ActionListener() { // establece el comportamiento al dar clic en el ComboBox
			public void actionPerformed(ActionEvent e) {
				e.getSource();
			}
		});

		JTextField textoDeListaDespleglable = (JTextField)listaDesplegable.getEditor().getEditorComponent(); // crea un objeto textfield y castea el contenido obtenido del ComboBox

		textoDeListaDespleglable.addKeyListener( new KeyAdapter() { // establece un comportamiento de digitación o de teclado

			public void keyTyped (KeyEvent evt) { // evento de teclas

				// TODO: Arreglar cuando se actualiza el comboBox esté sincronizado al digitar. (Metodos Update y Run)

				int c = evt.getKeyCode();

				if ( !((c >= 48) && (c <= 57) ) || (c == 8)) { // valida que los caracteres ingresados sean números entre 0 y 9, o elimine elementos de la consulta. || https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list/31637206

					String cedulaConsultada = textoDeListaDespleglable.getText();

					try {

						listaDesplegable.removeAllItems(); // elimina los registros del JComboBox

						listaDesplegable.addItem(cedulaConsultada);

						contador = 0;

						if ( textoDeListaDespleglable.getText() != null) { // si el campo no está vacío

							//cedulaDigitos.add(cedulaConsultada + ""); // agrega los dígitos a una lista de string

							ResultSet usuarioConsultado =  (ResultSet) conexion.DB_EjecutarQuery(objUsuario.setQueryBuscarUsuarioSimilar(cedulaConsultada)); // ejecuta el comando de busqueda en la base de datos por medio de cédula

							// System.out.println(objUsuario.setQueryBuscarUsuarioSimilar(cedulaConsultada));

							cedulas.clear(); // limpia los valres de consultas anteriores

							if (usuarioConsultado != null) // Si encuentra registros
							{						
								while(usuarioConsultado.next()) { // para cada registro encontrado

									cedulas.add(usuarioConsultado.getString(1)); // almacena el registro en una lista 

									//System.out.println(usuarioConsultado.getString(1));

									contador = contador +1;
								}

								String[] cedulaVector = null;  // genera un objeto vector de String

								cedulaVector = cedulas.toArray(new String[0]);  // convierte la lista en un vector

								for (int i = 0; i < 5; i ++) {  // recorre todo 10 elementos del vector

									//System.out.println(cedulaVector[i]);

									if ( cedulaVector[i].contains(cedulaConsultada)) {

										listaDesplegable.addItem((String) cedulaVector[i]); // adiciona los elementos en el JComboBox

									}
								}

								//textoDeListaDespleglable.setText(cedulaConsultada); // establece como texto dentro del textfield
							}
						}

					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}

				else 
				{
					JOptionPane.showMessageDialog(ventana
							, "Ingrese sólo números"
							, "VALOR INVÁLIDO"
							, getDefaultCloseOperation());

				}

			}
		}	);

		ventana.add(listaDesplegable); // adiciona el comboBox al frame

		JButton botonVerDetalles = new JButton();  // genera un objeto boton
		botonVerDetalles.setText("Ver"); // establece el texto del botón
		botonVerDetalles.setBounds((int)(getWidth()*(0.43)), (int)(getHeight()*(0.3)), 100, 30); // establece las medidas del botón 
		ventana.add(botonVerDetalles); // adiciona el botón al frame
		botonVerDetalles.addActionListener(new ActionListener() { // establece el comportamiento del botón al dar click
			public void actionPerformed(ActionEvent e) {

				/* TODO: funciones para búsqueda en base de datos ACCES */

				try {

					// ejecuta el comando para verificar si el usuario existe
					ResultSet usuarioConsultado =  (ResultSet) conexion.DB_EjecutarQuery(objUsuario.setQueryBuscarUsuario(listaDesplegable.getSelectedItem().toString()));

					if (usuarioConsultado != null) { // en caso de que exista el usuario

						// guarda los datos en el objeto usuario
						objUsuario.setCedula(usuarioConsultado.getString(1));
						objUsuario.setNombre(usuarioConsultado.getString(2));
						objUsuario.setApellido(usuarioConsultado.getString(3));
						objUsuario.setDireccion(usuarioConsultado.getString(4));
						objUsuario.setCorreo(usuarioConsultado.getString(5));
						objUsuario.setNacionalidad(usuarioConsultado.getString(6));
						objUsuario.setEdad(Integer.parseInt(usuarioConsultado.getString(7)));
						objUsuario.setTelefono(usuarioConsultado.getString(8));
						objUsuario.setCelular(usuarioConsultado.getString(9));

						conexion.DB_CerrarConexion(); // termina o cierra la conexión de acceseo a la base de datos

						pantalla_verDetallesUsuario(objUsuario); // imprime la pantalla de detalles y envia como parámetro al objeto usuario
					}
					else // en caso de que no exista un usuario 
					{
						JOptionPane.showMessageDialog(	// mensaje de alerta 
								ventana 
								, "El usuario no se encuentra en la base de datos."
								, "REGISTRO NO EXISTE"
								, getDefaultCloseOperation());

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		layout_btnVolver(); // genera el botón volver
		super.repaint();


	}
	public void pantalla_verDetallesUsuario(Usuarios usuario) {

		Vista ventana = this;
		
		ventana.getContentPane().removeAll();

		ventana.setLayout(null); 

		layout_tituloVentana("DETALLES DE USUARIO");

		// TODO: Cambiar los JLabel por JTextField editables, así será más fácil al dar click en actualizar la información. 
		
		layout_etiquetadeTexto(
				usuario.getNombre()
				, new float[] {(float)0.1, (float) 0.3} 
				, new int[] {500,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				usuario.getApellido()
				, new float[] {(float)0.1, (float) 0.35} 
				, new int[] {500,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				usuario.getCedula()
				, new float[] {(float)0.1, (float) 0.4} 
				, new int[] {100,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				usuario.getCelular()
				, new float[] {(float)0.1, (float) 0.45} 
				, new int[] {100,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				usuario.getCorreo()
				, new float[] {(float)0.1, (float) 0.5} 
				, new int[] {500,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				usuario.getDireccion()
				, new float[] {(float)0.1, (float) 0.55} 
				, new int[] {500,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				usuario.getNacionalidad()
				, new float[] {(float)0.1, (float) 0.6} 
				, new int[] {200,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				Integer.toString(usuario.getEdad())
				, new float[] {(float)0.1, (float) 0.65} 
				, new int[] {100,30}
				, "arial"
				, Font.BOLD
				, 12);
		
		layout_etiquetadeTexto(
				usuario.getTelefono()
				, new float[] {(float)0.1, (float) 0.7} 
				, new int[] {100,30}
				, "arial"
				, Font.BOLD
				, 12);

		// TODO: Terminar
		/* JButton btnEditar = layout_boton(
				"Editar"
				, new float[] {(float)0.8, (float) 0.6} 
				, new int[] {100,30}
				, true);
		super.add(btnEditar);
		 */
		
		JButton btnEliminar = layout_boton(
				"Eliminar" 
				, new float[] {(float)0.8, (float) 0.7} 
				, new int[] {100,30}
				, true);
		super.add(btnEliminar);
		
		Controlador conexion = new Controlador();
		
		btnEliminar.addActionListener(new ActionListener() { 
			public void actionPerformed (ActionEvent evt) {

				conexion.DB_AbrirConexion(); // establece el acceso de conexión a la base de datos

				conexion.DB_EjecutarUpdateQuery(usuario.setQueryEliminarUsuario(usuario.getCedula())); // ejecuta el comando de eliminar registro

				JOptionPane.showMessageDialog(	// mensaje de alerta 
						 ventana
						, "El usuario fue eliminado correctamente."
						, "REGISTRO ELIMINADO"
						, getDefaultCloseOperation());

				conexion.DB_CerrarConexion(); // ejecuta comando para terminar la conexión y acceso a la base de datos.

				pantalla_buscar(); // recarga la pantalla de busqueda
			}
		});

		super.repaint();

	}
	public void pantalla_verInformes(String cedulaUsuario) {
		// TODO generar vistas con gráficos

	}
	public void pantalla_verRegistros(String cedulaUsuario) {
		// TODO generar vista de tabla, detalles, o único usuario

	}
	public void pantalla_creditos()
	{
		super.getContentPane().removeAll();
		super.setLayout(null);

		//layout_tituloVentana("Acerca de Peñantástico"); //" Titulo de ventana"

		// INFORMACIÓN GENERAL

		layout_imagenWeb( 									// Logo del programa
				Programa.programa_logo
				, "Logo " + Programa.programa_nombre
				, new float[] {(float)0.1, (float)0.1}
				, new int[] {100, 100} );

		//Ej: GIMP 2.8.0 || Internet Explorer /n versión 6.0.200.2229_esp_sp3_sdk_25092001

		layout_etiquetadeTexto(							// Nombre del programa 
				Programa.programa_nombre									
				, new float[] {(float)0.2, (float)0.1}
				, new int[] {500, 80}
				, "calibri"
				, Font.BOLD
				, 42);

		layout_etiquetadeTexto(							// Versión instalada 
				Programa.programa_version				
				, new float[] {(float)0.2, (float)0.2}
				, new int[] {100, 30}
				, "calibri"
				, Font.ITALIC
				, 12);
		
		layout_etiquetadeTexto(							// [Opcional] Fecha de creación 
				Programa.programa_fechaCreacion				
				, new float[] {(float)0.3, (float)0.2}
				, new int[] {100, 30}
				, "calibri"
				, Font.ITALIC
				, 12);

		layout_etiquetadeTexto(							// CopyRight o Creative Commons o CopyLeft - Compañía fabricante o autor de derechos 
				Programa.fabrica_copyRight				
				, new float[] {(float)0.7, (float)0.75}
				, new int[] {200, 80}
				, "calibri"
				, Font.ITALIC
				, 12);

		layout_etiquetadeTexto(							// [Opcional] Logo de la compañía fabricante o marca/sello del autor 
				Programa.fabrica_url_logo				
				, new float[] {(float)0.7, (float)0.7}
				, new int[] {500, 80}
				, "calibri"
				, Font.ITALIC
				, 12);

		

		layout_etiquetadeTexto(							// Descripción del programa Ej: Programa para manipulación de imágenes de GNU, etc, etc 
				Programa.programa_descripcion				
				, new float[] {(float)0.1, (float)0.3}
				, new int[] {900, 100}
				, "calibri"
				, Font.ITALIC
				, 12);

		// ACTUALIZACIONES [Opcional]
		// [] Fecha de actualización y versión disponible
		// [] Breve descripción de cambios en actualziación con enlace a saber más
		// [] Botón actualizar
		// [] Solicitar soporte en caso de error		
		// [] Comprobar actualizaciones [CheckBox]

		// EXTRAS [Opcional]
		layout_etiquetadeTexto(							// [] Advertencia o nota {Puede ser un mensaje sobre leyes del derecho de autor, abeasdata, protección al consumidor, etc}  
				Programa.programa_advertencia				
				, new float[] {(float)0.1, (float)0.4}
				, new int[] {300, 80}
				, "calibri"
				, Font.ITALIC
				, 12);

		super.add(layout_boton(							// [] Términos de acuerdo de uso
				"Términos de acuerdo"
				, new float[] {(float)0.3, (float)0.8}
				, new int[] {100, 30}
				, true)); 

		super.add(layout_boton(							// [] Politicas de privacidad
				"Políticas de privacidad"
				, new float[] {(float)0.5, (float)0.8}
				, new int[] {100, 30}
				, true));

		super.add(layout_boton(							// [] Botón "inf. Avanzada..." {Ver información detallada del programa en página oficial o documento ayuda}
				"Info. Avanzada.."
				, new float[] {(float)0.8, (float)0.1}
				, new int[] {100, 30}
				, true));

		super.add(layout_boton(							// [] Botón "Tecnología" (OpenGL.., Let'sEncrypt.., etc.. ) para conocer más sobre frameworks y librerías usadas.
				"UCANACCESS"
				, new float[] {(float)0.8, (float)0.2}
				, new int[] {100, 30}
				, true));


		layout_btnVolver(); // boton para volver a pantalla principal o bienvenida

		super.repaint();

	}
	// TODO: CargarfuenteDeURL() https://docs.oracle.com/javase/tutorial/2d/text/fonts.html || https://rstopup.com/como-importar-una-fuente.html
	// TODO: cambiarFuente() http://chuwiki.chuidiang.org/index.php?title=Fuentes_de_texto_en_Java
	// TODO: Toggle Switch https://stackoverflow.com/questions/9146683/is-there-a-standard-gui-toggle-switch-in-java
	// TODO: Tabla http://www.enseignement.polytechnique.fr/informatique/Java/1.8/javax/swing/JTable.html
	// TODO: Lista elementos, objetos o componentes (imagenes, texto, video, url, etc)
	// TODO: ADMISION DE CARACTERES UTF-8 (Terminar función utfConvertion()
	public String utfConvertion(String texto, String charsetName) {
		byte arreglo[];
		try {
			arreglo = texto.getBytes(charsetName);
			for (byte x: arreglo) {
				//charSetBytes[i] = x;
			}
			//return String.join(" ", charSetBytes.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "Empty";
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		// 

	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// 

	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO: mejorar comportamiento.Verificar el DISPOSE_ON_CLOSE 
		dispose();
		System.exit(0);
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// 

	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// 

	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// 

	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// 

	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// 

	}
}
