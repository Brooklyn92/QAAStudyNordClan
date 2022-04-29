package codewars;

public class ToSquareRootOrNotToSquareRoot {

    public static void main(String[] args) {
        int array1[] = {4, 3, 9, 7, 2, 1};
        squareOrSquareRoot(array1);
    }


    public static int[] squareOrSquareRoot(int[] array) {
        for (int a : array) {
            if (Math.sqrt(a) % 1 == 0) {
                a = (int) Math.sqrt(a);
            } else {
                a *= a;
            }
            System.out.print(a + ", ");
        }
        return array;
    }
}
