package ts.andrey.calculate;

public class FindDigits {

    private FindDigits() {
    }

    public static String findFirst(String string) {
        var minus = string.charAt(0) == '-';
        string = Cutter.cutFirstNonDigits(string);
        final var sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            final var ch = string.charAt(i);
            if (!Character.isDigit(ch) && ch != '.') {
                if (minus) {
                    return "-" + sb;
                }
                return sb.toString();
            }
            sb.append(ch);
        }
        if (minus) {
            return "-" + sb;
        }
        return sb.toString();
    }

    public static String findLast(String string) {
        var minus = false;
        string = Cutter.cutLastNonDigits(string);
        final var sb = new StringBuilder();
        for (int i = string.length() - 1; i > -1; i--) {
            final var ch = string.charAt(i);
            if (ch == '-') {
                minus = true;
            }
            if (!Character.isDigit(ch) && ch != '.') {
                if (minus) {
                    return "-" + sb.reverse();
                }
                return sb.reverse().toString();
            }
            sb.append(ch);
        }
        if (minus) {
            return "-" + sb.reverse();
        }
        return sb.reverse().toString();
    }

}
