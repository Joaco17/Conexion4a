
package Controladores;

import java.util.ArrayList;

import Modelos.Actividad;
import Modelos.Conexion;
import Modelos.ModeloActividad;

public class ActividadController {
	//Atributos de la clase
	private ModeloActividad modeloActividad;

	public ActividadController() {
		// Constructor de la clase (Declaración de sus atributos)
		modeloActividad = new ModeloActividad();
	}
	
	//Método cuyo objetivo es realizar una inserción de datos a la BBDD con los parámetros recibidos 
	public void añadirActividad(String Asignatura, String Nombre, String Inicio, String Fin, String Entregada){
		//Generamos instancia SQL
		Conexion conexion = Conexion.getInstance();
		//Realizamos un INSERT sobre la tabla actividades de nuestra BBDD insertando como datos los parámetros recibidos
		conexion.modifyQuery("INSERT INTO actividad(Asignatura, Nombre, Inicio, Fin, Entregada) VALUES('"+Asignatura+"', '"+Nombre+"', '"+Inicio+"', '"+Fin+"', "+Entregada+");");
		//Impreso informativo por consola
		System.out.println("Inserción de datos correcta.");
	}
	
	//Este método interactua con el modelo de datos Actividad para cargar todos los registros existentes de la tabla actividad
	public ArrayList<Actividad> loadActividades(){
		return modeloActividad.load();
	}
	
}