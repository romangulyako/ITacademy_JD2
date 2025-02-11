package itacademy.aopannotation;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    public void performJob() {
        System.out.println("Performing job");
    }

    public void performExceptionJob() throws Exception{
        System.out.println("Performing exception job");
        throw new Exception("Exception Job");
    }

    public String performJobAround() {
        System.out.println("Performing job around");
        return "SUCCESS";
    }

    public void performJob(String name) {
        System.out.println("Performing job " + name);
    }
}
