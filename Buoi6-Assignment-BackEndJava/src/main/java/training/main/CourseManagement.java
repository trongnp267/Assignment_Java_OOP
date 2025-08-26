package training.main;

import training.entities.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagement {
    public static final String CREATE = "1";
    public static final String SEARCH = "2";
    public static final String DISPLAYALL = "3";
    public static final String QUIT = "4";

    public static final String CODE = "1";
    public static final String NAME = "2";
    public static final String STATUS = "3";
    public static final String DURATION = "4";
    public static final String FLAG = "5";

    private ArrayList<Course> courses;

    public CourseManagement() {
        this.courses = new ArrayList<>();
    }

    private void input(Scanner sc) {
        Course course = new Course();

        course.input(sc, courses);

        courses.add(course);

        System.out.println("Course Created Successfully");
    }

    private ArrayList<Course> search(String type, Object data) {
        ArrayList<Course> listSearch = new ArrayList<>();

        for (Course course : courses) {
            switch (type) {
                case CODE:
                    if (course.getCode().equals(data)) {
                        listSearch.add(course);
                    }
                    break;
                case NAME:
                    if (course.getName().equals(data)) {
                        listSearch.add(course);
                    }
                    break;
                case STATUS:
                    if (course.isStatus() == (boolean) data) {
                        listSearch.add(course);
                    }
                    break;
                case DURATION:
                    if (course.getDuration() == (short) data) {
                        listSearch.add(course);
                    }
                    break;
                case FLAG:
                    if (course.getFlag().equals(data)) {
                        listSearch.add(course);
                    }
                    break;
            }
        }

        return listSearch;
    }

    private void displayAll(String flag) {
        courses.stream().filter(course -> course.getFlag().equals(flag)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        CourseManagement cm = new CourseManagement();

        String function = "";

        do {
            System.out.println("1. Create Course");
            System.out.println("2. Search Course");
            System.out.println("3. Display All Course");
            System.out.println("4. Quit");

            System.out.println("Enter your function:");
            function = sc.nextLine();

            switch (function) {
                case CREATE:
                    cm.input(sc);

                    break;
                case SEARCH:
                    cm.solvingFunctionSearch();

                    break;
                case DISPLAYALL:
                    String flag = Course.inputFlag();

                    cm.displayAll(flag);

                    break;
            }
        } while (!QUIT.equals(function));
    }

    public void solvingFunctionSearch() {
        Scanner sc = new Scanner(System.in);

        String type = "";
        Object data = null;
        boolean flag = true;

        do {
            try {
                System.out.println("1. Code");
                System.out.println("2. Name");
                System.out.println("3. Status");
                System.out.println("4. Duration");
                System.out.println("5. Flag");

                System.out.println("Enter your type:");
                type = sc.nextLine();

                switch (type) {
                    case CODE:
                        data = Course.inputCode();
                        break;
                    case NAME:
                        data = Course.inputName();
                        break;
                    case STATUS:
                        data = Course.inputStatus();
                        break;
                    case DURATION:
                        data = Course.inputDuration();
                        break;
                    case FLAG:
                        data = Course.inputFlag();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid type");
                }

                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);

        if (data != null) {
            ArrayList<Course> listSearch = search(type, data);

            listSearch.forEach(System.out::println);
        } else {
            System.out.println("Invalid data");
        }
    }
}
