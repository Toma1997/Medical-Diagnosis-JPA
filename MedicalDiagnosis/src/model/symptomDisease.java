package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="symptoms_diseases")
public class symptomDisease implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symptomDiseaseID")
    private int symptomDiseaseID;
    private int symptomID, diseaseID;

    public symptomDisease() {
    }

    public symptomDisease(int symptomDiseaseID, int symptomID, int diseaseID) {
        this.symptomDiseaseID = symptomDiseaseID;
        this.symptomID = symptomID;
        this.diseaseID = diseaseID;
    }

    public int getSymptomDiseaseID() {
        return symptomDiseaseID;
    }

    public void setSymptomDiseaseID(int symptomDiseaseID) {
        this.symptomDiseaseID = symptomDiseaseID;
    }

    public int getSymptomID() {
        return symptomID;
    }

    public void setSymptomID(int symptomID) {
        this.symptomID = symptomID;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }
}
