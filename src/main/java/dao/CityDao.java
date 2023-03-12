package dao;

import model.City;
import model.Employee;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    void insert(City city);

    void update(City city);

    Optional<City> findById(long id);

    List<City> findAll();

    void delete(City city);
}
