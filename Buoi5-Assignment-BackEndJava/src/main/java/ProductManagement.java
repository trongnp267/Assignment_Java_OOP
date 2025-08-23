import java.util.Optional;

public class ProductManagement {
    private Product[] products = new Product[10];
    private int productCount = 0;

    public void addProduct(Product product) throws IllegalArgumentException {
        if(productCount >= 10){
            throw new IllegalArgumentException("Number of products exceed 10");
        }

        if(findProductByID(product.getProductID()).isPresent()) {
            throw new IllegalArgumentException("Product ID is not unique");
        }

        products[productCount++] = product;

        System.out.println("Product added successfully.");
    }

    public Product getProductByID(int productID) throws ProductNotFoundException {
        Optional<Product> product = findProductByID(productID);

        if(product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException {
        Optional<Product> product = findProductByID(productID);

        if(product.isPresent()) {
            product.get().setQuantityInStock(newQuantity);
        } else {
            throw new ProductNotFoundException("Product not found");
        }

        System.out.println("Quantity updated successfully.");
    }

    public Optional<Product> findProductByID(int productID) {
        for(int i = 0; i < productCount; i++){
            if(products[i].getProductID() == productID){
                return  Optional.of(products[i]);
            }
        }

        return Optional.empty();
    }
}
