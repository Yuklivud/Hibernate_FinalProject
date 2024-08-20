package org.hiber.country.dao;

import org.hiber.country.entity.Country;

import java.util.List;

public interface CountryDAO {
    public void save(Country city);
    public Country findById(int id);
    public void update(Country city);
    public void delete(Country city);
    public List<Country> findAll();
}
