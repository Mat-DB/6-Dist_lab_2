package fti.uantwerpen.be.lab2.server;

import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {
    private final BankAccountRepository repository;

    BankController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/bank")
    public String welcome() {
        return "Welcome to this amazing test bank!!";
    }

    @GetMapping("/account/getBalance")
    BankAccount one(@RequestParam Long id) {
        return repository.findById(id).orElseThrow(() -> new BankAccountNotFoundException(id));
    }

    @PostMapping("/account/new")
    BankAccount newBankAccount(@RequestBody BankAccount newBankAccount) {
        return repository.save(newBankAccount);
    }

}
