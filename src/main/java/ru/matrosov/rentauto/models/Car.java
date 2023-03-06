package ru.matrosov.rentauto.models;

public class Car {
    private int id;
    private String model_name;
    private String gos_number;

    public Car(int id, String model_name, String gos_number) {
        this.id = id;
        this.model_name = model_name;
        this.gos_number = gos_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getGos_number() {
        return gos_number;
    }

    public void setGos_number(String gos_number) {
        this.gos_number = gos_number;
    }
}
