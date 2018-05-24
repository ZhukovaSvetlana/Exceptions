import java.util.*;

public class Main {
    private static final Server server = new Server();

    public static void main(String[] args) {
        new Client(server).start();
    }



}