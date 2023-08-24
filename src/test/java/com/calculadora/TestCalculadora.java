package com.calculadora;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Clase de prueba para la clase Calculadora.
 * Contiene tests para todas las operaciones.
 */
public class TestCalculadora {

  /**
   * Prueba la operación de suma de dos números.
   */
  @Test
  public void testSumar(){
    Calculadora calc = new Calculadora();

    // Valor esperado, valor actual, delta
    assertEquals(10, calc.sumar(5,5), 0.0);
  }

  /**
   * Prueba la operación de resta de dos números.
   */
  @Test
  public void testRestar() {
    Calculadora calc = new Calculadora();
    assertEquals(5, calc.restar(10, 5),0.0);
  }

  /**
   * Prueba la operación de multiplicación de dos números.
   */
  @Test
  public void testMultiplicar() {

    Calculadora calc = new Calculadora();

    assertEquals(25.0, calc.multiplicar(5, 5), 0.0);

  }

  /**
   * Prueba la operación de división de dos números.
   */
  @Test
  public void testDividir() {

    Calculadora calc = new Calculadora();

    assertEquals(2.0, calc.dividir(10, 5), 0.0);

  }

  /**
   * Prueba que se lance ArithmeticException al dividir por 0.
   */
  @Test(expected = ArithmeticException.class)
  public void testDividirPorCero() {

    Calculadora calc = new Calculadora();

    calc.dividir(10, 0);

  }
}
