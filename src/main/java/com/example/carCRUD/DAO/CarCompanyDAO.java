package com.example.carCRUD.DAO;

import com.example.carCRUD.Entities.CarCompany;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarCompanyDAO {

    @Transactional
    void save(CarCompany company);

    @Transactional
    void update(CarCompany company);

    List<CarCompany> findAll();

    void delete(Integer id);

    CarCompany findById(Integer id);


}
