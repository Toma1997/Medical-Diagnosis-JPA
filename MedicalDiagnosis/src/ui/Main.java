package ui;
import model.Patient;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("medical_diagnosis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Begin of code for db interaction.

        // Plain Query.
        System.out.println("Ispod je rezultat obicnog upita za prikaz svih pacijenata!");
        List<Patient> patients = em.createQuery("SELECT p FROM Patient as p").getResultList();
        for(Patient patient: patients) {
            System.out.println(patient.toString());
        }

        // TypedQuery.

        // NamedQuery.

        // NamedQueries.

        // Criteria API Query.

        // Complex Query with joins, etc.

        // End of code for db interaction.

        tx.commit();
        em.close();
    }
}
