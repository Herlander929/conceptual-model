package com.herlander.cursomcc;

import com.herlander.cursomcc.domain.*;
import com.herlander.cursomcc.domain.enums.EstadoPagamento;
import com.herlander.cursomcc.domain.enums.TipoCliente;
import com.herlander.cursomcc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

	@Autowired
	private ClientRepositorie clientRepositorie;

	@Autowired
	private AdressRepositorie adressRepositorie;

	@Autowired
	private PedidoRepositorie pedidoRepositorie;

	@Autowired
	private PagamentoRepositorie pagamentoRepositorie;

	@Autowired
	private ItemPedidoRepositorie itemPedidoRepositorie;

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

		Client cli1 = new Client(null, "Maria Sillva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA );
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		Adress e1 = new Adress(null, "Rua Flores", "300", "Apto 303", "jardim", "38220834",cli1, c1  );
		Adress e2 = new Adress(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012",cli1, c2 );


		cli1.getAdresses().addAll(Arrays.asList(e1,e2));

		clientRepositorie.saveAll(Arrays.asList(cli1));
		adressRepositorie.saveAll(Arrays.asList(e1,e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1  );
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2  );

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepositorie.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepositorie.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 00.0, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 00.0, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepositorie.saveAll(Arrays.asList(ip1, ip2, ip3));







	}
}
