package itacademy.students;

import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.NumberUtils;

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
        double practiceTime = this.learnedSkill.getHoursForMasterSkill() / this.talent * SLOWDOWN_COEFFICIENT;
        return NumberUtils.roundToOneDecimalPlaces(practiceTime);
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
