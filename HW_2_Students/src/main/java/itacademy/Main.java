package itacademy;

import itacademy.dto.Skills;

public class Main {
    private final static int COUNT_STUDENTS_OF_EACH_TYPE = 3;

    public static void main(String[] args) {
       StudentsGroup jd2 = new StudentsGroup(Skills.JAVA_CORE);

        for (int i = 0; i < COUNT_STUDENTS_OF_EACH_TYPE; i++) {
            jd2.enrollStudent(StudentsFactory.createStudentTypeOne());
        }
        for (int i = 0; i < COUNT_STUDENTS_OF_EACH_TYPE; i++) {
            jd2.enrollStudent(StudentsFactory.createStudentTypeTwo());
        }
        for (int i = 0; i < COUNT_STUDENTS_OF_EACH_TYPE; i++) {
            jd2.enrollStudent(StudentsFactory.createStudentTypeThree());
        }

        System.out.println(jd2.getInfoAboutGroupsLearningAbility());
    }
}
