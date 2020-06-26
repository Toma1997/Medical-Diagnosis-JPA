package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "symptoms")
public class Symptom implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symptomID")
    private int symptomID;
    private String symptomName, cause;

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
}
