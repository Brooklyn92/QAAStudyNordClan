package codewars;

import java.util.Arrays;

public class HowGoodAreYouReally {
    public static void main(String[] args) {
        betterThanAverage(new int[]{12, 23, 34, 45, 56, 67, 78, 89, 90}, 69);

    }
    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        System.out.println((double)yourPoints > Arrays.stream(classPoints).average().getAsDouble());
        return yourPoints > Arrays.stream(classPoints).average().getAsDouble() ;
    }
}

/*
@Test
  public void tests() {
    assertEquals(true, Kata.betterThanAverage(new int[] {2, 3}, 5));
    assertEquals(true, Kata.betterThanAverage(new int[] {100, 40, 34, 57, 29, 72, 57, 88}, 75));
    assertEquals(true, Kata.betterThanAverage(new int[] {12, 23, 34, 45, 56, 67, 78, 89, 90}, 69));
    assertEquals(false, Kata.betterThanAverage(new int[] {100, 90}, 11));
  }
 */