import java.util.Map;
import java.util.Random;

public class Server {
    private final Storage storage = new Storage();

    public Map<ProductType, Integer> getProducts() {
        return storage.getProducts();
    }

    public void tryToBuy(ProductType productType, Integer count) throws BusinessLogicException {
        imitateAnotherClientWork();
        checkForCount(productType, count);
        storage.change(productType, count);
    }

    private void checkForCount(ProductType productType, Integer count) throws BusinessLogicException {
        if (storage.getProducts().get(productType) < count) {
            throw new BusinessLogicException("Недостаточно элементов");
        }
    }

    private void imitateAnotherClientWork() {
        Random random = new Random();
        if (random.nextInt(4) == 0) {
            Map<ProductType, Integer> products = storage.getProducts();
            for (ProductType productType : ProductType.values()) {
                storage.change(productType, random.nextInt(products.get(productType)));
            }

        }
    }
}
