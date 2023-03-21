package fti.uantwerpen.be.lab2.client;

public class ClientMain {
    public static void main(String[] args) {
        Client client0 = new Client("Femke", "single");
        Client client1 = new Client("Daan", "shared");
        Client client2 = new Client("Lars", "shared");

        Thread threadClient0 = new Thread(client0);
        Thread threadClient1 = new Thread(client1);
        Thread threadClient2 = new Thread(client2);

        System.out.println("Starting the clients!");
        threadClient0.start();
        threadClient1.start();
        threadClient2.start();

        System.out.println("Waiting until all 3 done.");
        try {
            threadClient0.join();
            threadClient1.join();
            threadClient2.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e);
            e.printStackTrace();
        }
        System.out.println("All 3 done.");
    }
}
