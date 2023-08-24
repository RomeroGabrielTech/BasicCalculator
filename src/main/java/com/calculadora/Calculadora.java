package com.calculadora;

public class Calculadora {

  /**
   * Suma dos números
   *
   * @param num1 primer número
   * @param num2 segundo número
   * @return resultado de la suma
   */
  public double sumar(double num1, double num2){
    return num1 + num2;
  }

  /**
   * Resta dos números
   *
   * @param num1 minuendo
   * @param num2 sustraendo
   * @return resultado de la resta
   */
  public double restar(double num1, double num2){
    return num1 - num2;
  }

  /**
   * Multiplica dos números
   *
   * @param num1 primer número
   * @param num2 segundo número
   * @return resultado de la multiplicación
   */
  public double multiplicar(double num1, double num2){
    return num1 * num2;
  }

  /**
   * Divide dos números
   *
   * @param num1 dividendo
   * @param num2 divisor
   * @return resultado de la división
   * @throws ArithmeticException si el divisor es 0
   */
  public double dividir(double num1, double num2){

    if (num2 == 0) {
      throw new ArithmeticException("No se puede dividir por 0");
    }

    return num1 / num2;
  }

}
