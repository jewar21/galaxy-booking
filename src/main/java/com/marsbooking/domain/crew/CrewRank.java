package com.marsbooking.domain.crew;

public enum CrewRank {

    CADET(1, "Cadet", "Cadete en entrenamiento"),
    ENSIGN(2, "Ensign", "Oficial junior"),
    LIEUTENANT_JG(3, "Lieutenant (j.g.)", "Teniente junior"),
    LIEUTENANT(4, "Lieutenant", "Teniente"),
    LIEUTENANT_COMMANDER(5, "Lieutenant Commander", "Teniente Comandante"),
    COMMANDER(6, "Commander", "Comandante"),
    CAPTAIN(7, "Captain", "Capitán"),
    COMMODORE(8, "Commodore", "Comodoro"),
    ADMIRAL(9, "Admiral", "Almirante");
    
    private final int level;
    private final String title;
    private final String description;
    
    CrewRank(int level, String title, String description) {
        this.level = level;
        this.title = title;
        this.description = description;
    }
    
    // Getters
    public int getLevel() { return level; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }

    public boolean isHigherThan(CrewRank other) {
        return this.level > other.level;
    }

    public boolean isLowerThan(CrewRank other) {
        return this.level < other.level;
    }

    public CrewRank getNextRank() {
        CrewRank[] ranks = CrewRank.values();
        for (int i = 0; i < ranks.length - 1; i++) {
            if (ranks[i] == this) {
                return ranks[i + 1];
            }
        }
        return this; // Si ya es el rango más alto
    }

    public CrewRank getPreviousRank() {
        CrewRank[] ranks = CrewRank.values();
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] == this) {
                return ranks[i - 1];
            }
        }
        return this; // Si ya es el rango más bajo
    }

    public boolean isOfficerRank() {
        return level >= ENSIGN.level;
    }

    public boolean isSeniorCommand() {
        return level >= COMMANDER.level;
    }

    public int getLevelDifference(CrewRank other) {
        return Math.abs(this.level - other.level);
    }

    public static CrewRank findByTitle(String title) {
        for (CrewRank rank : values()) {
            if (rank.title.equalsIgnoreCase(title)) {
                return rank;
            }
        }
        return null;
    }

    public static CrewRank[] getRanksFromLevel(int minLevel) {
        return java.util.Arrays.stream(values())
                .filter(rank -> rank.level >= minLevel)
                .toArray(CrewRank[]::new);
    }
    
    @Override
    public String toString() {
        return title;
    }
}