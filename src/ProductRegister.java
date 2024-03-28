import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ProductRegister {
    private final List<Product> products;

    public ProductRegister() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void sortProductsByPrice() {
        Collections.sort(products);
    }

    public List<Product> listProducts() {
        return products;
    }
}
