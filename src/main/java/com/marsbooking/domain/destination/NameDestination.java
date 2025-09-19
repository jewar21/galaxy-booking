package com.marsbooking.domain.destination;
public class NameDestination {

    private String destinationName = "Marte";
    private double distanceFromEarth = 225_000_000; 
    private boolean habitable = false;
    private String atmosphereType = "Principalmente CO₂";
    private double temperature = -63; 
    private double travelCost = 1_000_000_000; 
    private String mainAttraction = "Monte Olimpo y exploración espacial";
    private String musicOnBoard; 


    public NameDestination(String musicOnBoard) {
        this.musicOnBoard = musicOnBoard;
    }

    
    public String getDestinationName() { return destinationName; }
    public double getDistanceFromEarth() { return distanceFromEarth; }
    public boolean isHabitable() { return habitable; }
    public String getAtmosphereType() { return atmosphereType; }
    public double getTemperature() { return temperature; }
    public double getTravelCost() { return travelCost; }
    public String getMainAttraction() { return mainAttraction; }
    public String getMusicOnBoard() { return musicOnBoard; }

    
    @Override
    public String toString() {
        return "Destino: " + destinationName + "\n" +
               "Distancia desde la Tierra: " + distanceFromEarth + " km\n" +
               "Habitable: " + (habitable ? "Sí" : "No") + "\n" +
               "Atmósfera: " + atmosphereType + "\n" +
               "Temperatura: " + temperature + "°C\n" +
               "Costo del viaje: $" + travelCost + "\n" +
               "Atracción principal: " + mainAttraction + "\n" +
               "Música durante el viaje: " + musicOnBoard;
    }
}
