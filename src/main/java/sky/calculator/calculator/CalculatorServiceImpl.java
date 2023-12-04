package sky.calculator.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    public Integer result(int num1, int num2, String op) {
        switch (op) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "/" -> {
                if (num2 == 0) {
                    throw new IllegalArgumentException(" На ноль делить нельзя");
                }
                return num1 / num2;
            }
            case "*" -> {
                return num1 * num2;
            }
        }
        return null;
    }
}
