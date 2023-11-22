package hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Parents parents = new Parents();
            parents.setId1("myid1");
            parents.setId2("myid2");
            parents.setName("Parents");
            em.persist(parents);
            em.flush();
            em.clear();
            ParentId parentId = new ParentId("myid1", "myid2");
            Parents parents1 = em.find(Parents.class, parentId);
            System.out.println(parents1.getName());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
