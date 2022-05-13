package codewars;

public class Plural {
    public static void main(String[] args) {
        System.out.println(isPlural(0.5f));

    }
    public static boolean isPlural(float f) {
        if (f==1) {
            return false;
        } else {
            return true;
        }
    }
}
