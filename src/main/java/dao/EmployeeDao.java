package dao;

import model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    void insert(Employee employee);

    void update(Employee employee);

    Optional<Employee> findById(long id);

    List<Employee> findAll();

    void delete(Employee employee);
}
