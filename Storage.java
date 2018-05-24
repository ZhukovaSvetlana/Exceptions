import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<ProductType, Integer> products = new HashMap<>();

    Storage() {
        products.put(ProductType.SWEATER, 10);
        products.put(ProductType.BOOTS, 15);
        products.put(ProductType.SCARF, 10);
        products.put(ProductType.JEANS, 15);
    }

    public Map<ProductType, Integer> getProducts() {
        return new HashMap<>(products);
    }

    public void change(ProductType productType, Integer count) {
        products.put(productType, count);
    }
}
