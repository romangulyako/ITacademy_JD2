package itacademy.students;

import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;

public class StudentTypeThree implements IStudent, IPracticing {
    private static final int SLOWDOWN_COEFFICIENT = 3;
    private final double talent;
    private final Skills learnedSkill;

    public StudentTypeThree(double talent, Skills learnedSkill) {
        this.talent = talent;
        this.learnedSkill = learnedSkill;
    }

    @Override
    public double doPractice() {
        return this.learnedSkill.getHoursForMasterSkill() * SLOWDOWN_COEFFICIENT / this.talent;
    }

    @Override
    public double learnSkill() {
        return this.doPractice();
    }

    @Override
    public String toString() {
        return "Студент типа 3, "
                + "талант - " + this.talent + ", "
                + "изучаемый навык - " + this.learnedSkill.getNameSkill();
    }
}
