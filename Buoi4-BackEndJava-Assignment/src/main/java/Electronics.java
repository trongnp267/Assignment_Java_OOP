import java.util.Scanner;

public class Electronics extends Product{
    private String brand;

    public Electronics() {

    }

    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrandFromKeyBoard(){
        Scanner sc = new Scanner(System.in);

        String inputBrand = "";
        boolean flag = false;

        do {
            try{
                System.out.println("Enter product brand:");
                inputBrand = sc.nextLine();

                if(inputBrand.isEmpty()){
                    throw new IllegalArgumentException();
                }

                flag = false;
            }catch(IllegalArgumentException e){
                System.out.println("Brand must not be empty.");
                flag = true;
            }
        }while(flag);

        return inputBrand;
    }

    @Override
    public Product createSpecificProduct(int id, String name, float price) {
        String brandProduct =  getBrandFromKeyBoard();

        return new Electronics(id, name, price, brandProduct);
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + this.brand;
    }
}
