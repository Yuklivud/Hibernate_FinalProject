package org.hiber.country.dao;

import org.hiber.country.entity.City;

import java.util.List;

public interface CityDAO {
    public void save(City city);
    public City findById(int id);
    public void update(City city);
    public void delete(City city);
    public List<City> findAll();
}
