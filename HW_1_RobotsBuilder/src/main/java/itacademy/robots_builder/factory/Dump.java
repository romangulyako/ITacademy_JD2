package itacademy.robots_builder.factory;

import itacademy.robots_builder.dto.RobotParts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dump {
    private static final int STARTED_PARTS_COUNT = 20;
    private final List<RobotParts> container = initializeDump();

    /**
     * Метод добавляет на свалку запчасть
     *
     * @param part запчасть, которую выбрасывают
     */
    public synchronized void addPart(RobotParts part) {
        container.add(part);
    }

    /**
     * Метод возвращает определенное количество запчастей
     * со свалки и убирает их оттуда
     *
     * @param count количество возвращаемых запчастей
     * @return список запчастей
     */
    public synchronized List<RobotParts> getParts(int count) {
        List<RobotParts> parts = new ArrayList<>();

        if (count >= container.size()) {
            parts.addAll(container);
            container.clear();
        } else {
            for (int i = 0; i < count; i++) {
                int index = ThreadLocalRandom.current()
                        .nextInt(container.size());
                RobotParts part = container.get(index);
                parts.add(part);
                container.remove(index);
            }
        }

        return parts;
    }

    /**
     * Метод для начального заполнения свалки запчастями
     *
     * @return список запчастей
     */
    private synchronized List<RobotParts> initializeDump() {
        List<RobotParts> startedParts = new ArrayList<>();

        for (int i = 0; i < STARTED_PARTS_COUNT; i++) {
            startedParts.add(RobotParts.getRandomPart());
        }

        return startedParts;
    }
}
