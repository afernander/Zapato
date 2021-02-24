/**
* Esta clase permmite crear una variable tipo Dato que contiene toda la información.
*
*
*
*/
public class Dato {

    /** Esta variables son las propuestas a utilizar al momento de realizar la lectura de los archivos */
    String codigoEstacion;

    String fecha;

    double ritmo1 ;
    double temperatura1;


    /** Este metodo contiene el constructor aqui están las variables como parametros */
    
    public Dato(String codigoEstacion, String fecha, double ritmo1, double temperatura1) {
        
        
       
        this.codigoEstacion = codigoEstacion;
          
        this.ritmo1 = ritmo1;
        
        this.fecha = fecha;
         
        this.temperatura1 = temperatura1;


        
       

    }   

}