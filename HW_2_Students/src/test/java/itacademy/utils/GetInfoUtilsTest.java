package itacademy.utils;

import itacademy.api.IAnalyzable;
import itacademy.api.IFlowable;
import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.students.StudentTypeOne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetInfoUtilsTest {
    private final IStudent student = new StudentTypeOne(1);

    @Test
    void getPracticeTimeTest() {
        student.setSkill(Skills.JAVA_CORE);
        String expected = "Затрачено часов на практику: 66.0";
        String result = GetInfoUtils.getPracticeTime((IPracticing) student);

        assertEquals(expected,result);
    }

    @Test
    void getAnalyzeTimeTest() {
        student.setSkill(Skills.JAVA_CORE);
        String expected = "Затрачено часов на разбор: 66.0";
        String result = GetInfoUtils.getAnalyzeTime((IAnalyzable) student);

        assertEquals(expected,result);
    }

    @Test
    void getBeingInTheFlowTimeTest() {
        student.setSkill(Skills.JAVA_CORE);
        String expected = "Затрачено часов на пребывание в потоке: 66.0";
        String result = GetInfoUtils.getBeingInTheFlowTime((IFlowable) student);

        assertEquals(expected,result);
    }

    @Test
    void getAllLearningTimeTest() {
        student.setSkill(Skills.JAVA_CORE);
        String expected = "Затрачено часов на полное изучение навыка: 198.0";
        String result = GetInfoUtils.getAllLearningTime(student);

        assertEquals(expected,result);
    }

    @Test
    void getAllStudentInfoTest() {
        student.setSkill(Skills.JAVA_CORE);
        String expected = "Студент типа 1, талант - 1.0, изучаемый навык - Программирование на Java\n"
                + "Затрачено часов на практику: 66.0\n"
                +"Затрачено часов на разбор: 66.0\n"
                + "Затрачено часов на пребывание в потоке: 66.0\n"
                + "Затрачено часов на полное изучение навыка: 198.0";
        String result = GetInfoUtils.getAllStudentInfo(student);

        assertEquals(expected,result);
    }

    @Test
    void nullArgumentsTest() {
        assertThrows(NullPointerException.class,
                () -> GetInfoUtils.getPracticeTime((IPracticing) student));

        assertThrows(NullPointerException.class,
                () -> GetInfoUtils.getAnalyzeTime((IAnalyzable) student));

        assertThrows(NullPointerException.class,
                () -> GetInfoUtils.getBeingInTheFlowTime((IFlowable) student));

        assertThrows(NullPointerException.class,
                () -> GetInfoUtils.getAllLearningTime(student));

        assertThrows(NullPointerException.class,
                () -> GetInfoUtils.getAllStudentInfo(student));
    }
}