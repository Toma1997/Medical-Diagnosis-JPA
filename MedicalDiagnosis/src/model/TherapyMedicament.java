package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "therapies_medicaments")
public class TherapyMedicament implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "therapyMedicamentID")
    private int therapyMedicamentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapyID")
    private Therapy therapy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicamentID")
    private Medicament medicament;

    public TherapyMedicament() {
    }

    public int getTherapyMedicamentID() {
        return therapyMedicamentID;
    }

    public void setTherapyMedicamentID(int therapyMedicamentID) {
        this.therapyMedicamentID = therapyMedicamentID;
    }


    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
}
