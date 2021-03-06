package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicamentID")
    private int medicamentID;
    private String medicamentName, medicamentDescription, dose, restriction;

    @OneToMany(mappedBy = "medicament")
    private Set<TherapyMedicament> therapyMedicaments = new HashSet<TherapyMedicament>();

    public Medicament() {
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

    public Set<TherapyMedicament> getTherapyMedicaments() {
        return therapyMedicaments;
    }

    public void setTherapyMedicaments(Set<TherapyMedicament> therapyMedicaments) {
        this.therapyMedicaments = therapyMedicaments;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "medicamentID=" + medicamentID +
                ", medicamentName='" + medicamentName + '\'' +
                ", medicamentDescription='" + medicamentDescription + '\'' +
                ", dose='" + dose + '\'' +
                ", restriction='" + restriction + '\'' +
                '}';
    }
}
