package codewars;

public class RockPaperScissors {
    public static void main(String[] args) {
        System.out.println(rps("rock", "scissors"));
    }

    public static String rps(String p1, String p2) {
        String[] array = {"rock","paper","scissors"};

        if (array[0].equals(p1) & array[2].equals(p2)
                    | array[2].equals(p1) & array[1].equals(p2)
                    | array[1].equals(p1) & array[0].equals(p2)) {
            return "Player 1 won!";
            }

        if (array[2].equals(p1) & array[0].equals(p2)
                | array[1].equals(p1) & array[2].equals(p2)
                | array[0].equals(p1) & array[1].equals(p2)) {
            return "Player 2 won!";
        }

        if (p1.equals(p2)) {
            return "Draw!";
            }

        return "";
    }

    /*
    if (
                    p1.startsWith("r") & p2.startsWith("s")
                |   p1.startsWith("s") & p2.startsWith("p")
                |   p1.startsWith("p") & p2.startsWith("r")) {
            System.out.println("Player 1 won!");
        }
        if (p1.equals(p2)){
            System.out.println("Draw!");
        }
        else {
            System.out.println("Player 2 won!");
        }
     */
}
/*
@Test
    public void test1() {
        System.out.println("Fixed Tests Player 1 won!");
        assertEquals("Player 1 won!", Kata.rps("rock", "scissors"));
        assertEquals("Player 1 won!", Kata.rps("scissors", "paper"));
        assertEquals("Player 1 won!", Kata.rps("paper", "rock"));
    }
    @Test
    public void test2() {
        System.out.println("Fixed Tests Player 2 won!");
        assertEquals("Player 2 won!", Kata.rps("scissors", "rock"));
        assertEquals("Player 2 won!", Kata.rps("paper", "scissors"));
        assertEquals("Player 2 won!", Kata.rps("rock", "paper"));
    }
    @Test
    public void test3() {
        System.out.println("Fixed Tests Draw!");
        assertEquals("Draw!", Kata.rps("scissors", "scissors"));
        assertEquals("Draw!", Kata.rps("paper", "paper"));
        assertEquals("Draw!", Kata.rps("rock", "rock"));
    }
 */