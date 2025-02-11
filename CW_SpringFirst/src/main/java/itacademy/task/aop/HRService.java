package itacademy.task.aop;

import org.springframework.stereotype.Service;

@Service("hrService")
public class HRService {
    public void findEmployee(String experience) {
        System.out.println("Идет поиск сотрудника с опытом: " + experience);
    }
}
