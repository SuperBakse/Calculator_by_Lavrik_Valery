public class Calculator {
    private double result;


    public void add(double num1, double num2) { result = num1 + num2; }

    public void subtract(double num1, double num2) { result = num1 - num2; }

    public void multiply(double num1, double num2) { result = num1 * num2; }

    public void divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error (n / 0)");
        } else {
            result = num1 / num2;
        }
    }

    public void sin(double x) { result = function.sin(x); }

    public void cos(double x) { result = function.cos(x); }

    public void tan(double x) { result = function.tan(x); }

    public void cot(double x) { result = function.ctg(x); }

    public void arcsin(double x) { result = function.asin(x); }

    public void arccos(double x) { result = function.acos(x); }

    public void arctan(double x) { result = function.atan(x); }

    public void arcctg(double x) { result = function.acot(x); }

    public void root(double number, int n) { result = function.root(number, n); }

    public void log(double base, double x) { result = function.log(base, x); }

    public void ln(double x) { result = function.ln(x); }

    public void pow(double number, int exponent) { result = function.power(number, exponent); }

    public void factorial(int num) { result = function.factorial(num); }

    public void exp(double val) { result = function.exp(val); }

    public void abs(double x) { result = function.abs(x); }

    public void round(double num) { result = function.round(num); }

    public void degree(double degrees) { result = function.degree(degrees); }

    public double getResult() { return result; }
}

class function {
    public static double exp(double val) {
        final int n = 100;
        double term = 1;
        double sum = 1;

        for (int i = 1; i < n; i++) {
            term *= val / i;
            sum += term;
        }
        return sum;
    }

    public static double abs(double x) {
        if (x < 0) return -x;
        else return x;
    }

    public static double power(double base, int exponent) { // мутод "бином Ньютона
        double result = base;
        for (int i = 1; i != exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static double root(double num, int n) { // метод Ньютона. Погрешность в 0.000001
        double guess = 1.0;
        while (abs(power(guess, n) - num) > 0.0001) {
            guess = ((n - 1) * guess + num / power(guess, n - 1)) / n;
        }
        return round(guess); // - 0.000001;
    }

    public static double round(double num) { // перенести куда-нибудь эту функцию от сюда. это не математическая функция
        long factor = (long) power(10, 6);
        num = num * factor;
        long tmp = (long) (num + 0.5);
        return (double) tmp / factor;
    }

    public static double factorial(int num) { // n >= 10
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double sin(double x) { // метод "ряд Тейлора"
        double term = x;                 // может считать только от -35 до 35. -35 >=  x >= 35
        double sum = term;
        for (int i = 3; abs(term) > 1e-6; i += 2) {
            term *= -x * x / ((i - 1) * i);
            sum += term;
        }
        return sum;
    }

    public static double cos(double x) {
        double term = 1;
        double sum = term;
        for (int i = 2; abs(term) > 1e-6; i += 2) {
            term *= -x * x / ((i - 1) * i);
            sum += term;
        }
        return sum;
    }

    public static double tan(double x) { return sin(x) / cos(x); }

    public static double ctg(double x) { return cos(x) / sin(x); }

    public static double asin(double x) {
        double guess = x;
        for (int i = 0; i < 10; i++) {
            guess = guess - (sin(guess) - x) / cos(guess);
        }
        return guess;
    }

    public static double acos(double x) {
        double guess = 1.0;
        for (int i = 0; i < 10; i++) {
            guess = guess - (cos(guess) - x) / -sin(guess);
        }
        return guess;
    }

    public static double atan(double x) {
        double guess = x;
        for (int i = 0; i < 10; i++) {
            guess = guess - (tan(guess) - x) / (1 + power(tan(guess), 2));
        }
        return guess;
    }

    public static double acot(double x) {
        double guess = 1.0;
        for (int i = 0; i < 10; i++) {
            guess = guess - (ctg(guess) - x) / -(1 + power(ctg(guess), 2));
        }
        return guess;
    }


    public static double ln(double x) {
        double oldSum = 0;
        double xmlxpl = (x - 1) / (x + 1);
        double xmlxpl2 = xmlxpl * xmlxpl;
        double denom = 1;
        double frac = xmlxpl;
        double term = frac;
        double sum = term;

        while (sum != oldSum) {
            oldSum = sum;
            denom += 2;
            frac *= xmlxpl2;
            sum += frac / denom;
        }
        return 2 * sum;
    }

    public static double log(double base, double x) { return ln(x) / ln(base); }

    public static double degree(double degrees) { return degrees * 3.141592653589793 / 180; }
}