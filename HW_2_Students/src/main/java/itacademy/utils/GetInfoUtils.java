package itacademy.utils;

import itacademy.api.IAnalyzable;
import itacademy.api.IFlowable;
import itacademy.api.IPracticing;
import itacademy.api.IStudent;

public class GetInfoUtils {
    private final static String NEW_LINE_SYMBOL = "\n";

    /**
     * Возвращает в понятном и читаемом виде информацию
     * о времени, потраченном на практику
     *
     * @param student студент, который делает практическую часть
     * @return сообщение с информацией
     */
    public static String getPracticeTime(IPracticing student) {
        return "Затрачено часов на практику: " + student.doPractice();
    }

    /**
     * Возвращает в понятном и читаемом виде информацию
     * о времени, потраченном на разбор
     *
     * @param student студент, который делает разбор
     * @return сообщение с информацией
     */
    public static String getAnalyzeTime(IAnalyzable student) {
        return "Затрачено часов на разбор: " + student.doAnalyze();
    }

    /**
     * Возвращает в понятном и читаемом виде информацию
     * о времени, потраченном на нахождение в потоке
     *
     * @param student студент, который находится в потоке
     * @return сообщение с информацией
     */
    public static String getBeingInTheFlowTime(IFlowable student) {
        return "Затрачено часов на пребывание в потоке: " + student.beInTheFlow();
    }

    /**
     * Возвращает в понятном и читаемом виде информацию
     * о времени, потраченном на полное освоение навыка
     *
     * @param student студент, который осваивает навык
     * @return сообщение с информацией
     */
    public static String getAllLearningTime(IStudent student) {
        return "Затрачено часов на полное изучение навыка: " + student.learnSkill();
    }

    /**
     * Возвращает в понятном и читаемом виде полную информацию
     * о студенте и времени, потраченном на отдельные части
     * освоения навыка и общем времени освоения
     *
     * @param student студент, который осваивает навык
     * @return сообщение с информацией
     */
    public static String getAllStudentInfo(IStudent student) {
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append(student);

        if (student instanceof IPracticing) {
            infoBuilder.append(NEW_LINE_SYMBOL)
                    .append(getPracticeTime((IPracticing) student));
        }

        if (student instanceof IAnalyzable) {
            infoBuilder.append(NEW_LINE_SYMBOL)
                    .append(getAnalyzeTime((IAnalyzable) student));
        }

        if (student instanceof IFlowable) {
            infoBuilder.append(NEW_LINE_SYMBOL)
                    .append(getBeingInTheFlowTime((IFlowable) student));
        }

        infoBuilder.append(NEW_LINE_SYMBOL)
                .append(getAllLearningTime(student));

        return infoBuilder.toString();
    }
}
