package itacademy.robots_builder;

import itacademy.robots_builder.dto.RobotParts;
import itacademy.robots_builder.factory.Dump;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Assistant {
    private final static int MIN_PARTS_COUNT = 1;
    private final static int MAX_PARTS_COUNT = 4;

    private final Scientist scientist;

    public Assistant(Scientist scientist) {
        this.scientist = scientist;
    }

    /**
     * Метод собирает на свалке случайное количество запчастей
     *
     * @param dump свалка, на которой будут собираться запчасти
     * @return список собранных запчастей
     */
    public List<RobotParts> takeRobotPartsFromDump(Dump dump) {
        int partsCount = ThreadLocalRandom.current()
                .nextInt(MAX_PARTS_COUNT) + MIN_PARTS_COUNT;
        return dump.getParts(partsCount);
    }

    /**
     * Метод передает запчасти ученому
     * @param parts список передаваемых запчастей
     */
    public void giveRobotPartsToScientist(List<RobotParts> parts) {
        scientist.takeRobotParts(parts);
    }
}
