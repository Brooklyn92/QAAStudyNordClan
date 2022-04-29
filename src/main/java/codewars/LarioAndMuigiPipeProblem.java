package codewars;
import java.util.Arrays;

public class LarioAndMuigiPipeProblem {
    public static void main(String[] args) {
        pipeFix(new int[]{-1, 2, 3, 8});
        System.out.println(Arrays.toString(pipeFix(new int[]{-1, 2, 3, 8})));
    }

    public static int[] pipeFix(int[] n) {
        int start = n[0];
        int end = n[n.length-1];
        int length = end - start + 1;
        int[] result = new int[length];

        for (int i=0; i < length; i++){
            result[i] = start + i;
        }
        return result;
    }
}
