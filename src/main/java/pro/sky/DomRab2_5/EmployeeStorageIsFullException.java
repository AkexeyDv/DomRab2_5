package pro.sky.DomRab2_5;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super("Превышено количество записей БД");
    }
}
