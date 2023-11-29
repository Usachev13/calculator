package sky.calculator.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    @GetMapping()
    public String welcome(){
        return calculatorService.welcome();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);}

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);}

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " + " + num2 + " = " + calculatorService.multiply(num1, num2);}
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        return num1 + " + " + num2 + " = " + calculatorService.divide(num1, num2);}
}
