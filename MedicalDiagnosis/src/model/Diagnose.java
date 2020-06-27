package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnosis")
public class Diagnose implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosisID")
    private int diagnosisID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientID")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptomDiseaseID")
    private SymptomDisease symptomDisease;

    @OneToMany(mappedBy = "diagnose")
    private Set<Therapy> therapies = new HashSet<Therapy>();

    public Diagnose() {
    }

    public int getDiagnosisID() {
        return diagnosisID;
    }

    public void setDiagnosisID(int diagnosisID) {
        this.diagnosisID = diagnosisID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public SymptomDisease getSymptomDisease() {
        return symptomDisease;
    }

    public void setSymptomDisease(SymptomDisease symptomDisease) {
        this.symptomDisease = symptomDisease;
    }

    public Set<Therapy> getTherapies() {
        return therapies;
    }

    public void setTherapies(Set<Therapy> therapies) {
        this.therapies = therapies;
    }

    @Override
    public String toString() {
        return "Diagnose{" +
                "diagnosisID=" + diagnosisID +
                ", patient=" + patient.getPatientID() +
                ", symptomDisease=" + symptomDisease.getSymptomDiseaseID() +
                '}';
    }
}
