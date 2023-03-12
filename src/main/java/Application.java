import config.HibernateManager;
import dao.CityDao;
import dao.CityDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.City;
import model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDao employeeDAO = new EmployeeDaoImpl(new HibernateManager());
        CityDao cityDao=new CityDaoImpl(new HibernateManager());
        City city=cityDao.findById(52).get();
        city.getEmployees().remove(0);
        cityDao.update(city);
        /*City city = new City();
        city.setName("Нефтекамск");
        cityDao.insert(city);
        cityDao.update(city);
        Employee employee = new Employee();
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
        System.out.println(employeeDAO.findById(employee1.getId()).get());

        System.out.println(cityDao.findById(city.getId()).get().getEmployees());
        employeeDAO.delete(employee1);

        System.out.println(employeeDAO.findAll());*/


    }
}
