package panaderia.vista;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
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
				try {
					this.procesarUnaOrden();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("no se pudo generar la orden");
				}
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
	 * @throws IOException
	 */
	private void procesarUnaOrden() throws IOException {
		String codigoTienda="";
		String ruta="";
		Scanner consola = new Scanner(System.in);
		pedirCodigo(codigoTienda);
		boolean existe=control.existeTienda(codigoTienda);// PRIMERO PEDIR EL CÓDIGO DE LA TIENDA
		// Y VERIFICAR SI EXISTE. ya está hecho
		 if (existe){// SI EXISTE:
		
		
			pedirRuta(ruta);// PEDIR LA RUTA CON LOS PRODUCTOS DEL PEDIDO
			control.crearOrden(ruta,codigoTienda);
// Y SOLICITAR AL CONTROL CREAR LA ORDEN.
		 }
		 String rutaProductos = consola.next();
			control.crearOrden(rutaProductos, codigoTienda);

		 // Y LOS DETALLES ORDENADOS, PARA MOSTRAR AL USUARIO.
		 String tiendaD = control.obtenerDatosTienda(codigoTienda);
		 List<String> detallesO = control.obtenerDetallesOrdenados();
//
		/*  for (String i : tiendaD) {
			 System.out.println(i);
		 } */
		 for (String j : detallesO) {
			 System.out.println(j);
		 }
		 // PREGUNTAR SI DESEA ACEPTAR. SI ACEPTA:
		 // INFORMAR AL CONTROL PARA QUE GUARDE LA ORDEN.
		 System.out.println("Accepta la orden? S/N: ");
		 String deseaAcceptar = consola.next();
		 while (deseaAcceptar.equals("S")) {
			 if (deseaAcceptar.equals("S")) {
				 control.guardarOrden();
			 }
		 }
		 System.out.println("Fin del programa. Muchas gracias.");
		 consola.close();
	 }
 }
		
		
		// LUEGO: PEDIR AL CONTROL LOS DATOS DE LA TIENDA
		// Y LOS DETALLES ORDENADOS, PARA MOSTRAR AL USUARIO.
		
		// PREGUNTAR SI DESEA ACEPTAR. SI ACEPTA:
		// INFORMAR AL CONTROL PARA QUE GUARDE LA ORDEN.
