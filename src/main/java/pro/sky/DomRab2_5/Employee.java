package pro.sky.DomRab2_5;

import java.util.Objects;

public class Employee {
    private String name;
    private String lastName;


    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        /*{ "firstName": "Ivan", "lastName": "Ivanov" }*/
        return "{ \"name\": \""+name + "\", \"lastName\": \"" + lastName+"\" }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

}



