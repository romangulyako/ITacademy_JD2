package itacademy.robots_builder.factory;

import itacademy.robots_builder.dto.RobotParts;

import java.util.concurrent.ThreadLocalRandom;

public class RobotPartsFactory {
    private static final int MIN_PARTS_COUNT = 1;
    private static final int MAX_PARTS_COUNT = 4;

    private final Dump dump;

    public RobotPartsFactory(Dump dump) {
        this.dump = dump;
    }

    /**
     * Метод симулирует выброс на свалку случайное количество запчастей
     */
    public void throwParts() {
        int partsCount = ThreadLocalRandom.current()
                .nextInt(MAX_PARTS_COUNT) + MIN_PARTS_COUNT;

        synchronized(dump) {
            for (int i = 0; i < partsCount; i++) {
                dump.addPart(RobotParts.getRandomPart());
            }
        }
    }
}
