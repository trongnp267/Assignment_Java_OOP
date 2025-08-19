package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AntiqueShop {
    public static final int ADDNEWVASE = 1;
    public static final int ADDNEWSTATUE = 2;
    public static final int ADDNEWPAINTING = 3;
    public static final int DISPLAYALLITEMS = 4;
    public static final int FINDITEMSBYCREATOR = 5;
    public static final int DISPLAYLISTBYITEMS = 6;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ItemList itemList = new ItemList();

        byte choice = 0;

        do{
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator");
            System.out.println("6. Display the list by items");
            System.out.println("7. Quit");

            try{
                System.out.println("Enter your choice: ");
                choice = Byte.parseByte(sc.nextLine());
            }catch(Exception e){
                System.out.println("Please enter a valid choice!!!");
            }

            switch(choice){
                case ADDNEWVASE:
                    Item newVase = new Vase();
                    newVase.input(itemList);

                    if(itemList.addItem(newVase)){
                        System.out.println("New Vase has been added successfully.");
                    }
                    else{
                        System.out.println("New Vase added failed.");
                    }

                    break;
                case ADDNEWSTATUE:
                    Item newStatue = new Statue();
                    newStatue.input(itemList);

                    if(itemList.addItem(newStatue)){
                        System.out.println("New Statue has been added successfully.");
                    }
                    else{
                        System.out.println("New Statue added failed.");
                    }

                    break;
                case ADDNEWPAINTING:
                    Item newPainting = new Painting();
                    newPainting.input(itemList);

                    if(itemList.addItem(newPainting)){
                        System.out.println("New Painting has been added successfully.");
                    }
                    else{
                        System.out.println("New Painting added failed.");
                    }

                    break;
                case DISPLAYALLITEMS:
                    itemList.displayAll();
                    break;
                case FINDITEMSBYCREATOR:
                    System.out.println("Enter your's creator: ");
                    String creator = sc.nextLine();

                    Item findItem = itemList.findItem(creator);

                    if(findItem == null){
                        System.out.println("No item with the name " + creator + " exists");
                    } else {
                        System.out.println(findItem);
                    }

                    break;
                case DISPLAYLISTBYITEMS:
                    System.out.println("Choose item type to display:");
                    System.out.println("1. Vase");
                    System.out.println("2. Statue");
                    System.out.println("3. Painting");

                    System.out.print("Enter your choice: ");
                    String type = sc.nextLine();

                    itemList.displayItemsByType(type);
                    break;
            }

        }while(choice <= 6);
    }
}
