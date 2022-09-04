package panaderia.datos;

import java.util.ArrayList;
import java.util.List;

/**
 * Un clase usada para hacer pruebas.
 * Permite obtener una lista de productos fijas
 * (sin tener que leer un archivo externo).
 * 
 * @version 1.0
 */
public class DatosPruebaProductos implements IFuenteDatos {

	@Override
	public List<String[]> obtenerDatosBase() {
		String[] producto1 = {"1","yuca","50"};
		String[] producto2 = {"2","cilantro","200"};
		String[] producto3 = {"3","café","100"};
		List<String[]> productos = new ArrayList<>();
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		return productos;
	}
}


