package pro.sky.homework_collectoin_list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping(value = "/")
    public String hi(){
        return "Привет";
    }
}
