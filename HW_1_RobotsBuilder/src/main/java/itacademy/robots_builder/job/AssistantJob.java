package itacademy.robots_builder.job;

import itacademy.robots_builder.Assistant;
import itacademy.robots_builder.factory.Dump;
import itacademy.robots_builder.dto.RobotParts;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AssistantJob implements Runnable{
    private final static long INTERVAL_BETWEEN_NIGHTS = 100;
    private final static int NIGHTS_COUNT = 100;

    private final Dump dump;
    private final Assistant assistant;

    public AssistantJob(Dump dump, Assistant assistant) {
        this.dump = dump;
        this.assistant = assistant;
    }

    /**
     * Метод симулирует работу ассистента по сбору на свалке запчастей и передаче их ученому
     */
    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            List<RobotParts> parts = assistant.takeRobotPartsFromDump(dump);
            assistant.giveRobotPartsToScientist(parts);

            try {
                TimeUnit.MILLISECONDS.sleep(INTERVAL_BETWEEN_NIGHTS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
