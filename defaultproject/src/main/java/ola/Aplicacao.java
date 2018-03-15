package ola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aplicacao {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class);
	}

	@Bean
	public CommandLineRunner bootstrap(WordRepository repository) {
		return (args) -> {
			repository.save(new Word("hello", "oi", 1));
			System.out.println(repository.findByText("hello"));
		};
	}

}