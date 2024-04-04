package pro.sky.DomRab2_5;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface {
    private List<Employee> employeesList;
    private final int countMax = 3;

    public EmployeeService(List<Employee> employeeList) {
        this.employeesList = employeeList;
    }

    @Override
    public Employee newEmployee(String name, String lastName) {
        Employee employee;
        if (employeesList.size() >= countMax) {
            throw new EmployeeStorageIsFullException("БД уже полностью заполена");
        }
        if (seekEmployee(name, lastName) == -1) {
            employee = new Employee(name, lastName);
            employeesList.add(employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует в базе");
        }


    }

    @Override
    public Employee delEmployee(String name, String lastName) {
        Employee currentDelEmployee = findEmployee(name, lastName);
        employeesList.remove(currentDelEmployee);
        return currentDelEmployee;
    }

    @Override
    public Employee findEmployee(String name, String lastName) {
        if (seekEmployee(name, lastName) != -1) {
            return employeesList.get(seekEmployee(name, lastName));
        }
        throw new EmployeeNotFoundException("Сотрудник не обнаружен");
    }

    //Создадим универсальный метод поиска индекса объектов Employee в объекте List
    private int seekEmployee(String name, String lastName) {
        for (int idx = 0; idx < employeesList.size(); idx++) {
            if ((employeesList.get(idx).getName()).equals(name) &&
                    (employeesList.get(idx).getLastName()).equals(lastName)) {
                return idx;
            }
        }
        return -1;
    }


    @Override
    public List<Employee> printList() {
        return employeesList;
    }


    @Override
    public String hello() {
        return "Привет! С вами отдел кадров!";
    }

}
