package itacademy.api;

import itacademy.dto.Skills;

public interface IStudent {
    /**
     * Метод рассчитывает время, за которое студент полностью осваивает навык
     *
     * @return количество часов
     */
    double learnSkill();

    /**
     * Метод задает студенту навык, который он будет изучать
     * @param skill навык
     */
    void setSkill(Skills skill);

    /**
     * Метод возвращает навык, который изучает студент
     *
     * @return навык
     */
    Skills getSkill();
}
