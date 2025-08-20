import java.util.Scanner;

public class TraineeForm {
    private Scanner scanner;

    public TraineeForm(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getId(){

        System.out.println("Trainee's id: ");
        String id = scanner.nextLine();

        return id;
    }

    public Trainee getTrainee(){

        System.out.println("Trainee's name: ");
        String name = scanner.nextLine();

        System.out.println("Trainee's gender: ");
        String gender = scanner.nextLine();

        byte age = 0;
        boolean checkAge = false;
        do{
            try{
                System.out.println("Trainee's age: ");
                age = Byte.parseByte(scanner.nextLine());
                checkAge = false;
            }catch(Exception e){
                System.out.println("Age must be a number");
                checkAge = true;
            }
        }while(checkAge);

        return new Trainee(name, gender, age);
    }
}
