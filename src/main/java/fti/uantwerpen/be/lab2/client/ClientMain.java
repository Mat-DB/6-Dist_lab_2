package fti.uantwerpen.be.lab2.client;

public class ClientMain {
    public static void main(String[] args) {
        Client client1 = new Client("Femke", "single");

        Thread threadClient1 = new Thread(client1);

        threadClient1.start();
    }
}
