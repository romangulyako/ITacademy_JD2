package itacademy;

import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.students.StudentTypeOne;
import itacademy.students.StudentTypeThree;
import itacademy.students.StudentTypeTwo;
import itacademy.utils.NumberUtils;

import java.util.concurrent.ThreadLocalRandom;

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
        return new StudentTypeOne(getRandomTalent(),skill);
    }

    /**
     * Метод создает студента типа 2 с рандомным талантом
     *
     * @param skill навык, который студент будет изучать
     * @return студент типа 2
     */
    public static IStudent createStudentTypeTwo(Skills skill) {
        return new StudentTypeTwo(getRandomTalent(),skill);
    }

    /**
     * Метод создает студента типа 3 с рандомным талантом
     *
     * @param skill навык, который студент будет изучать
     * @return студент типа 3
     */
    public static IStudent createStudentTypeThree(Skills skill) {
        return new StudentTypeThree(getRandomTalent(),skill);
    }

    /**
     * Метод генерирует случайный талант в промежутке между
     * минимальным и максимальным возможным талантом студента
     *
     * @return талант студента
     */
    private static double getRandomTalent() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        double talent = rnd.nextDouble(MIN_TALENT,MAX_TALENT);
        return NumberUtils.roundToOneDecimalPlaces(talent);
    }
}
