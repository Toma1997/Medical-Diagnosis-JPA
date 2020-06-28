package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
@NamedQueries({
    @NamedQuery(query = "SELECT p FROM Patient AS p WHERE p.birthDate <= :date", name="Patients older than given date"),
    @NamedQuery(query = "SELECT p FROM Patient AS p WHERE p.weight < (SELECT AVG(p.weight) FROM Patient as p)", name="Patients with lower weight than AVG"),
    @NamedQuery(query = "SELECT p FROM Patient AS p WHERE p.weight > :weight AND p.height < :height ORDER BY p.birthDate DESC", name="Sorted patients by birthDate with weight gt given and height lt given")
})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientID")
    private int patientID;
    private String patientName, patientSurname;
    private Date birthDate;
    private char gender;
    private double weight, height;

    @OneToMany(mappedBy = "patient")
    private Set<Diagnose> diagnosis = new HashSet<Diagnose>();

    public Patient() {
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Set<Diagnose> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Set<Diagnose> diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", patientName='" + patientName + '\'' +
                ", patientSurname='" + patientSurname + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
