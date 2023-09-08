package com.example.carCRUD;

import com.example.carCRUD.DAO.CarCompanyDAO;
import com.example.carCRUD.Entities.CarCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarCrudApplication  {


	public static void main(String[] args) {
		SpringApplication.run(CarCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CarCompanyDAO carCompanyDAO) {

		return runner -> {

			//createCompany(carCompanyDAO);
			//deleteById(carCompanyDAO);
			updateCompany(carCompanyDAO);

		};
	}

	private void updateCompany(CarCompanyDAO carCompanyDAO) {
		CarCompany company = carCompanyDAO.findById(2);
		company.setName("Mercedes");
		carCompanyDAO.update(company);
	}

	private void deleteById(CarCompanyDAO carCompanyDAO) {
		int id = 1;
		carCompanyDAO.delete(id);
	}

	private void createCompany(CarCompanyDAO carCompanyDAO) {
		CarCompany audi = new CarCompany("Audi");
		System.out.println("Adding Audi");
		carCompanyDAO.save(audi);
	}
}
