package dao;

import config.HibernateManager;
import model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private final HibernateManager hibernateManager;

    public EmployeeDaoImpl(HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }

    @Override
    public void insert(Employee employee) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.persist(employee);
        });
    }

    @Override
    public void update(Employee employee) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.merge(employee);
        });
    }

    @Override
    public Optional<Employee> findById(long id) {
        return Optional.ofNullable(hibernateManager.withEntityManager(entityManager -> {
            return entityManager.find(Employee.class, id);
        }));
    }

    @Override
    public List<Employee> findAll() {
        return hibernateManager.withEntityManager(entityManager -> {
            return entityManager.createQuery("SELECT e from Employee e", Employee.class).getResultList();
        });
    }

    @Override
    public void delete(Employee employee) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.remove(employee);
        });
    }
}
