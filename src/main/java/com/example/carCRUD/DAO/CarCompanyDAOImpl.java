package com.example.carCRUD.DAO;

import com.example.carCRUD.Entities.CarCompany;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CarCompanyDAOImpl implements  CarCompanyDAO {

    private EntityManager entityManager;

    @Autowired
    public CarCompanyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(CarCompany company) {
        entityManager.persist(company);
    }

    @Transactional
    @Override
    public void update(CarCompany company) {
        entityManager.merge(company);
    }

    @Override
    public List<CarCompany> findAll() {
        String jpql = "FROM CarCompany";
        TypedQuery<CarCompany> query = entityManager.createQuery(jpql,CarCompany.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        CarCompany company = entityManager.find(CarCompany.class,id);
        entityManager.remove(company);
    }

    @Override
    public CarCompany findById(Integer id) {
        return entityManager.find(CarCompany.class,id);
    }


}
