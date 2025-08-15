
import java.util.Optional;
import java.util.Scanner;

public class TrainingManagement {
    public static final String CREATING = "1";
    public static final String DISPLAYING = "2";
    public static final String FINDINGBYID = "3";
    public static final String FINDINGBYNAME = "4";
    public static final String UPDATINGBYID = "5";
    public static final String QUIT = "6";

    private TraineeForm traineeForm;
    private Scanner scanner;
    private Trainee[] listOfTrainees = new Trainee[100];
    private byte count = 0;

    public TrainingManagement() {
        traineeForm = new TraineeForm(new Scanner(System.in));
    }

    private void addTrainee(){
        String id = traineeForm.getId();
        Trainee trainee = traineeForm.getTrainee();

        boolean flag = true;

        if(!checkIdValid(id, this)){
            System.out.println("Trainee's id is invalid");
            flag = false;
        }

        if (!checkNameValid(trainee.getName())) {
            System.out.println("Input trainee's name is empty!!!");
            flag = false;
        }

        if (!checkGenderValid(trainee.getGender())) {
            System.out.println("Input trainee's gender is not male/female!!!");
            flag = false;
        }

        if (!checkAgeValid(trainee.getAge())) {
            System.out.println("Input trainee's age is less than 6!!!");
            flag = false;
        }

        if(flag){
            Trainee newTrainee = new Trainee(id, trainee.getName(),  trainee.getGender(), trainee.getAge());
            listOfTrainees[count++] = newTrainee;
            System.out.println("Add trainee success!!!");
        }
        else {
            System.out.println("Add trainee failed!!!");
        }

    }

    private void displayAllTrainees(){
        for(int i = 0; i < count; i++){
            System.out.println("Trainee number " + (i + 1) + ":");
            System.out.println("Id: " + listOfTrainees[i].getId());
            System.out.println("Name: " + listOfTrainees[i].getName());
            System.out.println("Gender: " + listOfTrainees[i].getGender());
            System.out.println("Age: " + listOfTrainees[i].getAge());
        }
    }

    private Optional<Trainee> findTraineeById(String id){
        for(int i = 0; i < count; i++){
            if(listOfTrainees[i].getId().equals(id)){
                return Optional.of(listOfTrainees[i]);
            }
        }
        return Optional.empty();
    }

    private Optional<Trainee[]> findTraineeByName(String name){
        Trainee[] list = new Trainee[count];
        int foundCount = 0;

        for(int i = 0; i < count; i++){
            if(listOfTrainees[i].getName().equals(name)){
                list[foundCount++] = listOfTrainees[i];
            }
        }

        if(foundCount == 0){
            return Optional.empty();
        }

        Trainee[] result = new Trainee[foundCount];
        for(int i = 0; i < foundCount; i++){
            result[i] = list[i];
        }

        return Optional.of(result);
    }

    private void updateTrainee(String id, Trainee newTrainee){
        Optional<Trainee> traineeUpdate = findTraineeById(id);

        if(traineeUpdate.isPresent()){
            if(checkNameValid(newTrainee.getName())) {
                traineeUpdate.get().setName(newTrainee.getName());
                System.out.println("Update trainee'name success!!!");
            }
            else {
                System.out.println("Input trainee's name is empty. Then trainee's name doesn't update");
            }

            if(checkGenderValid(newTrainee.getGender())) {
                traineeUpdate.get().setGender(newTrainee.getGender());
                System.out.println("Update trainee's gender success!!!");
            }
            else{
                System.out.println("Input trainee's gender is not male/female. Then trainee's gender doesn't update");
            }

            if(checkAgeValid(newTrainee.getAge())) {
                traineeUpdate.get().setAge(newTrainee.getAge());
                System.out.println("Update trainee's age success!!!");
            }
            else{
                System.out.println("Input trainee's age is less than 6. Then trainee's age doesn't update");
            }

        } else {
            System.out.println("Trainee not found!!!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrainingManagement trainingManagement = new TrainingManagement();
        String choice = "";
        do{
            System.out.println("1. Creating trainee");
            System.out.println("2. Displaying all trainees");
            System.out.println("3. Finding a trainee by Id");
            System.out.println("4. Finding trainees by Name");
            System.out.println("5. Updating a trainee by Id");
            System.out.println("6. Quit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice){
                case CREATING:

                    if (trainingManagement.count >= 100) {
                        System.out.println("List of trainees is full!!!");
                    } else {
                        trainingManagement.addTrainee();
                    }

                    break;
                case DISPLAYING:

                    trainingManagement.displayAllTrainees();

                    break;
                case FINDINGBYID:
                    String id = trainingManagement.traineeForm.getId();

                    if (!checkIdValid(id, trainingManagement)) {
                        System.out.println("Trainee's id is already exist!!!");
                    } else {
                        System.out.println("Trainee's id is not exist!!!");
                    }

                    break;
                case FINDINGBYNAME:
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();

                    if(checkNameValid(name)) {
                        Optional<Trainee[]> listFindName = trainingManagement.findTraineeByName(name);

                        if(listFindName.isPresent()){
                            System.out.println(listFindName.get().length + " trainee names have been found!!!");
                        }
                        else{
                            System.out.println("No trainee with this name exist!!!");
                        }
                    }
                    else{
                        System.out.println("Invalid name!!!");
                    }

                    break;
                case UPDATINGBYID:
                    String idUpdate = trainingManagement.traineeForm.getId();
                    Trainee updateTrainee = trainingManagement.traineeForm.getTrainee();

                    trainingManagement.updateTrainee(idUpdate, updateTrainee);

                    break;
            }
        }while(!choice.equals(QUIT));
    }

    public static boolean checkIdValid(String id, TrainingManagement trainingManagement){

        Optional<Trainee> check = trainingManagement.findTraineeById(id);
        if(check.isPresent() || id.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean checkNameValid(String name){
        if(!name.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean checkGenderValid(String gender){
        if("male".equals(gender) || "female".equals(gender)){
            return true;
        }
        return false;
    }

    public static boolean checkAgeValid(byte age){
        if(age >= 6){
            return true;
        }
        return false;
    }
}
