package com.marsbooking.domain.itinerary;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Itinerary {

    private LocalDate date;
    private List<String> scales = new ArrayList<>();
    private String activitiesMars;
    private String timeTravel;
    private String necessaryResources;

    private final LocalDate fechaActual = LocalDate.of(2050, 1, 1);

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date.isAfter(fechaActual)) {
            this.date = date;
            System.out.println(" Viaje programado para: " + date);
        } else {
            System.out.println("La fecha debe ser posterior a " + fechaActual);
        }
    }

    public List<String> getScales() {
        return scales;
    }

    public void addScale(String scale) {
        if (scale != null && !scale.trim().isEmpty()) {
            scales.add(scale);
            System.out.println("Escala añadida: " + scale);
        } else {
            System.out.println("Error: la escala debe tener un valor válido.");
        }
    }

    public String getActivitiesMars() {
        return activitiesMars;
    }

    public void setActivitiesMars(String activitiesMars) {
        if (activitiesMars != null && !activitiesMars.trim().isEmpty()) {
            this.activitiesMars = activitiesMars;
        } else {
            System.out.println("Error: debe proporcionar una descripción de actividades en Marte.");
        }
    }

    public String getTimeTravel() {
        return timeTravel;
    }

    public void setTimeTravel(String timeTravel) {
        if (timeTravel != null && !timeTravel.trim().isEmpty()) {
            this.timeTravel = timeTravel;
        } else {
            System.out.println("Error: debe especificar un tiempo de viaje válido.");
        }
    }

    public String getNecessaryResources() {
        return necessaryResources;
    }

    public void setNecessaryResources(String necessaryResources) {
        if (necessaryResources != null && !necessaryResources.trim().isEmpty()) {
            this.necessaryResources = necessaryResources;
        } else {
            System.out.println("Error: debe especificar los recursos necesarios.");
        }
    }


}
