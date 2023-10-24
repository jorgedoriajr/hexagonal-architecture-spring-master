package com.rodolforamos.hexagonalarchitecture.adapters.configuration;

import com.rodolforamos.hexagonalarchitecture.HexagonalArchitectureApplication;
import com.rodolforamos.hexagonalarchitecture.adapters.persistence.BankAccountRepository;
import com.rodolforamos.hexagonalarchitecture.application.services.BankAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalArchitectureApplication.class)
public class BeanConfiguration {

    @Bean
    BankAccountService bankAccountService(BankAccountRepository repository) {
        return new BankAccountService(repository, repository);
    }
}
