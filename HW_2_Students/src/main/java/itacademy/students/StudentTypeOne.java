package itacademy.students;

import itacademy.api.IAnalyzable;
import itacademy.api.IFlowable;
import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.ExceptionUtils;
import itacademy.utils.NumberUtils;

public class StudentTypeOne implements IStudent, IAnalyzable, IPracticing, IFlowable {
    private static final int ACTIONS_COUNT = 3;

    private final double talent;
    private Skills skill;

    public StudentTypeOne(double talent) {
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
    public double beInTheFlow() {
        return doPartOfLearning();
    }

    @Override
    public double doPractice() {
        return doPartOfLearning();
    }

    @Override
    public double learnSkill() {
        double fullTime = this.doAnalyze() + this.doPractice() + this.beInTheFlow();
        return NumberUtils.roundToOneDecimalPlaces(fullTime);
    }

    @Override
    public String toString() {
        ExceptionUtils.checkSkillSetting(this);

        return "Студент типа 1, "
                + "талант - " + this.talent + ", "
                + "изучаемый навык - " + this.skill.getNameSkill();
    }

    /**
     * Метод рассчитывает сколько времени потратит студент типа 1
     * на одну из частей освоения навыка с учетом его таланта
     *
     * @return количество часов
     */
    private double doPartOfLearning() {
        ExceptionUtils.checkSkillSetting(this);

        double time = this.skill.getHoursForMasterSkill()
                / this.talent
                / ACTIONS_COUNT;
        return NumberUtils.roundToOneDecimalPlaces(time);
    }
}
