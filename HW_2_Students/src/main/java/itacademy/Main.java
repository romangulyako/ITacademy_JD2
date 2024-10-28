package itacademy;

import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.GetInfoUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String SEPARATOR = "-----------------------------------------";
    private final static int COUNT_STUDENTS_OF_EACH_TYPE = 3;

    public static void main(String[] args) {
        List<IStudent> javaCoreGroup = new ArrayList<>();

        for (int i = 0; i < COUNT_STUDENTS_OF_EACH_TYPE; i++) {
            javaCoreGroup.add(StudentsFactory.createStudentTypeOne(Skills.JAVA_CORE));
        }
        for (int i = 0; i < COUNT_STUDENTS_OF_EACH_TYPE; i++) {
            javaCoreGroup.add(StudentsFactory.createStudentTypeTwo(Skills.JAVA_CORE));
        }
        for (int i = 0; i < COUNT_STUDENTS_OF_EACH_TYPE; i++) {
            javaCoreGroup.add(StudentsFactory.createStudentTypeThree(Skills.JAVA_CORE));
        }

        for (IStudent student : javaCoreGroup) {
            System.out.println(GetInfoUtils.getAllStudentInfo(student));
            System.out.println(SEPARATOR);
        }
    }
}
