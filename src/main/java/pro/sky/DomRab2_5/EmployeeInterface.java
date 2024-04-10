package pro.sky.DomRab2_5;

public interface EmployeeInterface {

    String printMap();

    Employee newEmployee(String name, String surName);

    Employee findEmployee(String name, String lastName);

    Employee delEmployee(String name, String lastName);


}
