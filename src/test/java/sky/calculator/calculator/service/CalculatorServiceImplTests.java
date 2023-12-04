package sky.calculator.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import sky.calculator.calculator.CalculatorService;
import sky.calculator.calculator.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceImplTests {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    void welcome(){
        String expected = "Добро пожаловать в калькулятор";
        assertEquals(expected, "Добро пожаловать в калькулятор");
    }

    @Test
    void resultPlus() {

        int res = calculatorService.result(2, 5, "+");
        int res2 = calculatorService.result(-7, 5, "+");
        assertEquals(7, res);
        assertEquals(-2, res2);
    }

    @Test
    void resultMinus() {

        int res = calculatorService.result(5, 3, "-");
        int res2 = calculatorService.result(-3, 3, "-");
        assertEquals(2, res);
        assertEquals(-6, res2);
    }

    @Test
    void resultMultiply() {

        int res = calculatorService.result(5, 3, "*");
        int res2 = calculatorService.result(-2, 3, "*");
        assertEquals(15, res);
        assertEquals(-6, res2);
    }

    @Test
    void resultDivide() {

        int res = calculatorService.result(15, 3, "/");
        int res2 = calculatorService.result(-6, 3, "/");
        assertEquals(5, res);
        assertEquals(-2, res2);

    }
    @Test
    void divideByZero(){
        assertThrows(IllegalArgumentException.class, () -> calculatorService.result(2, 0, "/"));

    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "5,10,15", "15,30,45"})
    void plusprm(int a, int b, int expected){
        assertEquals(expected, calculatorService.result(a, b, "+"));
    }
    @ParameterizedTest
    @CsvSource(value = {"6,2,4", "10,5,5", "15,30,-15"})
    void minusprm(int a, int b, int expected){
        assertEquals(expected, calculatorService.result(a, b, "-"));
    }
    @ParameterizedTest
    @CsvSource(value = {"6,2,12", "10,5,50", "5,30,150"})
    void multiplyprm(int a, int b, int expected){
        assertEquals(expected, calculatorService.result(a, b, "*"));
    }
    @ParameterizedTest
    @CsvSource(value = {"6,2,3", "10,5,2", "30,5,6"})
    void divideprm(int a, int b, int expected){
        assertEquals(expected, calculatorService.result(a, b, "/"));
    }
}
