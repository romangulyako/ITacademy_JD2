package itacademy.students;

import itacademy.dto.Skills;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTypeTwoTest {
    private final StudentTypeTwo normalStudent = new StudentTypeTwo(1, Skills.JAVA_CORE);
    private final StudentTypeTwo studentWithNullableSkill = new StudentTypeTwo(1,null);

    @Test
    void doAnalyzeTest() {
        double expected = 198;
        double result = normalStudent.doAnalyze();
        assertEquals(expected,result);
    }

    @Test
    void doPracticeTest() {
        double expected = 198;
        double result = normalStudent.doPractice();
        assertEquals(expected,result);
    }

    @Test
    void learnSkillTest() {
        double expected = 396;
        double result = normalStudent.learnSkill();
        assertEquals(expected,result);
    }

    @Test
    void toStringTest() {
        String expected = "Студент типа 2, талант - 1.0, " +
                "изучаемый навык - Программирование на Java";
        assertEquals(expected,normalStudent.toString());
    }

    @Test
    void nullArgumentsTest() {
        assertThrows(NullPointerException.class, studentWithNullableSkill::doAnalyze);
        assertThrows(NullPointerException.class, studentWithNullableSkill::doPractice);
        assertThrows(NullPointerException.class, studentWithNullableSkill::learnSkill);
        assertThrows(NullPointerException.class, studentWithNullableSkill::toString);
    }
}