package panaderia.logica;

import java.util.List;

import panaderia.datos.EscritorArchivoOrdenes;
import panaderia.entidades.base.Recorrido;
import panaderia.entidades.base.Tienda;
import panaderia.entidades.pedido.OrdenPedido;


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

	public boolean existeTienda(String codigoTienda) {
		/*
		 * se compara el codigo de la tienda para saber si existe o no.
		 */
		 Tienda tienda=recorrido.buscarTienda(codigoTienda);
		
		if (tienda!=null) {
			return true;

		} else {
			return false;
		}
	}
	public void crearOrden(String nombreArchivosProductos,String codigoTienda){

		/*
		 * 
		 */

	}
	private void crearDetalle(OrdenPedido orden,String[] datosBaseDetalle) {
		
	}
	public String obtenerDatosTienda(String codigoTienda) {

		return codigoTienda;
		
	}

	public List<String> obtenerDetallesOrdenados() {

		return 0;
		
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
