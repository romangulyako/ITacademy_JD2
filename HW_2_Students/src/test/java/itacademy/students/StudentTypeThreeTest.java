package itacademy.students;

import itacademy.dto.Skills;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTypeThreeTest {
    private final StudentTypeThree normalStudent = new StudentTypeThree(1, Skills.JAVA_CORE);
    private final StudentTypeThree studentWithNullableSkill = new StudentTypeThree(1,null);

    @Test
    void doPracticeTest() {
        double expected = 594;
        double result = normalStudent.doPractice();
        assertEquals(expected,result);
    }

    @Test
    void learnSkillTest() {
        double expected = 594;
        double result = normalStudent.learnSkill();
        assertEquals(expected,result);
    }

    @Test
    void toStringTest() {
        String expected = "Студент типа 3, талант - 1.0, " +
                "изучаемый навык - Программирование на Java";
        assertEquals(expected,normalStudent.toString());
    }

    @Test
    void nullArgumentsTest() {
        assertThrows(NullPointerException.class, studentWithNullableSkill::doPractice);
        assertThrows(NullPointerException.class, studentWithNullableSkill::learnSkill);
        assertThrows(NullPointerException.class, studentWithNullableSkill::toString);
    }
}