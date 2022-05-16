package codewars;

public class CountOfPositivesAndSumOfNegatives {
    public static void main(String[] args) {
      countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15});

    }
    public static int[] countPositivesSumNegatives(int[] input) {
        int count = 0;
        int sum =0;
       for (int inputs:input){
           if (inputs>0) {
               count++;
           }
           if (inputs<0){
               sum=sum+inputs;
           }
       }
        System.out.println(count);
        System.out.println(sum);
        return new int[] {count, sum}; //return an array with count of positives and sum of negatives
    }
}
