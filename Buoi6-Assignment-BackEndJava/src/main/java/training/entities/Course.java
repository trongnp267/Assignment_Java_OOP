package training.entities;

import training.utils.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;

    public Course() {

    }

    public Course(String code, String name, boolean status, short duration, String flag) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Status: " + status + ", Duration: " + duration + ", Flag: " + flag;
    }

    public void input(Scanner sc, ArrayList<Course> courses){
        String code = "";
        while(true){
            code = inputCode();

            if(!Validator.isDuplicatedCode(code, courses)){
                break;
            }

            System.out.println("Input code is duplicated");
        }
        this.code = code;

        this.name = inputName();

        this.status = inputStatus();

        this.duration = inputDuration();

        this.flag = inputFlag();
    }

    public static String inputCode(){
        Scanner sc = new Scanner(System.in);

        String code = "";
        boolean flag = true;

        do {
            try {
                System.out.println("Enter Code:");
                code = sc.nextLine();

                if(!Validator.validateCode(code)){
                    throw new IllegalArgumentException("Invalid code");
                }

                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while(flag);

        return code;
    }

    public static String inputName(){
        Scanner sc = new Scanner(System.in);

        String name = "";
        boolean flag = true;

        do {
            try {
                System.out.println("Enter Name:");
                name = sc.nextLine();

                if("".equals(name)){
                    throw new IllegalArgumentException("Name cannot be empty");
                }

                flag = false;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while(flag);

        return name;
    }

    public static boolean inputStatus(){
        Scanner sc = new Scanner(System.in);

        boolean status = false;
        boolean flag = true;

        do {
            try {
                System.out.println("Enter Status:");
                String input = sc.nextLine();

                if(input.equalsIgnoreCase("true")){
                    status = true;
                } else if (input.equalsIgnoreCase("false")){
                    status = false;
                } else {
                    throw new IllegalArgumentException("status must be true or false");
                }

                flag = false;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while(flag);

        return status;
    }

    public static short inputDuration(){
        Scanner sc = new Scanner(System.in);

        short duration = 0;
        boolean flag = true;

        do {
            try {
                System.out.println("Enter Duration:");
                duration = Short.parseShort(sc.nextLine());

                if(!Validator.validateDuration(duration)){
                    throw new IllegalArgumentException("duration must be positive integer");
                }

                flag = false;
            } catch(NumberFormatException e) {
                System.out.println("Input duration is not a number");
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while(flag);

        return duration;
    }

    public static String inputFlag(){
        Scanner sc = new Scanner(System.in);

        String flag = "";
        boolean check = true;
        do {
            try {
                System.out.println("Enter Flag:");
                flag = sc.nextLine();

                if(!Validator.validateFlag(flag)){
                    throw new IllegalArgumentException("Flag only accept 'optional', 'prerequisite', 'N/A'");
                }

                check = false;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while(check);

        return flag;
    }
}
