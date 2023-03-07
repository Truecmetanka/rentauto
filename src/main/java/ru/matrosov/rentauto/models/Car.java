package ru.matrosov.rentauto.models;

public class Car {
    private int id;
    private String modelName;
    private String licensePlate;

    public Car(int id, String model_name, String gos_number) {
        this.id = id;
        this.modelName = model_name;
        this.licensePlate = gos_number;
    }

    public Car() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
