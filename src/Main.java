
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Sanchez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * Método que genera sismos aleatorios de diferentes grados desde 1.0 a 9.5
     */
    public static double generarSismo() {
        double aleatorio = (Math.random() * 8.6) + 1;
        aleatorio = (double) ((int) (aleatorio * 10) / 10.0);//convierte el numero en un double de 1 decimal
        return aleatorio;
    }

    /**
     * Método que llena la matriz con numeros doubles aleatorios desde 1 a 9.5
     *
     * @param matriz que se desea llenar
     * @return matriz llenada
     */
    public static double[][] llenarMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = generarSismo();
            }
        }
        return matriz;
    }

    /**
     * Método que busca el sismo de mayor intensidad, lo muestra junto con el
     * dia en que ocurrio y la hora
     *
     * @param matriz donde se desea buscar el sismo
     */
    public static void sismoMax(double[][] matriz) {
        double mayor = matriz[0][0];//se toma el primero como mayor
        //filaMayor = filaMenor = colMayor = colMenor = 0;
        int dia = 0;
        int hora = 0;
        for (int i = 0; i < matriz.length; i++) {  //
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    dia = i;
                    hora = j;
                }
            }
        }
        System.out.print("Sismo mayor de mayor intensidad fue de: " + mayor);
        System.out.println(" Dia: " + dia + " Hora: " + hora);
    }

    /**
     * Método que busca los sismos ≥ 4.0
     */
    public void mayores4(double[][] matriz) {
        // ArrayList<double> asdasd = new ArrayList<double>();
        int mayoresA4 = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] >= 4) {
                    mayoresA4++;
                }
            }

        }

    }

    /**
     * Método que pide la cantidad de días a analizar
     *
     * @return numero de días validado
     */
    public static int pedirDias() {
        int numero = 0;
        try {
            numero = leerTeclado();
            if (numero < 1 || numero > 31) {
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
    public static int leerTeclado() {
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
    public static void menu() {
        boolean bandera = true;
        while (bandera) {
            System.out.println("Ingrese la cantidad de dias a revisar (1≤ N ≤ 31)");
            double matriz[][] = new double[pedirDias()][24];
            double[][] matrizLlenada = llenarMatriz(matriz);
            System.out.println("\n1.Mostrar sismo más intenso\n2.Mostrar sismos ≥ 4.0\n3.Salir");
            int opcion = leerTeclado();
            switch (opcion) {
                case 1:
                    sismoMax(matrizLlenada);
                    break;
                case 2:

                    break;
                case 3:
                    bandera = false;
                    break;
            }

        }

    }
}
