package itacademy.students;

import itacademy.api.IAnalyzable;
import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.ExceptionUtils;
import itacademy.utils.NumberUtils;

public class StudentTypeTwo implements IStudent, IAnalyzable, IPracticing {
    private static final int ACTIONS_COUNT = 2;
    private static final int SLOWDOWN_COEFFICIENT = 2;
    private final double talent;
    private Skills skill;

    public StudentTypeTwo(double talent) {
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
    public double doAnalyze() {
        return doPartOfLearning();
    }

    @Override
    public double doPractice() {
        return doPartOfLearning();
    }

    @Override
    public double learnSkill() {
        return this.doAnalyze() + this.doPractice();
    }

    @Override
    public String toString() {
        ExceptionUtils.checkSkillSetting(this);

        return "Студент типа 2, "
                + "талант - " + this.talent + ", "
                + "изучаемый навык - " + this.skill.getNameSkill();
    }

    /**
     * Метод рассчитывает сколько времени потратит студент типа 2
     * на одну из частей освоения навыка с учетом его таланта
     *
     * @return количество часов
     */
    private double doPartOfLearning() {
        ExceptionUtils.checkSkillSetting(this);

        double time = SLOWDOWN_COEFFICIENT
                * this.skill.getHoursForMasterSkill()
                / this.talent
                / ACTIONS_COUNT;
        return NumberUtils.roundToOneDecimalPlaces(time);
    }
}
