import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать в калькулятор!\n" +
                "Введите строку:");

        String str = (sc.nextLine());
        System.out.println(calc(str));
    }

    public static String calc(String input){
        try {
            if (!Validation.isValidString(input)) {
                throw new IllegalArgumentException("Неверный ввод. Введите строку в формате \"целое число\" + \"оператор\" + \"целое число\" \n" +
                        "Числа должны быть в диапазоне от 1 до 10 включительно");
            } else {
                //Определяем оператор
                char[] chars = input.toCharArray();
                char mainOperator = 0;
                for (char ch : chars) {
                    for (char operator : Validation.operators) {
                        if (ch == operator) {
                            mainOperator = ch;
                        }
                    }
                }

                //Создаем числа
                String[] numbers = input.split("\\" + mainOperator);

                int num1 = Integer.parseInt(numbers[0].trim());
                int num2 = Integer.parseInt(numbers[1].trim());

                //Проводим операции
                Calculator calculatorRepository = new Calculator();

                switch (mainOperator) {
                    case '+' -> {
                        return ("Результат: " + calculatorRepository.summing(num1, num2));
                    }
                    case '-' -> {
                        return ("Результат: " + calculatorRepository.subtraction(num1, num2));
                    }
                    case '*' -> {
                        return ("Результат: " + calculatorRepository.product(num1, num2));
                    }
                    default -> {
                        return ("Результат: " + calculatorRepository.division(num1, num2));
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            return (e.getMessage());
        }
    }
}
