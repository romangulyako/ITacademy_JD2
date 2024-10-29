package itacademy.robots_builder;

import itacademy.robots_builder.dto.RobotParts;

import java.util.*;

public class Scientist {
    private final Map<RobotParts,Integer> partsForAssembly = new HashMap<>();

    /**
     * Метод для получения запчастей и добавления их в хранилище для последующей сборки
     *
     * @param parts список запчастей
     */
    public void takeRobotParts(List<RobotParts> parts) {
        for (RobotParts part : parts) {
            Integer count = partsForAssembly.getOrDefault(part,0);
            partsForAssembly.put(part,++count);
        }
    }

    /**
     * Метод собирает роботов из имеющихся запчастей
     *
     * @return количество роботов
     */
    public int assembleRobots() {
        int allPartsCount = RobotParts.values().length;
        if (partsForAssembly.size() == allPartsCount) {
            List<Integer> partsCount = new ArrayList<>(partsForAssembly.values());
            int robotsCount = partsCount.get(0);
            for (Integer partCount : partsCount) {
                robotsCount = Math.min(robotsCount,partCount);
            }

            return robotsCount;
        }

        return 0;
    }
}
