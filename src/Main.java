import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String vvod = s.nextLine();

        String operStr = " ";
        char[] symbol = new char[10];
        char oper = '+';
        for (int i=1; i < vvod.length(); i++) {
            symbol[i] = vvod.charAt(i);
            if ( symbol[i] == '+'){
                oper = '+'; operStr = "\\+";
            }
            if ( symbol[i] == '-'){
                oper = '-'; operStr = "-";
            }
            if ( symbol[i] == '*'){
                oper = '*'; operStr = "\\*";
            }
            if ( symbol[i] == '/'){
                oper = '/'; operStr = "/";
            }
        }

        int num1 = 0;
        int num2 = 0;
        int result;
        int resultArab;
        String[] numbers = vvod.split(operStr);
        if (numbers.length > 2) {
            System.out.println("Что-то пошло не так. Калькулятор считает только две переменные! Попробуйте снова.");
            System.exit(0);
        }
        try{
            num1 = romanNumeral(numbers[0]);
            num2 = romanNumeral(numbers[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет символа для выполнения операции или отсутствует вторая переменная! Попробуйте снова.");
            System.exit(0);
        }
        if (num1 == 0 | num2 == 0) {
            try {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
                if (num1 > 10 | num2 > 10 | num1 < 0 | num2 <0) {
                    System.out.println("Калькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно! Попробуйте снова.");
                    System.exit(0);
                }
                resultArab = calculate(num1, num2, oper);
                System.out.println(resultArab);//Выводим результат по арабским цифрам
            } catch (NumberFormatException e) {
                System.out.println("Калькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно! Попробуйте снова.");
            } catch (ArithmeticException e) {
                System.out.println("На ноль делить нельзя! Попробуйте снова.");
            }
        } else {
            try {
                result = calculate(num1, num2, oper);
                if (result == 0) {
                    System.out.println("Результатом работы калькулятора с римскими числами могут быть только положительные числа! Попробуйте снова.");
                    System.exit(0);
                }
                String resultRom = romanSolution(result);
                System.out.println(resultRom); // Выводим результат по римским цифрам
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Результатом работы калькулятора с римскими числами могут быть только положительные числа! Попробуйте снова.");
            }
        }
    }

    public static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }

    public static int romanNumeral(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    public static String romanSolution(int arabNumeral) {
        String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return romanAll[arabNumeral];

    }
}
