package itacademy.utils;

import itacademy.api.IStudent;
import itacademy.exceptions.SkillNotSetException;

public class ExceptionUtils {
    public static void checkSkillSetting(IStudent student) {
        if (student.getSkill() == null) {
            throw new SkillNotSetException("У студента еще не задан навык");
        }
    }
}
