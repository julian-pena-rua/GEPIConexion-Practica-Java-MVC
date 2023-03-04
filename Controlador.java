/**
 * Clase vista, contiene los siguientes elementos
 *-----------
 *Controlador |
 *		      |   ____	
 *--------    |-> |BD|  	Capa física
 *       	  |	  |  |  		SSL
 *       	  |	  |__|			NO SSL
 *------------|            			BD-> OPEN - CLOSE - EXECUTE - ETCs
 *			      
 *
 * Referentes
 *-----------
 *  
 *  30 Atajos de Eclipse:		https://javarevisited.blogspot.com/2018/07/top-30-eclipse-keyboard-shortcuts-java-programming.html
 *	
 *	Tutorial código ejemplo:	https://docs.oracle.com/javase/tutorial/  
 *
 *	Conectar BS ACCESS			https://www.benchresources.net/jdbc-msaccess-database-connection-steps-in-java-8/
 *   							https://codeday.me/es/qa/20181212/26649.html
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controlador {

	// variables
	Connection conexion = null;
	Statement estado = null;
	PreparedStatement estadoPreparado = null;
	ResultSet setResultado =  null;

	String msAccDB = Programa.programa_baseDeDatos;
	String dbURL = "jdbc:ucanaccess://"
			+ msAccDB;

	public Controlador(){

		{ // Paso 1: Cargar o registrar la clase driver Oracle JDBC
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			}
			catch(ClassNotFoundException cnfex) {

				System.out.println("Problemas en la carga o "
						+ "registro del driver JDBC MS Access");
				cnfex.printStackTrace();
			}
		}

	}

	public void DB_AbrirConexion() {
		{ // Paso 2: Abrir la conexión a la base de datos
			try {

				// Paso 2.A: Crear y  
				// obtener la conexion usando la clase de DriverManager
				this.conexion = DriverManager.getConnection(this.dbURL); 

				// Paso 2.B: Crea el estado JDBC 
				this.estado = this.conexion.createStatement();

			}

			catch(SQLException sqlex){
				sqlex.printStackTrace();
			}
		}

	}

	public void DB_CerrarConexion() {
		{ // Paso 3: Cerrar la conexion de la base de datos
			try {
				if(null != this.conexion) {
					// limpia los recursos luego de procesarlos
					if (this.setResultado != null) {
						this.setResultado.close();
					}
					this.estado.close();

					// finalmente cierra la conexión
					this.conexion.close();
				}
			}
			catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}

	}

	public Object DB_EjecutarQuery(String query) {
		{ 

			// Paso 2: Abrir la conexión a la base de datos
			try {


				// Paso 2.C: Ejecuta el SQL y 
				// recibe los datos en el ResultSet
				this.setResultado = this.estado.executeQuery(query);
				

				// procesa y devuelve datos e imprime en la consola
				while(this.setResultado.next()) {
					return this.setResultado;
				}
			}
			catch(SQLException sqlex){
				sqlex.printStackTrace();
			}

		}
		return null;
	}

	public void DB_EjecutarUpdateQuery(String query) {
		{
			/*   https://stackoverflow.com/questions/35837222/how-to-insert-rows-using-ucanaccess */

			// Paso 2: Abrir la conexión a la base de datos
			try {

				// Paso 2.C: Ejecuta el SQL e 
				// ingresa, actualiza o elimina los datos en la query
				this.estadoPreparado = this.conexion.prepareStatement(query);
				this.estadoPreparado.executeUpdate();

			}
			catch(SQLException sqlex){
				sqlex.printStackTrace();
			}

		}
		
	}
	
	
}

