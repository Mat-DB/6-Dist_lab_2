package fti.uantwerpen.be.lab2.server;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    Optional<BankAccount> findByNames(String name);
}

