package com.herlander.cursomcc;

import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.domain.City;
import com.herlander.cursomcc.domain.Products;
import com.herlander.cursomcc.domain.State;
import com.herlander.cursomcc.repositories.CategorieRepositorie;
import com.herlander.cursomcc.repositories.CityRepositorie;
import com.herlander.cursomcc.repositories.ProductRepositorie;
import com.herlander.cursomcc.repositories.StateRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class CursomccApplication implements CommandLineRunner {

	@Autowired
	private CategorieRepositorie categoriaRepositorie;

	@Autowired
	private ProductRepositorie productRepositorie;

	@Autowired
	private CityRepositorie cityRepositorie;

	@Autowired
	private StateRepositorie stateRepositorie;

	public static void main(String[] args) {
		SpringApplication.run(CursomccApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Categories cat1 = new Categories(null, "Informática");
		Categories cat2 = new Categories(null, "Escritório");

		Products p1 = new Products(null, "Computador", 2000.00);
		Products p2 = new Products(null, "Impressora", 800.00);
		Products p3 = new Products(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll((Arrays.asList(p2)));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));


		categoriaRepositorie.saveAll(Arrays.asList(cat1, cat2));
		productRepositorie.saveAll(Arrays.asList(p1,p2,p3));

		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCitys().addAll(Arrays.asList(c1));
		est2.getCitys().addAll(Arrays.asList(c2,c3));

		stateRepositorie.saveAll(Arrays.asList(est1, est2));
		cityRepositorie.saveAll(Arrays.asList(c1, c2, c3));






	}
}
