package com.marsbooking.domain.spacecraft;
// Clase Spacecraft
public class Spacecraft {

    // Atributos
    private String model;      // Modelo de la nave
    private String fuelType;   // Tipo de combustible
    private double maxSpeed;   // Velocidad máxima en km/h
    private String status;     // Estado: "En órbita", "Listo", "En mantenimiento"
    private int capacity;      // Capacidad de pasajeros

    // Constructor
    public Spacecraft(String model, String fuelType, double maxSpeed, String status, int capacity) {
        this.model = model;
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
        this.status = status;
        this.capacity = capacity;
    }

    // Getters y Setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Método para mostrar información de la nave
    public void showInfo() {
        System.out.println("🚀 Spacecraft Info:");
        System.out.println("Modelo: " + model);
        System.out.println("Combustible: " + fuelType);
        System.out.println("Velocidad Máxima: " + maxSpeed + " km/h");
        System.out.println("Estado: " + status);
        System.out.println("Capacidad: " + capacity + " pasajeros");
    }

    // Método para simular un lanzamiento
    public void launch() {
        if (status.equalsIgnoreCase("Listo")) {
            System.out.println("La nave " + model + " ha despegado rumbo a Marte ");
            status = "En órbita";
        } else {
            System.out.println("La nave no está lista para despegar. Estado actual: " + status);
        }
    }

    // Método para simular mantenimiento
    public void maintenance() {
        status = "En mantenimiento";
        System.out.println("La nave " + model + " está ahora en mantenimiento ");
    }
}