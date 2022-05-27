package codewars;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(sumOfDifferences(new int[]{1, 2, 10}));
    }
    public static int sumOfDifferences(int[] arr) {
        int sum = 0;
        Arrays.sort(arr);
        for (int i =0; i<arr.length; i++) {
            sum = (arr[2] - arr[1])+(arr[1] - arr[0]);
        }
        return sum;
    }
}
/*
@Test
    public void basicTests() {
        assertEquals(9, ZywOo.sumOfDifferences(new int[]{1, 2, 10}));
        assertEquals(2, ZywOo.sumOfDifferences(new int[]{-3, -2, -1}));
        assertEquals(0, ZywOo.sumOfDifferences(new int[]{1, 1, 1, 1, 1}));
        assertEquals(34, ZywOo.sumOfDifferences(new int[]{-17, 17}));
        assertEquals(0, ZywOo.sumOfDifferences(new int[0]));
        assertEquals(0, ZywOo.sumOfDifferences(new int[]{0}));
        assertEquals(0, ZywOo.sumOfDifferences(new int[]{-1}));
        assertEquals(0, ZywOo.sumOfDifferences(new int[]{1}));
    }
    In descending order: [10, 2, 1]
    Sum: (10 - 2) + (2 - 1) = 8 + 1 = 9
 */