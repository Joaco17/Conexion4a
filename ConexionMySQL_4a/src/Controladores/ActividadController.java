
package Controladores;

import java.util.ArrayList;

import Modelos.Actividad;
import Modelos.Conexion;
import Modelos.ModeloActividad;

public class ActividadController {
	//Atributos de la clase
	private ModeloActividad modeloActividad;

	public ActividadController() {
		// Constructor de la clase (Declaraci�n de sus atributos)
		modeloActividad = new ModeloActividad();
	}
	
	//M�todo cuyo objetivo es realizar una inserci�n de datos a la BBDD con los par�metros recibidos 
	public void a�adirActividad(String Asignatura, String Nombre, String Inicio, String Fin, String Entregada){
		//Generamos instancia SQL
		Conexion conexion = Conexion.getInstance();
		//Realizamos un INSERT sobre la tabla actividades de nuestra BBDD insertando como datos los par�metros recibidos
		conexion.modifyQuery("INSERT INTO actividad(Asignatura, Nombre, Inicio, Fin, Entregada) VALUES('"+Asignatura+"', '"+Nombre+"', '"+Inicio+"', '"+Fin+"', "+Entregada+");");
		//Impreso informativo por consola
		System.out.println("Inserci�n de datos correcta.");
	}
	
	//Este m�todo interactua con el modelo de datos Actividad para cargar todos los registros existentes de la tabla actividad
	public ArrayList<Actividad> loadActividades(){
		return modeloActividad.load();
	}
	
}