package training.utils;

import training.entities.Course;

import java.util.ArrayList;

public class Validator {
    public static boolean validateCode(String code){
        if(code == null) {
            return false;
        }

        String regex = "^RA\\d{3}$";

        return code.matches(regex);
    }

    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses){
        return courses.stream().anyMatch(course -> course.getCode().equals(code));
    }

    public static boolean validateStatus(boolean status){
        return false;
    }

    public static boolean validateFlag(String flag){
        if("optional".equals(flag) || "prerequisite".equals(flag) || "N/A".equals(flag)){
            return true;
        }

        return false;
    }

    public static boolean validateDuration(short duration){
        if(duration > 0) {
            return true;
        }

        return false;
    }
}
