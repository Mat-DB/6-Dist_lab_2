package fti.uantwerpen.be.lab2.server;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
     * Get the balance of the account with the given name.
     *
     * @param name The name of the account to get the balance of.
     * @return A Double
     */
    @GetMapping("/account/{name}/get-balance") // /account/getBalance?name={name}
    @ResponseBody
    public double getBalance(@PathVariable String name) {
        BankAccount account = repository.findByNames(name).orElseThrow(() -> new BankAccountNotFoundException(name));
        return account.getBalance();
    }

    /**
     * If the account exists, add money to the account with the given name.
     *
     * @param name The name of the account to add money to.
     * @param amount The amount of money to add to the account.
     * @return A String
     */
    @PutMapping("/account/{name}/add-money/{amount}") // /account/addMoney?name={name}&amount={amount}
    @ResponseBody
    public String addMoney(@PathVariable String name, @PathVariable Double amount) {
        BankAccount account = repository.findByNames(name).orElseThrow(() -> new BankAccountNotFoundException(name));
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
    @PutMapping("/account/{name}/remove-money/{amount}") // /account/removeMoney?name={name}&amount={amount}
    @ResponseBody
    public String removeMoney(@PathVariable String name, @PathVariable Double amount) {
        BankAccount account = repository.findByNames(name).orElseThrow(() -> new BankAccountNotFoundException(name));
        account.setBalance(account.getBalance() - amount);
        repository.save(account);
        return "New balance is " + account.getBalance();
    }

}
