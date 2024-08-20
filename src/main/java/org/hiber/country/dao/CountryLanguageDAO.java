package org.hiber.country.dao;


import org.hiber.country.entity.CountryLanguage;

import java.util.List;

public interface CountryLanguageDAO {
    public void save(CountryLanguage city);
    public CountryLanguage findById(int id);
    public void update(CountryLanguage city);
    public void delete(CountryLanguage city);
    public List<CountryLanguage> findAll();
}
