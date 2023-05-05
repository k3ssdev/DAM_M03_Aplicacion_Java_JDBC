package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Teclado {

    public static int pideEntero(String pregunta) {
        System.out.println(pregunta);
        int num = 0;
        boolean repite = true;
        while (repite) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String op = br.readLine();
                num = Integer.parseInt(op);
                repite = false;
            } catch (Exception a) {
                System.out.println("Numero incorrecto, try again");
            }
        }

        return num;
    }

    public static double pideDouble(String pregunta) {

        System.out.println(pregunta);
        double num = 0;
        boolean repite = true;
        while (repite) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String op = br.readLine();
                num = Double.parseDouble(op);
                repite = false;
            } catch (Exception e) {
                System.out.println("Numero incorrecto, try again");
            }
        }

        return num;
    }
    /**
     * Pide un valor mediante el metodo pideDouble y controla que el valor este
     * entre los valores
     *
     * @return [] valorMinimo
     * @return [] valorMaximo
     */
    public static double pideValorMinMax(double valorMinimo, double valorMaximo) {
        return pideValorMinMax(valorMinimo, valorMaximo,"Introduce un numero entre "+valorMinimo+" y "+valorMaximo);
     }
     public static double pideValorMinMax(double valorMinimo, double valorMaximo,String pregunta) {
         double valor = 0;
         do {
             valor = pideDouble(pregunta);
             if ((valor < valorMinimo) || (valor > valorMaximo)) {
                 System.out.println("El valor  debe ser un valor entre "
                         + valorMinimo + " y " + valorMaximo);
             }
         } while ((valor < valorMinimo) || (valor > valorMaximo));
         return valor;
     }
 
     /**
      * Pide un valor mediante el metodo pideInt y controla que el valor este
      * entre los valores
      *
      * @return [] valorMinimo
      * @return [] valorMaximo
      */
     public static int pideValorMinMax(int valorMinimo, int valorMaximo) {
       return pideValorMinMax(valorMinimo,valorMaximo,"Introduce el valor entre "+valorMinimo+" y "+valorMaximo);
     }
     public static int pideValorMinMax(int valorMinimo, int valorMaximo, String pregunta) {
         int valor = 0;
         do {
             valor = pideEntero(pregunta);
             if ((valor < valorMinimo) || (valor > valorMaximo)) {
                 System.out.println("El valor debe ser un valor entre "
                         + valorMinimo + " y " + valorMaximo);
             }
         } while ((valor < valorMinimo) || (valor > valorMaximo));
         return valor;
     }

    /**
     * Pide una strinc por consola
     *
     * @param txt mensaje a mostrar por consola
     * @return
     */
    public static String pideString(String txt) {
        System.out.println(txt);
        boolean repeat;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            repeat = false;
            try {
                return br.readLine();
            } catch (IOException ex) {
                repeat = true;
            }
        } while (repeat);
        return null;
    }

    /**
     * Pide una String por consola. Si la string introducida no coincide con
     * alguna de las opciones, vuelve a pedir
     *
     * @param mensaje a mostrar por consola
     * @param opciones listado de opciones que aceptaremos como válidas
     * @return
     */
    public static String pideString(String txt, String opciones[]) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(txt);
            try {
                String valor_entrado= br.readLine();
                //buscamos si la string existe en el array de opciones
                //realizamos el bucle mientras no se encuentre una opcion igual al valor_entrado
                for(int k =0; !opciones[k].equals(valor_entrado) ;k++){}
                return valor_entrado;
            } catch (Exception ex) {
                System.out.println("Valor introducido erroneo");
                
            }
        } while (true);
        
    }

   /**
    * Espera a que el usuario pulse una tecla para continuar
    */
    public void pausa() {
        System.out.println("Pulsa una tecla para continuar...");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
        } catch (Exception e) {
        }
    }

}