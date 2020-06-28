package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "therapies")
public class Therapy implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "therapyID")
    private int therapyID;
    private String therapyType, therapyName, pharmacyAddr, sector;
    private Date therapyStartDate, therapyEndDate;
    private Timestamp examinationDate;
    private int room, bed;

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

    public String getTherapyType() {
        return therapyType;
    }

    public void setTherapyType(String therapyType) {
        this.therapyType = therapyType;
    }

    public String getTherapyName() {
        return therapyName;
    }

    public void setTherapyName(String therapyName) {
        this.therapyName = therapyName;
    }

    public String getPharmacyAddr() {
        return pharmacyAddr;
    }

    public void setPharmacyAddr(String pharmacyAddr) {
        if(this.therapyType == "Home")
            this.pharmacyAddr = pharmacyAddr;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        if(this.therapyType == "Hospital")
            this.sector = sector;
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

    public Timestamp getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Timestamp examinationDate) {
        if(this.therapyType == "Home")
            this.examinationDate = examinationDate;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        if(this.therapyType == "Hospital")
            this.room = room;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        if(this.therapyType == "Hospital")
            this.bed = bed;
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

    @Override
    public String toString() {
        String str =  "Therapy{" +
                "therapyID=" + therapyID +
                ", therapyType='" + therapyType + '\'' +
                ", therapyName='" + therapyName + '\'' +
                ", therapyStartDate=" + therapyStartDate +
                ", therapyEndDate=" + therapyEndDate +
                ", diagnosisID=" + diagnose.getDiagnosisID();
        if(this.therapyType.equals("Home")){
            str += ", pharmacyAddr='" + pharmacyAddr + '\'' +
                    ", examinationDate=" + examinationDate +
                    "}";
        } else {
            str += ", sector='" + sector + '\'' +
                    ", room=" + room +
                    ", bed=" + bed +
                    '}';
        }
        return str;
    }
}
