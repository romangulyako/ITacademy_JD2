package itacademy.task_70;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public final static String METHOD_NAME = "printInfo";

    public static void main(String[] args) {
        try {
            Main main = new Main();
            Class<?> mainClass = main.getClass();
            Method printInfoMethod = mainClass.getDeclaredMethod(METHOD_NAME, Class.class);
            String info = printInfoMethod.invoke(main,Man.class).toString();
            System.out.println(info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String printInfo(Class<?> someClass) {
        Field[] fields = someClass.getDeclaredFields();
        Method[] methods = someClass.getDeclaredMethods();
        Constructor<?>[] constructors = someClass.getDeclaredConstructors();

        StringBuilder builder = new StringBuilder();

        builder.append("Fields:\n");
        for (Field field : fields) {
            builder.append(field.getName())
                    .append("\n");
        }

        builder.append("Methods:\n");
        for (Method method : methods) {
            builder.append(method.getName())
                    .append("\n");
        }

        builder.append("Constructors:\n");
        for (Constructor<?> constructor : constructors) {
            builder.append(constructor.getName())
                    .append("\n");
        }

        return builder.toString();
    }
}
