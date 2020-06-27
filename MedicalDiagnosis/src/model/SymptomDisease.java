package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="symptoms_diseases")
public class SymptomDisease implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symptomDiseaseID")
    private int symptomDiseaseID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptomID")
    private Symptom symptom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diseaseID")
    private Disease disease;

    @OneToMany(mappedBy = "symptomDisease")
    private Set<Diagnose> diagnosis = new HashSet<Diagnose>();

    public SymptomDisease() {
    }

    public int getSymptomDiseaseID() {
        return symptomDiseaseID;
    }

    public void setSymptomDiseaseID(int symptomDiseaseID) {
        this.symptomDiseaseID = symptomDiseaseID;
    }

    public Symptom getSypmtom() {
        return symptom;
    }

    public void setSypmtom(Symptom sypmtom) {
        this.symptom = sypmtom;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Set<Diagnose> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Set<Diagnose> diagnosis) {
        this.diagnosis = diagnosis;
    }
}
