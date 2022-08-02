package pro.sky.Homework26.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework26.Employee;
import pro.sky.Homework26.WorkingExceptions.EmployeeAlreadyAddedException;
import pro.sky.Homework26.WorkingExceptions.EmployeeNotFoundException;
import pro.sky.Homework26.WorkingExceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public static final int limitEmployees = 20;
    private final Map<String,Employee> employees = new HashMap<>(
            new Employee("Иванов", "Иван"),
            new Employee("Петров", "Роман"),
            new Employee("Сидоров", "Юрий"),
            new Employee("Куликов", "Михайл"),
            new Employee("Ильин", "Александр"),
            new Employee("Рогонов", "Александр"),
            new Employee("Белов", "Евгений"),
            new Employee("Сосновцев", "Виктор"),
            new Employee("Смирнов", "Андрей"),
            new Employee("Андреев", "Роман")
    );

    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        String key = getKey(lastName,firstName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < limitEmployees) {
            employees.put(key,employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String lastName, String firstName) {
        String key = getKey(lastName,firstName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return  employees.remove(key);

    }

    public Employee getEmployee(String lastName, String firstName) {
        String key = getKey(lastName,firstName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employee.get(key);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees.values);
    }

    private String getKey(String lastName, String firstName) {
        return

    }


}
