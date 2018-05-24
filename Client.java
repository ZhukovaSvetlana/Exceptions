import java.util.Map;
import java.util.Scanner;

public class Client {
    private final Scanner in = new Scanner(System.in);
    private final Server server;
    private Map<ProductType, Integer> products;

    public Client(Server server) {
        this.server = server;
    }

    public void start() {
        while (true) {
            refreshProducts();
            showMenu();
            switch (in.nextInt()) {
                case 1: {
                    for (ProductType productType : ProductType.values()) {
                        System.out.println(String.format("%d: %s %d", productType.ordinal(), productType.getName(), products.get(productType)));
                    }
                    System.out.print("Введите номер товара: ");
                    int productOrdinal = in.nextInt();
                    System.out.println(("Сколько товара вы хотите приобрести?"));
                    int count = in.nextInt();
                }
                break;

                case 2: {
                    try {
                        int count = 1;
                        ProductType productType = ProductType.BOOTS;

                        if (products.get(productType) > count)
                            server.tryToBuy(productType, count);
                        // ToDo: else
                            //
                    } catch (BusinessLogicException e) {
                        System.out.println(e.getMessage());
                    }
                }

                default:
                    return;
            }
        }
    }

    private void refreshProducts() {
        products = server.getProducts();
    }


    private void showMenu() {
        System.out.println(("1. Купить"));
        System.out.println(("2. Выйти"));
        System.out.print(">");
    }


}
