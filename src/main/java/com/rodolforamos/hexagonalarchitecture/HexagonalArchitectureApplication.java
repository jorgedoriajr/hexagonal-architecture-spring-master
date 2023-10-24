package com.rodolforamos.hexagonalarchitecture;

import com.rodolforamos.hexagonalarchitecture.adapters.persistence.BankAccountRepository;
import com.rodolforamos.hexagonalarchitecture.application.domain.BankAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class HexagonalArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureApplication.class, args);
    }

    @Bean
    public CommandLineRunner bootstrapData(BankAccountRepository repository) {

        //Paper: http://rdrblog.com.br/java/spring/arquitetura-hexagonal-com-spring-boot/

        return (args) -> {
            BigDecimal initialBalance = BigDecimal.valueOf(1000);
            BankAccount bankAccount1 = new BankAccount(0L, initialBalance);
            repository.save(bankAccount1);

            BigDecimal otherBalance = BigDecimal.valueOf(2000);
            BankAccount bankAccount2 = new BankAccount(1L, otherBalance);
            repository.save(bankAccount2);
        };
    }

}
