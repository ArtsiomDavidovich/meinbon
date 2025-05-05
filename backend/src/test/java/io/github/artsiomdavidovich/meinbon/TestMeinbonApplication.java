package io.github.artsiomdavidovich.meinbon;

import org.springframework.boot.SpringApplication;

public class TestMeinbonApplication {

	public static void main(String[] args) {
		SpringApplication.from(MeinbonApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
