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
            Team team1 = new Team();
            team1.setName("team1");

            Team team2 = new Team();
            team2.setName("team2");
            em.persist(team1);
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("AA");
            member1.setTeam(team1);

            Member member2 = new Member();
            member2.setUsername("BB");
            member2.setTeam(team2);

            Member member3 = new Member();
            member3.setUsername("CC");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
