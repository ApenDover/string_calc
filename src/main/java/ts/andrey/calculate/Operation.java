package ts.andrey.calculate;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation {

    private Operation() {
    }

    /**
     * возвращает первое вхождение
     * внутренних скобок
     *
     * @param string 5+(3+(6+2)+1+(2+1)+1)
     * @return 6+2
     */
    public static String openStaples(String string) {
        if (!string.contains("(")) {
            return string;
        }
        boolean start = false;
        final var sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ')') {
                return sb.toString();
            }
            if (start) {
                if (string.charAt(i) == '(') {
                    sb.delete(0, sb.length());
                    continue;
                }
                sb.append(string.charAt(i));
            }
            if (string.charAt(i) == '(') {
                start = true;
            }
        }
        return "";
    }

    /**
     * возвращает сумму
     * внутренних скобок
     * метода openStaples()
     *
     * @param string 5+(3+(6+2)+1+(2+1)+1)
     * @return 8
     */
    public static String calcStaples(String string) {
        final var actualPrimer = openStaples(string);
        final var subResult = calcString(actualPrimer);
        final var subString = "(" + actualPrimer + ")";
        if (Double.parseDouble(subResult) < 0) {
            string = string.replace(subString, subResult).replace("--", "+").replace("+-", "-");
        } else {
            string = string.replace(subString, subResult).replace("+-", "-");
        }
        return string;
    }

    /**
     * считает всю строку с учетом приоритетов
     *
     * @param string
     * @return
     */
    public static String calcString(String string) {
        if (string.contains(" ")) {
            string = StringUtils.deleteWhitespace(string);
        }
        while (string.contains("(")) {
            string = calcStaples(string);
        }
        while (string.contains("*")) {
            string = countAtString(string, '*');
        }
        while (string.contains("/")) {
            string = countAtString(string, '/');
        }
        while (check(string)) {
            string = countPair(string);
        }
        return roundEnd(string);
    }


    /**
     * считает пару значений вокруг переданного оператора
     * берется первое вхождение оператора и окружающая пара чисел
     * возвращается изначальная строка с вставленным результатом
     *
     * @param string
     * @param operation
     * @return
     */
    public static String countAtString(String string, Character operation) {
        if (!string.contains(String.valueOf(operation))) {
            return string;
        }
        final var a = FindDigits.findLast(string.substring(0, string.indexOf(operation)));
        final var b = FindDigits.findFirst(string.substring(string.indexOf(operation) + 1));
        final var calcString = a + operation + b;
        final var result = count(Double.parseDouble(a), Double.parseDouble(b), operation);
        return string.replace(calcString, result);
    }

    public static String count(double a, double b, Character operation) {
        switch (operation) {
            case '*' -> {
                return roundEnd(String.valueOf(a * b));
            }
            case '/' -> {
                if (b == 0) {
                    return "0.0";
                }
                return roundEnd(BigDecimal.valueOf(a / b).setScale(5, RoundingMode.HALF_UP).toString());
            }
            case '+' -> {
                return roundEnd(String.valueOf(a + b));
            }
            case '-' -> {
                return roundEnd(String.valueOf(a - b));
            }
            case '^' -> {
                return roundEnd(String.valueOf(Math.pow(a, b)));
            }
            default -> throw new IllegalArgumentException(String.valueOf(operation));
        }
    }

    private static boolean check(String string) {
        if (string.charAt(0) == '-') {
            string = string.substring(1);
        }
        return string.contains("-") || string.contains("+") || string.contains("/") || string.contains("*");
    }

    private static String countPair(String string) {
        var a = FindDigits.findFirst(string);
        string = string.substring(a.length());
        return count(Double.parseDouble(a), string);
    }

    private static String count(double a, String string) {
        final var operation = string.charAt(0);
        string = string.substring(1);
        var b = FindDigits.findFirst(string);
        string = string.substring(b.length());
        return count(a, Double.parseDouble(b), operation) + string;
    }

    private static String roundEnd(String string) {
        for (int i = string.length() - 1; i > -1; i--) {
            if (string.charAt(i) == '0' && string.charAt(i - 1) != '.') {
                string = string.substring(0, string.length() - 1);
            } else {
                break;
            }
        }
        return string;
    }

}
