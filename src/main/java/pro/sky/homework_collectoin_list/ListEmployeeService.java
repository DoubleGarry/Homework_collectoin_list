package pro.sky.homework_collectoin_list;

import org.springframework.stereotype.Service;
import pro.sky.homework_collectoin_list.exception.EmployeeAlreadyAddedException;
import pro.sky.homework_collectoin_list.exception.EmployeeNotFoundException;
import pro.sky.homework_collectoin_list.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class ListEmployeeService implements EmployeeService {
    private static final int CAPACITY = 10;
    private final Map<String, Employee> employees;
    public ListEmployeeService(){
        this.employees = new HashMap<>();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (employees.containsKey(emp.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        employees.put(emp.getFullName(),emp);
        return emp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (employees.containsKey(emp.getFullName())) {
            return employees.remove(emp.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (employees.containsKey(emp.getFullName())) {
            return employees.get(emp.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
