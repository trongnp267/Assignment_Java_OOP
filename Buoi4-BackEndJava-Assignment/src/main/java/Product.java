import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Product {
    protected int id;
    protected String name;
    protected float price;

    public Product() {

    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static int getIdFromKeyBoard(){
        Scanner sc = new Scanner(System.in);

        int inputId = 0;
        boolean flag = false;

        do {
            try{
                System.out.println("Enter product ID:");
                inputId = Integer.parseInt(sc.nextLine());

                if(inputId <= 0){
                    throw new NumberFormatException();
                }

                flag = false;
            }catch(NumberFormatException e){
                System.out.println("Id must be a positive integer number.");
                flag = true;
            }
        }while(flag);

        return inputId;
    }

    public static String getNameFromKeyBoard(){
        Scanner sc = new Scanner(System.in);

        String inputName = "";
        boolean flag = false;

        do {
            try{
                System.out.println("Enter product name:");
                inputName = sc.nextLine();

                if(inputName.isEmpty()){
                    throw new IllegalArgumentException();
                }

                flag = false;
            }catch(IllegalArgumentException e){
                System.out.println("Name must not be empty.");
                flag = true;
            }
        }while(flag);

        return inputName;
    }

    public static float getPriceFromKeyBoard(){
        Scanner sc = new Scanner(System.in);

        float inputPrice = 0;
        boolean flag = false;

        do{
            try{
                System.out.println("Enter product price:");
                inputPrice = Float.parseFloat(sc.nextLine());

                if(inputPrice <= 0){
                    throw new NumberFormatException();
                }

                flag = false;
            }catch(NumberFormatException e){
                System.out.println("Price must be a positive float number.");
                flag = true;
            }
        }while(flag);

        return inputPrice;
    }

    public Product createProduct(Program p){
        int idProduct = 0;
        while(true){
            idProduct =  getIdFromKeyBoard();

            if(p.isIdUnique(idProduct)){
                break;
            }

            System.out.println("Id must be unique.");
        }

        String nameProduct = getNameFromKeyBoard();

        float priceProduct = getPriceFromKeyBoard();

        return createSpecificProduct(idProduct, nameProduct, priceProduct);
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Price: " + String.format("%.2f", price);
    }

    public abstract Product createSpecificProduct(int id, String name, float price);
}
