package codewars;

public class CatYearsDogYears {
    public static void main(String[] args) {
        humanYearsCatYearsDogYears(10);

    }

    public static int[] humanYearsCatYearsDogYears(final int humanYears) {
        int[] years = new int[]{humanYears, 0, 0};
        int countYear = 1;

        while (countYear <= humanYears) {

            switch (countYear) {
                case 1: {
                    years[1] += 15;
                    years[2] += 15;
                    break;
                }

                case 2: {
                    years[1] += 9;
                    years[2] += 9;
                    break;
                }

                default:
                  years[1] += 4;
                  years[2] += 5;
            }
            countYear++;
        }




        for (int y: years) {
            System.out.print(y + ", ");
        }
        return years;
    }
}
