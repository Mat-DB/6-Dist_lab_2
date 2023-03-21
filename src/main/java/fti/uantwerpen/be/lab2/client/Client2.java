package fti.uantwerpen.be.lab2.client;

import org.springframework.web.client.RestTemplate;

public class Client2 implements Runnable {
    private static final String base_url = "http://localhost:8080/";
    private final String name;
    private final RestTemplate restTemplate;
    private final String accountType;

    public Client2(String name, String accountType) {
        this.name = name;
        this.restTemplate = new RestTemplate();
        this.accountType = accountType;
    }

    @Override
    public void run() {
        for (int i=0; i<5; i++){
            System.out.println("Balance for " + this.name + " is " + getBalance());
            addMoney(10);
            System.out.println("Balance for " + this.name + " is " + getBalance());
            addMoney(20);
            System.out.println("Balance for " + this.name + " is " + getBalance());
            removeMoney(20);
            System.out.println("Balance for " + this.name + " is " + getBalance());
        }
    }

    public double getBalance() {
        try {
            return restTemplate.getForObject(base_url + "account/" + this.name + "/account-type/" + this.accountType + "/balance", double.class, this.name);
        } catch (Exception e) {
            System.out.println("Error while getting balance of " + this.name + "and account type " + this.accountType);
            e.printStackTrace();
            return 0;
        }
    }

    public void addMoney(double amount) {
        try {
            restTemplate.put(base_url + "account/" + this.name + "/account-type/" + this.accountType + "/add-money/" + amount, null);
            System.out.println("Added " + amount + " to account of " + this.name);
        } catch (Exception e) {
            System.out.println("Error while adding money to " + this.name);
            e.printStackTrace();
        }
    }

    public void removeMoney(double amount) {
        try {
            restTemplate.put(base_url + "account/" + this.name + "/account-type/" + this.accountType + "/remove-money/" + amount, null);
            System.out.println("Removed " + amount + " from account of " + this.name);
        } catch (Exception e) {
            System.out.println("Error while removing money from " + this.name);
            e.printStackTrace();
        }

    }
}
