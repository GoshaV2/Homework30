import config.HibernateManager;
import dao.EmployeeDAO;
import dao.EmployeeDaoImpl;
import model.City;
import model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDaoImpl(new HibernateManager());
        Employee employee = new Employee();
        City city = new City();
        city.setName("Нефтекамск");
        employee.setCity(city);
        employee.setGender("М");
        employee.setAge(12);
        employee.setFirstName("Иван");
        employee.setLastName("Иванов");
        employeeDAO.insert(employee);
        System.out.println(employee);

        Employee employee1 = employeeDAO.findById(employee.getId()).get();
        employee1.setLastName("Иванович");
        employeeDAO.update(employee1);
        System.out.println(employeeDAO.findById(24).get());

        employeeDAO.delete(employee1);

        System.out.println(employeeDAO.findAll());
    }
}
