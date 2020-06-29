package ui;
import model.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("medical_diagnosis");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Plain Query
        System.out.println("\nBelow is the result of Plain query which retrieves all patients:");
        List<Patient> patients = em.createQuery("SELECT p FROM Patient as p").getResultList();
        for(Patient patient: patients) {
            System.out.println(patient.toString());
        }

        // TypedQuery
        System.out.println("\nBelow is the result of Typed Query which retrieves all sypmtoms which name starts with 'Bol' (pain):");
        TypedQuery<Symptom> typedQuery = em.createQuery("SELECT s FROM Symptom s WHERE s.symptomName LIKE 'Bol%'", Symptom.class);
        List<Symptom> symptomsWithPain = typedQuery.getResultList();
        for(Symptom symptom: symptomsWithPain) {
            System.out.println(symptom.toString());
        }

        // NamedQuery
        System.out.println("\nBelow is the result of Named Query which retrieves all diseases which type is Stomach:");
        Query query = em.createNamedQuery("Find disease by type");
        query.setParameter("type", "Stomacno");
        List<Disease> diseasesStomach = query.getResultList();
        for(Disease disease: diseasesStomach){
            System.out.println(disease.toString());
        }

        // NamedQueries
        System.out.println("\nBelow is the result of Named Queries which retrieves specific patients:");

        Query query1 = em.createNamedQuery("Patients older than given date");
        String date1 = "1998-04-24";
        query1.setParameter("date",  Date.valueOf(date1));
        List<Patient> patientsOlderThanGivenDate = query1.getResultList();
        System.out.println("\nPatients older than "+date1+":");
        for(Patient patient: patientsOlderThanGivenDate){
            System.out.println(patient.toString());
        }

        Query query2 = em.createNamedQuery("Patients with lower weight than AVG");
        List<Patient> patientsLessWeightThanAVG = query2.getResultList();
        System.out.println("\nPatients with lower weight than AVG:");
        for(Patient patient: patientsLessWeightThanAVG){
            System.out.println(patient.toString());
        }

        Query query3 = em.createNamedQuery("Sorted patients by birthDate with weight gt given and height lt given");
        query3.setParameter("weight", 70.0);
        query3.setParameter("height", 187.0);
        List<Patient> sortedPatientsWithGtWeightLtHeight = query3.getResultList();
        System.out.println("\nSorted patients by birthDate with weight gt given and height lt given");
        for(Patient patient: sortedPatientsWithGtWeightLtHeight){
            System.out.println(patient.toString());
        }

        // Criteria API Query
        CriteriaBuilder cb = em.getCriteriaBuilder();
        System.out.println("\nBelow are the results of Criteria API Queries which retrieves specific patients:");
        CriteriaQuery<Object> criteriaQuery1 = cb.createQuery();
        Root<Medicament> from1 = criteriaQuery1.from(Medicament.class);
        System.out.println("\nSelect all medicaments:");
        CriteriaQuery<Object> select1 = criteriaQuery1.select(from1);
        TypedQuery<Object> typedQuery1 = em.createQuery(select1);
        List<Object> medicaments = typedQuery1.getResultList();
        for(Object obj: medicaments) {
            Medicament medicament = (Medicament) obj;
            System.out.println(medicament.toString());
        }

        CriteriaQuery<Object> criteriaQuery2 = cb.createQuery();
        Root<Therapy> from2 = criteriaQuery2.from(Therapy.class);
        System.out.println("\nSelect all therapies ordered by therapyStartDate descending:");
        CriteriaQuery<Object> select2 = criteriaQuery1.select(from2);
        select1.orderBy(cb.desc(from2.get("therapyStartDate")));
        TypedQuery<Object> typedQuery2 = em.createQuery(select2);
        List<Object> therapies = typedQuery2.getResultList();
        for(Object obj: therapies) {
            Therapy therapy = (Therapy) obj;
            System.out.println(therapy.toString());
        }

        // Complex Query with joins, etc.
        System.out.println("\nBelow are the results of the complex queries with joins:\n");
        TypedQuery<Patient> complexQuery1 = em.createQuery("SELECT DISTINCT p FROM Diagnose d INNER JOIN d.patient p WHERE d.patient.weight < 80.0 ORDER BY d.patient.height DESC",
                Patient.class);
        List<Patient> patientsJoinDiagnoses = complexQuery1.getResultList();
        for(Patient patient: patientsJoinDiagnoses){
            System.out.println(patient.toString());
            System.out.println("Patients diagnoses:");
            for(Diagnose diagnose: patient.getDiagnosis()){
                System.out.println(diagnose.toString());
            }
            System.out.println();
        }

        tx.commit();
        em.close();
    }
}
