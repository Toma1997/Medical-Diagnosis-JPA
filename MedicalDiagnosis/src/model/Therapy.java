package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "therapies")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "therapyType")
public abstract class Therapy implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "therapyID")
    private int therapyID;
    private String therapyName;
    private Date therapyStartDate, therapyEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosisID")
    private Diagnose diagnose;

    @OneToMany(mappedBy = "therapy")
    private Set<TherapyMedicament> therapyMedicaments = new HashSet<TherapyMedicament>();

    public Therapy() {
    }

    public int getTherapyID() {
        return therapyID;
    }

    public void setTherapyID(int therapyID) {
        this.therapyID = therapyID;
    }

    public String getTherapyName() {
        return therapyName;
    }

    public void setTherapyName(String therapyName) {
        this.therapyName = therapyName;
    }

    public Date getTherapyStartDate() {
        return therapyStartDate;
    }

    public void setTherapyStartDate(Date therapyStartDate) {
        this.therapyStartDate = therapyStartDate;
    }

    public Date getTherapyEndDate() {
        return therapyEndDate;
    }

    public void setTherapyEndDate(Date therapyEndDate) {
        this.therapyEndDate = therapyEndDate;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public Set<TherapyMedicament> getTherapyMedicaments() {
        return therapyMedicaments;
    }

    public void setTherapyMedicaments(Set<TherapyMedicament> therapyMedicaments) {
        this.therapyMedicaments = therapyMedicaments;
    }
}
