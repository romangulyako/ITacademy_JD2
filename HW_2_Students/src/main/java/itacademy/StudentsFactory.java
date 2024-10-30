package itacademy;

import itacademy.api.IStudent;
import itacademy.students.StudentTypeOne;
import itacademy.students.StudentTypeThree;
import itacademy.students.StudentTypeTwo;
import itacademy.utils.NumberUtils;

public class StudentsFactory {
    private static final double MIN_TALENT = 0.1;
    private static final double MAX_TALENT = 1;

    /**
     * Метод создает студента типа 1 с рандомным талантом
     *
     * @return студент типа 1
     */
    public static IStudent createStudentTypeOne() {
        return new StudentTypeOne(NumberUtils.getRandomNumber(MIN_TALENT,MAX_TALENT));
    }

    /**
     * Метод создает студента типа 2 с рандомным талантом
     *
     * @return студент типа 2
     */
    public static IStudent createStudentTypeTwo() {
        return new StudentTypeTwo(NumberUtils.getRandomNumber(MIN_TALENT,MAX_TALENT));
    }

    /**
     * Метод создает студента типа 3 с рандомным талантом
     *
     * @return студент типа 3
     */
    public static IStudent createStudentTypeThree() {
        return new StudentTypeThree(NumberUtils.getRandomNumber(MIN_TALENT,MAX_TALENT));
    }
}
