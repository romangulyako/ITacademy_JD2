package itacademy.dto;

public enum Skills {
    JAVA_CORE(198, "Программирование на Java"),
    DRIVE(66, "Вождение автомобиля");

    private final double hoursForMasterSkill;
    private final String nameSkill;

    Skills(double hoursForMasterSkill, String nameSkill) {
        this.hoursForMasterSkill = hoursForMasterSkill;
        this.nameSkill = nameSkill;
    }

    public double getHoursForMasterSkill() {
        return hoursForMasterSkill;
    }

    public String getNameSkill() {
        return nameSkill;
    }
}
