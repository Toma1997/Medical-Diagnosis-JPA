package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diseases")
public class Disease  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diseaseID")
    private int diseaseID;
    private String diseaseName, diseaseType;

    @OneToMany(mappedBy = "disease")
    private Set<SymptomDisease> symptomsDiseases = new HashSet<SymptomDisease>();

    public Disease() {
    }
    public Disease(int diseaseID, String diseaseName, String diseaseType) {
        this.diseaseID = diseaseID;
        this.diseaseName = diseaseName;
        this.diseaseType = diseaseType;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Set<SymptomDisease> getSymptomsDiseases() {
        return symptomsDiseases;
    }

    public void setSymptomsDiseases(Set<SymptomDisease> symptomsDiseases) {
        this.symptomsDiseases = symptomsDiseases;
    }
}
