/**
 * 	 *------------ 
	 *Modelo      | Es una entidad, una cosa - Una abstracción - Una instancia o memoria volátil 
	 *-------     |-> Calidad Datos 
 	 *	Control   |-> Querys
     *	   Data   |
	 *------------|
     *
     *				      
     *
     *
	 * Referentes
	 *-----------
	 *  30 Atajos de Eclipse:		https://javarevisited.blogspot.com/2018/07/top-30-eclipse-keyboard-shortcuts-java-programming.html
	 *  
	 *  
	 *	Tutorial código ejemplo:	https://docs.oracle.com/javase/tutorial/  
	 */
public class Usuarios {

	public String cedula = "hello  i love you, wont you tell me your name?";
	private String nombre;
	private String apellido;
	private String direccion;
	private String correo;
	private String nacionalidad;
	private int edad;
	private String telefono;
	private String celular;
	
	
	public static void main(String[] args) {
		
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	public String toString() {
		return ("Telefono celular es: " +  celular + " y el telefono es: " + telefono);
	}
	
	public String setQueryLeerTodosUsuarios() {
		return "SELECT * "
				+ "FROM usuario";
	}
	
	public String setQueryBuscarUsuario(String cedula) {
		return "SELECT * "
				+ "FROM usuario "
				+ "WHERE cedula "
				+ "= '" 
				+ cedula + "'";
	}
	
	public String setQueryBuscarUsuarioSimilar(String cedula) {
		return "SELECT * "
				+ "FROM usuario "
				+ "WHERE cedula "
				+ "LIKE "  
				+ "'" + cedula + "%'";
	}
	
	 public String setQueryEliminarUsuario(String cedula) {
		 
		 return "DELETE "
		 		+ "FROM usuario "
		 		+ "WHERE cedula "
		 		+ "= '" 
		 		+ cedula + "'";
	 }
	 
	 public String setQueryModificarUsuario() {
		 return "UPDATE usuario "
		 		+ "SET nombre = '" +  this.nombre + "'" + 
				 " WHERE cedula"
				 + "= '" 
				 + this.cedula + "'";  
	 }
	 
	 public String setQueryIngresarUsuario() {
		 // String cedula, String nombre, String apellido, String direccion, String correo, String nacionalidad, int edad, String telefono, String celular

		 return "INSERT INTO "
		 		+ "usuario "
		 		+ "(cedula, nombre, apellido, direccion, correo, nacionalidad, edad, telefono, celular)"
		 		+ " VALUES ( "
		 			+ "'" + this.cedula + "'" + " , "
		 			+ "'" + this.nombre + "'" + ", "
		 			+ "'" + this.apellido + "'" + ", "
		 			+ "'" + this.direccion + "'" + ", "
		 			+ "'" + this.correo + "'" + ", "
		 			+ "'" + this.nacionalidad + "'" + ", "
		 			+ this.edad + ", "
		 			+ "'" + this.telefono + "'" + ", "
		 			+ "'" + this.celular + "'" + " );"
		 		;
		 
	 }
	
}
