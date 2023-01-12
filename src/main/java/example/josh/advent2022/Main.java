package example.josh.advent2022;

import java.util.Scanner;

public final class Main {
  public static void main(String[] args) {
    System.out.println("Choose a day by entering an integer: ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    final int inputDay;
    try {
      inputDay = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      System.out.println("Input was not an integer. Stack trace: ");
      e.printStackTrace();
      return;
    }

    final Day objectDay;
    switch (inputDay) {
      case 1 -> {
        objectDay = new Day1();
      }
      case 2 -> {
        objectDay = new Day2();
      }
      case 3 -> {
        objectDay = new Day3();
      }
      case 4 -> {
        objectDay = new Day4();
      }
      case 5 -> {
        objectDay = new Day5();
      }
      default -> {
        System.out.println("Day \"" + inputDay + "\" is not implemented yet.");
        return;
      }
    }
    objectDay.part1();
    objectDay.part2();
  }
}
