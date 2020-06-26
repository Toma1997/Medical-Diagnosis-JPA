package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diseases")
public class Disease  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diseaseID")
    private int diseaseID;
    private String diseaseName, diseaseType;

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
}
