package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "symptoms")
public class Symptom implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symptomID")
    private int symptomID;
    private String symptomName, cause;

    @OneToMany(mappedBy = "symptom")
    private Set<SymptomDisease> symptomsDiseases = new HashSet<SymptomDisease>();

    public Symptom() {
    }
    public Symptom(int symptomID, String symptomName, String cause) {
        this.symptomID = symptomID;
        this.symptomName = symptomName;
        this.cause = cause;
    }

    public int getSymptomID() {
        return symptomID;
    }

    public void setSymptomID(int symptomID) {
        this.symptomID = symptomID;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Set<SymptomDisease> getSymptomsDiseases() {
        return symptomsDiseases;
    }

    public void setSymptomsDiseases(Set<SymptomDisease> symptomsDiseases) {
        this.symptomsDiseases = symptomsDiseases;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "symptomID=" + symptomID +
                ", symptomName='" + symptomName + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
