package operations;

import java.util.Scanner;

public class Operation_SumPair implements OperationGeneric {

    /*
     * igual es mejor pedir los sumandos dentro del metodo de cada implementación de
     * forma que quien invoque al metodo no tenga que saber que lonuitid debe tener
     * aStrings
     */
    @Override
    public String operate() {

        int sum = 0;

        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 2; i++) {
                try {
                    System.out.println("Insert "+i+"º sumand");
                    sum += Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Parameters must be parseable to numeric.");
                    i--;
                }
            }
        }
        return Integer.toString(sum);
    }

    @Override
    public String getOperationName() {
        return getClass().toString().split("_")[1];
    }

}
