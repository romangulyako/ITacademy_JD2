package itacademy.robots_builder.dto;

import java.util.concurrent.ThreadLocalRandom;

public enum RobotParts {
    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    /**
     * Метод возвращает одну любую случайную запчасть
     * @return запчасть
     */
    public static RobotParts getRandomPart() {
        RobotParts[] parts = values();
        int index = ThreadLocalRandom.current().nextInt(parts.length);

        return parts[index];
    }
}
