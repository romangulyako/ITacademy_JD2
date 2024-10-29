package itacademy.robots_builder;

import itacademy.robots_builder.factory.Dump;
import itacademy.robots_builder.factory.RobotPartsFactory;
import itacademy.robots_builder.job.AssistantJob;
import itacademy.robots_builder.job.RobotPartsFactoryJob;

public class Main {
    public static void main(String[] args) {
        Scientist scientist1 = new Scientist();
        Scientist scientist2 = new Scientist();

        Assistant assistant1 = new Assistant(scientist1);
        Assistant assistant2 = new Assistant(scientist2);

        Dump dump = new Dump();
        RobotPartsFactory factory = new RobotPartsFactory(dump);

        Thread factoryJob = new Thread(new RobotPartsFactoryJob(factory));
        Thread assistant1Job = new Thread(new AssistantJob(dump,assistant1));
        Thread assistant2Job = new Thread(new AssistantJob(dump,assistant2));

        factoryJob.start();
        assistant1Job.start();
        assistant2Job.start();

        try {
            factoryJob.join();
            assistant1Job.join();
            assistant2Job.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Количество собранных роботов у первого ученого:" + scientist1.assembleRobots());
        System.out.println("Количество собранных роботов у второго ученого:" + scientist2.assembleRobots());
    }
}
