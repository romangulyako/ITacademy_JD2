package itacademy.students;

import itacademy.api.IAnalyzable;
import itacademy.api.IFlowable;
import itacademy.api.IPracticing;
import itacademy.api.IStudent;
import itacademy.dto.Skills;
import itacademy.utils.NumberUtils;

public class StudentTypeOne implements IStudent, IAnalyzable, IPracticing, IFlowable {
    private static final int ACTIONS_COUNT = 3;

    private final double talent;
    private final Skills learnedSkill;

    public StudentTypeOne(double talent, Skills learnedSkill) {
        this.talent = talent;
        this.learnedSkill = learnedSkill;
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
        return "Студент типа 1, "
                + "талант - " + this.talent + ", "
                + "изучаемый навык - " + this.learnedSkill.getNameSkill();
    }

    /**
     * Метод рассчитывает сколько времени потратит студент типа 1
     * на одну из частей освоения навыка с учетом его таланта
     *
     * @return количество часов
     */
    private double doPartOfLearning() {
        double time = this.learnedSkill.getHoursForMasterSkill()
                / this.talent
                / ACTIONS_COUNT;
        return NumberUtils.roundToOneDecimalPlaces(time);
    }
}
