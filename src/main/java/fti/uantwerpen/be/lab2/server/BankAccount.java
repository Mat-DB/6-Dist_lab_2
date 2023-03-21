package fti.uantwerpen.be.lab2.server;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
public class BankAccount {

    private @Id @GeneratedValue Long id;
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof BankAccount))
            return false;
        BankAccount bankAccount = (BankAccount) o;
        return Objects.equals(this.id, bankAccount.id) && Objects.equals(this.name, bankAccount.name)
                && Objects.equals(this.balance, bankAccount.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.balance);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + this.id + ", name='" + this.name + '\'' + ", balance='" + this.balance + '\'' + '}';
    }

}
