package itacademy.students;

import itacademy.dto.Skills;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTypeTwoTest {
    private final StudentTypeTwo normalStudent = new StudentTypeTwo(1);

    @Test
    void doAnalyzeTest() {
        normalStudent.setSkill(Skills.JAVA_CORE);
        double expected = 198;
        double result = normalStudent.doAnalyze();
        assertEquals(expected,result);
    }

    @Test
    void doPracticeTest() {
        normalStudent.setSkill(Skills.JAVA_CORE);
        double expected = 198;
        double result = normalStudent.doPractice();
        assertEquals(expected,result);
    }

    @Test
    void learnSkillTest() {
        normalStudent.setSkill(Skills.JAVA_CORE);
        double expected = 396;
        double result = normalStudent.learnSkill();
        assertEquals(expected,result);
    }

    @Test
    void toStringTest() {
        normalStudent.setSkill(Skills.JAVA_CORE);
        String expected = "Студент типа 2, талант - 1.0, " +
                "изучаемый навык - Программирование на Java";
        assertEquals(expected,normalStudent.toString());
    }

    @Test
    void nullArgumentsTest() {
        assertThrows(NullPointerException.class, normalStudent::doAnalyze);
        assertThrows(NullPointerException.class, normalStudent::doPractice);
        assertThrows(NullPointerException.class, normalStudent::learnSkill);
        assertThrows(NullPointerException.class, normalStudent::toString);
    }
}