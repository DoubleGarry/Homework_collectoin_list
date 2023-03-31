package pro.sky.homework_collectoin_list;

import org.springframework.stereotype.Service;
import pro.sky.homework_collectoin_list.exception.EmployeeAlreadyAddedException;
import pro.sky.homework_collectoin_list.exception.EmployeeNotFoundException;
import pro.sky.homework_collectoin_list.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListEmployeeService implements EmployeeService {
    private static final int CAPACITY = 10;
    List<Employee> team = new ArrayList<>();


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (team.contains(emp)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (team.size() >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        team.add(emp);
        return emp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        int index = team.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return team.remove(index);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        int index = team.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return team.get(index);
    }
}
