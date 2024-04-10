package pro.sky.DomRab2_5;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService implements EmployeeInterface {
    private Map<String, Employee> employeesMap;
    private final int countMax = 20;

    public EmployeeService(Map<String, Employee> employeesMap) {
        this.employeesMap = employeesMap;
    }

    @Override
    public Employee newEmployee(String name, String surName) {
        if (employeesMap.size() >= countMax) {
            throw new EmployeeStorageIsFullException("БД уже полностью заполена");
        }
        if (employeesMap.containsKey(name + surName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует в базе");
        }

        employeesMap.put(name + surName, new Employee(name, surName));
        return employeesMap.get(name + surName);

    }

    @Override
    public Employee delEmployee(String name, String surName) {
        if (employeesMap.containsKey(name+surName)){
            Employee currentDelEmployee = employeesMap.get(name + surName);
            employeesMap.remove(name + surName);
            return currentDelEmployee;
        }
        throw new EmployeeNotFoundException("Сотрудник не обнаружен");

    }

    @Override
    public Employee findEmployee(String name, String surName) {
        if (employeesMap.containsKey(name + surName)) {
            return employeesMap.get(name + surName);
        }
        throw new RuntimeException("Сотрудник не обнаружен");
    }

    @Override
    public String printMap() {
        return employeesMap.values().toString();
    }


}
