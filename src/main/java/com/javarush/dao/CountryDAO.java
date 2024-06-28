package com.javarush.dao;

import com.javarush.domain.Country;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;

public class CountryDAO {
    private SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {
        Query<Country> query = sessionFactory
                .getCurrentSession()
                .createQuery("select c from Country c join fetch c.languages", Country.class);
        return query.getResultList();

    }
}
