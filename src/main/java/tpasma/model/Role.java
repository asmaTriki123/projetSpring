package tpasma.model;

public enum Role {
    ADMINISTRATEUR,
    AGENT_MAINTENANCE,
    AGENT_ACCUEIL,
    SURVEILLANT,
    RESPONSABLE_ADMISSIONS,
    COMPTABLE,
    ANIMATEUR,
    TECHNICIEN_INFORMATIQUE;

    // Méthode pour avoir un format avec la première lettre en majuscule et le reste en minuscule
    public String getFormattedRole() {
        String role = this.name().toLowerCase(); // Convertir tout en minuscule
        return role.substring(0, 1).toUpperCase() + role.substring(1); // Capitaliser la première lettre
    }
}