package fti.uantwerpen.be.lab2.server;

import org.springframework.data.jpa.repository.JpaRepository;

interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}

