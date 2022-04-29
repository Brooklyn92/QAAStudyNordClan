package codewars;

public class BinToDecimal {
    public static void main(String[] args) {
        binToDecimal("1");

    }
    public static int binToDecimal(String inp) {
        int bin = Integer.parseInt(inp, 2);
        System.out.println(bin);
        return bin;
    }
}