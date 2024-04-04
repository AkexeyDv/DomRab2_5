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
    public List<Employee> hello() {
        return employees.printList();
    }


    @GetMapping(path = "/employee/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("lastName") String lastName) {


        return employees.newEmployee(name, lastName);
    }

    @GetMapping(path = "/employee/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("lastName") String lastName) {
        return employees.findEmployee(name, lastName);

    }


    @GetMapping(path = "/employee/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("lastName") String lastName) {
        employees.delEmployee(name, lastName);
        return employees.delEmployee(name, lastName);
    }

}

