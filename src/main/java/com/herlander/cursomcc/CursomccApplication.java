package com.herlander.cursomcc;

import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.domain.Products;
import com.herlander.cursomcc.repositories.CategorieRepositorie;
import com.herlander.cursomcc.repositories.ProductRepositorie;
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
	}
}
