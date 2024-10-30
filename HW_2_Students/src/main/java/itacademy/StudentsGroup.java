package itacademy;

import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.GetInfoUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentsGroup {
    private final static String SEPARATOR = "-----------------------------------------";
    private final static String NEW_LINE_SYMBOL = "\n";

    private final List<IStudent> students = new ArrayList<>();
    private final Skills skill;

    public StudentsGroup(Skills skill) {
        this.skill = skill;
    }

    /**
     * Метод зачисляет студента в группу
     *
     * @param student студент
     */
    public void enrollStudent(IStudent student) {
        if (student != null) {
            student.setSkill(skill);
            students.add(student);
        }
    }

    /**
     * Метод возвращает информацию о студентах, а также об обучаемости группы
     *
     * @return информация
     */
    public String getInfoAboutGroupsLearningAbility() {
        StringBuilder builder = new StringBuilder();

        for (IStudent student : students) {
            builder.append(GetInfoUtils.getAllStudentInfo(student));
            builder.append(NEW_LINE_SYMBOL).append(SEPARATOR).append(NEW_LINE_SYMBOL);
        }

        return builder.toString();
    }
}
