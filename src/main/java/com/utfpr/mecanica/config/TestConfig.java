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

import com.utfpr.mecanica.entities.Pessoa;
import com.utfpr.mecanica.entities.User;
import com.utfpr.mecanica.repositories.PessoaRepository;
import com.utfpr.mecanica.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {

		/* Instancia objetos */
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		/* Salva esses objetos no BD */
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Pessoa p1 = new Pessoa(null, "85858585", "Maria", Instant.parse("2019-06-20T19:53:07Z"), "maria@gmail.com");
		Pessoa p2 = new Pessoa(null, "54547474", "Rodrigo", Instant.parse("2019-07-21T03:42:10Z"), "rodrigo@gmail.com");
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
	}
}