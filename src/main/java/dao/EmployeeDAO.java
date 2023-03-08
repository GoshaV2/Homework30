package dao;

import model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    Employee insert(Employee employee);

    Employee update(Employee employee);

    Optional<Employee> findById(long id);

    List<Employee> findAll();

    void delete(Employee employee);
}
