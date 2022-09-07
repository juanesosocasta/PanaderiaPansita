package panaderia.logica;

import java.io.IOException;
import java.util.List;

import panaderia.datos.EscritorArchivoOrdenes;
import panaderia.datos.IFuenteDatos;
import panaderia.datos.LectorArchivo;
import panaderia.entidades.base.Producto;
import panaderia.entidades.base.Recorrido;
import panaderia.entidades.pedido.OrdenPedido;
import panaderia.entidades.base.Tienda;

/**
 * Lógica del programa de un recorrido de un vendedor,
 * para crear las órdenes de pedido de las tiendas.
 * 
 * @version 1.0
 */
public class ControlRecorrido {
	private Recorrido recorrido;
	private OrdenPedido ordenEnProceso;

	public ControlRecorrido() {
		this.recorrido = new Recorrido();
		this.ordenEnProceso = null;
	}

	public void cargarDatosIniciales() {
		CargadorDatos cargador = new CargadorDatos(recorrido);
		cargador.cargarDatosIniciales();
	}

	// Verifica que existe una tienda
	public boolean existeTienda(String codigoTienda) {
		Tienda tienda = recorrido.buscarTienda(codigoTienda);
		if (tienda != null) {
			return true;
		} else
			return false;
	}
	/*
	 * metodo encargado de crear ordenes para las tiendas respectivas
	 */
	public void crearOrden(String nombreArchivoProductos, String codigoTienda) throws IOException{
		IFuenteDatos archivoProductos = new LectorArchivo();
		List<String[]> datosBaseProductos=archivoProductos.obtenerDatosBase();
		datosBaseProductos = archivoProductos.obtenerDatosBase();
		System.out.println();
		Tienda tienda = recorrido.buscarTienda(codigoTienda);
		ordenEnProceso = new OrdenPedido(tienda);
		for(String[] i : datosBaseProductos) {
			System.out.println(datosBaseProductos);
			crearDetalle(ordenEnProceso, i);
		}
		
	}
	/*
	 * metodo encargado de profundizar la informacion de un pedido analizando los productos
	 */
	private void crearDetalle(OrdenPedido orden, String[] datosBaseDetalle){
		Producto producto = this.recorrido.buscarProducto(datosBaseDetalle[0]);
		
		this.ordenEnProceso.addDetalle(producto, producto.hashCode());
	}
	/*
	 * metodo encargado de recuperar datos de las tiendas que se tienen.
	 */
	public String obtenerDatosTienda(String codigoTienda) {
		Tienda tienda = recorrido.buscarTienda(codigoTienda);
		String tiendita=tienda.toString();
		System.out.println(tienda);
		return tiendita;
	}
	/*
	 * metodo encargado de obtener los productos ordenandolos de manera alfabetica
	 */
	public List<String> obtenerDetallesOrdenados() {
		Producto ordenados = recorrido.buscarProducto(null);
		return this.ordenEnProceso.getDetallesOrdenados();
	}

	/**
	 * Envía la orden para que su información
	 * se guarde en un archivo, y luego
	 * deja el atributo en null para que se
	 * pueda procesar una nueva orden.
	 */
	public void guardarOrden() {
		EscritorArchivoOrdenes escritor = new EscritorArchivoOrdenes();
		escritor.escribirOrden(ordenEnProceso);
		ordenEnProceso = null;
	}
}
