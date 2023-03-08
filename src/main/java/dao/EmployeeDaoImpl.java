package dao;

import config.HibernateManager;
import model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class EmployeeDaoImpl implements EmployeeDAO {

    private final HibernateManager hibernateManager;

    public EmployeeDaoImpl(HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }

    @Override
    public Employee insert(Employee employee) {
        hibernateManager.withEntityManager(entityManager -> {
            if (employee.getCity() != null) {
                entityManager.persist(employee.getCity());
            }
            entityManager.persist(employee);
        });
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.merge(employee);
        });
        return employee;
    }

    @Override
    public Optional<Employee> findById(long id) {
        final Employee[] employee = {null};
        hibernateManager.withEntityManager(entityManager -> {
            employee[0] = entityManager.find(Employee.class, id);
        });
        return Optional.ofNullable(employee[0]);
    }

    @Override
    public List<Employee> findAll() {
        AtomicReference<List<Employee>> employees = new AtomicReference<>(Collections.emptyList());
        hibernateManager.withEntityManager(entityManager -> {
            employees.set(entityManager.createQuery("SELECT e from Employee e", Employee.class).getResultList());
        });
        return employees.get();
    }

    @Override
    public void delete(Employee employee) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.remove(employee);
        });
    }
}
