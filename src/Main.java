import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str,
                arabRegex = "^(1|2|3|4|5|6|7|8|9|10)\\s+[+|\\-|*|\\/]\\s+(1|2|3|4|5|6|7|8|9|10)$",
                romanRegex = "^(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s+[+|\\-|*|\\/]\\s+(I|II|III|IV|V|VI|VII|VIII|IX|X)$",
                incorrectRegex1 = "^(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s+[+|\\-|*|\\/]\\s+(1|2|3|4|5|6|7|8|9|10)$",
                incorrectRegex2 = "(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s+[+|\\-|*|\\/]\\s+(1|2|3|4|5|6|7|8|9|10)$";
        String[] romanNum = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", //0-10
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", //11-20
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", //21-30
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", //31-40
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", //41-50
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", //51-60
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", //61-70
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", //71-80
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", //81-90
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C", //91-100
        };

        System.out.println("Input:");
        str = reader.readLine();

        System.out.println("Output:");
        try {
            if (Pattern.matches(arabRegex, str)) {
                System.out.println(Calculator.calculate(str, true));
            } else if (Pattern.matches(romanRegex, str)) {
                int result = Calculator.calculate(str, false);

                if (result < 0)
                    throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                else
                    System.out.println(romanNum[result]);
            } else if (Pattern.matches(incorrectRegex1, str) | Pattern.matches(incorrectRegex2, str)) {
                throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
            } else {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда от 1 до 10 и один оператор (+, -, /, *)");
            }
        } catch (Exception ex) {
                System.out.println(ex.getMessage());
        }
    }
}