package codewars;

public class ILoveYouALittleALotPassionatelyAndNotAtAll {

    public static void main(String[] args) {
        System.out.println(howMuchILoveYou(89));
    }
    public static String howMuchILoveYou(int nb_petals) {
        String[] arr = {"not at all", "I love you", "a little", "a lot", "passionately", "madly"};
        return arr[nb_petals%6];
    }
}