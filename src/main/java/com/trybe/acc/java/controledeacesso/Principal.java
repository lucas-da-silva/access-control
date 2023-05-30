package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> people = new ArrayList<Integer>();
    boolean isToAddPeople = true;
    int underagePeople = 0;
    int adultPeople = 0;
    int olderAdultPeople = 0;

    while (isToAddPeople) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println(
              "1 - Acessar o estabelecimento\r\n" + "2 - Finalizar sistema e mostar relatório");
      short option = Short.parseShort(scanner.next());

      if (option == 1) {
        System.out.println("Entre com a sua idade:");
        int age = Integer.parseInt(scanner.next());
        people.add(age);

        if (age < 18) {
          underagePeople++;
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (age <= 49) {
          adultPeople++;
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          olderAdultPeople++;
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }
      } else if (option == 2) {
        isToAddPeople = false;
      } else {
        System.out.println("Entre com uma opção válida!");
      }
    }

    int totalPeople = people.size();
    double percentageUnderagePeople = ((double) underagePeople / totalPeople) * 100;
    double percentageAdultPeople = ((double) adultPeople / totalPeople) * 100;
    double percentageOlderAdultPeople = ((double) olderAdultPeople / totalPeople) * 100;


    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + underagePeople);
    System.out.println("adultas: " + adultPeople);
    System.out.println("a partir de 50: " + olderAdultPeople);

    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println("\r\n----- Percentual -----");
    System.out.println("menores: " + df.format(percentageUnderagePeople));
    System.out.println("adultas: " + df.format(percentageAdultPeople));
    System.out.println("a partir de 50: " + df.format(percentageOlderAdultPeople));

    System.out.println("Total: " + totalPeople);
    scanner.close();
  }
}
