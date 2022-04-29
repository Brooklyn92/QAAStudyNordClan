package codewars;
import java.util.*;

public class ConvertNumberToReversedArrayOfDigits {
    public static void main(String[] args) {
        digitize(12345);

    }

    public static int[] digitize(long n) {
        StringBuilder builder = new StringBuilder(Long.toString(n));
        builder.reverse().chars().map(Character::getNumericValue);
        int[] arr = new int[builder.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.getNumericValue(builder.charAt(i));
            System.out.print(arr[i] + ", ");
        }
        return arr;
    }
}
