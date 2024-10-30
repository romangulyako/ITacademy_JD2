package itacademy;

import itacademy.api.IStudent;
import itacademy.dto.Skills;
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
     * @param skill навык, который студент будет изучать
     * @return студент типа 1
     */
    public static IStudent createStudentTypeOne(Skills skill) {
        return new StudentTypeOne(NumberUtils.getRandomNumber(MIN_TALENT,MAX_TALENT),skill);
    }

    /**
     * Метод создает студента типа 2 с рандомным талантом
     *
     * @param skill навык, который студент будет изучать
     * @return студент типа 2
     */
    public static IStudent createStudentTypeTwo(Skills skill) {
        return new StudentTypeTwo(NumberUtils.getRandomNumber(MIN_TALENT,MAX_TALENT),skill);
    }

    /**
     * Метод создает студента типа 3 с рандомным талантом
     *
     * @param skill навык, который студент будет изучать
     * @return студент типа 3
     */
    public static IStudent createStudentTypeThree(Skills skill) {
        return new StudentTypeThree(NumberUtils.getRandomNumber(MIN_TALENT,MAX_TALENT),skill);
    }
}
