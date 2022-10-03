package com.herlander.cursomcc;

import com.herlander.cursomcc.domain.Categories;
import com.herlander.cursomcc.repositories.CategorieRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class CursomccApplication implements CommandLineRunner {

	@Autowired
	private CategorieRepositorie categoriaRepositorie;

	public static void main(String[] args) {
		SpringApplication.run(CursomccApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Categories cat1 = new Categories(null, "Informática");
		Categories cat2 = new Categories(null, "Escritório");

		categoriaRepositorie.saveAll(Arrays.asList(cat1, cat2));
	}
}
