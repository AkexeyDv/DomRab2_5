package pro.sky.DomRab2_5;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface {
    private List<Employee> employeesList =new ArrayList<>() ;
    private final int countMax=3;

    public EmployeeService(List<Employee> employeeList) {
        this.employeesList = employeeList;
    }

    @Override
    public void newEmployee(String name, String lastName){
        boolean employeeYes=false;
        for (Employee employeeList: employeesList){
            if(employeeList.getName().equals(name)&&employeeList.getLastName().equals(lastName)){
                employeeYes=true;
            }
        }
        if(employeesList.size()>=countMax){
            throw new EmployeeStorageIsFullException("БД уже полностью заполена");
        }
        if(employeeYes==false){
            employeesList.add(new Employee(name,lastName));

        }else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует в базе");
        }


    }
    public Employee findEmployee(String name, String lastName){
        for (Employee employeeList: employeesList) {
            if (employeeList.getName().equals(name) && employeeList.getLastName().equals(lastName)) {
                return employeeList;
            }
        }

        throw new EmployeeNotFoundException("Сотрудник не обнаружен");
    }
    public Employee delEmployee(String name, String lastName){
        Employee currentDelEmployee=findEmployee(name,lastName);
        employeesList.remove(currentDelEmployee);
        return currentDelEmployee;
    }

    @Override
    public  List<Employee> getEmployeesList() {
        return employeesList;
    }





    @Override
    public String hello() {
        return "Привет! С вами отдел кадров!";
    }

}
