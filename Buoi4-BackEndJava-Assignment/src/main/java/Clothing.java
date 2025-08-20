import java.util.Scanner;

public class Clothing extends Product {
    private String size;

    public Clothing() {
    }

    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public String getSizeFromKeyBoard() {
        Scanner sc = new Scanner(System.in);

        String inputSize = "";
        boolean flag = false;

        do {
            try{
                System.out.println("Enter product size:");
                inputSize = sc.nextLine();

                if(inputSize.isEmpty()){
                    throw new IllegalArgumentException();
                }

                flag = false;
            }catch(IllegalArgumentException e){
                System.out.println("Size must not be empty.");
                flag = true;
            }
        }while(flag);

        return inputSize;
    }

    @Override
    public Product createSpecificProduct(int id, String name, float price) {
        String sizeProduct = getSizeFromKeyBoard();
        return new Clothing (id, name, price, sizeProduct);
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + this.size;
    }
}
