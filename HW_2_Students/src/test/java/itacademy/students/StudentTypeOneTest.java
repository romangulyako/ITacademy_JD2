package itacademy.students;

import itacademy.dto.Skills;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTypeOneTest {
    private final StudentTypeOne normalStudent = new StudentTypeOne(1, Skills.JAVA_CORE);
    private final StudentTypeOne studentWithNullableSkill = new StudentTypeOne(1,null);

    @Test
    void doAnalyzeTest() {
        double expected = 66;
        double result = normalStudent.doAnalyze();
        assertEquals(expected,result);
    }

    @Test
    void beInTheFlowTest() {
        double expected = 66;
        double result = normalStudent.beInTheFlow();
        assertEquals(expected,result);
    }

    @Test
    void doPracticeTest() {
        double expected = 66;
        double result = normalStudent.doPractice();
        assertEquals(expected,result);
    }

    @Test
    void learnSkillTest() {
        double expected = 198;
        double result = normalStudent.learnSkill();
        assertEquals(expected,result);
    }

    @Test
    void toStringTest() {
        String expected = "Студент типа 1, талант - 1.0, " +
                "изучаемый навык - Программирование на Java";
        assertEquals(expected,normalStudent.toString());
    }

    @Test
    void nullArgumentsTest() {
        assertThrows(NullPointerException.class, studentWithNullableSkill::doAnalyze);
        assertThrows(NullPointerException.class, studentWithNullableSkill::doPractice);
        assertThrows(NullPointerException.class, studentWithNullableSkill::beInTheFlow);
        assertThrows(NullPointerException.class, studentWithNullableSkill::learnSkill);
        assertThrows(NullPointerException.class, studentWithNullableSkill::toString);
    }
}