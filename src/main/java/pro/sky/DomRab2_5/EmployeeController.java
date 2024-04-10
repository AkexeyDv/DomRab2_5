package pro.sky.DomRab2_5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employees;

    public EmployeeController(EmployeeService employees) {
        this.employees = employees;
    }

    @GetMapping(path = "/employee")
    public String hello() {
        return employees.printMap();
    }


    @GetMapping(path = "/employee/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("surName") String surName) {


        return employees.newEmployee(name, surName);
    }

    @GetMapping(path = "/employee/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("surName") String surName) {
        return employees.findEmployee(name, surName);

    }

    @GetMapping(path = "/employee/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("surName") String surName) {
        //employees.delEmployee(name, surName);
        return employees.delEmployee(name, surName);
    }

}

