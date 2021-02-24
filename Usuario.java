import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

/**
 * Inica la ejecucion del programa
 * 
 * @param   args    Los argumentos del programa enviados desde consola
 */

public class Usuario 
{


    static String ritmoelevado= "No accediste a este dato";
    static String ritmopromedio = "No accediste a este dato";
    static String temperaturapromedio = "No accediste a este dato";

    public static void main(String [] args) throws Exception {
        ArrayList<Dato> Informacionalmacenada;
        LectorDeDatos ldd = new  LectorDeDatos();
        //  Estadistica Operaciones = new Estadistica();
        Escribirarchivo guardar = new Escribirarchivo();
        //Filtro filtrar = new Filtro();
        System.out.println("Bienvenido usuario");
        System.out.println("\nEscoja según el número el dato que desea conocer de la información procesada");
        System.out.println("\n1. Estado ritmo cardiaco");
        System.out.println("2. Estado segun la temperatura");
        System.out.println("3. Recomendaciones");

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        switch (a) {
            case 1:
            System.out.println("1. Cuantas veces estuviste con un ritmo cardiaco elevado");
            System.out.println("2. Promedio de tu ritmo cardiaco en el ultimo día");

            int b = sc.nextInt(); 

            switch(b) {

                case 1: 
                int contador = 0;  

                Informacionalmacenada = ldd.leerDatos("informacion.csv");
                for(Dato elementopromedio : Informacionalmacenada){

                    if(elementopromedio.ritmo1!=-10000){
                        if(elementopromedio.ritmo1 >= 85){

                            contador++;

                        }
                    }             
                }  

                System.out.println("La cantidad de datos que se encuentraron son" + " " + contador);
                ritmoelevado = Double.toString(contador);

                if(contador > 10){
                    System.out.println("Tienes que descansar cada 3 horas");
                }else{ 
                    System.out.println("Sigue así estás en excelente estado");
                }

                break;

                case 2:

                double promediar = 0;
                double contar = 0;

                Informacionalmacenada = ldd.leerDatos("informacion.csv");
                for(Dato elementopromedio : Informacionalmacenada){
                    if(elementopromedio.ritmo1!=-10000){
                        promediar+=elementopromedio.ritmo1;
                        contar++;

                    }
                }
                System.out.println("El promedio de tu ritmo cardiaco el ultimo día fue de " + promediar/contar);  
                ritmopromedio  = Double.toString(promediar/contar);
                break;
            } 
            break;
            case 2:

            double promedio = 0;
            int contar = 0;

            Informacionalmacenada = ldd.leerDatos("informacion.csv");
            for(Dato elementopromedio : Informacionalmacenada){
                if(elementopromedio.temperatura1!=-10000){
                    promedio+=elementopromedio.temperatura1;
                    contar++;

                }
            } 
            System.out.println("El promedio de la temperatura del ultimo día fue de " + promedio/contar);
            temperaturapromedio = Double.toString(promedio/contar); 

            if(promedio/contar < 35){
                System.out.println("La temperatura de tu carro ha estado en excelentes condiciones");
            }else{
                System.out.println("Tienes que hacer una pausa");
            }
            break;    

            case 3:

            Informacionalmacenada = ldd.leerDatos("informacion.csv");
            int contador = 0;  
            for(Dato elementopromedio : Informacionalmacenada){
                double total = 0;
                if(elementopromedio.ritmo1!=-10000 && elementopromedio.temperatura1 != -1000 ){

                    if(total > 35){
                        System.out.println("Deberías tomar un descanso largo");

                    }else{
                        System.out.println("Estás en excelentes condiciones"); 
                    }  
                    break;    

                }

            }
        }

        System.out.println("¿Desea guardar tus datos en un archivo txt, en forma persistencia"); 
        System.out.println("");
        System.out.println("1. Si");
        System.out.println("2. No");

        int c = sc.nextInt();

        switch(c){
            case 1:
            guardar.guardarinformacion();
            System.out.println("Los datos han sido guardados correctamente como Persistencia.txt");
            break;

            case 2:

            System.out.println("La tarea ha finalizado"); 
            break;

        }
    }
}