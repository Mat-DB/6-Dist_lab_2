package fti.uantwerpen.be.lab2.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
class LoadBankDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadBankDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BankAccountRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new BankAccount("Jan", 50)));
            log.info("Preloading " + repository.save(new BankAccount("Mike", 50)));
            log.info("Preloading " + repository.save(new BankAccount("Lukas", 50)));
            log.info("Preloading " + repository.save(new BankAccount(Arrays.asList("Matthias", "Ibe"), 100)));
        };
    }
}
