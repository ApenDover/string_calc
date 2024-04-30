package ts.andrey;

import ts.andrey.calculate.Operation;

public class Main {
    public static void main(String[] args) {
        final var string = "2 / 0";
        final var result = Operation.calcString(string);
        System.out.println(result);
    }

}