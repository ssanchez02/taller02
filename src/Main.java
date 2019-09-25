
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Sebastián Sanchez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    /**
     * Método que genera sismos aleatorios de diferentes grados desde 1.0 a 9.5
     */
    public static double generarSismo() {
        double aleatorio = (Math.random() * 8.6) + 1;
        aleatorio = (double) ((int) (aleatorio * 10) / 10.0);//convierte el numero en un double de 1 decimal
        return aleatorio;
    }

    public static double[][] llenarMatriz(double[][] matriz) {
        for (int i = 0; i<matriz.length; i++) {
            for (int j = 0; j<matriz[i].length; j++) {
                matriz[i][j]=generarSismo();
            }
        }
        return matriz;
    }

    /**
     * Método que pide la cantidad de días a analizar
     *
     * @return numero de días validado
     */
    public int pedirDias() {
        int numero = 0;
        try {
            numero = leerTeclado();
            if (numero < 1 && numero > 31) {
                pedirDias();
            }
        } catch (InputMismatchException e) {
            System.out.println(" Dato ingresado incorrecto, intentar nuevamente ");
            numero = pedirDias();
        }
        return numero;
    }

    /**
     * Método que lee la entrada por teclado del usuario
     *
     * @return numero entero ingresado
     */
    public int leerTeclado() {
        Scanner teclado = new Scanner(System.in);
        int numero;
        try {
            numero = teclado.nextInt();
            if (numero < 0) {
                leerTeclado();
            }
        } catch (InputMismatchException e) {
            System.out.println("Dato ingresado incorrecto, intentar nuevamente");
            numero = leerTeclado();
        }
        return numero;
    }

    /**
     * Método que simula un menu
     */
    public void menu() {
        boolean bandera = true;
        while (bandera) {
            System.out.println("Ingrese la cantidad de dias a revisar (1≤ N ≤ 31)");
            double matriz[][] = new double[pedirDias()][24];
            System.out.println("\n1.\n2.\n3.\n4.Salir");
            int opcion = leerTeclado();
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    bandera = false;
                    break;
            }

        }

    }
}
