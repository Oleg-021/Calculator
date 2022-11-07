public class Calculator {
    public static int calculate(String str, boolean isArab) throws Exception {
        String[] words = str.split(" +");
        String operator = words[1];
        int operand1 = 0;
        int operand2 = 0;

        if (isArab) {
            operand1 = Integer.parseInt(words[0]);
            operand2 = Integer.parseInt(words[2]);
        } else {
            operand1 = Interpreter.interpretRome(words[0]);
            operand2 = Interpreter.interpretRome(words[2]);
        }

        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            default -> operand1 / operand2;
        };
    }

    private static class Interpreter {
        private static int interpretRome(String word) throws Exception {
            return switch (word) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                default -> 10;
            };
        }
    }
}
