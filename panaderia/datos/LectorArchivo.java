package panaderia.datos;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class LectorArchivo {

    /**
     * Leer la información de un archivo de texto
     */
    public void leerDatos(String nombreArchivo) throws IOException {
            Path rutaArchivo = Paths.get(nombreArchivo);
            BufferedReader lector = Files.newBufferedReader(rutaArchivo);

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                System.out.println(Arrays.toString(datos));  //ESTO ES SOLO PARA LA PRUEBA - SE DEBE QUITAR
            }
            lector.close();
    }

    public static void main(String[] args) {
        LectorArchivo ejemplo = new LectorArchivo();
        try {
            ejemplo.leerDatos("../cargaArchivos/Tiendas.txt");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}