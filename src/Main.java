import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        List<String> listFunctions = Arrays.asList("-", "+", "*", "/");

        while (true) {
            System.out.print("Введите значения: ");
            String input = scanner.nextLine();

            if ("exit".equals(input)) {
                break;
            }

            String[] tokens = input.trim().split("\\s+");

            int intfirstOperand = 0;
            double firstOperand = 0.0;
            int intsecondOperand = 0;
            double secondOperand = 0.0;
            String operation;

            if (listFunctions.contains(tokens[1])) {
                operation = tokens[1];
                intfirstOperand = Integer.parseInt(tokens[0]);
                firstOperand = Double.parseDouble(tokens[0]);
                intsecondOperand = Integer.parseInt(tokens[2]);
                secondOperand = Double.parseDouble(tokens[2]);
            } else {
                operation = tokens[0];
                if (tokens.length > 1 && !tokens[1].isEmpty() && isNumeric(tokens[1])) {
                    intfirstOperand = Integer.parseInt(tokens[1]);
                    firstOperand = Double.parseDouble(tokens[1]);
                }
                if (tokens.length > 2 && !tokens[2].isEmpty() && isNumeric(tokens[2])) {
                    intsecondOperand = Integer.parseInt(tokens[2]);
                    secondOperand = Double.parseDouble(tokens[2]);
                }
            }

            performOperation(calculator, operation, firstOperand, secondOperand, intfirstOperand, intsecondOperand);
            System.out.println("Итог: " + calculator.getResult());
        }

        scanner.close();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void performOperation(Calculator calculator, String operation, double firstOperand,
                                         double secondOperand, int intfirstOperand, int intsecondOperand) {
        switch (operation) {
            case "+":
                calculator.add(firstOperand, secondOperand);
                break;
            case "-":
                calculator.subtract(firstOperand, secondOperand);
                break;
            case "*":
                calculator.multiply(firstOperand, secondOperand);
                break;
            case "/":
                calculator.divide(firstOperand, secondOperand);
                break;
            case "sin":
                calculator.sin(firstOperand);
                break;
            case "cos":
                calculator.cos(firstOperand);
                break;
            case "tan":
                calculator.tan(firstOperand);
                break;
            case "cot":
                calculator.cot(firstOperand);
                break;
            case "arcsin":
                calculator.arcsin(firstOperand);
                break;
            case "arccos":
                calculator.arccos(firstOperand);
                break;
            case "arctan":
                calculator.arctan(firstOperand);
                break;
            case "arccot":
                calculator.arcctg(firstOperand);
                break;
            case "root":
                calculator.root(firstOperand, intsecondOperand);
                break;
            case "log":
                calculator.log(firstOperand, secondOperand);
                break;
            case "ln":
                calculator.ln(firstOperand);
                break;
            case "pow":
                calculator.pow(firstOperand, intsecondOperand);
                break;
            case "factorial":
                calculator.factorial(intfirstOperand);
                break;
            case "exp":
                calculator.exp(firstOperand);
                break;
            case "abs":
                calculator.abs(firstOperand);
                break;
            case "round":
                calculator.round(firstOperand);
                break;
            case "degree":
                calculator.degree(firstOperand);
                break;
            default:
                System.out.println("Неизвестная операция");
                break;
        }
    }
}
