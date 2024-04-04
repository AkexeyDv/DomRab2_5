package pro.sky.DomRab2_5;

import java.util.List;

public interface EmployeeInterface {
    String hello();

    List<Employee> printList();

    Employee newEmployee(String name, String lastName);

    Employee findEmployee(String name, String lastName);

    Employee delEmployee(String name, String lastName);


}
