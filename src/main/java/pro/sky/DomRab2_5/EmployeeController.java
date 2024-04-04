package pro.sky.DomRab2_5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeInterface employees;

    public EmployeeController(EmployeeInterface employees) {
        this.employees = employees;
    }

    @GetMapping(path ="/employee")
    public String hello() {
        return employees.getEmployeesList().toString() ;
    }



    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("name") String name,
                              @RequestParam("lastName") String lastName) {
        employees.newEmployee(name,lastName);


        return "{ \"name\": \""+name + "\", \"lastName\": \"" + lastName+"\" }"+" добавлен в список сотрудников";

    }
    @GetMapping(path = "/employee/find")
    public String findEmployee(@RequestParam("name") String name,
                               @RequestParam("lastName") String lastName){
        employees.findEmployee(name,lastName);
        return "{ \"name\": \""+name + "\", \"lastName\": \"" + lastName+"\" }"+" найден";

    }
    @GetMapping(path="/employee/remove")
    public String removeEmployee(@RequestParam("name") String name,
                                 @RequestParam("lastName") String lastName){
        employees.delEmployee(name,lastName);
        return "{ \"name\": \""+name + "\", \"lastName\": \"" + lastName+"\" }" + "удален";
    }

}

