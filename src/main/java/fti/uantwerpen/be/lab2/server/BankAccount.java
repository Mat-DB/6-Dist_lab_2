package fti.uantwerpen.be.lab2.server;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
public class BankAccount {
    enum AccountType {shared, single}

    private @Id @GeneratedValue Long id;
    @ElementCollection
    private List<String> names = new ArrayList<>();
    private double balance;
    private AccountType type;

    BankAccount(String name, double balance) {
        this.names.add(name);
        this.balance = balance;
        this.type = AccountType.single;
    }

    BankAccount(List<String> names, double balance) {
        this.names.addAll(names);
        this.balance = balance;
        this.type = AccountType.shared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BankAccount))
            return false;
        BankAccount bankAccount = (BankAccount) o;
        return Objects.equals(this.id, bankAccount.id) && Objects.equals(this.names, bankAccount.names)
                && Objects.equals(this.balance, bankAccount.balance) && Objects.equals(this.type, bankAccount.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.names, this.balance, this.type);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + this.id + ", name='" + this.names + '\'' + ", balance='" + this.balance + '\'' + "account type='" + this.type + '}';
    }

}
