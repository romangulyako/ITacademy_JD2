package itacademy.task_72;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> academyClass = Academy.class;
        Method[] methods = academyClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(AcademyInfo.class)) {
                System.out.println("Метод "
                        + method.getName()
                        + " имеет аннотацию "
                        + method.getAnnotation(AcademyInfo.class).toString());
            } else {
                System.out.println("Метод "
                        + method.getName()
                        + " не имеет нужной аннотации");
            }
        }
    }
}
