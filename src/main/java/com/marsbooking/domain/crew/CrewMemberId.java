package com.marsbooking.domain.crew;

public class CrewMemberId {
    private String prefix;
    private int number;
    private String department;
    
    public CrewMemberId(String prefix, int number, String department) {
        this.prefix = prefix;
        this.number = number;
        this.department = department;
    }
    
    public CrewMemberId(String fullId) {
        parseId(fullId);
    }
    
    // Getters
    public String getPrefix() { return prefix; }
    public int getNumber() { return number; }
    public String getDepartment() { return department; }
    
    // Setters
    public void setPrefix(String prefix) { this.prefix = prefix; }
    public void setNumber(int number) { this.number = number; }
    public void setDepartment(String department) { this.department = department; }

    public String generateFullId() {
        return String.format("%s-%03d-%s", prefix, number, department);
    }

    private void parseId(String fullId) {
        if (fullId != null && fullId.contains("-")) {
            String[] parts = fullId.split("-");
            if (parts.length >= 3) {
                this.prefix = parts[0];
                try {
                    this.number = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    this.number = 0;
                }
                this.department = parts[2];
            }
        }
    }

    public boolean isValidFormat() {
        return prefix != null && !prefix.isEmpty() && 
               number > 0 && 
               department != null && !department.isEmpty();
    }

    public CrewMemberId getNextId() {
        return new CrewMemberId(prefix, number + 1, department);
    }

    public boolean belongsToDepartment(String targetDepartment) {
        return department != null && department.equalsIgnoreCase(targetDepartment);
    }
    
    @Override
    public String toString() {
        return generateFullId();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CrewMemberId that = (CrewMemberId) obj;
        return generateFullId().equals(that.generateFullId());
    }
    
    @Override
    public int hashCode() {
        return generateFullId().hashCode();
    }
}