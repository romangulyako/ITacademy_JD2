package itacademy.students;

import itacademy.api.IAnalyzable;
import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.NumberUtils;

public class StudentTypeTwo implements IStudent, IAnalyzable, IPracticing {
    private static final int ACTIONS_COUNT = 2;
    private static final int SLOWDOWN_COEFFICIENT = 2;
    private final double talent;
    private final Skills learnedSkill;

    public StudentTypeTwo(double talent, Skills learnedSkill) {
        this.talent = talent;
        this.learnedSkill = learnedSkill;
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
        return "Студент типа 2, "
                + "талант - " + this.talent + ", "
                + "изучаемый навык - " + this.learnedSkill.getNameSkill();
    }

    /**
     * Метод рассчитывает сколько времени потратит студент типа 2
     * на одну из частей освоения навыка с учетом его таланта
     *
     * @return количество часов
     */
    private double doPartOfLearning() {
        double time = SLOWDOWN_COEFFICIENT
                * this.learnedSkill.getHoursForMasterSkill()
                / this.talent
                / ACTIONS_COUNT;
        return NumberUtils.roundToOneDecimalPlaces(time);
    }
}
