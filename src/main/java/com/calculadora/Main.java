package com.calculadora;
import java.util.Scanner;
import java.io.IOException;


/**
 * Clase principal que actúa como la interfaz de usuario para una calculadora básica.
 * <p>
 * Esta clase permite al usuario elegir operaciones matemáticas como suma, resta, multiplicación y división.
 * También incluye opciones para limpiar la pantalla, volver a mostrar el menú y salir de la aplicación.
 * </p>
 */
public class Main {

  // Constantes para las opciones del menú
  private static final int SUMA = 1;
  private static final int RESTA = 2;
  private static final int MULTIPLICACION = 3;
  private static final int DIVISION = 4;

  // Constantes adicionales para el menú
  private static final int LIMPIAR = 5;
  private static final int SALIR = 6;

  /**
   * Método principal que controla el flujo de la aplicación.
   *
   * @param args Argumentos de línea de comandos (no utilizados en esta aplicación).
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    double num1 = 0;
    double num2 = 0;

    // Bucle infinito para mantener la aplicación en ejecución hasta que el usuario decida salir
    while (true) {

      // Pide al usuario si desea cambiar los números para las operaciones
      System.out.print("¿Deseas ingresar nuevos números? (s/n): ");
      String deseaCambiar = scanner.next();
      if (deseaCambiar.equalsIgnoreCase("s")) {

        // Obtener números
        System.out.print("Ingresa el primer número: ");
        num1 = scanner.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        num2 = scanner.nextDouble();
      }

      // Muestra los números actuales en la consola
      System.out.println("Número 1: " + num1);
      System.out.println("Número 2: " + num2);

      // Limpia la pantalla y muestra el menú
      limpiarPantalla();
      mostrarMenu();

      Calculadora calc = new Calculadora();
      int opcion = scanner.nextInt();

      // Validación de la opción ingresada por el usuario
      if (opcion < SUMA || opcion > SALIR) {
        System.out.println("Opción inválida");
        continue;
      }

      double resultado = 0;

      try {

        switch (opcion) {

          case SUMA:
            resultado = calc.sumar(num1, num2);
            break;

          case RESTA:
            resultado = calc.restar(num1, num2);
            break;

          case MULTIPLICACION:
            resultado = calc.multiplicar(num1, num2);
            break;

          case DIVISION:
            resultado = calc.dividir(num1, num2);
            break;

          case LIMPIAR:
            limpiarPantalla();
            mostrarMenu();
            break;

          case SALIR:
            salirApp();
        }

      } catch (ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());
      }

      System.out.println("El resultado es: " + resultado);

    }
  }
  /**
   * Limpia la pantalla de la consola para diferentes sistemas operativos.
   *
   * @throws IOException si hay un error de entrada/salida.
   * @throws InterruptedException si el hilo en espera es interrumpido.
   */
    public static void limpiarPantalla () {

      try {
        if (System.getProperty("os.name").contains("Windows"))
          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
          Runtime.getRuntime().exec("clear");
      } catch (IOException | InterruptedException ex) {
      }

    }

  /**
   * Imprime en pantalla un menú con las opciones disponibles para realizar
   * operaciones matemáticas, limpiar la pantalla y salir de la aplicación.
   */
    public static void mostrarMenu () {
      System.out.println("Operaciones:");
      System.out.println(SUMA + ". Sumar");
      System.out.println(RESTA + ". Restar");
      System.out.println(MULTIPLICACION + ". Multiplicar");
      System.out.println(DIVISION + ". Dividir");
      System.out.println(LIMPIAR + ". Limpiar pantalla");
      System.out.println(SALIR + ". Salir");
    }

  /**
   * Termina la ejecución de la aplicación.
   *
   * Cierra la aplicación y muestra un mensaje de despedida.
   */
    public static void salirApp () {
      System.out.println("Saliendo de la aplicación...");
      System.exit(0);
    }


}
