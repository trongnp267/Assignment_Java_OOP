package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Statue extends Item{
    private int weight;
    private String color;

    public Statue() {
    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight >= 0 && weight <= 1000){
            this.weight = weight;
        }
        else{
            System.out.println("Weight must be between 0 and 1000");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color.isEmpty()){
            System.out.println("Color cannot be empty");
        }
        else{
            this.color = color;
        }
    }

    @Override
    public void input(ItemList itemList) {
        Scanner sc = new Scanner(System.in);

        super.input(itemList);

        int inputWeight = 0;
        boolean checkWeight = false;
        do {
            try{
                System.out.println("Enter weight: ");
                inputWeight = Integer.parseInt(sc.nextLine());

                if(inputWeight < 0 ||  inputWeight > 1000){
                    throw new IllegalArgumentException("Error: height must be between 0 and 2000");
                }

                checkWeight = false;

            }catch(InputMismatchException e){
                System.out.println("Error: input value must be an integer");
                checkWeight = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                checkWeight = true;
            }
        }while(checkWeight);
        this.weight = inputWeight;

        String inputColor = "";
        boolean checkColor = false;
        do {
            System.out.println("Enter color: ");
            inputColor = sc.nextLine();

            checkColor = false;

            if(inputColor.isEmpty()){
                System.out.println("Color cannot be empty");
                checkColor = true;
            }

        }while(checkColor);
        this.color = inputColor;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Weight: %d, Color: %s", weight, color);
    }
}
