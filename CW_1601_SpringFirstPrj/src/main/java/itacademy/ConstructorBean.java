package itacademy;

import java.util.List;
import java.util.Map;

public class ConstructorBean {
    private String name;
    private List<String> stringList;
    private Map<Long, String> map;

    public ConstructorBean(String name) {
        this.name = name;
    }

    public ConstructorBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Map<Long, String> getMap() {
        return map;
    }

    public void setMap(Map<Long, String> map) {
        this.map = map;
    }
}
