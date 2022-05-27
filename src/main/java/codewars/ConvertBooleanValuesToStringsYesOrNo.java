package codewars;

public class ConvertBooleanValuesToStringsYesOrNo {
    public static void main(String[] args) {
        boolToWord(false);

    }
    public static String boolToWord(boolean b) {
        String r = b==true?"Yes":"No";
        System.out.println(r);
        return r;
    }
}