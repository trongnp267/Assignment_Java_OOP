package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Item {
    protected String id;
    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(String id, int value, String creator) {
        this.id = id;
        this.value = value;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isEmpty()) {
            System.out.println("id is null");
        }
        else{
            this.id = id;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value < 0) {
            System.out.println("value is negative");
        }
        else{
            this.value = value;
        }
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if(creator.isEmpty()){
            System.out.println("creator is empty");
        }
        else {
            this.creator = creator;
        }
    }

    public void input(ItemList itemList){
        Scanner sc = new Scanner(System.in);

        String inputId = "";
        boolean checkId = false;
        do {
            System.out.println("Enter ID: ");
            inputId = sc.nextLine();

            checkId = false;

            if(inputId.isEmpty()){
                checkId = true;
                System.out.println("input ID is empty");
            }

            if(itemList.findItemById(inputId)){
                checkId = true;
                System.out.println("ID already exists");
            }

        }while(checkId);
        this.id = inputId;

        int inputValue = 0;
        boolean checkValue = false;
        do {
            try{
                System.out.println("Enter Value: ");
                inputValue = Integer.parseInt(sc.nextLine());

                if(inputValue < 0){
                    throw new IllegalArgumentException("Error: input value > 0");
                }

                checkValue = false;
            }catch(InputMismatchException e) {
                System.out.println("Error: input value must be an integer");
                checkValue = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                checkValue = true;
            }
        }while(checkValue);
        this.value = inputValue;

        String inputCreator = "";
        boolean checkCreator = false;
        do {
            System.out.println("Enter Creator: ");
            inputCreator = sc.nextLine();

            checkCreator = false;

            if(inputCreator.isEmpty()){
                System.out.println("input Creator is empty");
                checkCreator = true;
            }

        }while(checkCreator);
        this.creator = inputCreator;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
    }
}
