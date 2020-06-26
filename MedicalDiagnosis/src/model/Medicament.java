package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medicaments")
public class Medicament implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicamentID")
    private int medicamentID;
    private String medicamentName, medicamentDescription, dose, restriction;

    public Medicament() {
    }
    public Medicament(int medicamentID, String medicamentName, String medicamentDescription, String dose, String restriction) {
        this.medicamentID = medicamentID;
        this.medicamentName = medicamentName;
        this.medicamentDescription = medicamentDescription;
        this.dose = dose;
        this.restriction = restriction;
    }

    public int getMedicamentID() {
        return medicamentID;
    }

    public void setMedicamentID(int medicamentID) {
        this.medicamentID = medicamentID;
    }

    public String getMedicamentName() {
        return medicamentName;
    }

    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }

    public String getMedicamentDescription() {
        return medicamentDescription;
    }

    public void setMedicamentDescription(String medicamentDescription) {
        this.medicamentDescription = medicamentDescription;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }
}
