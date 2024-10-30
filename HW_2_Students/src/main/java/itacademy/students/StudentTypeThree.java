package itacademy.students;

import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.ExceptionUtils;
import itacademy.utils.NumberUtils;

public class StudentTypeThree implements IStudent, IPracticing {
    private static final int SLOWDOWN_COEFFICIENT = 3;
    private final double talent;
    private Skills skill;

    public StudentTypeThree(double talent) {
        this.talent = talent;
    }

    @Override
    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    @Override
    public Skills getSkill() {
        return skill;
    }

    @Override
    public double doPractice() {
        ExceptionUtils.checkSkillSetting(this);

        double practiceTime = this.skill.getHoursForMasterSkill() / this.talent * SLOWDOWN_COEFFICIENT;
        return NumberUtils.roundToOneDecimalPlaces(practiceTime);
    }

    @Override
    public double learnSkill() {
        return this.doPractice();
    }

    @Override
    public String toString() {
        ExceptionUtils.checkSkillSetting(this);

        return "Студент типа 3, "
                + "талант - " + this.talent + ", "
                + "изучаемый навык - " + this.skill.getNameSkill();
    }
}
