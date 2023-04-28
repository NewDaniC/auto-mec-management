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

import com.utfpr.mecanica.entities.Cidade;
import com.utfpr.mecanica.entities.Endereco;
import com.utfpr.mecanica.entities.Estado;
import com.utfpr.mecanica.entities.Pessoa;
import com.utfpr.mecanica.entities.User;
import com.utfpr.mecanica.repositories.CidadeRepository;
import com.utfpr.mecanica.repositories.EnderecoRepository;
import com.utfpr.mecanica.repositories.EstadoRepository;
import com.utfpr.mecanica.repositories.PessoaRepository;
import com.utfpr.mecanica.repositories.UserRepository;

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

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); /* Instancia objetos */
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(user1, user2)); /* Salva esses objetos no BD */
		
		Pessoa pes1 = new Pessoa(null, "85858585", "Maria", Instant.parse("2019-06-20T00:00:00Z"), "maria@gmail.com");
		Pessoa pes2 = new Pessoa(null, "54547474", "Rodrigo", Instant.parse("2002-07-21T00:00:00Z"), "rodrigo@gmail.com");
		pessoaRepository.saveAll(Arrays.asList(pes1, pes2));
		
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
		
		
	}
}