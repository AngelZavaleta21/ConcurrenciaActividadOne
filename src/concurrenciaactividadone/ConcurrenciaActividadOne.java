
package concurrenciaactividadone;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel Zavaleta
 */
public class ConcurrenciaActividadOne {
    
    //static int  h=0;
    //static int thread [] = new int[h+1]; 
    //private static BigInteger factorialfinal;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InterruptedException {
        
        // Creamos un objeto de tipò Scanner
        Scanner leemos = new Scanner(System.in);
     
        // Pedimos al usuario El factorial que deseamos calcular

        System.out.println("¿Que factorial deseas calcular? ");
        System.out.println("");

        // Almacenamos en una variable de tipo entero
        int fac= leemos.nextInt();
        
        // Pedimos a cuantos hilos sera
        System.out.println("Introduce el numero de hilos");
        System.out.println("");

        // Almacenamos en una variable de tipo entero
        int h = leemos.nextInt();
        
        // Creamos un arreglo de enteros que me va a tener los hilos de ejecucion 
        int thread[]=new int [h+1];
        thread[0]=1;
        //string valor[]= {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
        thread[h]= fac;
        
        // Hacemos una realcion entre el factorial y los hilos
        int relacion = fac/h;
        int acumulador=0;

                
        for ( int i=1; i<h; i++){
            acumulador+= relacion;
            thread[i]= acumulador;
        }

        // Creamos el arreglo de tipo BigInteger para los resultados de cada hilo
        BigInteger  []resultados = new BigInteger[h];
        long tiempoUno = System.currentTimeMillis();

        
        for(int i=0; i<resultados.length;i++){
            
            resultados[i] = new BigInteger("1");
        }
        
        // Empezamos a trabajar los hilos dando inicio a la clase ThreadFactorial
        for(int i=0;i<thread.length-1;i++){
            if(i==0){
                Thread hilo = new Thread (new ThreadFactorial(thread[i],thread[i+1],resultados,i));
                hilo.start();
                hilo.join();
            }else{
                Thread hilo = new Thread (new ThreadFactorial(thread[i]+1,thread[i+1],resultados,i));
                hilo.start();
                hilo.join();
            }
        }
        
        // Creamos una variable de tipo BigInteger para almacenar el resultado final y hacemos la multiplicacion de resultados dentro de un for

        BigInteger hola = new BigInteger("1");
        for(int i=0; i<resultados.length;i++){
            hola=hola.multiply(resultados[i]);
        }
        
        long tiempodos = System.currentTimeMillis();
        //long tiempofinal = tiempodos-tiempoUno;
        //double t=(double) tiempofinal/1000;
        
        // Vamos a imprimir el resultado final del factorial

        System.out.println("El factorial de "+fac+" es: ");
        System.out.println(hola);

        // Hacemos la operacion del tiempo de ejecucio y la mostramos
        long tiempofinal = tiempodos-tiempoUno;
        System.out.println("El tiempo transcurido fue de "+(double)tiempofinal/1000+" segundos.");
        System.out.println(fac + "\t" + (double) tiempofinal / 1000);

    }
    
    


  }



         
 