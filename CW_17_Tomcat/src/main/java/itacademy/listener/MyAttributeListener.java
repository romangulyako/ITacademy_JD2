package itacademy.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyAttributeListener implements HttpSessionAttributeListener {
    private final String counterAttr = "counter";

    public void attributeAdded(HttpSessionBindingEvent ev) {
        String currentAttributeName = ev.getName();
        String urlAttr = "URL";

        if (currentAttributeName.equals(counterAttr)) {
            Integer currentValueInt = (Integer) ev.getValue();
            System.out.println("в Session добавлен счетчик=" + currentValueInt);
        } else if (currentAttributeName.equals(urlAttr)) {
            StringBuffer currentValueStr = (StringBuffer) ev.getValue();
            System.out.println("в Session добавлен URL=" + currentValueStr);
        } else System.out.println("добавлен новый атрибут");
    }

    public void attributeRemoved(HttpSessionBindingEvent ev) {
    }

    public void attributeReplaced(HttpSessionBindingEvent ev) {
        String currentAttributeName = ev.getName();
        if (currentAttributeName.equals(counterAttr)) {
            Integer currentValueInt = (Integer) ev.getValue();
            System.out.println("В Session заменен cчетчик=" + currentValueInt);
        }
    }
}
