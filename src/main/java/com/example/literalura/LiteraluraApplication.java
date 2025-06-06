package com.example.literalura;

import com.example.literalura.auxiliar.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	private final Menu menu;

	public LiteraluraApplication(Menu menu) {
		this.menu = menu;
	}

	@Override
	public void run(String... args) throws Exception {
		menu.exibeMenu();
	}
}
