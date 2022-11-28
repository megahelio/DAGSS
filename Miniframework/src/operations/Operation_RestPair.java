package operations;

import java.util.Scanner;

public class Operation_RestPair implements OperationGeneric {

    @Override
    public String operate() {

        int rest = 0;
        boolean error = false;
        try (Scanner sc = new Scanner(System.in)) {

            do {
                try {
                    rest = 0;
                    System.out.println("Insert 1st number: ");
                    rest = Integer.parseInt(sc.nextLine());
                    System.out.println("Insert 2nd number: ");
                    rest -= Integer.parseInt(sc.nextLine());
                    error = false;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Parameters must be parseable to numeric.");
                    error = true;
                }
            } while (error);

        }
        return Integer.toString(rest);
    }

    @Override
    public String getOperationName() {
        return getClass().toString().split("_")[1];
    }

}
