package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        this.height = height;
        this.width = width;
        this.isWaterColor = isWaterColor;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height >= 0 && height <= 2000){
            this.height = height;
        }
        else{
            System.out.println("Height must be between 0 and 2000");
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width >= 0 && width <= 3000){
            this.width = width;
        }
        else {
            System.out.println("Width must be between 0 and 3000");
        }
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public void setWaterColor(boolean waterColor) {
        isWaterColor = waterColor;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
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

        int inputWidth = 0;
        boolean checkWidth = false;
        do {
            try{
                System.out.println("Enter width: ");
                inputWidth = Integer.parseInt(sc.nextLine());

                if(inputWidth < 0 ||  inputWidth > 3000){
                    throw new IllegalArgumentException("Error: width must be between 0 and 3000");
                }

                checkWidth = false;
            }catch(InputMismatchException e){
                System.out.println("Width must be an integer");
                checkWidth = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                checkWidth = true;
            }
        }while(checkWidth);
        this.width = inputWidth;

        boolean inputIsWaterColor = false;
        boolean checkIsWaterColor = false;
        do {
            try{
                System.out.println("Enter isWaterColor: ");
                inputIsWaterColor = sc.nextBoolean();

                checkIsWaterColor = false;
            }catch(InputMismatchException e){
                System.out.println("Enter isWaterColor must be true or false");
                checkIsWaterColor = true;

                sc.nextLine();
            }
        }while(checkIsWaterColor);
        this.isWaterColor = inputIsWaterColor;

        boolean inputIsFramed = false;
        boolean checkIsFramed = false;
        do {
            try{
                System.out.println("Enter isFramed: ");
                inputIsFramed = sc.nextBoolean();

                checkIsFramed = false;
            }catch(InputMismatchException e){
                System.out.println("Enter isFramed must be true or false");
                checkIsFramed = true;

                sc.nextLine();
            }
        }while(checkIsFramed);
        this.isFramed = inputIsFramed;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Height: %d, Width: %d, IsWaterColor: %b, IsFramed: %b",  height, width, isWaterColor, isFramed);
    }
}
