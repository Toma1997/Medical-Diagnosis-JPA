package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value="Hospital")
public class HospitalTherapy extends Therapy implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sector;
    private int room, bed;

    public HospitalTherapy() {
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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

    @Override
    public String toString() {
        return "HospitalTherapy{" +
                "therapyID=" + this.getTherapyID() +
                ", therapyName='" + this.getTherapyName() + '\'' +
                ", therapyStartDate=" + this.getTherapyStartDate() +
                ", therapyEndDate=" + this.getTherapyEndDate() +
                ", diagnosisID=" + this.getDiagnose().getDiagnosisID() +
                ", sector='" + sector + '\'' +
                ", room=" + room +
                ", bed=" + bed +
                '}';
    }
}
