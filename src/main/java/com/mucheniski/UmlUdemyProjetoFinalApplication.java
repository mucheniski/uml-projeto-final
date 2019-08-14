package com.mucheniski;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mucheniski.domains.Categoria;
import com.mucheniski.domains.Cidade;
import com.mucheniski.domains.Cliente;
import com.mucheniski.domains.Endereco;
import com.mucheniski.domains.Estado;
import com.mucheniski.domains.Pagamento;
import com.mucheniski.domains.PagamentoBoleto;
import com.mucheniski.domains.PagamentoCartao;
import com.mucheniski.domains.Pedido;
import com.mucheniski.domains.Produto;
import com.mucheniski.enums.StatusPagamento;
import com.mucheniski.enums.TipoCliente;
import com.mucheniski.repositories.CategoriaRepository;
import com.mucheniski.repositories.CidadeRepository;
import com.mucheniski.repositories.ClienteRepository;
import com.mucheniski.repositories.EnderecoRepository;
import com.mucheniski.repositories.EstadoRepository;
import com.mucheniski.repositories.PagamentoRepository;
import com.mucheniski.repositories.PedidoRepository;
import com.mucheniski.repositories.ProdutoRepository;

@SpringBootApplication
public class UmlUdemyProjetoFinalApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UmlUdemyProjetoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		Cliente cliente1 = new Cliente(null, "Bruna", "bruna@teste", "08080808029", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("888888888", "9999999"));
		
		Endereco endereco1 = new Endereco(null, "Rua nome da rua1", "123", "apto1", "Centro", "88888888", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Rua nome da rua2", "321", "apto2", "Centro", "88888888", cliente1, cidade2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2019 13:23"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("23/08/2019 10:23"), cliente1, endereco2);
		
		Pagamento pagamentoCartao1 = new PagamentoCartao(null, StatusPagamento.QUITADO, pedido1, 3);
		pedido1.setPagamento(pagamentoCartao1);
		
		Pagamento pagamentoBoleto1 = new PagamentoBoleto(null, StatusPagamento.PENDENTE, pedido2, sdf.parse("30/09/2019 13:23"), null);
		pedido2.setPagamento(pagamentoBoleto1);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamentoCartao1, pagamentoBoleto1));
		
	}

}
