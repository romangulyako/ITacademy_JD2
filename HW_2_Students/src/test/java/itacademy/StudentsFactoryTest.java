package itacademy;

import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.students.StudentTypeOne;
import itacademy.students.StudentTypeThree;
import itacademy.students.StudentTypeTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsFactoryTest {

    @Test
    void createStudentTypeOneTest() {
        IStudent student = StudentsFactory.createStudentTypeOne();

        assertInstanceOf(StudentTypeOne.class, student);
    }

    @Test
    void createStudentTypeTwoTest() {
        IStudent student = StudentsFactory.createStudentTypeTwo();

        assertInstanceOf(StudentTypeTwo.class, student);
    }

    @Test
    void createStudentTypeThreeTest() {
        IStudent student = StudentsFactory.createStudentTypeThree();

        assertInstanceOf(StudentTypeThree.class, student);
    }
}