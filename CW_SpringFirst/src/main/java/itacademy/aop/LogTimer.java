package itacademy.aop;

import java.time.LocalDateTime;

public class LogTimer {
    public void logStart() {
        System.out.println("Start time : " + LocalDateTime.now());
    }

    public void logEnd() {
        System.out.println("End time : " + LocalDateTime.now());
    }
}
