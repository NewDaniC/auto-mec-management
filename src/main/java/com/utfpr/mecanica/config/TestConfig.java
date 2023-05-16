package com.utfpr.mecanica.config;

import java.time.Instant;

/*
 * Classe para teste, com ela é possivel instanciar objetos para testar o projeto.
 */

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.utfpr.mecanica.entities.Cargo;
import com.utfpr.mecanica.entities.Categoria;
import com.utfpr.mecanica.entities.Cidade;
import com.utfpr.mecanica.entities.Cliente;
import com.utfpr.mecanica.entities.Endereco;
import com.utfpr.mecanica.entities.Estado;
import com.utfpr.mecanica.entities.Funcionario;
import com.utfpr.mecanica.entities.Item;
import com.utfpr.mecanica.entities.Manutencao;
import com.utfpr.mecanica.entities.Pagamento;
import com.utfpr.mecanica.entities.Pessoa;
import com.utfpr.mecanica.entities.Servico;
import com.utfpr.mecanica.entities.User;
import com.utfpr.mecanica.entities.Veiculo;
import com.utfpr.mecanica.entities.enums.CorDoVeiculo;
import com.utfpr.mecanica.entities.enums.EstadoPagamento;
import com.utfpr.mecanica.entities.enums.TipoCargo;
import com.utfpr.mecanica.entities.enums.TipoPagamento;
import com.utfpr.mecanica.repositories.CargoRepository;
import com.utfpr.mecanica.repositories.CategoriaRepository;
import com.utfpr.mecanica.repositories.CidadeRepository;
import com.utfpr.mecanica.repositories.ClienteRepository;
import com.utfpr.mecanica.repositories.EnderecoRepository;
import com.utfpr.mecanica.repositories.EstadoRepository;
import com.utfpr.mecanica.repositories.FuncionarioRepository;
import com.utfpr.mecanica.repositories.ItemRepository;
import com.utfpr.mecanica.repositories.ManutencaoRepository;
import com.utfpr.mecanica.repositories.PessoaRepository;
import com.utfpr.mecanica.repositories.ServicoRepository;
import com.utfpr.mecanica.repositories.UserRepository;
import com.utfpr.mecanica.repositories.VeiculoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ManutencaoRepository manutencaoRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); /* Instancia objetos */
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(user1, user2)); /* Salva esses objetos no BD */
		
		Estado est1 = new Estado(null, "Paraná");
		Estado est2 = new Estado(null, "Santa Catarina");
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
		Cidade cid1 = new Cidade(null, "Santa Helena", est1);
		Cidade cid2 = new Cidade(null, "Cascavel", est1);
		Cidade cid3 = new Cidade(null, "Itapema", est2);
		Cidade cid4 = new Cidade(null, "Florianópolis", est2);
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));
		
		Endereco end1 = new Endereco(null, "Rua Rio de Janeiro", "2000", "Casa", "Vila Rica", "85892000", cid1);
		Endereco end2 = new Endereco(null, "Rua Belo Horizonte", "222", "Casa", "Baixada Amarela", "85892000", cid1);
		Endereco end3 = new Endereco(null, "Rua das Flores", "333", "Casa", "Jardins", "888888888", cid3);
		Endereco end4 = new Endereco(null, "Rua Manuas", "555", "Casa", "Alamedas", "12345678", cid4);
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4));
		
		Pessoa pes1 = new Pessoa(null, "85858585", "Maria", Instant.parse("2019-06-20T00:00:00Z"), "maria@gmail.com", "45999999999", end1);
		Pessoa pes2 = new Pessoa(null, "54547474", "Rodrigo", Instant.parse("2002-07-21T00:00:00Z"), "rodrigo@gmail.com", "45988888888", end2);
		Pessoa pes3 = new Pessoa(null, "12121212", "João", Instant.parse("2014-01-25T00:00:00Z"), "joao@gmail.com", "45911111111", end3);
		Pessoa pes4 = new Pessoa(null, "99999999", "Patricia", Instant.parse("2014-01-25T00:00:00Z"), "patricia@gmail.com", "45977778888", end4);
		pessoaRepository.saveAll(Arrays.asList(pes1, pes2, pes3, pes4));
		
		Cargo car1 = new Cargo(null, 1200.00, "Mecanico", TipoCargo.MECANICO);
		cargoRepository.saveAll(Arrays.asList(car1));
		
		Funcionario fun1 = new Funcionario(pes4, car1, 1300.00, Instant.parse("2019-06-20T00:00:00Z"), null);
		funcionarioRepository.saveAll(Arrays.asList(fun1));
		
		Categoria cat1 = new Categoria(null, "Pneu");
		Categoria cat2 = new Categoria(null, "Eletrica");
		Categoria cat3 = new Categoria(null, "Lubrificante");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Item item1 = new Item (null, "Oleo 20w15", "Oleo de Motor - Lubrax", 10.0);
		Item item2 = new Item (null, "Fusivel 10 A", "Fusivel - Fusitec", 2.0);
		itemRepository.saveAll(Arrays.asList(item1, item2));
		
		// Preenchendo tabela tb_item_categoria
		item1.getCategoria().add(cat3);
		item2.getCategoria().add(cat2);
		itemRepository.saveAll(Arrays.asList(item1, item2));
		
		Veiculo vei1 = new Veiculo (null, "abc-1234", 2020, CorDoVeiculo.AMARELO);
		Veiculo vei2 = new Veiculo (null, "placa", 2020, CorDoVeiculo.AZUL);
		veiculoRepository.saveAll(Arrays.asList(vei1, vei2));
		
		Cliente cli1 = new Cliente (pes1, vei1, 9);
		Cliente cli2 = new Cliente (pes2, vei1, 10);
		Cliente cli3 = new Cliente (pes3, vei2, 8);
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		
		Manutencao man1 = new Manutencao(null, Instant.parse("2023-02-15T00:00:00Z"), null, 1200000, vei1);
		Manutencao man2 = new Manutencao(null, Instant.parse("2023-03-20T00:00:00Z"), null, 1234567, vei1);
		Manutencao man3 = new Manutencao(null, Instant.parse("2023-04-01T00:00:00Z"), null, 85000, vei2);
		manutencaoRepository.saveAll(Arrays.asList(man1, man2, man3));
		
		Servico ser1 = new Servico(man1, item1, item1.getPreco(), 5, 0.0, "Troca de oleo - Sem problemas");
		Servico ser2 = new Servico(man1, item2, item2.getPreco(), 1, 10.0, "Troca de fusivel - Sem problemas");
		Servico ser3 = new Servico(man2, item1, item1.getPreco(), 10, 0.0, "Troca de oleo - Sem problemas");
		servicoRepository.saveAll(Arrays.asList(ser1, ser2, ser3));
		
		Pagamento pag1 = new Pagamento (null, EstadoPagamento.QUITADO, TipoPagamento.DINHEIRO, null, Instant.now(), 0.0, 10, man1);
		man1.setPagamento(pag1);
		manutencaoRepository.save(man1);		
	}
}