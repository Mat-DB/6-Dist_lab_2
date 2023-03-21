package fti.uantwerpen.be.lab2.server;

public class BankAccountNotFoundException extends RuntimeException {
    BankAccountNotFoundException(Long id) {
        super("Could not find bank account " + id);
    }
}
