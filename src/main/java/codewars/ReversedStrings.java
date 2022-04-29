package codewars;

public class ReversedStrings {
    public static void main(String[] args) {
        solution("World");
    }

    public static String solution(String str) {
        String sb1 = new StringBuilder(str).reverse().toString();
        System.out.println(sb1);
        return sb1;
    }

}
