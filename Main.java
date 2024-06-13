import java.util.Arrays;

public class Main {

    static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static String calc(String input) throws Exception {
        Integer result;
        String[] symbols = input.split(" ");
        String value1 = symbols[0];
        String value2 = symbols[2];
        String operand = symbols[1];
        boolean v1 = isRomanic(value1);
        boolean v2 = isRomanic(value2);
        if (symbols.length != 3) {
            throw new Exception("Ошибка, введите два числа и оператор.");
        }

        if (v1 && v2) {
            int num1 = Arrays.asList(roman).indexOf(value1) + 1;
            int num2 = Arrays.asList(roman).indexOf(value2) + 1;
            result = calc(num1, num2, operand);
            if (result <= 0) {
                throw new Exception("Ошибка, результатом работы калькулятора с римскими числами могут быть положительные числа отличные от ноля.");
            }

            return roman[result-1];
        } else if (!v1 && !v2) {
            int num1 = Integer.parseInt(symbols[0]);
            int num2 = Integer.parseInt(symbols[2]);
            result = calc(num1, num2, operand);
            return result.toString();
        } else {
            throw new Exception("Ошибка, используйте либо арабские, либо римские цифры одновременно.");
        }
    }

    private static int calc(int num1, int num2, String operand) throws Exception {
        int result;
        if (operand.equals("/") && num2 == 0) {
            throw new Exception("Ошибка, на ноль делить нельзя");
        } else if ((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)) {
            switch (operand) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    throw new Exception("Ошибка, введите корректный оператор (+, -, *, /).");
            }

        } else  {
            throw new Exception("Ошибка, введите числа от 1 до 10");
        }
        return result;
    }

    private static boolean isRomanic(String value) {
        for (int i = 0; i < roman.length; i++) {
            if (value.equals(roman[i])) {
                return true;
            }
        }
        return false;
    }
}
