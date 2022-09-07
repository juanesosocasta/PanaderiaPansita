package panaderia.datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.awt.Component;
import javax.swing.JFileChooser;

public class LectorArchivo {
    //declaracion de variables necesarias
    String[] datos;
    private static String nombreArchivoProductos = "../cargaArchivos/Productos.txt";
    private static String nombreArchivoTiendas = "D:/informacion universidad/ingenieria de Software 1/codigos/tarea1parejas/panaderia/cargaArchivos/Tiendas.txt";
   /*
    * metodo encargado de leer los archivos y devolver un array de strings
    *se le ingresa el nombre del archivo por medio del explorador de archivos y de esta forma 
    *se logra pasar los 2 archivos
    */
    public String[] lectorArchivo(String nombreArchivo) throws IOException{
        Path rutaArchivo = Paths.get(nombreArchivo);
        BufferedReader lector = Files.newBufferedReader(rutaArchivo);
        String linea;
          // zona de alimentacion y lectura de arrays
        while ((linea = lector.readLine()) != null) {
            datos = linea.split(";");
        }

        lector.close();
        return datos;
    }

             /**
             * Leer la información de un archivo de texto
             * 
               
             */
    public List<String[]>  obtenerDatosBase() {
            String nombreArchivo = escogerArchivo();
            LectorArchivo lectura = new LectorArchivo();
            List<String[]> datoTiendaProducto = new ArrayList<>();
            try {
                if (nombreArchivo!= null) {
                    String[] direccion=nombreArchivo.split("/");
                    String[]tiendas=lectura.lectorArchivo(nombreArchivo);
                    datoTiendaProducto.add(tiendas);
                    nombreArchivo = escogerArchivo();
                    String[]productos=lectura.lectorArchivo(nombreArchivo);
                    datoTiendaProducto.add(productos);
                    return datoTiendaProducto;
                } return null;
            } catch (IOException e) {
                System.out.println("Error al leer el archivo");
            }
            return null;
        }

     
    public String escogerArchivo() {
            String direccion=null;
            JFileChooser chooser = new JFileChooser();
            /*
            * De acuerdo con JFileChooser para seleccionar el cuadro de carpeta emergente 1. Sólo seleccione el directorio JFileChooser.DIRECTORIES_ONLY
            * 2. Seleccione solo el archivo JFileChooser.FILES_ONLY
            * 3. Tanto los directorios como los archivos pueden ser JFileChooser.FILES_AND_DIRECTORIES
            */
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            
            
            // Guardar el directorio seleccionado chooser.showSaveDialog (parent);
            Component parent = null;
            int returnVal = chooser.showSaveDialog(parent);
            
            
            // Obtener el objeto de archivo seleccionado JFileChooser.APPROVE_OPTION
            // Si el directorio guardado es consistente con el objeto de archivo seleccionado, devolverá 0 si tiene éxito
            if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            
            // obtener ruta
            String selectPath = chooser.getSelectedFile().getPath();
            System.out.println ("El directorio que elijió es:" + selectPath);
            direccion= selectPath;
            }
            System.exit(0);
            return direccion;
    }
     
        
 }
     
       /*  public void leerDatos(String nombreArchivo) throws IOException {
            
        }
    }

    
   /*  */

    



//--------------------------------pruebas---------------------------------------------
//zona de impresion
       /*  for (String[] mierdas : tiendas) {
            System.out.println("cuanats listas hay: " + tiendas.size());
            System.out.println("tamaño de la lista: " + mierdas.length);
            for (String mierditas : mierdas) {
                System.out.println("tamaño de las mierdiytas: " + mierditas.length());
                System.out.println("esas mierdas " + mierditas);
            }

        } */