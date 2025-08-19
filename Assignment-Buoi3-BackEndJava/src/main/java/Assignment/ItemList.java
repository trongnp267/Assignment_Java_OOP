package Assignment;

public class ItemList {
    public static final String VASE = "1";
    public static final String STATUE = "2";
    public static final String PAINTING = "3";

    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;

    public ItemList(){
        list = new Item[MAX];
    }

    public boolean addItem(Item item){
        if(item == null || numOfItem >= MAX){
            return false;
        }

        list[numOfItem++] = item;

        return true;
    }

    public void displayAll(){
        for(int i=0;i<numOfItem;i++){
            System.out.println("Item number "+(i+1)+" : ");
            System.out.println(list[i]);
        }
    }

    public Item findItem(String creator){
        for(int i=0;i<numOfItem;i++){
            if(creator.equals(list[i].getCreator())){
                return list[i];
            }
        }
        return null;
    }


    public void displayItemsByType(String type){
        if(type.equals(VASE)){
            for(int i=0;i<numOfItem;i++){
                if(list[i] instanceof Vase){
                    System.out.println("Vase number "+(i+1)+" : ");
                    System.out.println(list[i]);
                }
            }
        }
        else if(type.equals(STATUE)){
            for(int i=0;i<numOfItem;i++){
                if(list[i] instanceof Statue){
                    System.out.println("Statue number "+(i+1)+" : ");
                    System.out.println(list[i]);
                }
            }
        }
        else{
            for(int i=0;i<numOfItem;i++){
                if(list[i] instanceof Painting){
                    System.out.println("Painting number "+(i+1)+" : ");
                    System.out.println(list[i]);
                }
            }
        }
    }

    public boolean findItemById(String id){
        for(int i=0;i<numOfItem;i++){
            if(list[i].getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
