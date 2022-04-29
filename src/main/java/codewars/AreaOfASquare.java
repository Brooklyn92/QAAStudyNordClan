package codewars;

public class AreaOfASquare {
    public static void main(String[] args) {
        squareArea(2);

    }
    public static double squareArea(double A) {
        double dlinaOkr = A*4;
        double pi = dlinaOkr/(Math.PI*2);
        double y =pi*pi;
        double d =Math.floor(y*100)/100.0;
        System.out.println(d);
        return d;
    }
}

/*
private static final double DELTA = 1e-15;
    @Test
    public void basicTests() {
        assertEquals(1.62, Geometry.squareArea(2),DELTA);
        assertEquals(0, Geometry.squareArea(0),DELTA);
        assertEquals(80, Geometry.squareArea(14.05),DELTA);
    }
 */