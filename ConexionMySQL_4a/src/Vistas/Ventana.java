package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.ActividadController;
import Modelos.Actividad;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contenedor;
	private JTextField cajaAsignatura;
	private JTextField cajaNombre;
	private JTextField cajaInicio;
	private JTextField cajaFin;
	private JTextField cajaEntregada;
	
	private ActividadController controlador;

	

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Actividad 4a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Tamaño del frame
		setBounds(100, 100, 700, 321);
		
		//Declaracion de atributos
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		
		controlador = new ActividadController();
		
		botones();
		cajas();
		labels();
		
		
		
		
		
		
		
	}
	
	public void botones(){
		JButton botonGuardaDatos = new JButton("Introducir datos");
		botonGuardaDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.añadirActividad(cajaAsignatura.getText(), 
						cajaNombre.getText(),cajaInicio.getText()
						,cajaFin.getText(), cajaEntregada.getText());
				
			}
		});
		botonGuardaDatos.setBounds(496, 149, 147, 23);
		contenedor.add(botonGuardaDatos);
		
		JButton botonDevolverDatos = new JButton("Devolver datos");
		botonDevolverDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerDatos();
			}
		});
		botonDevolverDatos.setBounds(289, 219, 147, 23);
		contenedor.add(botonDevolverDatos);
	}
	
	public void labels(){
		JLabel lblNewLabel = new JLabel("Asignatura");
		lblNewLabel.setBounds(74, 73, 79, 14);
		contenedor.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(201, 73, 60, 14);
		contenedor.add(lblNombre);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setBounds(327, 73, 70, 14);
		contenedor.add(lblInicio);
		
		JLabel lblFin = new JLabel("Fin");
		lblFin.setBounds(449, 73, 30, 14);
		contenedor.add(lblFin);
		
		JLabel lblEntregada = new JLabel("Entregada");
		lblEntregada.setBounds(559, 73, 84, 14);
		contenedor.add(lblEntregada);
	}
	
	public void cajas(){
		cajaAsignatura = new JTextField();
		cajaAsignatura.setBounds(54, 98, 108, 20);
		contenedor.add(cajaAsignatura);
		cajaAsignatura.setColumns(10);
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(175, 98, 107, 20);
		contenedor.add(cajaNombre);
		cajaNombre.setColumns(10);
		
		cajaInicio = new JTextField();
		cajaInicio.setBounds(289, 98, 108, 20);
		contenedor.add(cajaInicio);
		cajaInicio.setColumns(10);
		
		cajaFin = new JTextField();
		cajaFin.setBounds(407, 98, 112, 20);
		contenedor.add(cajaFin);
		cajaFin.setColumns(10);
		
		cajaEntregada = new JTextField();
		cajaEntregada.setBounds(529, 98, 114, 20);
		contenedor.add(cajaEntregada);
		cajaEntregada.setColumns(10);
	}
	
	public void introducirDatos(){
		controlador.añadirActividad(cajaAsignatura.getText(), cajaNombre.getText(),cajaInicio.getText(),cajaFin.getText(), cajaEntregada.getText());
	}
	
	public void recogerDatos(){
		//Obtenemos la lista de actividades que nos devuelve el método loadActividades de ActividadController
				ArrayList<Actividad> actividades = controlador.loadActividades();
				//Realizamos un recorrido sobre dicha lista
				for(int a=0; a<actividades.size(); a++){
					//Sacamos impreso por consola de los campos de cada registro que nos interesan 
					System.out.println("ACTIVIDAD "+actividades.get(a).toString());	
					System.out.println("Id: "+actividades.get(a).getId());
					System.out.println("Asignatura: "+actividades.get(a).getAsignatura());
					System.out.println("Nombre: "+actividades.get(a).getNombre());
					System.out.println("Fecha inicio: "+actividades.get(a).getInicio());
					System.out.println("Fecha fin: "+actividades.get(a).getFin());
					System.out.println("Entregada "+actividades.get(a).isEntregada());
					System.out.println("--------------------------------------");
					}
			}
}
