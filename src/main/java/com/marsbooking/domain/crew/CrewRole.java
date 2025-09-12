package com.marsbooking.domain.crew;

public enum CrewRole {
    // Roles principales de la tripulación
    CAPTAIN("Captain", "Commanding Officer", "COMMAND", true, 10),
    FIRST_OFFICER("First Officer", "Executive Officer", "COMMAND", true, 8),
    CHIEF_ENGINEER("Chief Engineer", "Engineering Department Head", "ENGINEERING", true, 6),
    CHIEF_MEDICAL_OFFICER("Chief Medical Officer", "Medical Department Head", "MEDICAL", true, 6),
    CHIEF_SECURITY("Chief of Security", "Security Department Head", "SECURITY", true, 6),
    CHIEF_SCIENCE_OFFICER("Chief Science Officer", "Science Department Head", "SCIENCE", true, 6),
    
    // Roles de ingeniería
    ENGINEER("Engineer", "Engineering Specialist", "ENGINEERING", false, 3),
    ASSISTANT_ENGINEER("Assistant Engineer", "Junior Engineering Officer", "ENGINEERING", false, 1),
    MAINTENANCE_TECH("Maintenance Technician", "Systems Maintenance", "ENGINEERING", false, 2),
    
    // Roles médicos
    DOCTOR("Doctor", "Medical Officer", "MEDICAL", false, 4),
    NURSE("Nurse", "Medical Support", "MEDICAL", false, 2),
    MEDIC("Medic", "Emergency Medical Response", "MEDICAL", false, 1),
    
    // Roles de seguridad
    SECURITY_OFFICER("Security Officer", "Security Personnel", "SECURITY", false, 2),
    TACTICAL_OFFICER("Tactical Officer", "Weapons and Defense", "SECURITY", false, 4),
    
    // Roles de ciencia
    SCIENTIST("Scientist", "Research Specialist", "SCIENCE", false, 3),
    ANALYST("Analyst", "Data Analysis Specialist", "SCIENCE", false, 2),
    
    // Roles de navegación y pilotaje
    HELMSMAN("Helmsman", "Navigation Officer", "NAVIGATION", false, 3),
    PILOT("Pilot", "Shuttle and Fighter Pilot", "NAVIGATION", false, 4),
    
    // Roles de comunicaciones
    COMMUNICATIONS_OFFICER("Communications Officer", "Communications Specialist", "COMMUNICATIONS", false, 2),
    
    // Roles generales
    OPERATIONS_OFFICER("Operations Officer", "General Operations", "OPERATIONS", false, 3),
    CADET("Cadet", "Training Position", "TRAINING", false, 0);
    
    private final String title;
    private final String description;
    private final String department;
    private final boolean isLeadership;
    private final int minimumExperience;
    
    CrewRole(String title, String description, String department, boolean isLeadership, int minimumExperience) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.isLeadership = isLeadership;
        this.minimumExperience = minimumExperience;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDepartment() { return department; }
    public boolean isLeadership() { return isLeadership; }
    public int getMinimumExperience() { return minimumExperience; }

    public boolean belongsToDepartment(String targetDepartment) {
        return department.equalsIgnoreCase(targetDepartment);
    }

    public boolean canFulfillRole(int experienceYears) {
        return experienceYears >= minimumExperience;
    }

    public boolean isPrimaryRole() {
        return !department.equals("TRAINING");
    }

    public static CrewRole[] getRolesByDepartment(String department) {
        return java.util.Arrays.stream(values())
                .filter(role -> role.belongsToDepartment(department))
                .toArray(CrewRole[]::new);
    }
    
    public static CrewRole[] getLeadershipRoles() {
        return java.util.Arrays.stream(values())
                .filter(role -> role.isLeadership)
                .toArray(CrewRole[]::new);
    }

    public static CrewRole findByTitle(String title) {
        for (CrewRole role : values()) {
            if (role.title.equalsIgnoreCase(title)) {
                return role;
            }
        }
        return null;
    }

    public static CrewRole[] getRolesByExperience(int minExperience) {
        return java.util.Arrays.stream(values())
                .filter(role -> role.minimumExperience <= minExperience)
                .toArray(CrewRole[]::new);
    }

    public boolean canSupervise(CrewRole other) {
        return this.isLeadership && this.belongsToDepartment(other.department);
    }
    
    @Override
    public String toString() {
        return title;
    }
}