package pro.sky.homework_collectoin_list;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
