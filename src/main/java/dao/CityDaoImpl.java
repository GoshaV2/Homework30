package dao;

import config.HibernateManager;
import model.City;

import java.util.List;
import java.util.Optional;

public class CityDaoImpl implements CityDao {
    private final HibernateManager hibernateManager;


    public CityDaoImpl(HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }

    @Override
    public void insert(City city) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.persist(city);
        });
    }

    @Override
    public void update(City city) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.merge(city);
        });
    }

    @Override
    public Optional<City> findById(long id) {
        City city = hibernateManager.withEntityManager(entityManager -> {
            return entityManager.find(City.class, id);
        });
        return Optional.ofNullable(city);
    }

    @Override
    public List<City> findAll() {
        List<City> cities = hibernateManager.withEntityManager(entityManager -> {
            return entityManager.createQuery("select city from City city").getResultList();
        });
        return cities;
    }

    @Override
    public void delete(City city) {
        hibernateManager.withEntityManager(entityManager -> {
            entityManager.remove(city);
        });
    }
}

