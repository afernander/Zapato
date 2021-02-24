import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class Escribirarchivo extends Usuario 
{

    ArrayList<Dato> Informacionalmacenada;
    LectorDeDatos ldd = new  LectorDeDatos();
    
    public void guardarinformacion(){

    try{
        
        PrintStream ps = new PrintStream(new File("Persistencia.txt"));
        
        Informacionalmacenada = ldd.leerDatos("informacion.csv");

        ps.println("A continuación los procesos realizados durante el programa");
        ps.println();
    
    



        ps.println("Ritmo elevado:  " + ritmoelevado);
        ps.println("Promedio de la frecuencia cardiaca:  " + ritmopromedio);
        ps.println("Promedio de la temperatura:  " + temperaturapromedio);
        ps.println();
        ps.println();
        ps.println("Para conocer a detalle tus resultados dirigete al programa principal");
             

        
      


    } catch (FileNotFoundException fnfe) {
        System.out.println("No puedo abrir el archivo de salida");
    }
}
}