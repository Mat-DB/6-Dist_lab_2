package fti.uantwerpen.be.lab2.server;

import org.springframework.web.bind.annotation.*;

/**
 * > The BankController class is a Spring Boot controller that exposes a REST API for the BankAccountRepository class.
 */
@RestController
public class BankController {
    // This is a private variable that is used to store the BankAccountRepository object.
    private final BankAccountRepository repository;

    // This is a constructor. It is called when a new BankController object is created.
    BankController(BankAccountRepository repository) {
        this.repository = repository;
    }

    /**
     * This function returns a weclome string when the user goes to the /bank
     * endpoint
     *
     * @return A string
     */
    @GetMapping("/bank")
    @ResponseBody
    public String welcome() {
        return "Welcome to this amazing test bank!!";
    }

    /**
     * Get the balance of the account with the given name and type.
     * When the type is not specified the assumption wil be made that the account is from the type single.
     *
     * @param name The name of the account to get the balance of.
     * @return A Double
     */
    @GetMapping("/account/{name}/account-type/{accountType}/get-balance")
    @ResponseBody
    public double getBalance(@PathVariable String name, @PathVariable BankAccount.AccountType accountType) {
        BankAccount account = repository.findByNamesAndType(name, accountType).orElseThrow(() -> new BankAccountNotFoundException(name, accountType));
        return account.getBalance();
    }

    /**
     * If the account exists, add money to the account with the given name.
     *
     * @param name The name of the account to add money to.
     * @param amount The amount of money to add to the account.
     * @return A String
     */
    @PutMapping("/account/{name}/account-type/{accountType}/add-money/{amount}")
    @ResponseBody
    public String addMoney(@PathVariable String name, @PathVariable Double amount, @PathVariable BankAccount.AccountType accountType) {
        BankAccount account = repository.findByNamesAndType(name, accountType).orElseThrow(() -> new BankAccountNotFoundException(name, accountType));
        account.setBalance(account.getBalance() + amount);
        repository.save(account);
        return "New balance is " + account.getBalance();
    }

    /**
     * If the account exists, remove money from the account with the given name.
     *
     * @param name The name of the account to remove money from.
     * @param amount The amount of money to remove from the account.
     * @return A String
     */
    @PutMapping("/account/{name}/account-type/{accountType}/remove-money/{amount}")
    @ResponseBody
    public String removeMoney(@PathVariable String name, @PathVariable Double amount, @PathVariable BankAccount.AccountType accountType) {
        BankAccount account = repository.findByNamesAndType(name, accountType).orElseThrow(() -> new BankAccountNotFoundException(name, accountType));
        account.setBalance(account.getBalance() - amount);
        repository.save(account);
        return "New balance is " + account.getBalance();
    }
}
