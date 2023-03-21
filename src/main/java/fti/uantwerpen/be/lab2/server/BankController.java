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
    public BankController(BankAccountRepository repository) {
        this.repository = repository;
    }

    /**
     * This function returns a weclome string when the user goes to the /bank
     * endpoint
     *
     * @return A string
     */
    @GetMapping("/bank")
    public String welcome() {
        return "Welcome to this amazing test bank!!";
    }

    /**
     * Get the balance of the account with the given name.
     *
     * @param name The name of the account to get the balance of.
     * @return A Double
     */
    @GetMapping("/account/getBalance") // /account/getBalance?name={name}
    public double getBalance(@RequestParam String name) {
        BankAccount account = repository.findByName(name).orElseThrow(() -> new BankAccountNotFoundException(name));
        return account.getBalance();
    }

    /**
     * If the account exists, add the amount to the balance and save the account.
     *
     * @param info a map of the request parameters
     * @return A string
     */
    @PutMapping("/account/addMoney") // /account/addMoney?name={name}&amount={amount}
    public String addMoney(@RequestParam Map<String, String> info) {
        String name = info.get("name");
        double amount = Double.parseDouble(info.get("amount"));
        BankAccount account = repository.findByName(name).orElseThrow(() -> new BankAccountNotFoundException(name));
        account.setBalance(account.getBalance() + amount);
        repository.save(account);
        return "New balance is " + account.getBalance();
    }

    /**
     * If the account exists, remove the amount from the balance and save the account.
     *
     * @param info This is the name of the parameter that will be passed in.
     * @return A string
     */
    @PutMapping("/account/removeMoney") // /account/removeMoney?name={name}&amount={amount}
    public String removeMoney(@RequestParam Map<String, String> info) {
        String name = info.get("name");
        double amount = Double.parseDouble(info.get("amount"));
        BankAccount account = repository.findByName(name).orElseThrow(() -> new BankAccountNotFoundException(name));
        account.setBalance(account.getBalance() - amount);
        repository.save(account);
        return "New balance is " + account.getBalance();
    }

}
