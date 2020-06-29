package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@DiscriminatorValue(value="Home")
public class HomeTherapy extends Therapy implements Serializable {
    private static final long serialVersionUID = 1L;
    private Timestamp examinationDate;
    private String pharmacyAddr;

    public HomeTherapy() {
    }

    public Timestamp getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Timestamp examinationDate) {
        this.examinationDate = examinationDate;
    }

    public String getPharmacyAddr() {
        return pharmacyAddr;
    }

    public void setPharmacyAddr(String pharmacyAddr) {
        this.pharmacyAddr = pharmacyAddr;
    }

    @Override
    public String toString() {
        return "HomeTherapy{" +
                "therapyID=" + this.getTherapyID() +
                ", therapyName='" + this.getTherapyName() + '\'' +
                ", therapyStartDate=" + this.getTherapyStartDate() +
                ", therapyEndDate=" + this.getTherapyEndDate() +
                ", diagnosisID=" + this.getDiagnose().getDiagnosisID() +
                ", examinationDate=" + examinationDate +
                ", pharmacyAddr='" + pharmacyAddr + '\'' +
                '}';
    }
}
