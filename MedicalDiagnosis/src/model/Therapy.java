package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "therapies")
public class Therapy implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "therapyID")
    private int therapyID;
    private String therapyType, therapyName, pharmacyAddr, sector;
    private Date therapyStartDate, therapyEndDate, dischargedDate;
    private Timestamp examinationDate;
    private int diagnosisID, room, bed;

    public Therapy() {
    }
    public Therapy(int therapyID, String therapyType, String therapyName, String pharmacyAddr, String sector, Date therapyStartDate, Date therapyEndDate, Date dischargedDate, Timestamp examinationDate, int diagnosisID, int room, int bed) {
        this.therapyID = therapyID;
        this.therapyType = therapyType;
        this.therapyName = therapyName;
        this.pharmacyAddr = pharmacyAddr;
        this.sector = sector;
        this.therapyStartDate = therapyStartDate;
        this.therapyEndDate = therapyEndDate;
        this.dischargedDate = dischargedDate;
        this.examinationDate = examinationDate;
        this.diagnosisID = diagnosisID;
        this.room = room;
        this.bed = bed;
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
        this.pharmacyAddr = pharmacyAddr;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
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

    public Date getDischargedDate() {
        return dischargedDate;
    }

    public void setDischargedDate(Date dischargedDate) {
        this.dischargedDate = dischargedDate;
    }

    public Timestamp getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Timestamp examinationDate) {
        this.examinationDate = examinationDate;
    }

    public int getDiagnosisID() {
        return diagnosisID;
    }

    public void setDiagnosisID(int diagnosisID) {
        this.diagnosisID = diagnosisID;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
}
