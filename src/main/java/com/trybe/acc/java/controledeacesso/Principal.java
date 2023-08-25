package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * sistema de acesso para verificar os usuarios.
 */
public class Principal {

  static short menores18 = 0;
  static short adultos = 0;
  static short adultos50mais = 0;
 
  /**
   * Método principal da aplicação chama o menu.
   */
  public static void main(String[] args) {
    menu();
  }

  /**
   * menu, para escolher as opções 1-catraca ou 2-relatorio.
   */
  public static void menu() {
    Scanner scanner = new Scanner(System.in);
    boolean reShowMenu = true;
    
    while (reShowMenu) {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n"
          + "2 - Finalizar sistema e mostrar relatório");
      
      String inputMenu = scanner.next();
      int intMenu = Integer.parseInt(inputMenu);
      
      if (intMenu != 1 && intMenu != 2) {
        System.out.println("Entre com uma opção válida!");
      } else if (intMenu == 1) {
        catraca(scanner);
      } else {
        reShowMenu = false;
        relatorio();
      }
    }
  }

  /**
   * recebe a idade dos clientes, libera a catraca e salva nos atributos da classe.
   */
  public static void catraca(Scanner scanner) {
    System.out.println("Entre com a sua idade:");
    int clientAge = scanner.nextInt();
    
    if (clientAge < 18) {
      System.out.println("Pessoa cliente menor de idade, catraca liberada!");
      menores18 += 1; 
    }
    if (clientAge >= 18 && clientAge < 50) {
      System.out.println("Pessoa adulta, catraca liberada!");
      adultos += 1;
    }
    if (clientAge >= 50) {
      System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
      adultos50mais += 1;
    }
  }
  
  /**
   * Imprime o relatorio no console.
   */
  public static void relatorio() {
    int numeroClientes = menores18 + adultos + adultos50mais;
    float numeroFloat = numeroClientes;
    DecimalFormat decimal = new DecimalFormat("0.0#");
    
    System.out.println("----- Quantidade -----\n"
        + "menores: " + menores18 + "\n"
        + "adultas: " + adultos + "\n"
        + "a partir de 50: " + adultos50mais + "\n"
        + "\n"
        + "----- Percentual -----\n"
        + "menores: " + decimal.format((menores18 * 100) / numeroFloat) + "%\n"
        + "adultas: " + decimal.format((adultos * 100) / numeroFloat) + "%\n"
        + "a partir de 50: " + decimal.format((adultos50mais * 100) / numeroFloat) + "%\n"
        + "\n"
        + "TOTAL: " + numeroClientes);
  }
}
