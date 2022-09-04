package panaderia.vista;

import java.io.IOException;
import java.util.Scanner;

import panaderia.entidades.base.Recorrido;
import panaderia.logica.ControlRecorrido;


/**
 * Realiza la interacción con el usuario
 * para poder iniciar el programa y procesar
 * las órdenes de pedido de un recorrido de ventas.
 * 
 * @version 1.0
 */
public class ProgramaPancita {
	private ControlRecorrido control;
	
	public ProgramaPancita() {
		this.control = new ControlRecorrido();
	}
	
	/**
	 * Permite cargar los datos iniciales necesarios
	 * para hacer el recorrido.
	 */
	public void iniciar() {
		this.control.cargarDatosIniciales();
	}
	
	/**
	 * Es el ciclo de control general del programa,
	 * para saber si hay más ordenes o termina.
	 */
	public void hacerRecorrido() {
		Scanner consola = new Scanner(System.in);
		String respuesta = "S";
		while (respuesta.equals("S")) {
			System.out.println("¿Desea crear orden de pedido (S/N)?");
			respuesta = consola.next();
			if (respuesta.equals("S")) {
				this.procesarUnaOrden();
			}
		}
		System.out.println("Fin del programa. Muchas gracias.");
		consola.close();
	}
	/*
	 * metodo encargado de tomar del usuario el codigo de la tienda que se quiere 
	 * ingresar.
	 */
	public void pedirCodigo(String codigoTienda) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("ingrese el codigo de la tienda");
			codigoTienda=scanner.nextLine();
			
		}catch(Exception e) {
			System.out.println("el codigo ingresado no es valido");
		}
		
	}

	public void pedirRuta(String ruta) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("ingrese la ruta con los productos del pedido");
			ruta=scanner.nextLine();
			
		}catch(Exception e) {
			System.out.println("el valor ingresado no es valido");
		}
	}
	
	/**
	 * Coordina el proceso para poder crear una orden
	 * de pedido, mostrarla y pedir la aceptación
	 * del usuario.
	 */
	private void procesarUnaOrden() {
		// COMPLETAR:
		String codigoTienda="";
		String ruta="";
		pedirCodigo(codigoTienda);
		boolean existe=control.existeTienda(codigoTienda);// PRIMERO PEDIR EL CÓDIGO DE LA TIENDA
		// Y VERIFICAR SI EXISTE. ya está hecho
		 if (existe){// SI EXISTE:
		
		
			pedirRuta(ruta);// PEDIR LA RUTA CON LOS PRODUCTOS DEL PEDIDO
			control.crearOrden(ruta,codigoTienda);
// Y SOLICITAR AL CONTROL CREAR LA ORDEN.
		 }
		
		
		
		
		// LUEGO: PEDIR AL CONTROL LOS DATOS DE LA TIENDA
		// Y LOS DETALLES ORDENADOS, PARA MOSTRAR AL USUARIO.
		
		// PREGUNTAR SI DESEA ACEPTAR. SI ACEPTA:
		// INFORMAR AL CONTROL PARA QUE GUARDE LA ORDEN.
	}
}
