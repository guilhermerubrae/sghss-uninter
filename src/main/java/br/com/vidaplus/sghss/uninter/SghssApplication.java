package br.com.vidaplus.sghss.uninter;

/*
 * classe principal do projeto sghss
 * inicializa a aplicação spring boot com todos os módulos configurados
 * author: guilherme abreu
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // marca a classe como aplicação spring boot
public class SghssApplication {

    public static void main(String[] args) {
        SpringApplication.run(SghssApplication.class, args); // inicializa o contexto da aplicação
    }
}
