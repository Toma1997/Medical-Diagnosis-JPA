package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diagnosis")
public class Diagnose implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosisID")
    private int diagnosisID;
    private int patientID, symptomDiseaseID;

    public Diagnose() {
    }
    public Diagnose(int diagnosisID, int patientID, int symptomDiseaseID) {
        this.diagnosisID = diagnosisID;
        this.patientID = patientID;
        this.symptomDiseaseID = symptomDiseaseID;
    }

    public int getDiagnosisID() {
        return diagnosisID;
    }

    public void setDiagnosisID(int diagnosisID) {
        this.diagnosisID = diagnosisID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getSymptomDiseaseID() {
        return symptomDiseaseID;
    }

    public void setSymptomDiseaseID(int symptomDiseaseID) {
        this.symptomDiseaseID = symptomDiseaseID;
    }
}
