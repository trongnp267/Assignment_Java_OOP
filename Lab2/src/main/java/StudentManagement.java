import java.util.Scanner;

public class StudentManagement {
    public static final String CREATE = "1";
    public static final String DISPLAY = "2";
    public static final String FINDBYID = "3";
    public static final String UPDATEBYID = "4";
    public static final String QUIT = "5";
    public static Student[] listStudents = new Student[100];
    public static int count = 0;

    public static Student findAStudentByID(int id)
    {
        for(int i = 0; i < count; i++){
            if(listStudents[i].id == id){
                return listStudents[i];
            }
        }
        return null;
    }

    public static void createStudent(Student student){
        Scanner sc = new Scanner(System.in);

        boolean checkId = false;
        do{
            System.out.println("Enter student ID: ");
            student.id = Integer.parseInt(sc.nextLine());
            checkId = false;
            if(findAStudentByID(student.id) != null){
                System.out.println("Student is already in use!!!");
                checkId = true;
            }
        }while(checkId);


        boolean checkName = false;
        do{
            System.out.println("Enter student name: ");
            student.name = sc.nextLine();
            checkName = false;
            if(student.name.isEmpty()){
                System.out.println("Student name is empty!!!");
                checkName = true;
            }
        }while(checkName);

        boolean checkAge = false;
        do{
            System.out.println("Enter student age: ");
            student.age = Integer.parseInt(sc.nextLine());
            checkAge = false;
            if(student.age < 18){
                System.out.println("Student age is less than 18!!!");
                checkAge = true;
            }
        }while(checkAge);

        System.out.println("Enter student address: ");
        student.address = sc.nextLine();

        boolean checkGender = false;
        do{
            System.out.println("Enter student gender: ");
            student.gender = sc.nextLine();
            checkGender = false;
            if(!student.gender.equals("male") &&  !student.gender.equals("female")){
                System.out.println("Student gender is not male/female!!!");
                checkGender = true;
            }
        }while(checkGender);

        System.out.println("Enter student email: ");
        student.email = sc.nextLine();
    }

    public static void displayAll(){
        for(int i = 0; i < count; i++){
            System.out.println("Student number " + (i + 1) + ": ");
            System.out.println("Student ID: " + listStudents[i].id);
            System.out.println("Student name: " + listStudents[i].name);
            System.out.println("Student age: " + listStudents[i].age);
            System.out.println("Student address: " + listStudents[i].address);
            System.out.println("Student gender: " + listStudents[i].gender);
            System.out.println("Student email: " + listStudents[i].email);
        }
    }

    public static void updateStudentById(Student student){
        Scanner sc = new Scanner(System.in);

        boolean checkName = false;
        do{
            System.out.println("Update student name: ");
            student.name = sc.nextLine();
            checkName = false;
            if(student.name.isEmpty()){
                System.out.println("Student name is empty!!!");
                checkName = true;
            }
        }while(checkName);

        boolean checkAge = false;
        do{
            System.out.println("Update student age: ");
            student.age = Integer.parseInt(sc.nextLine());
            checkAge = false;
            if(student.age < 18){
                System.out.println("Student age is less than 18!!!");
                checkAge = true;
            }
        }while(checkAge);

        System.out.println("Update student address: ");
        student.address = sc.nextLine();

        boolean checkGender = false;
        do{
            System.out.println("Update student gender: ");
            student.gender = sc.nextLine();
            checkGender = false;
            if(!student.gender.equals("male") &&  !student.gender.equals("female")){
                System.out.println("Student gender is not male/female!!!");
                checkGender = true;
            }
        }while(checkGender);

        System.out.println("Update student email: ");
        student.email = sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String choice = "";
        do{
            System.out.println("1. Create a student");
            System.out.println("2. Display all");
            System.out.println("3. Find a student by id");
            System.out.println("4. Update a student by id");
            System.out.println("5. Quit");
            System.out.println("Enter your choice: ");
            choice = sc.nextLine();
            switch (choice){
                case CREATE:
                    if(count >= 100){
                        System.out.println("List of students is full!!!");
                    }
                    else{
                        Student student = new Student();

                        createStudent(student);

                        listStudents[count++] = student;
                    }
                    break;
                case DISPLAY:
                    displayAll();
                    break;
                case FINDBYID:
                    System.out.println("Enter student ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Student studentFind = findAStudentByID(id);
                    if(studentFind != null){
                        System.out.println("Student is already exists!!!");
                    }
                    else{
                        System.out.println("Student not found!!!");
                    }
                    break;
                case UPDATEBYID:
                    System.out.println("Enter student ID: ");
                    int  idUpdate = Integer.parseInt(sc.nextLine());
                    Student studentUpdate = findAStudentByID(idUpdate);
                    if(studentUpdate != null){
                        updateStudentById(studentUpdate);
                    }
                    else{
                        System.out.println("Student not found!!!");
                    }
                    break;
            }
        }while(!choice.equals(QUIT));
    }
}
