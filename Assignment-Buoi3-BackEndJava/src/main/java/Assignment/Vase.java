package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vase extends Item{
    private int height;
    private String material;

    public Vase() {

    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height >= 0 && height <= 20000) {
            this.height = height;
        }
        else{
            System.out.println("Height must be between 0 and 20000");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if(material.isEmpty()){
            System.out.println("Material cannot be empty");
        }
        else{
            this.material = material;
        }
    }

    @Override
    public void input(ItemList itemList) {
        Scanner sc = new Scanner(System.in);

        super.input(itemList);

        int inputHeight = 0;
        boolean checkHeight = false;
        do {
            try{
                System.out.println("Enter height: ");
                inputHeight = Integer.parseInt(sc.nextLine());

                if(inputHeight < 0 ||  inputHeight > 2000){
                    throw new IllegalArgumentException("Error: height must be between 0 and 2000");
                }

                checkHeight = false;

            }catch(InputMismatchException e){
                System.out.println("Error: input value must be an integer");
                checkHeight = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                checkHeight = true;
            }
        }while(checkHeight);
        this.height = inputHeight;

        String inputMaterial = "";
        boolean checkMaterial = false;
        do {
            System.out.println("Enter material: ");
            inputMaterial = sc.nextLine();

            checkMaterial = false;

            if(inputMaterial.isEmpty()){
                System.out.println("Material cannot be empty");
                checkMaterial = true;
            }

        }while(checkMaterial);
        this.material = inputMaterial;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Height: %d, Material: %s", height, material);
    }
}
