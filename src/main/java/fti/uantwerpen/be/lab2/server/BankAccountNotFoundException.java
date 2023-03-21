package fti.uantwerpen.be.lab2.server;

public class BankAccountNotFoundException extends RuntimeException {
    BankAccountNotFoundException(String name, BankAccount.AccountType accountType) {
        super("Could not find bank account with name " + name + " and account type " + accountType);
    }

    BankAccountNotFoundException(Long id) {
        super("Could not find bank account with id " + id);
    }
}
