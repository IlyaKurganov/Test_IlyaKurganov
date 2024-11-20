class Validation {
    public static char[] operators = {'+', '-', '*', '/'};

    public static boolean isValidString(String str) {
        //Если строка пустая - она не валидна
        if (str.isEmpty()) {
            return false;
        }

        char[] chars = str.replaceAll(" ", "").toCharArray();
        char mainOperator = ' ';

        //Если строка содержит что-то кроме цифр и операторов - она не валидна
        for (char ch : chars) {
            if (!Character.isDigit(ch) && ch != operators[0] && ch != operators[1] && ch != operators[2] && ch != operators[3] && ch != ' ') {
                return false;
            }
        }

        //Если строка содержит больше 1-го оператора – она не валидна
        int quantityOfOperator = 0;
        for (char ch : chars) {
            for (char operator : operators) {
                if (ch == operator) {
                    mainOperator = operator;
                    quantityOfOperator++;
                }
                if (quantityOfOperator > 1) {
                    break;
                }
            }
        }
        if (quantityOfOperator == 0 || quantityOfOperator > 1) {
            return false;
        }

        // Проверяем, что оба числа не содержат пробелов внутри себя и в пределах от 1 до 10 включительно
        String[] numbers = str.split("\\" + mainOperator);

        if (numbers[0].trim().contains(" ") || numbers[1].trim().contains(" ")) {
            return false;
        }

        try {
            int num1 = Integer.parseInt(numbers[0].trim());
            int num2 = Integer.parseInt(numbers[1].trim());
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
