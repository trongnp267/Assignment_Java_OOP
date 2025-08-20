import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static final int ADD = 1;
    public static final int DISPLAY = 2;
    public static final int FIND = 3;
    public static final int QUIT = 0;

    public static final String ADDELECTRONICS = "1";
    public static final String ADDCLOTHING = "2";

    private Product[] products;
    private byte numOfProduct;
    private static final int MAX = 100;

    public Program() {
        products = new Product[MAX];
    }

    public void addProduct(Product product) {
        if(numOfProduct >= MAX) {
            System.out.println("Product's List is full!!!");
            return;
        }

        products[numOfProduct++] = product;

        System.out.println("Product added successfully.");
    }

    public void displayProducts() {
        for(int i = 0; i < numOfProduct; i++) {
            System.out.println("Product " + (i + 1) + ":");
            System.out.println(products[i]);
        }
    }

    public Optional<Product> findProduct(int id) {
        for(int i = 0; i < numOfProduct; i++) {
            if(products[i].id == id) {
                return Optional.of(products[i]);
            }
        }

        return Optional.empty();
    }

    public boolean isIdUnique(int id) {
        Optional<Product> product = findProduct(id);

        if(product.isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    public void addElectronics() {
        Product product = new Electronics();

        addProduct(product.createProduct(this));
    }

    public void addClothing() {
        Product product = new Clothing();

        addProduct(product.createProduct(this));
    }

    public static void main(String[] args) {
        Program p = new Program();

        Scanner sc = new Scanner(System.in);
        byte choice = -1;

        do {
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Find Product");
            System.out.println("0. Exit");

            try{

                System.out.println("Enter your choice: ");
                choice = Byte.parseByte(sc.nextLine());

                if(choice < 0 || choice > 3) {
                    throw new NumberFormatException();
                }

            }catch(NumberFormatException e){
                System.out.println("Type input is not correct!!!");
                choice = -1;
            }

            switch (choice) {
                case ADD:
                    System.out.println("1. Add Electronics Product");
                    System.out.println("2. Add Clothing Product");

                    System.out.println("Enter your type: ");
                    String type = sc.nextLine();

                    if(ADDELECTRONICS.equals(type)) {
                        p.addElectronics();
                    } else if (ADDCLOTHING.equals(type)) {
                        p.addClothing();
                    } else {
                        System.out.println("Type input is not correct!!!");
                    }

                    break;
                case DISPLAY:
                    p.displayProducts();
                    break;
                case FIND:

                    int id = Product.getIdFromKeyBoard();

                    if(p.findProduct(id).isPresent()) {
                        System.out.println(p.findProduct(id).get());
                    } else {
                        System.out.println("Product not found!!!");
                    }

                    break;
            }
        }while(choice != QUIT);
    }
}

