package controller;

import model.Operation;
import model.Result;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CalculController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Result result(Operation operation) throws Exception{
        String res [] = operation.getOperation().split(" ");
        int a = Integer.parseInt(res[0]);
        int b = Integer.parseInt(res[1]);
        int plus = a+b;
        int mult = a*b;
        double div = a/b;
        int minus = a-b;
        return new Result("a + b = " + String.valueOf(plus) + " a - b = " + String.valueOf(minus) + " a * b = " +String.valueOf(mult) + " a / b = " + String.valueOf(div));
    }
}
