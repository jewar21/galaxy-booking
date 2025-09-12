package com.marsbooking.domain.crew;

public class Crew {
    
public class crewMember {
    private String id;
    private String name;
    private String role;
    private String rank;
    private int experienceYears;
    private boolean onDuty;

    public crewMember(String id, String name, String role, String rank, int experienceYears, boolean onDuty) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.rank = rank;
        this.experienceYears = experienceYears;
        this.onDuty = onDuty;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getRank() { return rank; }
    public int getExperienceYears() { return experienceYears; }
    public boolean isOnDuty() { return onDuty; }

    public void setName(String name) { this.name = name; }
    public void setRole(String role) { this.role = role; }
    public void setRank(String rank) { this.rank = rank; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    public void setOnDuty(boolean onDuty) { this.onDuty = onDuty; }

    @Override
    public String toString() {
        return "CrewMember :" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", rank='" + rank + '\'' +
                ", experienceYears=" + experienceYears +
                ", onDuty=" + onDuty +
                ':';
    }

    public boolean isVeteran() {
        return experienceYears >= 10;
    }
    
    public boolean isJunior() {
        return experienceYears < 3;
    }

    public String getExperienceLevel() {
        if (experienceYears < 3) return "Junior";
        else if (experienceYears <= 10) return "Intermediate";
        else return "Veteran";
    }

    public void toggleDutyStatus() {
        this.onDuty = !this.onDuty;
    }

    public void promote(String newRank) {
        this.rank = newRank;
    }

    public void addExperience(int years) {
        if (years > 0) {
            this.experienceYears += years;
        }
    }
    
    public boolean canAssignToCriticalMission() {
        return onDuty && experienceYears >= 5;
    }

    public boolean hasRole(String targetRole) {
        return role != null && role.equalsIgnoreCase(targetRole);
    }

    public boolean hasRank(String targetRank) {
        return rank != null && rank.equalsIgnoreCase(targetRank);
    }

    public String getStatusSummary() {
        return String.format("%s (%s) - %s - %s - %d años exp. - %s", 
                           name, id, role, rank, experienceYears, 
                           onDuty ? "En servicio" : "Fuera de servicio");
    }

    public boolean canTrain(crewMember trainee) {
        return this.isVeteran() && this.onDuty && 
               trainee.isJunior() && !trainee.equals(this);
    }

    public int compareByExperience(crewMember other) {
        return Integer.compare(this.experienceYears, other.experienceYears);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        crewMember that = (crewMember) obj;
        return id != null ? id.equals(that.id) : that.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

}