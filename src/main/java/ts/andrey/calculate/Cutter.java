package ts.andrey.calculate;

public class Cutter {

    private Cutter() {
    }

    public static String cutFirstNonDigits(String string) {
        while (!Character.isDigit(string.charAt(0))) {
            string = string.substring(1);
        }
        return string;
    }

    public static String cutLastNonDigits(String string) {
        while (!Character.isDigit(string.charAt(string.length() - 1))) {
            string = string.substring(0, string.length() - 2);
        }
        return string;
    }

}
