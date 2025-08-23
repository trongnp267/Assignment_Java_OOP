import java.io.IOException;
import java.util.Scanner;

public class Program {
    public final static String ADDPRODUCT = "1";
    public final static String RETRIEVEPRODUCTBYID = "2";
    public final static String UPDATEPRODUCTQUANTITY = "3";
    public final static String QUIT = "4";

    public static int getIDFromKeyBoard() {
        Scanner sc = new Scanner(System.in);

        int id = 0;
        boolean flag = true;

        do {
            try {
                id = Integer.parseInt(sc.nextLine());

                if (id < 1) {
                    throw new IllegalArgumentException();
                }

                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Id's input is invalid type");
            } catch (IllegalArgumentException e) {
                System.out.println("Id's input must be a positive integer");
            }
        } while (flag);

        return id;
    }

    public static String getNameFromKeyBoard() {
        Scanner sc = new Scanner(System.in);

        String name = "";
        boolean flag = true;

        do {
            try {
                name = sc.nextLine();

                if ("".equals(name)) {
                    throw new IllegalArgumentException();
                }

                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Name's input is not empty");
            }
        } while (flag);

        return name;
    }

    public static double getPriceFromKeyBoard() {
        Scanner sc = new Scanner(System.in);

        double price = 0;
        boolean flag = true;

        do {
            try {
                price = Double.parseDouble(sc.nextLine());

                if(price < 0) {
                    throw new IllegalArgumentException();
                }

                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Price's input is invalid type");
            } catch (IllegalArgumentException e) {
                System.out.println("Price's input must be non-negative");
            }
        } while (flag);

        return price;
    }

    public static int getQuantityFromKeyBoard() {
        Scanner sc = new Scanner(System.in);

        int quantity = 0;
        boolean flag = true;

        do {
            try {
                quantity = Integer.parseInt(sc.nextLine());

                if (quantity < 0) {
                    throw new IllegalArgumentException();
                }

                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("QuantityInStock's input is invalid type");
            } catch (IllegalArgumentException e) {
                System.out.println("QuantityInStock's input must be a positive integer");
            }
        } while (flag);

        return quantity;
    }

    public static Product getProductFromKeyBoard() {
        System.out.println("Enter product details:");

        System.out.println("Product ID:");
        int id =  getIDFromKeyBoard();

        System.out.println("Product Name:");
        String name = getNameFromKeyBoard();

        System.out.println("Product Price:");
        double price = getPriceFromKeyBoard();

        System.out.println("Product Quantity:");
        int quantity = getQuantityFromKeyBoard();

        return new Product(id, name, price, quantity);
    }

    public static void addProduct(ProductManagement pm) {
        Product product = getProductFromKeyBoard();

        try {
            pm.addProduct(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void retrieveProduct(ProductManagement pm) {
        System.out.println("Enter product ID to retrieve:");
        int id =  getIDFromKeyBoard();

        try {
            Product product = pm.getProductByID(id);

            product.displayProductInfo();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateProductQuantity(ProductManagement pm) {
        System.out.println("Enter product ID to update:");
        int id =  getIDFromKeyBoard();

        System.out.println("Enter new quantity:");
        int quantity = getQuantityFromKeyBoard();

        try {
            pm.updateProductQuantity(id, quantity);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();

        Scanner sc = new Scanner(System.in);
        String option = "";

        do {
            System.out.println("=== Product Management Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Retrieve Product by ID");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Exit");

            System.out.println("Select an option: ");
            option = sc.nextLine();

            switch (option) {
                case ADDPRODUCT:
                    addProduct(pm);
                    break;
                case RETRIEVEPRODUCTBYID:
                    retrieveProduct(pm);
                    break;
                case UPDATEPRODUCTQUANTITY:
                    updateProductQuantity(pm);
                    break;
            }
        }while(!QUIT.equals(option));
        System.out.println("Exiting the program...");
    }
}
