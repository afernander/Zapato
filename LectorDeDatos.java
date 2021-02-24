/**
 * Esta clase permite leer los datos que brinda las estaciones en las diferentes ciudades del mundo
 * de Medellín.
 * Los datos se retornan en un ArrayList que contiene referencias a objetos de tipo
 * Dato.
 *
 * @author Daniel Alejandro Cifuentes Londoño
 * @version Mayo 2019
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class LectorDeDatos
{
    /** ArrayList donde se almacenan los datos leidos */
    
    ArrayList<Dato> listaConDatosFinal = new ArrayList<>();

    /** 
     * Este método recibe el nombre del archivo que se va a leer.
     * Se trata de abrir el archivo, si se puede abrir, se leen los
     * datos y se retornan en un ArrayList que almacena referencias a 
     * objetos tipo Dato.
     */
   
    public ArrayList<Dato> leerDatos(String nombre) {

        try {
            Scanner archivo = new Scanner(new File(nombre));

            while(archivo.hasNextLine()) {

                String linea = archivo.nextLine();

                Scanner registro = new Scanner(linea.replaceAll(", ", " ").replaceAll("\"", "").replaceAll("," , ", "));
                registro.useDelimiter(",");

                String codigoEstacion = registro.next();
                String fecha = registro.next().replaceAll(" ", "");
                String ritmo = registro.next().replaceAll(" ", "");
                String temperatura = registro.next().replaceAll(" ", "");
   

                double ritmo1 ;
                double temperatura1;

                if (ritmo.isEmpty()) ritmo = "  X";
                if (temperatura.isEmpty()) temperatura = "  X";

                if (ritmo.equals("  X")) ritmo1 = -10000;
                else ritmo1 = Double.parseDouble(ritmo);

                if (temperatura.equals("  X")) temperatura1 = -10000;
                else temperatura1 = Double.parseDouble(temperatura);


                Dato informacion = new Dato(codigoEstacion, fecha, ritmo1, temperatura1);
                listaConDatosFinal.add(informacion);
                System.out.println(codigoEstacion + " " +  fecha + " " + ritmo+ " " + temperatura);

            }
        } catch (FileNotFoundException e) {
            System.out.println("No pude abrir el archivo");
        }
        return listaConDatosFinal;
    }



    /**
     * Programa principal.
     * Se leen los datos almacenados en el archivo "datos.txt" y se
     * guardan en el ArrayList "al".
     * 
     */
    public static void main(String [] args) {
        LectorDeDatos ldd = new LectorDeDatos();
        System.out.println("Voy a leer los datos");
        ldd.leerDatos("informacion.csv");
        System.out.println("Ya leí los datos");
    }
}