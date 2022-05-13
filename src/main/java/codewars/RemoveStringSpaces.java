package codewars;

public class RemoveStringSpaces {
    public static void main(String[] args) {
        noSpace("8 j 8   mBliB8g  imjB8B8  jl  B");

    }
    public static String noSpace(final String x) {
        String x1 =  x.replaceAll(" ","");
        System.out.println(x1);
        return x1;
    }
}
