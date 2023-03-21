package fti.uantwerpen.be.lab2.server;

public class BankAccountNotFoundException extends RuntimeException {
    BankAccountNotFoundException(String name) {
        super("Could not find bank account with name " + name);
    }

    BankAccountNotFoundException(Long id) {
        super("Could not find bank account with id " + id);
    }
}
