package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "therapies_medicaments")
public class therapyMedicament implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "therapyMedicamentID")
    private int therapyMedicamentID;
    private int therapyID, medicamentID;

    public therapyMedicament() {
    }
    public therapyMedicament(int therapyMedicamentID, int therapyID, int medicamentID) {
        this.therapyMedicamentID = therapyMedicamentID;
        this.therapyID = therapyID;
        this.medicamentID = medicamentID;
    }

    public int getTherapyMedicamentID() {
        return therapyMedicamentID;
    }

    public void setTherapyMedicamentID(int therapyMedicamentID) {
        this.therapyMedicamentID = therapyMedicamentID;
    }

    public int getTherapyID() {
        return therapyID;
    }

    public void setTherapyID(int therapyID) {
        this.therapyID = therapyID;
    }

    public int getMedicamentID() {
        return medicamentID;
    }

    public void setMedicamentID(int medicamentID) {
        this.medicamentID = medicamentID;
    }
}
